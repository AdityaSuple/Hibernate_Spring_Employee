<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Employees</title>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Employees Data List</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Name</th>
					<th>Date Of Birth</th>
					<th>Gender</th>
					<th>Address</th>
					<th>City</th>
					<th>State</th>
					<th>LoginId</th>
					<th>Password</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempEmployee" items="${employees}">
				
					<tr>
						<td> ${tempEmployee.name} </td>
						<td> ${tempEmployee.dateOfBirth} </td>
						<td> ${tempEmployee.gender} </td>
						<td> ${tempEmployee.address} </td>
						<td> ${tempEmployee.city} </td>
						<td> ${tempEmployee.state} </td>
						<td> ${tempEmployee.loginId} </td>
						<td> ${tempEmployee.password} </td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









