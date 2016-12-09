<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/module/templateTop.jsp"%>
<div class="container">
	<form action="<c:url value='/StaffInsert'/>" method="post">
		<table border="1" class="table table-bordered">
			<tr>
				<td>�̸�</td>
				<td colspan="2"><input type="text" name="s_name" size="45"/></td>
			</tr>
			<tr>
				<td>�ֹι�ȣ</td>
				<td >
					<input type="text" name="s_secnoFront"/>
					<label> - </label>
				</td>  
				<td><input type="text" name="s_secnoBack"/></td>
			</tr>
			<tr>
				<td>����</td>
				<td colspan="2">
					<select name="r_no">
						<option>��������</option>
						<c:forEach var="religionList" items="${religionList}">
							<option value="${religionList.r_no}">${religionList.r_name} </option> 
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td><label>�з�</label></td>
				<td colspan="2">
					<c:forEach var="schoolList" items="${schoolList}">
						<input type="radio" name="sc_no" value="${schoolList.sc_no}"/>${schoolList.sc_graduate}
					</c:forEach>
				</td>
			</tr>
			
			<tr>
				<td>���</td>
				<td colspan="2">
					<c:forEach var="skillList" items="${skillList}">
						<input type="checkbox" name="sk_no" value="${skillList.sk_no}"/>${skillList.sk_name}	
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td>������</td>
				<td colspan="2">
					<input type="date" name="s_graduateday" />
				</td>
			</tr>
			
		</table>
		<input type="submit" value="���" />
		<input type="reset" value="���" />
	</form>
</div>	
<%@ include file="/module/templateBottom.jsp"%>