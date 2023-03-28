<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

th {
	background-color: #4CAF50;
	color: white;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

tr:hover {
	background-color: #ddd;
}

td a {
	color: #555;
	text-decoration: none;
}

td a:hover {
	color: #333;
	text-decoration: underline;
}

a {
	box-shadow: inset 0 0 0 0 #54b3d6;
	color: #54b3d6;
	margin: 0 -.25rem;
	padding: 0 .25rem;
	transition: color .3s ease-in-out, box-shadow .3s ease-in-out;
}

a:hover {
	box-shadow: inset 100px 0 0 0 #54b3d6;
	color: white;
}
</style>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="UTF-8">
<title>Customer Details</title>
</head>
<body>

	<h3>
		<c:out value="Customer Details for: ${customer.customerName}" />
	</h3>
	<table>
		<tr>
			<th>Field</th>
			<th>Value</th>
		</tr>
		<tr>
			<td>Customer Number</td>
			<td>${customer.customerNumber}</td>
		</tr>
		<tr>
			<td>Customer Name</td>
			<td>${customer.customerName}</td>
		</tr>
		<tr>
			<td>Phone</td>
			<td>${customer.phone}</td>
		</tr>
		<tr>
			<td>Address Line 1</td>
			<td>${customer.addressLine1}</td>
		</tr>
		<tr>
			<td>Address Line 2</td>
			<td>${customer.addressLine2}</td>
		</tr>
		<tr>
			<td>City</td>
			<td>${customer.city}</td>
		</tr>
		<tr>
			<td>State</td>
			<td>${customer.state}</td>
		</tr>
		<tr>
			<td>Postal Code</td>
			<td>${customer.postalCode}</td>
		</tr>
		<tr>
			<td>Country</td>
			<td>${customer.country}</td>
		</tr>
		<tr>
			<td>Sales Representative Number</td>
			<td>${customer.salesRepEmployeeNumber}</td>
		</tr>
		<tr>
			<td>Credit Limit</td>
			<td>${customer.creditLimit}</td>
		</tr>
	</table>

</body>
</html>