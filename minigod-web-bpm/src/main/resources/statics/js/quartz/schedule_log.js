$(function () {
    $("#jqGrid").jqGrid({
        url: '../sys/scheduleLog/list',
        datatype: "json",
        colModel: [			
            { label: '日志ID', name: 'logId', width: 50, key: true },
			{ label: '任务ID', name: 'jobId', width: 50},
			{ label: 'bean名称', name: 'beanName', width: 60 },
			{ label: '方法名称', name: 'methodName', width: 60 },
			{ label: '参数', name: 'params', width: 60 },
			{ label: '状态', name: 'status', width: 50, formatter: function(value, options, row){
				return value === 0 ? 
					'<span class="label label-success">成功</span>' :
					'<span class="label label-danger pointer" onclick="vm.showError('+row.logId+')">失败</span>';
			}},
			{ label: '耗时(单位：毫秒)', name: 'times', width: 70 },
			{ label: '执行时间', name: 'createTime', width: 80,
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
			}
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50,100,200],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: false,
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
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			jobId: null
		}
	},
	methods: {
		query: function () {
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'jobId': vm.q.jobId},
                page:1 
            }).trigger("reloadGrid");
		},
		showError: function(logId) {
			$.get("../sys/scheduleLog/info/"+logId, function(r){
				parent.layer.open({
				  title:'失败信息',
				  closeBtn:0,
				  content: r.log.error
				});
			});
		},
		back: function (event) {
			history.go(-1);
		}
	}
});

