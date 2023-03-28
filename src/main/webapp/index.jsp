<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<style>
		body {
			background-color: #f2f2f2;
			font-family: Arial, sans-serif;
			display: flex;
			flex-direction: column;
			align-items: center;
			justify-content: center;
			height: 100vh;
			margin: 0;
		}
		form {
			background-color: #fff;
			border-radius: 10px;
			box-shadow: 0px 0px 10px 2px rgba(0,0,0,0.2);
			padding: 20px;
			width: 50%;
			max-width: 500px;
		}
		h1 {
			margin-top: 0;
		}
		input[type="file"] {
			margin-bottom: 10px;
		}
		input[type="submit"] {
			background-color: #1db954;
			border: none;
			border-radius: 5px;
			color: #fff;
			cursor: pointer;
			padding: 10px 20px;
			transition: background-color 0.2s ease-in-out;
		}
		input[type="submit"]:hover {
			background-color: #1ed760;
		}
		.box {
			background-color: #fff;
			border-radius: 10px;
			box-shadow: 0px 0px 10px 2px rgba(0,0,0,0.2);
			margin-top: 20px;
			padding: 20px;
			width: 50%;
			max-width: 500px;
			text-align: center;
		}
		.box span {
			color: #f00;
		}
	</style>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="UTF-8">
<title>Upload a file</title>


</head>

<body>



	<form method="post" action="/Assignment4/XMLParsing"
		enctype='multipart/form-data'>

		<table>
			<tr>
				<td>Upload the employee.xml file:</td>
			</tr>
			<tr>
				<td><input type="file" name="file" /></td>
				<td><input type="submit" value="Submit your file" /></td>
			</tr>
		</table>
	</form>


	<div class="box">
		<c:if test="${ not empty errorMessage}">
			<span style="color: red;">${errorMessage}</span>
		</c:if>
	</div>
</body>
</html>

