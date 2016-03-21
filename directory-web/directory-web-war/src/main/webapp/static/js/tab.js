/*第一种形式 第二种形式 更换显示样式*/
function setTab(name, cursel, n) {
	for (i = 1; i <= 4; i++) {
		// var con = document.getElementById("con_" + name + "_" + i);
		var con = $("#" + "con_" + name + "_" + i);
		if (cursel == i) {
			$("#" + name + i).attr("class", "fl current");
			con.show();
		} else {
			$("#" + name + i).attr("class", "fl");
			con.hide();
		}
	}
}
// -->
/* 表格单双行变色 */
$(document).ready(function() {
	for (i = 1; i <= 4; i++) {
		var con = $("#" + "con_one" + "_" + i);
		con.hide();
	}

	setTab('one', 1, 4);
});
