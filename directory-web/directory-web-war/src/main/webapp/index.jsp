<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="static/css/data.css">
<script type="text/javascript" src="static/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/static/js/tab.js"></script>
<script type="text/javascript">
	function taskManage() {
		window.location.replace("taskManage.jsp");
	}
	function fileManage() {
		window.location.replace("taskManage.jsp");
	}
	function userManage() {
		window.location.replace("taskManage.jsp");
	}

	function authManage() {
		window.location.replace("taskManage.jsp");
	}
</script>
</head>
<body>
	<div class="data_cont mar_a w_100" id="tab">
		<div class="data_cont_nav mar_a h_lh ba_b02 w_100">
			<ul class="w_100 mar_a oUl">
				<li class="fl" id="one1" onclick="taskManage();">文件管理</li>
				<li class="fl" id="one2" onclick="fileManage();">任务管理</li>
				<li class="fl" id="one3" onclick="userManage();">用户管理</li>
				<li class="fl" id="one3" onclick="authManage();">授权管理</li>
			</ul>
		</div>
	</div>
</body>
</html>