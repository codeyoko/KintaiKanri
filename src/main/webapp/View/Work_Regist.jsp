<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤務時間登録</title>
<!-- bootstrap core css  -->
<link rel="stylesheet" type="text/css" href="css/kintai.css"/>
<link rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>
	<div class="wrapper">
		<div class="title_content">
			<h1>勤務時間登録</h1>
		</div>
		<div class="main_content_regist">
			<form action="InsertWorkController" method="post">
				<table>
					<tr>
						<td>日付</td>
						<td class="inp_tag"><input type="date" name="work_day" value="" size=25></td>
					</tr>
					<tr>
						<td>社員番号</td>
						<td class="inp_tag"><input type="text" name="emp_code" value="" size=25></td>
					</tr>
					<tr>
						<td>出勤時刻</td>
						<td class="inp_tag"><input type="time" name="start_hour" value="" size=25 ></td>
					</tr>
					<tr>
						<td>退勤時刻</td>
						<td class="inp_tag"><input type="time" name="end_hour" value="" size=25></td>
					</tr>
				</table>
				<br>
				
				
				<div class="btn_group">
					<a href="HomePageForward" style="text-decoration: none;color:black;">キャンセル</a>
					<input type="submit" name="submit" value="登録" />
				</div>
			
			</form>
			<!-- エラーメッセージが存在するときだけ表示する -->
			<div class="error">
				<b style="color:red"><%= request.getAttribute("errmgs3") != null ? request.getAttribute("errmgs3") : "" %></b>
				<b style="color:red"><%= request.getAttribute("errmgs4") != null ? request.getAttribute("errmgs4") : "" %></b>
			</div>
		</div>
	</div>
	
</body>
</html>