<%@page import="java.text.DateFormat"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

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
							<h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Booking Form</h3>
							<sf:form method="post"
								action="${pageContext.request.contextPath}/addBooking"
								modelAttribute="form">
								<sf:input type="hidden" id="id"
									class="form-control form-control-lg" path="id" name="id"
									value="${form.id}" />

								<sf:input type="hidden" id="userId"
									class="form-control form-control-lg" path="userId"
									name="userId" value="${user.id}" />

								<sf:input type="hidden" id="transportId"
									class="form-control form-control-lg" path="transportId"
									name="transportId" value="${transport.id}" />

								<div class="row">
									<div class="col-md-6 mb-4">
										<div class="form-outline">
											<s:bind path="firstName">
												<label class="form-label" for="firstName">First Name</label>
												<sf:input type="text" id="firstName"
													class="form-control form-control-lg" path="firstName"
													name="firstName" value="${user.firstName}" readonly="true" />
												<font color="red" style="font-size: 15px"><sf:errors
														path="${status.expression}" /></font>
											</s:bind>


										</div>

									</div>
									<div class="col-md-6 mb-4">

										<div class="form-outline">
											<s:bind path="lastName">
												<label class="form-label" for="lastName">Last Name</label>
												<sf:input type="text" id="lastName"
													class="form-control form-control-lg" path="lastName"
													value="${user.lastName}" readonly="true" />
												<font color="red" style="font-size: 15px"><sf:errors
														path="${status.expression}" /></font>
											</s:bind>
										</div>

									</div>

								</div>


								<div class="row">
									<div class="col-md-6 mb-4 pb-2">
										<s:bind path="email">
											<div class="form-outline">
												<label class="form-label" for="email">Email</label>
												<sf:input type="tel" id="email"
													class="form-control form-control-lg" path="email"
													value="${user.email}" readonly="true" />
												<font color="red" style="font-size: 15px"><sf:errors
														path="${status.expression}" /></font>
											</div>
										</s:bind>
									</div>

									<div class="col-md-6 mb-4 pb-2">
										<s:bind path="phoneNumber">
											<div class="form-outline">
												<label class="form-label" for="phoneNumber">Phone
													Number</label>
												<sf:input type="tel" id="phoneNumber"
													class="form-control form-control-lg" path="phoneNumber"
													value="${user.phoneNumber}" readonly="true" />
												<font color="red" style="font-size: 15px"><sf:errors
														path="${status.expression}" /></font>
											</div>
										</s:bind>
									</div>
								</div>

								<div class="row">
									<div class="col-md-6 mb-4 pb-2">
										<s:bind path="transportName">
											<div class="form-outline">
												<label class="form-label" for="transportName">Transport Name</label>
												<sf:input type="text" id="transportName"
													class="form-control form-control-lg" path="transportName"
													value="${transport.number}" readonly="true" />
												<font color="red" style="font-size: 15px"><sf:errors
														path="${status.expression}" /></font>
											</div>
										</s:bind>
									</div>

									<div class="col-md-6 mb-4 pb-2">
										<s:bind path="transportNumber">
											<div class="form-outline">
												<label class="form-label" for="phoneNumber">Transport Number</label>
												<sf:input type="text" id="transportNumber"
													class="form-control form-control-lg" path="transportNumber"
													value="${transport.name}" readonly="true" />
												<font color="red" style="font-size: 15px"><sf:errors
														path="${status.expression}" /></font>
											</div>
										</s:bind>
									</div>
								
								</div>

								<div class="row">
									<div class="col-md-6 mb-4 pb-2">
										<s:bind path="numberOfHours">
											<div class="form-outline">
												<label class="form-label" for="numberOfHours">Number
													Of Hours</label>
												<sf:input type="tel" id="numberOfHours"
													class="form-control form-control-lg" path="numberOfHours" />
												<font color="red" style="font-size: 15px"><sf:errors
														path="${status.expression}" /></font>
											</div>
										</s:bind>
									</div>
								</div>



								<c:choose>
									<c:when test="${form.id>0}">
										<div>
											<input class="btn btn-primary btn-lg" type="submit"
												value="Submit" />
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