<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form action="<c:url value='/StaffInsert'/>" method="post">
	<table>
		<tr>
			<td>이름 :</td>
			<td><input type="text" name="s_name" /></td>
		</tr>
		<tr>
			<td>주민번호 :</td>
			<td><input type="text" name="s_secnoFront"/>
			<label> - </label>  </td>
			<td><input type="text" name="s_secnoBack"/></td>
		</tr>
		<tr>
			<td>종교</td>
			<td>
				<select name="r_name">
					<option></option>
					<option></option>
					<option></option>
					<option></option>
				</select>
			</td>
		</tr>
		<tr>
			<td><label>학력 :</label></td>
			<td>
				<input type="radio" name="sc_graduate"/>고졸
				<input type="radio" name="sc_graduate"/>전문대졸
				<input type="radio" name="sc_graduate"/>일반대졸
			</td>
		</tr>
		
		<tr>
			<td>기술</td>
			<td>
				<c:forEach var="i" items="${skill}">
					<input type="checkbox" name="sk_name" id="sk_name" value="${i.sk_no}"/>${i.sk_name}	
				</c:forEach>
			</td>
		</tr>
		
	</table>
	<input type="submit" value="등록" />
	<input type="reset" value="취소" />
</form>
</body>
</html>