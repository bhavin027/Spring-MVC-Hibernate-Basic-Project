<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Web Customer Tracker- Customer List</title>
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
				
				<!-- Button to add new customer -->
				<input type="button" value="Add Customer" 
					onclick="window.location.href='showCustomerForm'"
					class="add-button"
				/>
				<!-- List of Customers -->
				<table>
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="tempCustomer" items="${customers}">
							<!-- Construct an update url with id -->
							<c:url var="updateLink" value="/customer/showUpateForm">
								<c:param name="customerId" value="${tempCustomer.id}" />
							</c:url>
							
							<tr>
								<td>${tempCustomer.firstName}</td>
								<td>${tempCustomer.lastName}</td>
								<td>${tempCustomer.email}</td>
								<td><a href="${updateLink}">Update</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>