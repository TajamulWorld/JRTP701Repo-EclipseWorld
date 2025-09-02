<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

	
	<h1 style="color: red;text-align: center;"> Edit Employee Form </h1>
	
	<frm:form modelAttribute="emp">
		<table style="background-color: cyan" align="center">
			<tr>
				<td>Employee No</td>
				<td> <frm:input path="empno" readonly="true" /> </td>
			</tr>
			<tr>
				<td>Name</td>
				<td> <frm:input path="ename" /> </td>
			</tr>
			<tr>
				<td>Job</td>
				<td> <frm:input path="job" /> </td>
			</tr>
			<tr>
				<td>Salary</td>
				<td> <frm:input path="sal" /> </td>
			</tr>
			<tr>
				<td>Dept No</td>
				<td>
					<frm:select path="deptno">
						<frm:option value="10">10</frm:option>
						<frm:option value="20">20</frm:option>
						<frm:option value="30">30</frm:option>
					</frm:select> 	
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="edit">
					&nbsp;&nbsp;<input type="reset" value="cancel">
				</td>
			</tr>
		</table>
	</frm:form>
	
	
	<br><br>
	<h1 style="text-align: center;">
		<a href="./"><img src="images/home.jpg" width="200px"></a>
	</h1>