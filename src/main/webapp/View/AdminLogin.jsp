<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者ログイン</title>
<!-- bootstrap core css  -->
<link rel="stylesheet" type="text/css" href="css/kintai.css"/>
<link rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>
	<div class="addlogin">
        <div class="logo">
            <img src="image/key.png" alt="">
        </div>
        <div class="text-center mt-4 name">
           管理者ログイン
        </div>
        <form action="LoginController" method="post" class="p-3 mt-3">
            <div class="form-field d-flex align-items-center">
                <span class="far fa-user"></span>
                <input type="text" name="userName" id="userName" placeholder="ID">
            </div>
            <div class="form-field d-flex align-items-center">
                <span class="fas fa-key"></span>
                <input type="password" name="password" id="pwd" placeholder="パスワード">
            </div>
            <input class="btn mt-3" type="submit" value="Login">
        </form>
  		<!-- エラーメッセージが存在するときだけ表示する -->
		<div class="errorlogin">
			<b style="color:red"><%= request.getAttribute("errmgsLogin") != null ? request.getAttribute("errmgsLogin") : "" %></b>
			
		</div>
    </div>
</body>
</html>