<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 body {
            font-family: Arial, sans-serif;
            background-image: url('https://www.shutterstock.com/image-vector/vector-3d-illustration-airplane-clouds-600nw-2143367099.jpg'); /* Path to your background image */
            background-size: cover; /* Cover the entire page */
            background-position: center; /* Center the image */
            background-repeat: no-repeat; /* Do not repeat the image */
            height: 100vh; /* Ensure body takes full height */
            margin: 0; /* Remove default margin */
        }
</style>
</head>

<body>

<body vlink="yellow" link="yellow" alink="red">


<div align ="center">
<h1>
<u><i>All Flights</i></u>
</h1>
<table border="1">
            <tr>
            	<th>Flight Number</th>
                <th>Airlines Name</th>
                <th>Route Id</th>
                <th>Departure</th>
                <th>Arrival</th>
                
            </tr>
            <c:forEach items="${flightList}" var="flight" >
			<tr>
                <td>${flight.flightNumber}</td>
                <td>${flight.carrierName}</td>
                <td>${flight.routeId}</td>
                <td>${flight.departure}</td>
                <td>${flight.arrival}</td>

            </tr>
</c:forEach>
</table>
<br><br><br>
<a href="index">Back to Home</a>
</div>
</body>
</html>