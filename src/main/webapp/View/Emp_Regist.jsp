<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員登録</title>
<!-- bootstrap core css  -->
<link rel="stylesheet" type="text/css" href="css/kintai.css"/>
<link rel="stylesheet" href="css/bootstrap.css" />
</head> 
<body>
	<div class="wrapper">
		<div class="title_content">
			<h1>社員登録</h1>
		</div>
		<div class="main_content_regist">
			<form action="InsertProcessController" method="post">
				<table>
					<tr class="tr_tag">
						<td>社員番号</td>
						<td class="inp_tag"><input type="text" name="emp_code" value="" size=25></td>
					</tr>
					<tr class="tr_tag">
						<td>入社日</td>
						<td class="inp_tag"><input type="date" name="start_day" value="" max="2023-12-31" size=25></td>
					</tr>
					<tr class="tr_tag">
						<td>名前</td>
						<td class="inp_tag"><input type="text" name="emp_name" value="" size=25></td>
					</tr>
					<tr class="tr_tag">
						<td>生年月日</td>
						<td class="inp_tag"><input type="date" name="emp_birthday" value="" min="1970-01-01" max="2023-12-31" size=25></td>
					</tr>
					<tr class="tr_tag">
						<td>退職日</td>
						<td class="inp_tag"><input type="date" name="last_day" value="" size=25></td>
					</tr>
					<tr class="tr_tag">
						<td>部署名</td>
						<td class="inp_tag"><input type="text" name="dept_name" value="" size=25></td>
					</tr>
				</table>
				<br>
				
				<div class="btn_group">
					<!-- <button type="button" class="btn_back" onclick="Homepage_back()">キャンセル</button> -->
					<a href="HomePageForward" style="text-decoration: none;color:black;">キャンセル</a>
					<input type="submit" name="submit" value="登録" />
				</div>
			</form>
			<!-- エラーメッセージが存在するときだけ表示する -->
			<div class="error">
				<b style="color:red"><%= request.getAttribute("errmgs1") != null ? request.getAttribute("errmgs1") : "" %></b>
				<b style="color:red"><%= request.getAttribute("errmgs2") != null ? request.getAttribute("errmgs2") : "" %></b>
				<b style="color:red"><%= request.getAttribute("errmgs3") != null ? request.getAttribute("errmgs3") : "" %></b>
			</div>
			
		</div>
	</div>

</body>
</html>