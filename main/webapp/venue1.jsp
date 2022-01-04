<%@page import="com.weddingplanner.module.Venues"%>
<%@page import="java.util.List"%>
<%@page import="com.weddingplanner.daoimpl.VenuesDaoimpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%!
VenuesDaoimpl venueDaoImpl = new VenuesDaoimpl();
List<Venues> showVenue;%>
<%/*  String venueName=(String)session.getAttribute("venuename");
showVenue=venueDaoImpl.allVenue(venueName); */
 
String venuename=request.getParameter("venueName");
System.out.println("jap page"+venuename);
Venues venue= venueDaoImpl.allVenue(venuename);
 System.out.println(venue);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
img {
width:500px;
heidht:600px;
}

</style>
</head>
<body>
    <form action="" method="post">
    <img src="<%=venue.getVenueImages()%>" alt="hall"><br>
             <span>Venue name: <%=venue.getVenueName() %> </span><br>
             <span> venue area:<%=venue.getVenueArea()%>  </span><br>
             <span>venue city: <%=venue.getVenueCity()%> </span><br>
            <span>contact number:<%=venue.getContactNumber() %> </span><br>
            <span>venue type:<%=venue.getVenueType() %></span><br>
           <span>venue vendor name:<%=venue.getVenueVendorName() %></span><br>
           <span>venue package:<%=venue.getVenuePackage() %></span><br>
            <span>Availability:<%=venue.getAvailability() %></span><br>
               <input type="submit" value="book">
               </form>
               
</body>
</html>