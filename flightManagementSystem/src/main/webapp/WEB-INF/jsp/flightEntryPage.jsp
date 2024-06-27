<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<div align="center" >
<h3>
 <form:form action="/flight" method="post" modelAttribute="flightRecord">
 <table>
 <tr>
 <td>
  Enter Flight ID :  </td>
  <td> <form:input path="flightNumber"/> </td>
  </tr>
 
 <tr>
 <td>
  Enter Airlines Name :  </td>
  <td>  <form:input path="carrierName"/>  </td>
  </tr>
  
  <tr>
 <td>
  Select Route ID :  </td>
  <td>  <form:input list ="routes" path="routeId"/>  </td>
  </tr>
  
  <datalist id ="routes">
   <c:forEach items="${routeList}" var="route">
           <option value ="${route}">
           </option>
    </c:forEach>
    </datalist>
    
    <tr>
 <td>
  Enter Seat Capacity :  </td>
  <td>  <form:input path="seatCapacity"/>  </td>
  </tr>
  
    <tr>
 <td>
  Enter Departure Time :  </td>
  <td>  <form:input path="departure"/>  </td>
  </tr>
  
    <tr>
 <td>
  Enter Arrival Time :  </td>
  <td>  <form:input path="arrival"/>  </td>
  </tr>

 <tr>
 <td>
  Enter Return Flight Departure Time:</td>
  <td> <input type = "text" name = "dtime"/> </td>
  </tr>

<tr>  <td>
  Enter Return Flight Arival Time: </td>
 <td> <input type = "text" name = "atime"/> </td>
 </tr>
  
</table>   
     
  <button type ="submit">Submit</button>
    <button type ="reset">Reset</button> 
</form:form>
</h3>
<a href="index">Back to Home</a>
</div>
</body>
</html>