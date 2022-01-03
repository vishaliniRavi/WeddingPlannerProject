<%@page import="com.weddingplanner.module.Venues"%>
<%@page import="java.util.List"%>
<%@page import="com.weddingplanner.daoimpl.VenuesDaoimpl"%>
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
VenuesDaoimpl venueDaoImpl = new VenuesDaoimpl();
List<Venues> showVenue;%>
<div class="venue">
 <%int count=0;
                for(Venues venue: showVenue){
                	%>
        <div class="for-inline">
        <div class="image-container">
            <img src=<%=venue.getVenueImages()%>alt="hall">
            <div class="title">
                <h2>Asirvatham Mahal</h2>
                <pre><i class="fas fa-map-marker-alt"></i> Medavakkam,Chennai   <i class="fas fa-hotel"></i> Banquet halls/Kalyan Mandapam</pre>
            </div>
        </div>
        </div>
        </div>
</body>
</html>