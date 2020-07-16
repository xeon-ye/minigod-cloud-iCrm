$(function () {
    $("#jqGrid").jqGrid({
        url: '../messageSendInfo/list',
        datatype: "json",
        colModel: [
            {label: 'id', name: 'id', index: 'id', width: 30, key: true},
            {
                label: '消息类型', name: 'messageType', index: 'message_type', width: 55,
                formatter: function (value, options, row) {
                    if (value == 0) {
                        return '<span class="label label-success">未知</span>';
                    }
                    if (value == 1) {
                        return '<span class="label label-success">邮件</span>';
                    }
                    if (value == 2) {
                        return '<span class="label label-success">短信</span>';
                    }
                    if (value == 3) {
                        return '<span class="label label-success">接口推送</span>';
                    }
                }
            },
            {label: '标题', name: 'messageTitle', index: 'message_title', width: 100},
            {
                label: '发送结果', name: 'sendResult', index: 'send_result', width: 50,
                formatter: function (value, options, row) {
                    if (value == 0) {
                        return '<span class="label label-warning">未知</span>';
                    }
                    if (value == 1) {
                        return '<span class="label label-warning">待处理</span>';
                    }
                    if (value == 2) {
                        return '<span class="label label-success">成功</span>';
                    }
                    if (value == 3) {
                        return '<span class="label label-danger">失败</span>';
                    }
                    if (value == 4) {
                        return '<span class="label label-warning">处理中</span>';
                    }
                    if (value == 5) {
                        return '<span class="label label-warning">未处理</span>';
                    }

                }
            },
            {label: '接收人', name: 'recipients', index: 'recipients', width: 160},
            {
                label: '内容', name: 'messageContent', index: 'message_content', width: 180,
                formatter:function (value) {
                    content = value.replace(/(\n)/g, "");
                    content = content.replace(/(\t)/g, "");
                    content = content.replace(/(\r)/g, "");
                    content = content.replace(/<\/?[^>]*>/g, "");
                    content = content.replace(/\s*/g, "");
                    return content;
                }
            },
            {label: '附件地址', name: 'attachmentUris', index: 'attachment_uris', width: 80},
            {
                label: '创建时间', name: 'createTime', index: 'create_time', width: 85,
                formatter: function (value) {
                    var dateObj = new Date(value);

                    var year = dateObj.getFullYear();//年
                    var month = dateObj.getMonth() + 1;//月  (注意：月份+1)
                    var date = dateObj.getDate();//日
                    var day = dateObj.getDay();
                    var weeks = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
                    var week = weeks[day];  // 根据day值，获取星期数组中的星期数。
                    var hours = dateObj.getHours();  // 小时
                    var minutes = dateObj.getMinutes();  // 分钟
                    var seconds = dateObj.getSeconds();  // 秒

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
            {
                label: '更新时间', name: 'updateTime', index: 'update_time', width: 85,
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
            // {label: '备注', name: 'comment', index: 'comment', width: 80}
        ],
        viewrecords: true,
        height: 600,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        },
        loadComplete: function () {
            var grid = $("#jqGrid");
            var ids = grid.getDataIDs();
            for (var i = 0; i < ids.length; i++) {
                grid.setRowData(ids[i], false, {height: 40}); //设置成你要设定的固定行高
            }
        }
        // subGrid : true,
        // subGridRowExpanded : function(subgrid_id, subgrid_messageType) {
        //     // we pass two parameters
        //     // subgrid_id is a id of the div tag created whitin a table data
        //     // the id of this elemenet is a combination of the "sg_" + id of the row
        //     // the row_id is the id of the row
        //     // If we wan to pass additinal parameters to the url we can use
        //     // a method getRowData(row_id) - which returns associative array in type name-value
        //     // here we can easy construct the flowing
        //     console.log(subgrid_messageType);
        //     $("#" + subgrid_id).html(
        //         "<div id=class='scroll'>12321</div>");
        // }
    });
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
            recipients: null,
            sendResult: '',
            messageType: ''
        },
        showList: true,
        title: null,
        messageSendInfo: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.messageSendInfo = {};
        },
        update: function (event) {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        },
        saveOrUpdate: function (event) {
            var url = vm.messageSendInfo.id == null ? "../messageSendInfo/save" : "../messageSendInfo/update";
            $.ajax({
                type: "POST",
                url: url,
                data: JSON.stringify(vm.messageSendInfo),
                success: function (r) {
                    if (r.code === 0) {
                        alert(r, function (index) {
                            vm.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        del: function (event) {
            var gids = getSelectedRows();
            if (gids == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: "../messageSendInfo/delete",
                    data: JSON.stringify(gids),
                    success: function (r) {
                        if (r.code == 0) {
                            alert(r, function (index) {
                                $("#jqGrid").trigger("reloadGrid");
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        getInfo: function (id) {
            $.get("../messageSendInfo/info/" + id, function (r) {
                if (r.code == 0) {
                    vm.messageSendInfo = r.messageSendInfo;
                } else {
                    alert(r.msg);
                }
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                page: page,
                postData: {
                    'recipients': vm.q.recipients,
                    'sendResult': vm.q.sendResult,
                    'messageType': vm.q.messageType
                }
            }).trigger("reloadGrid");
        }
    }
});