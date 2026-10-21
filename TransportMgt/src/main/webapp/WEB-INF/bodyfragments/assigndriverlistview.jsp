<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assigned Vehicle for You</title>
</head>
<body>

<div class="container content">

<h2 style="padding-top: 30px; margin-bottom: 20px">Assigned Vehicles</h2>
<%@include file="businessMessage.jsp" %>
<table class="table bg-light text-dark">
  <thead>
    <tr>
      <th scope="col">Driver Name</th>
      <th scope="col">Vehicle Number</th>
  
    </tr>
  </thead>
  <tbody>
  
  <c:forEach items="${list}" var="li" varStatus="u">
    <tr>     
      <td>${li.driverName}</td>
      <td>${li.transportNumber}</td>
    </tr>
   </c:forEach>
  </tbody>
</table>

</div>

</body>
</html>