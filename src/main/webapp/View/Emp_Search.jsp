<%@page import="BEAN.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員検索</title>
<!-- bootstrap core css  -->
<link rel="stylesheet" type="text/css" href="css/kintai.css"/>
<link rel="stylesheet" href="css/bootstrap.css" />

</head>
<body>
	<div class="wrapper_esearch">
		<div class="title_content">
			<h1>社員検索</h1>
		</div>
		<div class="main_content_regist">
			<form action="SearchEmController" method="post">
				<table>
					<tr>
						<td>
							<select name="selectOption">
								<option value="age" <%= "age".equals(request.getParameter("selectOption")) ? "selected" : "" %>>年齢</option>
								<option value="workYear" <%= "workYear".equals(request.getParameter("selectOption")) ? "selected" : "" %>>入社年数</option>
								<option value="retiree" <%= "retiree".equals(request.getParameter("selectOption")) ? "selected" : "" %>>退職者</option>
								<option value="depatment" <%= "depatment".equals(request.getParameter("selectOption")) ? "selected" : "" %>>部署名</option>
							</select>
						</td>
						<td>
							<input type="text" id="search_key" name="search_key" size="25" required>
						</td>
					</tr>
					
				</table>
				<div class="btn_sgroup">
					<a href="HomePageForward" style="text-decoration: none;color:black;">キャンセル</a>
					<input type="submit" value="検索" />
				</div>
			</form>
			<!-- エラーメッセージが存在するときだけ表示する -->
			<div class="error">
				<span style="color:red"><%= request.getAttribute("errmgs3") != null ? request.getAttribute("errmgs3") : "" %></span>
				<b style="color:red"><%= request.getAttribute("errmgs2") != null ? request.getAttribute("errmgs2") : "" %></b>
			</div>
			
		</div>
		
		<!-- 検索結果表示 -->
		<div class="sech_rest">
			<% ArrayList<Employee> EmpList = (ArrayList)request.getAttribute("EmployeeList"); %>
			<% if(EmpList != null) { %>
				<table class="table table-bordered border-primary">
					<thead>
						<tr>
							<th scope="col">社員番号</th>
							<th scope="col">入社日</th>
							<th scope="col">名前</th>
							<th scope="col">生年月日</th>
							<th scope="col">退職日</th>
							<th scope="col">部署名</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${EmployeeList}" var="EmpList">
							<tr>
							    <td>${EmpList.empCode }</td>
							    <td>${EmpList.startDay }</td>
							    <td>${EmpList.empName }</td>
							    <td>${EmpList.empBirthDay }</td>
							    <td>${EmpList.lastDay }</td>
							    <td>${EmpList.depatment }</td>
							<tr>
						</c:forEach>
						
					</tbody>
			</table>
			<% }  %>
		</div>
	</div>
</body>
</html>