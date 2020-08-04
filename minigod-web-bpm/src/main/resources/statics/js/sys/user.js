var resultLoginName = '';
var searchUrl = location.search; //获取url中"?“符后的字串
if (searchUrl.indexOf("?") != -1) {
    var userType = decodeURIComponent(searchUrl.substr(1).replace("userType=",""));
}
$(function () {
    $("#jqGrid").jqGrid({
        url: '../sys/user/list',
        datatype: "json",
        postData:{
            'userType': userType
        },
        colModel: [
            {label: '用户名', name: 'userName', width: 75,sortable:false},
            {label: '登录名', name: 'loginName', width: 80,sortable:false},
            {label: '用户类型', name: 'userType', width: 80,sortable:false,
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
            {label: '所属角色', name: 'orderRoleName', width: 175,sortable:false},
            {label: '部门', name: 'baName', width: 75},
            {label: '机构', name: 'bapName', width: 75},
            {label: '邮箱', name: 'email', width: 80},
            {label: '手机号', name: 'phone', width: 80},
            {label: '工号', name: 'exten', width: 40},
            {
                label: '状态', name: 'status', width: 30, formatter: function (value, options, row) {
                return value == 0 ?
                    '<span class="label label-success">正常</span>' :
                    '<span class="label label-danger">禁用</span>';
            }
            },
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
            resultLoginName = vm.user.loginName;
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});

var organTree = "";
var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url: "nourl"
        }
    }
};

/**
 * 初始化机构树
 */
function initTree() {
    $.get("../sys/organ/organTree", function (r) {
        //初始化zTree，三个参数一次分别是容器(zTree 的容器 className 别忘了设置为 "ztree")、参数配置、数据源
        organTree = $.fn.zTree.init($("#organTree"), setting, r.organTree);
        var node = organTree.getNodeByParam("id", vm.user.baid);//得到当前上级菜单节点
        organTree.selectNode(node);//选中新增加的节点
        //vm.menu.parentName = node.name;
    })
}

var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
            userName: null
        },
        showList: true,
        title: null,
        roleList: {},
        user: {
            status: 1,
            baid: '',
            baName: '',
            roleIdList: []
        }
    },
    created: function () {
        initTree();
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.roleList = {};
            vm.user = {status: userType, roleIdList: [], baid: '', baName: '',userType :userType};
            //获取角色信息
            this.getRoleList();
        },
        update: function () {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";
            vm.getUser(id);
            //获取角色信息
            this.getRoleList();
        },
        del: function () {
            var ids = getSelectedRows();
            if (ids == null) {
                return;
            }
            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: "../sys/user/delete",
                    data: JSON.stringify(ids),
                    success: function (r) {
                        if (r.code == 0) {
                            toast(r, function (index) {
                                vm.reload();
                            });
                        } else {
                            alertMsg(r.msg);
                        }
                    }
                });
            });
        },
        enabled: function () {
            var ids = getSelectedRows();
            if (ids == null) {
                return;
            }
            confirm('确定要启用选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: "../sys/user/enabled",
                    data: JSON.stringify(ids),
                    success: function (r) {
                        if (r.code == 0) {
                            toast(r, function (index) {
                                vm.reload();
                            });
                        } else {
                            alertMsg(r.msg);
                        }
                    }
                });
            });
        },
        reset: function () {
            var ids = getSelectedRows();
            if (ids == null) {
                return;
            }
            confirm('确定要重置选中的用户密码？', function () {
                $.ajax({
                    type: "POST",
                    url: "../sys/user/reset",
                    data: JSON.stringify(ids),
                    success: function (r) {
                        if (r.code == 0) {
                            toast(r, function (index) {
                                vm.reload();
                            });
                        } else {
                            alertMsg(r.msg);
                        }
                    }
                });
            });
        },
        saveOrUpdate: function (event) {
            if (vm.user.userName == null || "" == vm.user.userName) {
                layer.alert("用户名不可为空！");
            }
            else if (vm.user.loginName == null || "" == vm.user.loginName) {
                layer.alert("登录名不可为空！");
            }
            else if ((vm.user.passWord == null || "" == vm.user.passWord) && vm.user.id == null) {
                layer.alert("密码不可为空！");
            }
            else if (vm.user.baName == null || "" == vm.user.baName) {
                layer.alert("部门为必选！");
            }
            else if (vm.user.userType == null) {
                layer.alert("用户类型为必选！");
            }
            else {
                if (vm.user.id == null) {
                    var name = vm.user.loginName;
                    url = "../sys/user/queryByLoginName",
                        $.post(url, name, function (r) {
                            if (r.code == -1) {
                                layer.alert("登录名已存在，请重新输入！");
                            } else if (r.code == 0) {
                                doSaveOrUpdate();
                            }
                        })
                } else {
                    if (resultLoginName == vm.user.loginName) {
                        doSaveOrUpdate();
                    } else {
                        var name = vm.user.loginName;
                        url = "../sys/user/queryByLoginName",
                            $.post(url, name, function (r) {
                                if (r.code == -1) {
                                    layer.alert("登录名已存在，请重新输入！");
                                } else if (r.code == 0) {
                                    doSaveOrUpdate();
                                }
                            })
                    }
                }
            }
        },
        getUser: function (id) {
            $.get("../sys/user/info/" + id, function (r) {
                resultLoginName = r.user.loginName;
                vm.user = r.user;
            });
        },
        getRoleList: function () {
            $.post("../sys/role/select?roleType="+userType,function (r) {
                vm.roleList = r.list;
            });
        },
        organTree: function () {
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择机构",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: $("#menuLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = organTree.getSelectedNodes();
                    //选择上级菜单
                    vm.user.baid = node[0].id;
                    vm.user.baName = node[0].name;
                    layer.close(index);
                }
            });
        },
        reload: function (event) {
            vm.showList = true;
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {
                    'userName': vm.q.userName,
                    'loginName':vm.q.loginName,
                    'baName':vm.q.baName
                },
                page: 1
            }).trigger("reloadGrid");
        }
    }
});

var flag = function checkUserName() {
    $.get("../sys/user/info/" + name, function (result) {
        if (result.code() == '0') {
            return true;
        } else if (result.code() == '1') {
            return false;
        }
    });
}

function doSaveOrUpdate() {
    var url = vm.user.id == null ? "../sys/user/save" : "../sys/user/update";
    $.ajax({
        type: "POST",
        url: url,
        data: JSON.stringify(vm.user),
        success: function (r) {
            if (r.code == 0) {
                if (vm.user.id == null) {
                    toast(r, function (index, layer) {
                        vm.reload();
                    }, function (index) {
                        vm.menu.sort = 1;
                    })
                } else {
                    toast(r.msg, function () {
                        vm.reload();
                    });
                }

            } else {
                alertMsg(r.msg);
            }
        }
    });
}