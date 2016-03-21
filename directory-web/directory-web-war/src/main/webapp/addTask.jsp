<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="static/css/data.css">
<link rel="stylesheet" href="common/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<script type="text/javascript" src="common/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="common/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript"
	src="common/js/jquery.ztree.excheck-3.5.js"></script>
<SCRIPT type="text/javascript">
	function addFromFile() {
		var selectedFile = $("#selectedFileId").val();
		if (selectedFile == '') {
			alert("请选择文件！");
		} else {
			var files = selectedFile.split(',');
			var result = '';
			$.each(files, function(i, item) {
				if (result == '') {
					if (item != '') {
						result = item;
					}
				} else {
					if (item != '') {
						result = result + "\n" + item;
					}
				}
			});
			$("#taskFromFileId").html(result);
			$("#taskSelectEd").load("treeFolder.jsp");

		}

	}

	function addToFile() {

		var selectedFile = $("#selectedFileId").val();
		if (selectedFile == '') {
			alert("请选择文件！");
		} else {
			var files = selectedFile.split(',');
			var result = '';
			if (files.length == 2) {
				$.each(files, function(i, item) {
					if (result == '') {
						if (item != '') {
							result = item;
						}
					} else {
						if (item != '') {
							result = result + "\n" + item;
						}
					}
				});
				$("#taskToFiledId").val(result);
			} else {
				alert("请选择一个文件夹。");
			}

		}
	}

	function submitFile() {

		//序列化表单元素，返回json数据  
		var params = $("#fileFormId").serializeArray();
		//也可以把表单之外的元素按照name value的格式存进来  
		//params.push({name:"hello",value:"man"});  
		$.ajax({
			type : "POST",
			url : "/transferFile/add.action",
			data : params,
			success : function(data) {
				alert("成功");
			},
			error : function(e) {
				alert("出错：" + e);
			}
		});

	}
</SCRIPT>
</head>
<body>
	<form action="" id="fileFormId">
		<table>
			<tr>
				<td>要同步的数据</td>
				<td><input type="button" value="选择" onclick="addFromFile();" />
					<textarea id="taskFromFileId" name="fromFile" cols="30" rows="20"></textarea></td>
			</tr>
			<tr>
				<td>同步到的目录</td>
				<td><input type="button" value="选择" onclick="addToFile();" />
					<input type="text" id="taskToFiledId" name="toFolder" value="" /></td>
			</tr>
			<tr>
				<td rowspan="2"><input type="button" value="提交"
					onclick="submitFile();" /></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form>


</body>
</html>