<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="common/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#button_submit").click(function() {
			//序列化表单元素，返回json数据  
			var params = $("#fileForm").serializeArray();

			//也可以把表单之外的元素按照name value的格式存进来  
			//params.push({name:"hello",value:"man"});  
			alert(params);
			$.ajax({
				type : "POST",
				url : "/directory/addFile.action",
				data : params,
				success : function(data) {
					alert("成功");
				},
				error : function(e) {
					alert("出错：" + e);
				}
			});
		});
	});
</script>

</head>
<body>

	<form id="fileForm" action="/directory/addFile.action">
	
		<textarea id="directorys" name="directorys" rows="50" cols="50"></textarea>
		<input type="button" value="submit" id="button_submit" />
	</form>

</body>
</html>