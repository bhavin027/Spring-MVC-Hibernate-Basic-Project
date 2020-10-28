<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Web Customer Tracker- Add Customer</title>
		<!-- reference to css files -->
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css" />
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>CRM- Customer Relationship Manager</h2>
			</div>
		</div>
		<div id="container">
			<div id="content">
				<h3>Add New Customer</h3>
				<form:form action="saveCustomer" modelAttribute="customer" method="post">
					<table class="customerForm">
						<tbody>
							<tr>
								<td><label>First Name:</label></td>
								<td><form:input path="firstName" /></td>
							</tr>
							<tr>
								<td><label>Last Name:</label></td>
								<td><form:input path="lastName" /></td>
							</tr>
							<tr>
								<td><label>Email:</label></td>
								<td><form:input path="email" /></td>
							</tr>
							<tr>
								<td><label></label></td>
								<td><input type="submit" value="Save" class="save" /></td>
							</tr>
						</tbody>
					</table>
				</form:form>
				<div style="clear;both;"></div>
				<p>
					<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
				</p>
			</div>
		</div>
	</body>
</html>