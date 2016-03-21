<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加用户</title>
<!-- <script type="text/javascript" src="static/js/jquery-1.7.2.min.js"></script> -->
<script type="text/javascript">
	function submitClick() {

		$("#userSelectEdFolderArea").val($("#formTextArea").val());
		//序列化表单元素，返回json数据  
		var params = $("#userFolderForm").serializeArray();
		//也可以把表单之外的元素按照name value的格式存进来  
		//params.push({name:"hello",value:"man"});  
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
	}

	function addUserClick() {
		var userName = $("#userNameId").val();
		//序列化表单元素，返回json数据  
		var params = $("#userFolderFormQuery").serializeArray();

		$.ajax({
			type : "POST",
			url : "/user/getUserName.action",
			data : params,
			success : function(data) {
				if (data != 'error') {
					var userNames = $("#userNameTextArea").val();
					if (userNames == '') {
						$("#userNameTextArea").val(userName);
						addNew(userName, data);
					} else {
						var resultUserName = '';
						var uns = userNames.split(",");
						var flag = false;
						$.each(uns, function(i, item) {

							if (item == userName) {
								flag = true;
							} else {
								if (resultUserName == '') {
									resultUserName = item;
								} else {
									resultUserName = resultUserName + ","
											+ item;
								}
							}
						});
						if (resultUserName == '') {
							resultUserName = userName;
						} else {
							resultUserName = resultUserName + "," + userName;
						}
						$("#userNameTextArea").val(resultUserName);
						if (!flag) {
							addNew(userName, data);
						}

					}
				} else {
					alert("不存在此用户");
				}
			},
			error : function(e) {
				alert("查询出错，请重新选择！");
			}
		});
	}

	var row_count = 0;
	function addNew(name, id) {
		var table1 = $('#userNameTable');
		var row = $("<tr></tr>");
		var td = $("<td></td>");
		td
				.append($("<input type='checkbox' name='userNameTableCount' value='"+id+"'><input type='text' name='userId' style='display: none;' value='"+id+"'><b>"
						+ name + "</b>"));
		row.append(td);
		table1.append(row);
		row_count++;
	}
	function del() {
		var checked = $("input[type='checkbox'][name='userNameTableCount']");
		$(checked).each(function() {
			if ($(this).attr("checked") == true) //注意：此处判断不能用$(this).attr("checked")==‘true'来判断。 
			{
				$(this).parent().parent().remove();
			}
		});
	}
</script>
</head>
<body>
	<form action="" id="userFolderFormQuery">
		<input type="text" id="userNameId" name="userName"></input>
	</form>
	<input type="button" id="addUserNameFolder" value="增加"
		onclick="addUserClick();" />
	<input type="button" id="delUserNameFolder" value="删除" onclick="del();" />
	<input id="userNameTextArea" type="text" value=""
		style="display: none;"></input>
	<form action="" id="userFolderForm">
		<table id="userNameTable">
		</table>
		<input id="userSelectEdFolderArea" type="text" value=""
			style="display: none;" name="directorys">
	</form>
	<input id="userFolderFormSub1" type="button" value="增加"
		onclick="submitClick();" />
</body>
</html>