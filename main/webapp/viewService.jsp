<%@page import="com.weddingplanner.module.Services"%>
<%@page import="java.util.List"%>
<%@page import="com.weddingplanner.daoimpl.ServicesDaoimpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<%!
ServicesDaoimpl serviceDaoImpl = new ServicesDaoimpl();
List<Services> showservices ;%>
<%showservices=serviceDaoImpl.showServices(); 
%>
<% for(Services service: showservices){
	   System.out.println(service.getServiceImages());

                	%>
                
<section class="vendor" id="vendor">
    <div class=heading>
        <h1>SERVICES</h1>
    </div>
    <div class="box-container">
        <div class="box" class="box1">
         <a href="service1.jsp?servicename=<%=service.getServiceName()%>">
            <img src="<%=service.getServiceImages()%>" alt="hall"></a>
            <div class="info">
                <h3><%=service.getServiceName() %></h3>
                <a href ="service1.jsp?servicename=<%=service.getServiceName()%>" class="btn">Click</a>
            </div>
        </div>
        </div>
        
    </section>
 <%}%>
</body>
</html>