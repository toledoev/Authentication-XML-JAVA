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
<title>All Customers</title>
</head>
<body>

	<h3>
		<c:out value="All Customers" />
	</h3>
	<table>


		<tr>

			<th align="center" >Customer Number</th>
			<th align="center">Customer Name</th>
			<th align="center">Phone</th>
			<th align="center"></th>


		</tr>
		<c:forEach var="customer" items="${customerList}">

			<tr>
				<td>${customer.customerNumber}</td>
				<td>${customer.customerName}</td>
				<td>${customer.phone}</td>
				<td><a
					href="/Assignment4/GetOneCustServlet?custid=${customer.customerNumber}">
						More Details</a></td>

			</tr>
		</c:forEach>


	</table>


</body>
</html>