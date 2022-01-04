<%@page import="org.apache.catalina.connector.Request"%>
<%@page import="com.weddingplanner.module.Services"%>
<%@page import="com.weddingplanner.daoimpl.ServicesDaoimpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
ServicesDaoimpl serviceDaoImpl = new ServicesDaoimpl();
%>
<%String serviceName=request.getParameter("servicename");
Services service=serviceDaoImpl.allService(serviceName);
 %>
 <img src="<%=service.getServiceImages()%>" alt="hall">
             <span>Venue name: <%=service.getServiceName() %> </span><br>
             <span> venue area:<%=service.getServicePackage()%>  </span><br>
            
</body>
</html>