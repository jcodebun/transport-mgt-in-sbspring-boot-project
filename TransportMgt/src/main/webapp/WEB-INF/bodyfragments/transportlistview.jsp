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

<div class="container content" >

<h2 style="padding-top: 30px">Transport List</h2>
<%@include file="businessMessage.jsp" %>
<table class="table bg-light text-dark" style="margin-top: 20px;">
  <thead>
    <tr>
      <th scope="col">Vehicle Name</th>
      <th scope="col">Vehicle Type</th>
      <th scope="col">Number</th>
      <th scope="col">Storage Capacity</th>
      <th scope="col">Price Per Hour</th>
      <th scope="col">Booking Status</th>   
      <th scope="col">Image</th>    
       <c:if test="${sessionScope.user.userRole == 'Admin'}">  
      <th scope="col">Action</th>
      </c:if>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="li" varStatus="u">
    <tr>     
      <td>${li.name}</td>
      <td>${li.type}</td>
      <td>${li.number}</td>
      <td>${li.storage}</td>
      <td>${li.price}</td>
      <td>
      
      
      <c:choose>
      <c:when test="${li.bookingStatus == true}">
      Not Available
      <br>
      <c:if test="${sessionScope.user.userRole == 'Admin'}">
      <a href="${pageContext.request.contextPath}/markAvailable?id=${li.id}">Mark Available</a>
      </c:if>
      </c:when>
      <c:otherwise>
      Available
      
      </c:otherwise>
      
      </c:choose>
      
      </td>
      <td><img alt="" src="${pageContext.request.contextPath}/getTransportImage/${li.id}" width="150px" height="100px" ></td> 
       
      <td>    
       <c:if test="${sessionScope.user.userRole == 'Admin'}"> 
      <a href="${pageContext.request.contextPath}/transportEdit?id=${li.id}"><i class="fas fa-pen"></i></a>
      <a href="${pageContext.request.contextPath}/transportDelete?id=${li.id}"><i class="fas fa-trash"></i></a>    
       
     
      </c:if>
      <a class="btn btn-primary" href="${pageContext.request.contextPath}/booking?id=${li.id}">Book</a> 
       </td>
    </tr>
   </c:forEach>
  </tbody>
</table>

</div>

</body>
</html>