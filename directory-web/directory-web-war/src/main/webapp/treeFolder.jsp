<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CheckBox Tree - jQuery EasyUI Demo</title>
<link rel="stylesheet" href="common/css/demo.css" type="text/css">
<link rel="stylesheet" href="common/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<script type="text/javascript" src="common/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="common/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript"
	src="common/js/jquery.ztree.excheck-3.5.js"></script>
<SCRIPT type="text/javascript">
	var setting = {
		view : {
			selectedMulti : false
		},
		check : {
			enable : true,
			chkboxType : {
				"Y" : "s",
				"N" : "ps"
			}
		},
		async : {
			enable : true,
			url : "/directory/getFile.action",
			autoParam : [ "id", "fullName" ],
			otherParam : {},
			dataFilter : filter,
			type : "post"
		},
		callback : {
			beforeAsync : beforeAsync,
			onAsyncError : onAsyncError,
			onAsyncSuccess : onAsyncSuccess,
			onCheck : onCheck
		}
	};

	function filter(treeId, parentNode, childNodes) {
		if (!childNodes)
			return null;
		return childNodes;
	}
	function beforeClick(treeId, treeNode) {
		if (!treeNode.isParent) {
			alert("请选择父节点");
			return false;
		} else {
			return true;
		}
	}
	var log, className = "dark";
	function beforeAsync(treeId, treeNode) {
		className = (className === "dark" ? "" : "dark");
		showLog("[ " + getTime() + " beforeAsync ]&nbsp;&nbsp;&nbsp;&nbsp;"
				+ ((!!treeNode && !!treeNode.name) ? treeNode.name : "root"));
		return true;
	}
	function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus,
			errorThrown) {
		showLog("[ " + getTime() + " onAsyncError ]&nbsp;&nbsp;&nbsp;&nbsp;"
				+ ((!!treeNode && !!treeNode.name) ? treeNode.name : "root"));
	}
	function onAsyncSuccess(event, treeId, treeNode, msg) {
		showLog("[ " + getTime() + " onAsyncSuccess ]&nbsp;&nbsp;&nbsp;&nbsp;"
				+ ((!!treeNode && !!treeNode.name) ? treeNode.name : "root"));
	}

	function onCheck(e, treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj(treeId);
		var checkedNodes = zTree.getCheckedNodes(true);
		var checkedNodesResult = '';
		$.each(checkedNodes, function(i, checkedNode) {
			if (checkedNode.isParent) {
				checkedNodesResult = checkedNodesResult + ","
						+ checkedNode.fullName;
			}
		});
		$("#selectedFileId").val(checkedNodesResult);
	}

	function showLog(str) {
		if (!log)
			log = $("#log");
		log.append("<li class='"+className+"'>" + str + "</li>");
		if (log.children("li").length > 8) {
			log.get(0).removeChild(log.children("li")[0]);
		}
	}
	function getTime() {
		var now = new Date(), h = now.getHours(), m = now.getMinutes(), s = now
				.getSeconds(), ms = now.getMilliseconds();
		return (h + ":" + m + ":" + s + " " + ms);
	}

	function refreshNode(e) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"), type = e.data.type, silent = e.data.silent, nodes = zTree
				.getSelectedNodes();
		if (nodes.length == 0) {
			alert("请先选择一个父节点");
		}
		for (var i = 0, l = nodes.length; i < l; i++) {
			alert(nodes[i].fullName);
			zTree.reAsyncChildNodes(nodes[i], type, silent);
			if (!silent)
				zTree.selectNode(nodes[i]);
		}
	}

	$(document).ready(function() {
		$.fn.zTree.init($("#treeDemo"), setting);
		$("#refreshNode").bind("click", {
			type : "refresh",
			silent : false
		}, refreshNode);
		$("#refreshNodeSilent").bind("click", {
			type : "refresh",
			silent : true
		}, refreshNode);
		$("#addNode").bind("click", {
			type : "add",
			silent : false
		}, refreshNode);
		$("#addNodeSilent").bind("click", {
			type : "add",
			silent : true
		}, refreshNode);
	});
</SCRIPT>
</head>
<body>
	<div id="treeSelectId">
		<div id="treeDiv">
			<div style="float: left; width: 50%; height: 400px">
				<div class="content_wrap" id="treeDiv"
					style="width: 100%; height: 350px">
					<div class="zTreeDemoBackground left">
						<ul id="treeDemo" class="ztree"></ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<input type="text" id="selectedFileId" />
</body>
</html>