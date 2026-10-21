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

</head>
<body >

<div class="container" >

<h2 style="padding-top: 30px">Booking History</h2>
<%@include file="businessMessage.jsp" %>
<table class="table bg-light text-dark" style="margin-top: 30px;">
  <thead>
    <tr>
      <th scope="col">Transport Name</th>
      <th scope="col">Transport Number</th>
      <th scope="col">FirstName</th>
      <th scope="col">LastName</th>
      <th scope="col">Email</th>
      <th scope="col">PhoneNumber</th>
      <th scope="col">NumberOfHours</th> 
      <th scope="col">Total Price</th>  
      <th scope="col">Status</th>  
       <c:if test="${sessionScope.user.userRole == 'Admin'}">  
      <th scope="col">Action</th>
      </c:if>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="li" varStatus="u">
    <tr>     
      <td>${li.transportName}</td>
      <td>${li.transportNumber}</td>
      <td>${li.firstName}</td>
      <td>${li.lastName}</td>
      <td>${li.email}</td>
       <td>${li.phoneNumber}</td>
      <td>${li.numberOfHours}</td>
      <td>${li.totalPrice}</td>
      <td>${li.status}</td>
 
      <td>
      <c:if test="${li.status == 'Booked'}">
       <a href="${pageContext.request.contextPath}/cancelBooking?id=${li.id}" class="btn btn-danger">Cancel</a>
       </c:if>
      </td>


    </tr>
   </c:forEach>
  </tbody>
</table>

</div>

</body>
</html>