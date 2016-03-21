<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加用户</title>

<script type="text/javascript">
	$(document).ready(function() {
		$("#userFolderFormSub").click(function() {
			//序列化表单元素，返回json数据  
			var params = $("#userFolderForm").serializeArray();

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
	<form action="" id="userFolderForm">
		<table>
			<tr>
				<td>用户名</td>
				<td><input name="" type="text" /></td>
			</tr>
			<tr>
				<td>所属公司</td>
				<td><input name="" type="text" /></td>
			</tr>
			<tr>
				<td>所属部门</td>
				<td><input name="" type="text" /></td>
			</tr>
			<tr>
				<td>联系电话</td>
				<td><input name="" type="text" /></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input name="" type="text" /></td>
			</tr>
			<tr>
				<td>初始密码</td>
				<td><input name="" type="text" /></td>
			</tr>
			<tr>
				<td>帐号有效期</td>
				<td><input name="" type="text" /></td>
			</tr>
			<tr>
				<td>提交</td>
				<td><input id="userFolderFormSub" type="submit" value="增加" /></td>
			</tr>
		</table>

	</form>
</body>
</html>