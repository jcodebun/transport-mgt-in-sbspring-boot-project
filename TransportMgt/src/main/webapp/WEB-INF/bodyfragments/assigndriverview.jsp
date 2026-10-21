<%@page import="java.text.DateFormat"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page import="java.util.Date"%>



<body>
	<section class="vh-100 gradient-custom ">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-md-5 col-lg-5 col-xl-4 image-class">
					<img
						src="https://i.pinimg.com/736x/4b/39/a9/4b39a94252cddcc7d20326c140278c4e.jpg"
						class="img-fluid" alt="Phone image">
				</div>
				<div class="col-md-9 col-lg-7 col-xl-7 offset-xl-1">
					<div class="card shadow-2-strong card-registration">
						<div class="card-body p-4 p-md-5">
							<%@include file="businessMessage.jsp"%>
							<c:choose>
								<c:when test="${form.id>0}">
									<h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Edit</h3>
								</c:when>

								<c:otherwise>
									<h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Assign Driver Form</h3>
								</c:otherwise>
							</c:choose>



							<sf:form method="post"
								action="${pageContext.request.contextPath}/addAssigndriver"
								modelAttribute="form">
								
								<sf:input type="hidden" id="id"
									class="form-control form-control-lg" path="id" name="id"
									value="${form.id}" />

								<div class="row">
									<div class="col-md-6 mb-4">
										<div class="form-outline">
											<sf:select class="select form-control-lg"
												path="transportId">
												<option selected="true" disabled="disabled">Select
													Transport Number</option>
												<c:forEach var="transport" items="${transportList}">
													<sf:option value="${transport.id}"
														label="${transport.number}" />
												</c:forEach>
											</sf:select>

										</div>

									</div>
								</div>
								
									<div class="row">
									<div class="col-md-6 mb-4">
										<div class="form-outline">
											<sf:select class="select form-control-lg"
												path="driverId">
												<option selected="true" disabled="disabled">Select
													Driver Name</option>
												<c:forEach var="driver" items="${driverList}">
													<sf:option value="${driver.id}"
														label="${driver.firstName}" />
												</c:forEach>
											</sf:select>

										</div>

									</div>
								</div>


								<c:choose>
									<c:when test="${form.id>0}">
										<div>
											<input class="btn btn-primary btn-lg" type="submit"
												value="Update" />
										</div>
									</c:when>

									<c:otherwise>
										<div>
											<input class="btn btn-primary btn-lg" type="submit"
												value="Submit" />
										</div>
									</c:otherwise>
								</c:choose>

							</sf:form>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>