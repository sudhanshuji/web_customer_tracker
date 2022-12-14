<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>List Customers</title>
	<!-- reference our style sheet  -->
	<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css ">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
		
		<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd';return false;"
				class="add-button"/>
			<!--  add our html table here -->
			<table>
				<tr>
					<th>First Name
					<th>Last Name
					<th>Email
					<th>Action
				</tr>

				<!-- loop over and print our customer -->
				<c:forEach var="tempCustomer" items="${customers}">
					
					<!-- construct an update link with customer Id -->
					<c:url var="updateLink" value="/customer/showFormUpdate">
						<c:param name="customerId" value="${tempCustomer.id }">
						</c:param>
					</c:url>
					
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id }">
						</c:param>
					</c:url>
					
					<tr>
					
						<td>${tempCustomer.firstName}
						<td>${tempCustomer.lastName}
						<td>${tempCustomer.email}
						<td><a href="${updateLink }">Update</a>
							<a href="${deleteLink }" 
							onclick="if (!(confirm('Are you sure you want to delete this customer'))) return false">| Delete</a>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>
</body>
</html>