<%@page import="BEAN.SearchEmpAndWork"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤務時間検索</title>
<!-- bootstrap core css  -->
<link rel="stylesheet" type="text/css" href="css/kintai.css"/>
<link rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>
	<div class="wrapper_wsearch">
		<div class="title_content">
			<h1>勤務時間検索</h1>
		</div>
		<div class="main_content_regist">
			<form action="SearchWorkController" method="post">
				<table>
					<tr>
						<td>
							<select name="selectOption">
								<option value="depatment" <%= "depatment".equals(request.getParameter("selectOption")) ? "selected" : "" %>>部署名</option>
								<option value="workdate" <%= "workdate".equals(request.getParameter("selectOption")) ? "selected" : "" %>>日付</option>
							</select>
						</td>
						<td>
							<input type="text" name="search_key" size="25" placeholder="ここに入力してください" required>
						</td>
					</tr>
					
				</table>
				<div class="btn_sgroup">
					<a href="HomePageForward" style="text-decoration: none;color:black;">キャンセル</a>
					<input type="submit" name="submit" value="検索" />
				</div>
			
			</form>
			<!-- エラーメッセージが存在するときだけ表示する -->
			<div class="error">
				<span style="color:red"><%= request.getAttribute("errmgs4") != null ? request.getAttribute("errmgs4") : "" %></span>
			</div>
		</div>
		
		<!-- 検索結果表示 -->
		<div class="sech_rest">
			<% ArrayList<SearchEmpAndWork> SearchEmpList = (ArrayList)request.getAttribute("WorkingList"); %>
			<% if(SearchEmpList != null) { %>
				<table class="table table-bordered border-primary">
					<thead>
						<tr>
							<th scope="col">名前</th>
							<th scope="col">日付</th>
							<th scope="col">総労働時間</th>
							<th scope="col">残業時間</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${WorkingList}" var="list">
							<tr>
							    <td>${list.empName }</td>
							    <td>${list.workDate }</td>
							    <td>${list.workTime }</td>
							    <td>${list.overTime }</td>
							<tr>
						</c:forEach>
						
					</tbody>
				</table>
			 <% } %>
		</div>
	</div>
</body>
</html>