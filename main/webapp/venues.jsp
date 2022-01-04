<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="com.weddingplanner.daoimpl.VenuesDaoimpl" %>
    <% VenuesDaoimpl venueDao=new VenuesDaoimpl();%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
form{
            text-align: center;
            margin-top:25px;
        }                                          
       
</style>
</head>
<body>

<form action="insert" method="post">
<h1>venue details</h1>
venue name:<input type="text" name="venueName"><br><br>
venue area:<input type="text" name="venueArea"><br><br>
venue city:<input type="text" name="city"><br><br>
venue type:<input type="text" name="venueType"><br><br>
venue vendor name:<input type="text" name="vendorName"><br><br>
contact number:<input type="number" name="contactNumber"><br><br>
venue Package:<input type="number" name="venuePackage"><br><br>
availability:<input type="text" name="availability"><br><br>
<input type="submit" value=submit>
</form>
</body>
</html>