<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="static/css/data.css">
<title>Insert title here</title>
<script type="text/javascript">
	function addTask() {
		addTaskReal();
	}

	function addTaskReal() {
		$.ajax({
			type : "POST",
			url : "/transferTask/add.action",
			data : {
				'userId' : 1
			},
			success : function(data) {
				if (data > 0) {
					$("#taskId").val(data);
					$("#addTaskDiv").show();
					$("#taskSelectEd").load("tree1.jsp");
				}
			},
			error : function(e) {
				alert("增加任务异常：" + e);
			}
		});
	}
</script>
</head>
<body>
	<div>
		<jsp:include page="/index.jsp" flush="true" />
	</div>
	<hr />
	<div id="taskContentDiv">
		<input type="button" value="增加任务" onclick="addTask();"> <input
			type="text" name="taskId" id="taskId"></input>

		<div id="taskSelectEd"></div>
		<div id="addTaskDiv" style="display: none;">
			<jsp:include page="/addTask.jsp" flush="true" />
		</div>
	</div>

</body>
</html>