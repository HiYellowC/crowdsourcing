var unlockHTML = '<span class="label label-success label-mini">正常</span>';
var lockHTML = '<span class="label label-warning label-mini">冻结</span>';
var lockOperatorHTML = [
		'<button class="unlock btn btn-success btn-xs"><i class="fa fa-unlock-alt"></i></button> ',
		'<button class="mod btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button> ',
		'<button class="del btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>' ]
		.join('');
var unlockOperatorHTML = [
		'<button class="lock btn btn-warning btn-xs"><i class="fa fa-lock"></i></button> ',
		'<button class="mod btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button> ',
		'<button class="del btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>' ]
		.join('');

window.operateEvents = {
	'click .unlock' : function(e, value, row, index) {
		$.ajax({
			url : "/user/unlock/" + row.id,
			success : function(result) {
				if (result.status == 200) {
					alert("操作成功");
					$('.table').bootstrapTable('refresh');
				} else {
					alert("操作失败");
				}
			}
		});
	},
	'click .lock' : function(e, value, row, index) {
		$.ajax({
			url : "/user/lock/" + row.id,
			success : function(result) {
				if (result.status == 200) {
					alert("操作成功");
					$('.table').bootstrapTable('refresh');
				} else {
					alert("操作失败");
				}
			}
		});
	},
	'click .del' : function(e, value, row, index) {
		alert("此功能有待完善");
		/*
		 * $.ajax({ url: "/user/delete/" + row.id, success: function(result) {
		 * alert(result.msg); if(result.status == 200) {
		 * $('.table').bootstrapTable('remove', { field: 'id', values: [row.id]
		 * }); } } });
		 */
	}
};

function dateFormat(value, row, index) {
	var unixTimestamp = new Date(value);
	return unixTimestamp.toLocaleString();
}
function statusFormat(value, row, index) {
	if (value) {
		return lockHTML;
	} else {
		return unlockHTML;
	}
}
function operateFormat(value, row, index) {
	return row.lock ? lockOperatorHTML : unlockOperatorHTML;
}