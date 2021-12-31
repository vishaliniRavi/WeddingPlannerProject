package com.weddingplanner.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.weddingplanner.dao.BookingServicesDao;
import com.weddingplanner.dao.BookingVenuesDao;
import com.weddingplanner.dao.RatingsDao;
import com.weddingplanner.dao.ServicesDao;
import com.weddingplanner.dao.UserDao;
import com.weddingplanner.dao.VenuesDao;
import com.weddingplannr.model.BookingServices;
import com.weddingplannr.model.BookingVenues;
import com.weddingplannr.model.Ratings;
import com.weddingplannr.model.Services;
import com.weddingplannr.model.User;
import com.weddingplannr.model.Venues;

public class TestMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Wedding Planner");
		System.out.println("\n1.Register\n2.Login\nEnter your choice");
		int choice = Integer.parseInt(sc.nextLine());
		int flag;
		UserDao userDao = null;
		switch (choice) {
		case 1:
			userDao = new UserDao();
			String emailId = null;
			String userName = null;
			String password = null;
			String city = null;
			String mobile = null;
//register
			do {
				System.out.println("Enter user name");
				userName = sc.nextLine();
				if (userName.matches("[A-Za-z]{3,}")) {
					flag = 1;
					break;
				} else
					flag = 0;
				System.out.println("invalid name");
			} while (flag == 0);
			do {
				System.out.println("Enter Mobile number");
				mobile = sc.nextLine();
				if (mobile.matches("[6-9][0-9]{9}")) {
					flag = 1;
					break;
				} else {
					flag = 0;
					System.out.println("Enter valid mobile number");
				}
			} while (flag == 0);
			long mobileNumber = Long.parseLong(mobile);

			do {
				System.out.println("Enter city");
				city = sc.nextLine();
				if (city.matches("[A-Za-z0]{4,25}")) {
					flag = 1;
					break;
				} else
					flag = 0;
				System.out.println("Enter valid address");

			} while (flag == 0);

			do {
				System.out.println("Enter email id");
				emailId = sc.nextLine();
				if (emailId.matches("[a-z]+[a-z0-9]+[@][a-z]+[.][a-z]+")) {
					flag = 1;
					break;
				} else
					flag = 0;
				System.out.println("invalid email");
			} while (flag == 0);
			do {
				System.out.println("Enter password");
				password = sc.nextLine();
				if (password.matches("[A-Z]+[a-z]+[@#$]+[0-9]+{8,20}")) {
					flag = 1;
					break;
				} else
					flag = 0;
				System.out.println("invalid password");
			} while (flag == 0);
			do {
				System.out.println("confirm password");
				String confirm_password = sc.nextLine();
				if (password.equals(confirm_password)) {
					flag = 1;
					break;

				} else
					flag = 0;
				System.out.println("Enter correct password");
			} while (flag == 0);

			User user = new User(userName, mobileNumber, city, emailId, password);
			userDao.insertUser(user);
			break;
//login		
		case 2:
			userDao = new UserDao();
			do {
				System.out.println("Enter email id");
				emailId = sc.nextLine();
				if (emailId.matches("[a-z]+[a-z0-9]+[@][a-z]+[.][a-z]+")) {
					flag = 1;
					break;
				} else
					flag = 0;
				System.out.println("invalid email");
			} while (flag == 0);
			do {
				System.out.println("Enter password");
				password = sc.nextLine();
				if (password.matches("[A-Z]+[a-z]+[@#$]+[0-9]+{8,20}")) {
					flag = 1;
					break;
				} else
					flag = 0;
				System.out.println("invalid password");
			} while (flag == 0);
			do {
				User valideUser = userDao.validateUser(emailId, password);
				User validadmin = userDao.validateAdmin(emailId, password);
				if (validadmin != null) { // admin login
					System.out.println("Welcome admin");
					System.out.println(
							"\n1.view customers \n2.add venues\n3.Delete venue\n4.edit venue\n5.add services\n6.Remove services\nEnter your choice");
					int option = Integer.parseInt(sc.nextLine());
					switch (option) {
					case 1: // view customer
						UserDao userdao = new UserDao();
						List<User> userList = userdao.viewUser();
						for (int i = 0; i < userList.size(); i++) {
							System.out.println(userList.get(i));
						}
						break;
					case 2: // add venues
						VenuesDao venuedao = new VenuesDao();
						System.out.println("Enter venue name");
						String venueName = sc.nextLine();
						System.out.println("Enter venue Address");
						String venueAddress = sc.nextLine();
						System.out.println("Enter venue city");
						String venueCity = sc.nextLine();
						System.out.println("Enter venue type");
						String venueType = sc.nextLine();
						System.out.println("Enter venue vendor name");
						String venueVendorName = sc.nextLine();
						System.out.println("Enter Contact Number");
						Long contactNumber = Long.parseLong(sc.nextLine());
						System.out.println("Enter venue package");
						Double venuePackage = Double.parseDouble(sc.nextLine());
						System.out.println("Enter availability");
						String availability=sc.nextLine();
						Venues venue = new Venues(venueName, venueAddress, venueCity, venueType, venueVendorName,
								contactNumber, venuePackage,availability);
						venuedao.insertVenue(venue);
						break;
					case 3: // delete venues
						VenuesDao venueDao = new VenuesDao();
						System.out.println("Enter venue name to delete");
						venueName = sc.nextLine();
						venueDao.removeVenue(venueName);
						break;
					case 4: // edit venues
						venueDao = new VenuesDao();
						System.out.println("Enter user name to edit");
						venueName = sc.nextLine();
						System.out.println("Enter venue vendor name");
						venueVendorName = sc.nextLine();
						System.out.println("Enter Contact Number");
						contactNumber = Long.parseLong(sc.nextLine());
						System.out.println("Enter venue package");
						venuePackage = Double.parseDouble(sc.nextLine());
						venueDao.updateVenue(venueVendorName, contactNumber, venuePackage, venueName);
						break;
					case 5: // add service
						ServicesDao serviceDao = new ServicesDao();
						System.out.println("Enter Service name");
						String serviceName = sc.nextLine();
						System.out.println("Enter Service package");
						Double servicePackage = Double.parseDouble(sc.nextLine());
						Services service = new Services(serviceName, servicePackage);
						serviceDao.insertService(service);
						break;
					case 6:
						serviceDao = new ServicesDao();
						System.out.println("Enter service name to delete");
						serviceName = sc.nextLine();
						serviceDao.removeServices(serviceName);
					}
				} else if (valideUser != null) { // customer login
					System.out.println("Welcome " + valideUser.getUserName());
					System.out.println("\n1.view venue\n2.view Services\n3.Edit profile\n4.filter by cities\n5.filter by budgets\n6.Book venues\n7.Book Services\n8.Give ratings\n9.view ratings");
					flag = 1;
					int userChoice = Integer.parseInt(sc.nextLine());
					switch (userChoice) {
					case 1: // view venue
						VenuesDao venuedao = new VenuesDao();
						List<Venues> venuelist = venuedao.showVenue();
						for (int i = 0; i < venuelist.size(); i++) {
							System.out.println(venuelist.get(i));
						}
						break;
					case 2: // view services
						ServicesDao serviceDao = new ServicesDao();
						List<Services> serviceList = serviceDao.showServices();
					for (int i = 0; i < serviceList.size(); i++) {
							System.out.println(serviceList.get(i));
						}
						break;
					case 3:// edit profile
						userDao = new UserDao();
						do {
							System.out.println("Enter email id to edit your profile");
							emailId = sc.nextLine();
							if (emailId.matches("[a-z]+[a-z0-9]+[@][a-z]+[.][a-z]+")) {
								flag = 1;
								break;
							} else
								flag = 0;
							System.out.println("invalid email");
						} while (flag == 0);

						User valideUserUpdate = userDao.validateUserUpdate(emailId);
						if (valideUserUpdate != null) {
							do {
								System.out.println("Enter user name");
								userName = sc.nextLine();
								if (userName.matches("[A-Za-z]{3,}")) {
									flag = 1;
									break;
								} else
									flag = 0;
								System.out.println("invalid name");
							} while (flag == 0);
							do {
								System.out.println("Enter Mobile number");
								mobile = sc.nextLine();
								if (mobile.matches("[6-9][0-9]{9}")) {
									flag = 1;
									break;
								} else {
									flag = 0;
									System.out.println("Enter valid mobile number");
								}
							} while (flag == 0);
							long mobile_num = Long.parseLong(mobile);

							do {
								System.out.println("Enter city");
								city = sc.nextLine();
								if (city.matches("[A-Za-z0]{4,25}")) {
									flag = 1;
									break;
								} else
									flag = 0;
								System.out.println("Enter valid address");

							} while (flag == 0);

							do {
								System.out.println("Enter password");
								password = sc.nextLine();
								if (password.matches("[A-Z]+[a-z]+[@#$]+[0-9]+{8,20}")) {
									flag = 1;
									break;
								} else
									flag = 0;
								System.out.println("invalid password");
							} while (flag == 0);
							user = new User(userName, mobile_num, city, emailId, password);
							userDao.updateUserProfile(user);
						} else
							System.out.println("invalid email");
						break;
					case 4:
	      				 venuedao = new VenuesDao();
	      				 System.out.println("Enter city name");
	      				 String venueCity=sc.nextLine();
						 venuelist = venuedao.findCity(venueCity);
						for (int i = 0; i < venuelist.size(); i++) {
							System.out.println(venuelist.get(i));
						}
						break;
					case 5:
						System.out.println("\n1.Premium\n2.Luxury");
						System.out.println("Enter your choice");
						int budgetChoice=Integer.parseInt(sc.nextLine());
						switch(budgetChoice) {
						case 1:
							venuedao=new VenuesDao();
							venuelist=venuedao.findByBudget();
							for (int i = 0; i < venuelist.size(); i++) {
								System.out.println(venuelist.get(i));
							}break;
						case 2:
							venuedao=new VenuesDao();
							venuelist=venuedao.findLuxury();
							for (int i = 0; i < venuelist.size(); i++) {
								System.out.println(venuelist.get(i));
							}break;
						}break;
					case 6:
						venuedao = new VenuesDao();
						emailId = valideUser.getEmailId();
						int id1 = userDao.findUserId(emailId);
						System.out.println("view Produce List");
						List<Venues> venueList = venuedao.showVenue();
						for (int i = 0; i < venueList.size(); i++) {
							System.out.println(venueList.get(i));
						}
						System.out.println("Enter venue name");
						String venueName = sc.nextLine();
						int id2 = venuedao.findVenueId(venueName);
						System.out.println("Enter No of guest");
						int noOfGuest = Integer.parseInt(sc.nextLine());
						System.out.println("Enter function Timing Morning/Evening");
						String functionTiming = sc.nextLine();
						System.out.println("Enter Event Date");
						SimpleDateFormat sdf=new SimpleDateFormat("DD-MM-YYYY");
						Date eventDate=null;
						try {
							eventDate = sdf.parse(sc.nextLine());
						} catch (ParseException e) {
							e.printStackTrace();
						}
						int price = venuedao.findPackage(id2);
						System.out.println("package" + price);
						int advanceAmount=(price)/2;
						System.out.println("Advance amount You have to pay"+advanceAmount);
//						System.out.println("Enter your Number of Products");
//						int quantity=Integer.parseInt(scan.nextLine());
//						
//						double totalPrice=(double)(quantity*price);
						
						int walletbal=0;
						try {
							walletbal = userDao.walletbal(id1);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						int dedwallbal = (int) (walletbal - advanceAmount);
							System.out.println("\n 1.confirm order \n 2.cancel order");
							int orderConfirmation = sc.nextInt();
							sc.nextLine();
							switch (orderConfirmation) 
							{
							case 1:
								if (advanceAmount <= walletbal) {
									int upd=0;
									try {
										upd = userDao.updatewallet(dedwallbal, id1);
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									if(upd > 0) {
										BookingVenues bookVenue = new BookingVenues(id1, id2, venueName, noOfGuest, functionTiming,
												eventDate, price);
										BookingVenuesDao bookingVenue = new BookingVenuesDao();
										bookingVenue.bookVenue(bookVenue);
									System.out.println("order placed successfully!!!");
									}else {
										System.out.println("something went wrong try again!!");
									}
								} else {
									System.out.println("Low Balance please top up!!");
								}
								flag = 0;
								break;
							case 2:
								System.out.println("Order Cancelled");
								break;
							}
//					case 5:
//						
//							System.out.println("Do you want to book services?(Y/N)");
//							char bookingChoice = sc.nextLine().charAt(0);
//							ServicesDao servicedao = new ServicesDao();
//							if (bookingChoice == 'Y' || bookingChoice == 'y') {
//								List<Services> list = servicedao.showServices();
//								for (int i = 0; i < list.size(); i++) {
//									System.out.println(list.get(i));
//								}
//								emailId = valideUser.getEmailId();
//								int userId = userDao.findUserId(emailId);
//								System.out.println("user" + userId);
//								System.out.println("Enter Service Name");
//								String serviceName = sc.nextLine();
//								int serviceId = servicedao.findServiceId(serviceName);
//								System.out.println("service" + serviceId);
//								System.out.println("Enter Event Date");
//								String date = sc.nextLine();
//								double servicePackage = servicedao.findPackage(serviceId);
//								System.out.println("package" + servicePackage);
//								BookingServices bookService = new BookingServices(userId, serviceId, serviceName, date,
//										servicePackage);
//								BookingServicesDao bookingService = new BookingServicesDao();
//								bookingService.bookService(bookService);
//							}
					
					case 7:
						System.out.println("Do you want book Services");
						char bookingChoice = sc.nextLine().charAt(0);
 		      			
 		      			if (bookingChoice == 'Y' || bookingChoice == 'y')
 		      			{
 		      				System.out.println("1.photographer\n2.Mehandi\n3.Bridal makeup\n4.Decoration");
 		      				System.out.println("Enter your choice");
 		      				int serviceChoice = Integer.parseInt(sc.nextLine());
 		      				switch(serviceChoice) {
 		      				case 1:
 		      					System.out.println("Do you want book photography");
 		      					bookingChoice = sc.nextLine().charAt(0);
 		      					ServicesDao servicedao = new ServicesDao();
 		      					if (bookingChoice == 'Y' || bookingChoice == 'y') {
 		      						emailId = valideUser.getEmailId();
 									int userId = userDao.findUserId(emailId);
 									System.out.println("user" + userId);
 									System.out.println("Enter Service Name");
 									String serviceName = "photography";
 									int serviceId = servicedao.findServiceId();
 									System.out.println("service" + serviceId);
 									System.out.println("Enter Event Date");
 									String date = sc.nextLine();
 									double servicePackage = servicedao.findPackage(serviceId);
 									System.out.println("package" + servicePackage);
 									BookingServices bookService = new BookingServices(userId, serviceId, serviceName, date,
 											servicePackage);
 									BookingServicesDao bookingService = new BookingServicesDao();
 									bookingService.bookService(bookService);
 									emailId = valideUser.getEmailId();
			      					userId = userDao.findUserId(emailId);
									double totalpackage=bookingService.totalPackage(userId);
									System.out.println("Total package:"+totalpackage);
									int advance=(int) (totalpackage/4);
									System.out.println(advance);
									walletbal=0;
									try {
										walletbal = userDao.walletbal(userId);
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									 dedwallbal = (int) (walletbal - advance);
										System.out.println("\n 1.confirm order \n 2.cancel order");
										 orderConfirmation = sc.nextInt();
										sc.nextLine();
										switch (orderConfirmation) 
										{
										case 1:
											if (advance <= walletbal) {
												int upd=0;
												try {
													upd = userDao.updatewallet(dedwallbal, userId);
												} catch (Exception e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												if(upd > 0) {
													 bookService = new BookingServices(userId, serviceId, serviceName, date,
															servicePackage);
													BookingServicesDao bookservice = new BookingServicesDao();
													bookservice.bookService(bookService);
												System.out.println("order placed successfully!!!");
												}else {
													System.out.println("something went wrong try again!!");
												}
											} else {
												System.out.println("Low Balance please top up!!");
											}
											flag = 0;
											break;
										case 2:
											System.out.println("Order Cancelled");
											break;

										}	
 		      					}
 		      			  case 2:
 		      				  System.out.println("Do you want book Mehandi");
 		      				bookingChoice = sc.nextLine().charAt(0);
		      				  servicedao = new ServicesDao();
		      					if (bookingChoice == 'Y' || bookingChoice == 'y') {
		      						emailId = valideUser.getEmailId();
									int userId = userDao.findUserId(emailId);
									System.out.println("user" + userId);
									System.out.println("Enter Service Name");
									String serviceName="Mehadi";
									int serviceId = servicedao.findMehandiId();
									System.out.println("service" + serviceId);
									System.out.println("Enter Event Date");
									String date = sc.nextLine();
									double servicePackage = servicedao.findPackage(serviceId);
									System.out.println("package" + servicePackage);
									BookingServices bookService = new BookingServices(userId, serviceId, serviceName, date,
											servicePackage);
									BookingServicesDao bookingService = new BookingServicesDao();
									bookingService.bookService(bookService);
									emailId = valideUser.getEmailId();
			      					userId = userDao.findUserId(emailId);
									double totalpackage=bookingService.totalPackage(userId);
									System.out.println("Total package:"+totalpackage);
									int advance=(int) (totalpackage/4);
									System.out.println(advance);
									walletbal=0;
									try {
										walletbal = userDao.walletbal(userId);
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									 dedwallbal = (int) (walletbal - advance);
										System.out.println("\n 1.confirm order \n 2.cancel order");
										 orderConfirmation = sc.nextInt();
										sc.nextLine();
										switch (orderConfirmation) 
										{
										case 1:
											if (advance <= walletbal) {
												int upd=0;
												try {
													upd = userDao.updatewallet(dedwallbal, userId);
												} catch (Exception e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												if(upd > 0) {
													 bookService = new BookingServices(userId, serviceId, serviceName, date,
															servicePackage);
													BookingServicesDao bookservice = new BookingServicesDao();
													bookservice.bookService(bookService);
												System.out.println("order placed successfully!!!");
												}else {
													System.out.println("something went wrong try again!!");
												}
											} else {
												System.out.println("Low Balance please top up!!");
											}
											flag = 0;
											break;
										case 2:
											System.out.println("Order Cancelled");
											break;

										}	
		      					}
 		      			  case 3:
 		      				  System.out.println("Do yu want book Bridal Makeup");
 		      				bookingChoice = sc.nextLine().charAt(0);
		      				  servicedao = new ServicesDao();
		      					if (bookingChoice == 'Y' || bookingChoice == 'y') {
		      						emailId = valideUser.getEmailId();
									int userId = userDao.findUserId(emailId);
									System.out.println("user" + userId);
									System.out.println("Enter Service Name");
									String serviceName = "Bridal Makeup";
									int serviceId = servicedao.findMakeupId();
									System.out.println("service" + serviceId);
									System.out.println("Enter Event Date");
									String date = sc.nextLine();
									double servicePackage = servicedao.findPackage(serviceId);
									System.out.println("package" + servicePackage);
									BookingServices bookService = new BookingServices(userId, serviceId, serviceName, date,
											servicePackage);
									BookingServicesDao bookingService = new BookingServicesDao();
									bookingService.bookService(bookService);
			      					emailId = valideUser.getEmailId();
			      					userId = userDao.findUserId(emailId);
									double totalpackage=bookingService.totalPackage(userId);
									System.out.println("Total package:"+totalpackage);
									int advance=(int) (totalpackage/4);
									System.out.println(advance);
									walletbal=0;
									try {
										walletbal = userDao.walletbal(userId);
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									 dedwallbal = (int) (walletbal - advance);
										System.out.println("\n 1.confirm order \n 2.cancel order");
										 orderConfirmation = sc.nextInt();
										sc.nextLine();
										switch (orderConfirmation) 
										{
										case 1:
											if (advance <= walletbal) {
												int upd=0;
												try {
													upd = userDao.updatewallet(dedwallbal, userId);
												} catch (Exception e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												if(upd > 0) {
													 bookService = new BookingServices(userId, serviceId, serviceName, date,
															servicePackage);
													BookingServicesDao bookservice = new BookingServicesDao();
													bookservice.bookService(bookService);
												System.out.println("order placed successfully!!!");
												}else {
													System.out.println("something went wrong try again!!");
												}
											} else {
												System.out.println("Low Balance please top up!!");
											}
											flag = 0;
											break;
										case 2:
											System.out.println("Order Cancelled");
											break;

										}	
		      					}
 		      			  case 4:
 		      				  System.out.println("Do you want book Decoration");
 		      				bookingChoice = sc.nextLine().charAt(0);
		      				 servicedao = new ServicesDao();
		      					if (bookingChoice == 'Y' || bookingChoice == 'y') {
		      						emailId = valideUser.getEmailId();
									int userId = userDao.findUserId(emailId);
									System.out.println("user" + userId);
									System.out.println("Enter Service Name");
									String serviceName = "Decoration";
									int serviceId = servicedao.findDecorationId();
									System.out.println("service" + serviceId);
									System.out.println("Enter Event Date");
									String date = sc.nextLine();
									double servicePackage = servicedao.findPackage(serviceId);
									System.out.println("package" + servicePackage);
									BookingServices bookService = new BookingServices(userId, serviceId, serviceName, date,
											servicePackage);
									BookingServicesDao bookingService = new BookingServicesDao();
									bookingService.bookService(bookService);
			      					emailId = valideUser.getEmailId();
									 userId = userDao.findUserId(emailId);
									double totalpackage=bookingService.totalPackage(userId);
									System.out.println("Total package:"+totalpackage);
									int advance=(int) (totalpackage/4);
									System.out.println(advance);
									 walletbal=0;
									try {
										walletbal = userDao.walletbal(userId);
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									 dedwallbal = (int) (walletbal - advance);
										System.out.println("\n 1.confirm order \n 2.cancel order");
										 orderConfirmation = sc.nextInt();
										sc.nextLine();
										switch (orderConfirmation) 
										{
										case 1:
											if (advance <= walletbal) {
												int upd=0;
												try {
													upd = userDao.updatewallet(dedwallbal, userId);
												} catch (Exception e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												if(upd > 0) {
													 bookService = new BookingServices(userId, serviceId, serviceName, date,
															servicePackage);
													BookingServicesDao bookservice = new BookingServicesDao();
													bookservice.bookService(bookService);
												System.out.println("order placed successfully!!!");
												}else {
													System.out.println("something went wrong try again!!");
												}
											} else {
												System.out.println("Low Balance please top up!!");
											}
											flag = 0;
											break;
										case 2:
											System.out.println("Order Cancelled");
											break;
										}
		      					}
		      					
 		      				}
 		      			}
 		      			case 8:
 		      				RatingsDao ratings = new RatingsDao();
 		      				emailId = valideUser.getEmailId();
							int userId = userDao.findUserId(emailId);
 							System.out.println("Enter Service name");
 							String serviceName = sc.nextLine();
 							System.out.println("Give rating");
 							int rating = Integer.parseInt(sc.nextLine());
 							Ratings rate = new Ratings(userId, serviceName,rating);
 							ratings.insertRating(rate);
 							break;
 		      			case 9:
 		      				ratings = new RatingsDao();
 		      	             List<Ratings> ratingList=ratings.rating();
 							for (int i = 0; i < ratingList.size(); i++) {
 								System.out.println(ratingList.get(i));
 							}
 							break;
 						
//						if (bookingChoice == 'Y' || bookingChoice == 'y') {
//							System.out.println("Do you want photographer(Y/N)");
//							bookingChoice = sc.nextLine().charAt(0);
//							if (bookingChoice == 'Y' || bookingChoice == 'y') {
//								System.out.println("Choose the services you want!");
//								int serviceChoice = Integer.parseInt(sc.nextLine());
//								switch (serviceChoice) {
//								case 1:
//									emailId = valideUser.getEmailId();
//									id1 = userDao.findUserId(emailId);
//									System.out.println("user" + id1);
//									String serviceName = "Photographer";
//									System.out.println("Photographer booked");
//								}BookingServices bookService = new BookingServices()
//							}

//					case 4:
//						userDao = new UserDao();
//						System.out.println("Enter email id : ");
//						emailId = sc.nextLine();
//					   int id = userDao.findUserId(emailId);
//						System.out.println("User Id : " + id);
//						break;
//					case 5:
//						venuedao = new VenuesDao();
//						System.out.println("Enter venue Name : ");
//						String venueName = sc.nextLine();
//					   int venueId = venuedao.findVenueId(venueName);
//						System.out.println("venue Id : " + venueId);
//						break;
//					case 5:
//				     BookingVenuesDao bookVenue=new BookingVenuesDao();	
//				     System.out.println("Enter venue Id");
//				     int venueId=Integer.parseInt(sc.nextLine());
//				     System.out.println("Enter venue name");
//				     String venueName=sc.nextLine();
//				     System.out.println("enter no of guest");
//				     int noOfGuest=Integer.parseInt(sc.nextLine());
//				     System.out.println("enter function timing morning or evening");
//				     String functionTiming=sc.nextLine();
//				     System.out.println("enter event date");
//				     String eventDate=sc.nextLine();
//				     System.out.println("Enter venue package");
//				     double venuePackage=Double.parseDouble(sc.nextLine());
//						int userId=0;
//						BookingVenues bookvenue=new BookingVenues(userId,venueId,venueName,noOfGuest,functionTiming,eventDate,venuePackage);
//				     bookVenue.bookVenue(bookvenue);
					}
					
				}

				else
					System.out.println("invalid email and password");

			} while (flag == 0);

		}

	}
}