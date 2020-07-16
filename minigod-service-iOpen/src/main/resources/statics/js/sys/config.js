var key;
var keyId;
$(function () {
    $("#jqGrid").jqGrid({
        url: '../sys/config/list',
        datatype: "json",
        colModel: [
            {label: 'ID', name: 'id', width: 30, key: true},
            {label: '编号', name: 'keyId', width: 30},
            {label: '参数名', name: 'key', width: 120},
            {label: '参数值', name: 'value', width: 100},
            {label: '备注', name: 'remark', width: 120},
            {label: '创建时间', name: 'createTime', width: 60},
            {label: '创建人', name: 'createUser', width: 60},
            {label: '修改时间', name: 'updateTime', width: 60},
            {label: '修改人', name: 'updateUser', width: 60}
        ],
        viewrecords: true,
        height: 385,
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
        }
    });
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
            key: null
        },
        showList: true,
        title: null,
        config: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.config = {};
        },
        update: function () {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            this.getConfig(id);
        },
        del: function (event) {
            var ids = getSelectedRows();
            if (ids == null) {
                return;
            }
            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: "../sys/config/delete",
                    contentType: "application/json",
                    data: JSON.stringify(ids),
                    success: function (r) {
                        if (r.code == 0) {
                            alert(r, function (index) {
                                vm.reload();
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        saveOrUpdate: function (event) {
            if (vm.config.keyId == null || vm.config.keyId == '') {
                alertMsg("参数编号不可为空！")
            } else if (vm.config.key == null || vm.config.key == '') {
                alertMsg("参数名不可为空！")
            } else if (vm.config.value == null || vm.config.value == '') {
                alertMsg("参数值不可为空！")
            } else {
                var url = vm.config.id == null ? "../sys/config/save" : "../sys/config/update";
                //没有id时为新增 验证key 和keyId是否重复
                if (vm.config.id == null) {
                    $.get("../sys/config/checkKey/" + vm.config.key, function (r) {
                        if (r.code == 0) {
                            $.get("../sys/config/checkKeyId/" + vm.config.keyId, function (r) {
                                if (r.code == 0) {
                                    doSaveOrUpdate(url);
                                } else {
                                    alertMsg(r.msg);
                                }
                            });
                        } else {
                            alertMsg(r.msg);
                        }
                    });
                } else {
                    //有id时为修改 验证key 和keyId是否重复
                    if (vm.config.key == key) {
                        if(vm.config.keyId == keyId){
                            doSaveOrUpdate(url);
                        }else{
                            $.get("../sys/config/checkKeyId/" + vm.config.keyId, function (r) {
                                if (r.code == 0) {
                                    doSaveOrUpdate(url);
                                } else {
                                    alertMsg(r.msg);
                                }
                            });
                        }
                    }else{
                        if(vm.config.keyId == keyId){
                            $.get("../sys/config/checkKey/" + vm.config.key, function (r) {
                                if (r.code == 0) {
                                    doSaveOrUpdate(url);
                                } else {
                                    alertMsg(r.msg);
                                }
                            });
                        }else{
                            $.get("../sys/config/checkKey/" + vm.config.key, function (r) {
                                if (r.code == 0) {
                                    $.get("../sys/config/checkKeyId/" + vm.config.keyId, function (r) {
                                        if (r.code == 0) {
                                            doSaveOrUpdate(url);
                                        } else {
                                            alertMsg(r.msg);
                                        }
                                    });
                                } else {
                                    alertMsg(r.msg);
                                }
                            });
                        }
                    }
                }

            }
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'key': vm.q.key},
                page: page
            }).trigger("reloadGrid");
        },
        getConfig: function (id) {
            $.get("../sys/config/info/" + id, function (r) {
                vm.showList = false;
                vm.title = "修改";
                vm.config = r.config;
                key = r.config.key;
                keyId = r.config.keyId;
            });
        }
    }
});

//执行save或者update方法
function doSaveOrUpdate(url) {
    $.ajax({
        type: "POST",
        url: url,
        contentType: "application/json",
        data: JSON.stringify(vm.config),
        success: function (r) {
            if (r.code == 0) {
                alert(r, function (index) {
                    vm.reload();
                });
            } else {
                alert(r.msg);
            }
        }
    });
}