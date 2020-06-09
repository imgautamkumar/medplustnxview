<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Statement</title>
</head>
<body
	style="font-family: consolas; font-size: 20px; background-color: hsla(9, 100%, 64%, 0.5);">
	<div align="center">
		<h2>Account Statement</h2>

		<form:form commandName="accountStatementCommand" id="myForm">
			<span style="color: red"> <form:errors path="*"></form:errors>
			</span>
			<br>
	Account : <form:input path="account" />
			<br>
	From Date : <form:input path="fromDate" />
			<br>
	To Date : <form:input path="toDate" />
			<br>
			<input type="hidden" id="a1" name="statementType" value="normal" />
			<input type="submit" name="show" value="show">
			<br>
		</form:form>
	</div>

	<c:if test="${not empty statements}">
		<div align="center">
			Download in format : <a href="#" onclick="myFunction('pdf')"
				style="color: red;">pdf</a> or <a href="#"
				onclick="myFunction('xls')" style="color: red;">xls</a>
			<table border="1" style="background-color: orange; color: white">
				<tr>
					<th>txno</th>
					<th>transaction Date</th>
					<th>remarks</th>
					<th>debit</th>
					<th>credit</th>
					<th>available balance</th>
				</tr>
				<c:forEach items="${statements}" var="statement">
					<tr>
						<td>${statement.txNo}</td>
						<td>${statement.transactionDate}</td>
						<td>${statement.remarks}</td>
						<td>${statement.debit}</td>
						<td>${statement.credit}</td>
						<td>${statement.availableBalance}</td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</c:if>

	<script language="javascript">
		function process(showed) {
			document.getElementById("a1").value = showed;
			document.getElementById("myForm").submit();
		}
		function myFunction(showed) {
			process(showed);
		}
	</script>


</body>
</html>