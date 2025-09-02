<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

	<h3 style="color: red;text-align: center;"> Search Employees </h3>
	<frm:form action="search" modelAttribute="emp">
		<table align="center" style="background-color: lime;">
			<tr>
				<td>Employee Name :</td>
				<td><frm:input path="ename" /></td>
			</tr>
			<tr>
				<td>Employee Job :</td>
				<td><frm:input path="job"/></td>
			</tr>
			<tr>
				<td>Employee Salary :</td>
				<td><frm:input path="sal"/></td>
			</tr>
			<tr>
				<td>Employee Dept No :</td>
				<td>
					<%-- <frm:select path="deptno">
						<frm:option value="">--select dept--</frm:option>
						<frm:option value="10">10</frm:option>
						<frm:option value="20">20</frm:option>
						<frm:option value="30">30</frm:option>
					</frm:select> --%>
					<frm:checkboxes items="${dept}" path="deptno" />					
				</td>
			</tr>
			<tr>	
				<td></td>
				<td>
					<input type="submit" value="search with data">
					<input type="reset" value="cancel"/>
				</td>	
			</tr>
		</table>
	</frm:form>
	
	<br><hr><br>
	
	<h1 style="color: green;text-align: center;">${registerMsg}</h1>
	
	<c:choose>
		<c:when test="${!empty empList}">
			<h1 style="color: red;text-align: center;"> Registered Employees Report </h1>
			<table border="1" style="background-color: yellow;" align="center">
				<tr style="background-color: aqua;">
					<th>empno</th>
					<th>ename</th>
					<th>job</th>
					<th>sal</th>
					<th>deptno</th>
					<th>operations</th>
				</tr>
				<c:forEach var="emp" items="${empList}">
					<tr>
						<td>${emp.empno}</td>
						<td>${emp.ename}</td>
						<td>${emp.job}</td>
						<td>${emp.sal}</td>
						<td>${emp.deptno}</td>
						<td><a href="edit?no=${emp.empno}"><img src="images/edit.jpg" width="30px"></a>
							&nbsp;&nbsp;&nbsp; <a onclick="return confirm('Are you sure to delete??')" href="delete?no=${emp.empno}"><img src="images/delete.jpg" width="30px"></a>  </td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1 style="text-align: center;">No Employee registered</h1>
		</c:otherwise>
	</c:choose>
	
	<br><br>
	<h1 style="text-align: center;">
		<a href="register"><img src="images/add.jpg" width="100px">Add new Employee</a>
	</h1>
	
	<br><br>
	<h1 style="text-align: center;">
		<a href="./"><img src="images/home.jpg" width="200px"></a>
	</h1>