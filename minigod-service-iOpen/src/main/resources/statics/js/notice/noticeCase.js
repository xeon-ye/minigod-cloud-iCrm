var userIds = null;
$(function () {
    $("#jqGrid").jqGrid({
        url: '../noticeCase/list',
        datatype: "json",
        colModel: [			
			{ name: 'noticeCaseId', label: 'ID', index: 'id', width: 50, key: true ,hidden:true},
			{ name: 'noticeCaseName', label: '通知名称', index: 'notice_case_name', width: 80 },
			{ name: 'noticeContext', label: '通知内容', index: 'notice_context', width: 80 },
			{ name: 'noticeCaseCode', label: '通知编号', index: 'notice_case_code', width: 80 },
			{ name: 'createUser', label: '创建人', index: 'create_user', width: 80 },
            {
                label: '创建时间', name: 'createTime', index: "create_time", width: 80,
                formatter: function (value) {
                    var dateObj = new Date(value);

                    var year = dateObj.getFullYear();//年
                    var month = dateObj.getMonth() + 1;//月  (注意：月份+1)
                    var date = dateObj.getDate();//日
                    var day = dateObj.getDay();
                    var weeks = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
                    var week = weeks[day];//根据day值，获取星期数组中的星期数。
                    var hours = dateObj.getHours();//小时
                    var minutes = dateObj.getMinutes();//分钟
                    var seconds = dateObj.getSeconds();//秒

                    if (month < 10) {
                        month = "0" + month;
                    }
                    if (date < 10) {
                        date = "0" + date;
                    }
                    if (hours < 10) {
                        hours = "0" + hours;
                    }
                    if (minutes < 10) {
                        minutes = "0" + minutes;
                    }
                    if (seconds < 10) {
                        seconds = "0" + seconds;
                    }

                    var newDate = year + "-" + month + "-" + date + " " + hours + ":" + minutes + ":" + seconds;
                    return newDate;
                }
            },
			{ name: 'updateUser', label: '修改人', index: 'update_user', width: 80 },
            {
                label: '修改时间', name: 'updateTime', index: "update_time", width: 80,
                formatter: function (value) {
                    if(value==null || value ==''){
                        return "";
                    }else {
                        var dateObj = new Date(value);

                        var year = dateObj.getFullYear();//年
                        var month = dateObj.getMonth() + 1;//月  (注意：月份+1)
                        var date = dateObj.getDate();//日
                        var day = dateObj.getDay();
                        var weeks = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
                        var week = weeks[day];//根据day值，获取星期数组中的星期数。
                        var hours = dateObj.getHours();//小时
                        var minutes = dateObj.getMinutes();//分钟
                        var seconds = dateObj.getSeconds();//秒

                        if (month < 10) {
                            month = "0" + month;
                        }
                        if (date < 10) {
                            date = "0" + date;
                        }
                        if (hours < 10) {
                            hours = "0" + hours;
                        }
                        if (minutes < 10) {
                            minutes = "0" + minutes;
                        }
                        if (seconds < 10) {
                            seconds = "0" + seconds;
                        }

                        var newDate = year + "-" + month + "-" + date + " " + hours + ":" + minutes + ":" + seconds;
                        return newDate;
                    }
                }
            }
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page",
            rows:"limit",
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
    $("#userJqGrid").jqGrid({
        url: '../sys/user/userList',
        datatype: "json",
        postData:{
            'status': 0
        },
        colModel: [
            {label: 'id', name: 'id',index:'id',hidden:true},
            {label: '用户名', name: 'userName',index:'user_name'},
            {label: '用户类型', name: 'userType',index:'user_type',
                formatter: function (value, options, row) {
                    if (value == 0) {
                        return "<span class=\"label label-success\">内部用户</span>";
                    }
                    if (value == -1) {
                        return "<span class=\"label label-danger\">外部用户</span>";
                    }
                    else{
                        return "<span class=\"label label-warming\">未知</span>";
                    }
                }
            },
            {label: '所属角色', name: 'orderRoleName',index:'order_role_name',sortable: false},
            {label: '部门', name: 'baName',index:'ba_name',sortable: false},
            {label: '机构', name: 'bapName',index:'bap_name',sortable: false},
            {label: '邮箱', name: 'email',index:'email'},
            {label: '手机号', name: 'phone',index:'phone'},
            {
                label: '状态', name: 'status',index:'status',formatter: function (value, options, row) {
                return value == 0 ?
                    '<span class="label label-success">正常</span>' :
                    '<span class="label label-danger">禁用</span>';
            }
            }
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#userJqGridPager",
        jsonReader: {
            root: "userPage.list",
            page: "userPage.currPage",
            total: "userPage.totalPage",
            records: "userPage.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#userJqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
            if(userIds!=null ){
                $("#userJqGrid").jqGrid('resetSelection');
                for(var i = 0;i<userIds.length;i++){
                    $("#userJqGrid").jqGrid('setSelection',userIds[i]);
                }
            }
        },
        onSelectAll:function(aRowids,status){
            if(status==true){
                $.each(aRowids,function(i,item){
                    saveIdToArray(item);
                })
            }else{
                $.each(aRowids,function(i,item){
                    deleteIdFromArray(item);
                })
            }
        },
        onSelectRow:function(aRowids,status){
            if(status==true){ //选择
                saveIdToArray(aRowids);
            }else{ //取消选择
                deleteIdFromArray(aRowids);
            }
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		noticeCase: {},
        q: {
            userName: null
        },
	},
	methods: {
		query: function () {
			vm.reload();
		},
        userNoticeQuery : function () {
			vm.userNoticeReload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.noticeCase = {};
			userIds = null;
			vm.userNoticeReload();
		},
		update: function (event) {
			var noticeCaseId = getSelectedRow();
			if(noticeCaseId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            vm.getInfo(noticeCaseId);
		},
		saveOrUpdate: function (event) {
		    if("" == vm.noticeCase.noticeCaseName||null==vm.noticeCase.noticeCaseName){
                toast("通知名称不能为空！");
                return;
            }
		    if("" == vm.noticeCase.noticeContext||null==vm.noticeCase.noticeContext){
                toast("通知内容不能为空！");
                return;
            }
            var noticeCaseId = userIds;
            vm.noticeCase.userIds = noticeCaseId;
			var url = vm.noticeCase.noticeCaseId == null ? "../noticeCase/save" : "../noticeCase/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.noticeCase),
			    success: function(r){
			    	if(r.code == 0){
                        toast(r.msg, function () {
                            vm.reload();
                        });
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var noticeCaseIds = getSelectedRows();
			if(noticeCaseIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../noticeCase/delete",
				    data: JSON.stringify(noticeCaseIds),
				    success: function(r){
						if(r.code == 0){
							alert(r, function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(noticeCaseId){
			$.get("../noticeCase/info/"+noticeCaseId, function(r){
                if(r.code == 0){
                    vm.noticeCase = r.noticeCase;
                    userIds = vm.noticeCase.userIds;
                    vm.userNoticeReload();
                }else{
                    alert(r.msg);
                }
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                page:page
            }).trigger("reloadGrid");
		},
        userNoticeReload:function () {
            $("#userJqGrid").jqGrid('setGridParam',{
                page:1,
                postData: {
                    'userName': vm.q.userName,
                    'status': 0
                }
            }).trigger("reloadGrid");
        }
	}
});

//保存到数组
function saveIdToArray(item){
    var exit = false;
    for(var i = 0;i < userIds.length;i++){
        if(item == userIds[i]){
            exit = true;
            return;
        }
    }
    userIds.push(item);
}


//从数组中删除
function deleteIdFromArray(item){
    if(userIds.length > 0){
        for(var i = 0;i < userIds.length;i++){
            if(item == userIds[i]){
                userIds.splice(i,1);
                break;
            }
        }
    }
}