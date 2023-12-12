<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤務管理システム</title>
<!-- bootstrap core css  -->
<link rel="stylesheet" type="text/css" href="css/kintai.css"/>
<link rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>
	 <div class="wrapper">
		<div class="title_content">
			<h1>勤務管理システム</h1>
		</div>
		<div class="container main_content">
			<div class="row ">
				<div class="col-md-6 emp_rdiv">
					<a style="text-decoration: none;" class="emp_regist" href="EmpRegistForward" >社員登録</a>
				</div>
				<div class="col-md-6 work_rdiv">
					<a style="text-decoration: none;" class="work_regist" href="WorkRegistForward">勤務時間登録</a>
			    </div>	
			</div>
			<div class="row">
				<div class="col-md-6 emp_sdiv">
					<a style="text-decoration: none;" class="emp_search" href="EmpSearchForward" >社員検索</a>
				</div>
				<div class="col-md-6 work_sdiv">
					<a style="text-decoration: none;" class="work_search" href="WorkSearchForward">勤務時間検索</a>
			    </div>	
			</div>
		</div>
	</div> 
	
</body>
</html>