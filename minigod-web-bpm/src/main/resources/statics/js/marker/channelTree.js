var resultFareKind;
var resultNextFareKind;
var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "channelId",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url: "nourl"
        }
    }
};

var setting2 = {
    data: {
        simpleData: {
            enable: true,
            idKey: "channelId",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url: "nourl"
        }
    },
    check: {
        //复选框
        //enable:true,
        nocheckInherit: true
    },
    callback: {
        onClick: zTreeOnClick
    }
};

var resultName = "";
var resultId = "";

function zTreeOnClick(event, treeId, treeNode) {
    var url = "../userChannelInfo/info/" + treeNode.id;
    $.get(url, function (result) {
        vm.menu = result.menu;
        resultName = result.menu.channelName;
        resultId = result.menu.channelId;
        vm.showInfo = true;
        vm.showPlanButton = true;
        vm.showHistory = false;
        if (result.channelFare == true) {
            vm.nextFareCase = true;
            vm.nextCaseButton = false;
            vm.delCaseButton = true;
        } else {
            vm.nextFareCase = false;
            vm.delCaseButton = false;
            vm.nextCaseButton = true;
        }
        resultFareKind = vm.menu.fareKind;
        resultNextFareKind = vm.menu.nextFareKind;

        vm.icon = true;
        vm.title = '修改渠道';
        if (vm.menu.isFreeCommission == null) {
            $("#free").removeAttr('checked');
        }
        if (vm.menu.isFreeCommission == null) {
            $("#noFree").removeAttr('checked');
        }
        if (vm.menu.isFreeCommission == 1) {
            $("#free").prop('checked', 'checked');
        } else if (vm.menu.isFreeCommission == 0) {
            $("#noFree").prop('checked', 'checked');
        }
        if (vm.menu.nextFreeCommission == 1) {
            $("#nextFree").prop('checked', 'checked');
        } else if (vm.menu.nextFreeCommission == 0) {
            $("#noNextFree").prop('checked', 'checked');
        }

        changeFareCase();

        var now = getNowFormatDate();
        if (vm.menu.beginDate != null &&vm.menu.beginDate != '' && vm.menu.auditStatus !=3) {
            if (fallDate(vm.menu.beginDate, now) <= 0) {
                $("#beginDate").attr("disabled", "true")
                // $("#free").attr("disabled", "true")
                // $("#noFree").attr("disabled", "true")
            } else {
                // $("#fareKind").removeAttr("disabled");
                $("#beginDate").removeAttr("disabled");
                // $("#free").removeAttr("disabled");
                // $("#noFree").removeAttr("disabled");
            }
        } else {
            // $("#fareKind").removeAttr("disabled");
            $("#beginDate").removeAttr("disabled");
            // $("#free").removeAttr("disabled");
            // $("#noFree").removeAttr("disabled");
        }
    })
    // historyOnClick(vm.menu.channelId);
};

function historyOnClick() {
    $('#jqGrid').jqGrid('clearGridData');
    $('#jqGrid').jqGrid('setGridParam', {
        url: '../channelFareSetupLog/list?channelId=' + vm.menu.channelId,
    }).trigger('reloadGrid');

    $("#jqGrid").jqGrid(
        {
            url: '../channelFareSetupLog/list?channelId=' + vm.menu.channelId,
            datatype: "json",
            colModel: [
                {
                    label: '时间', name: 'createTime', sortable: false, formatter: function (value) {
                    var dateObj = new Date(value);

                    var year = dateObj.getFullYear();//年
                    var month = dateObj.getMonth() + 1;//月  (注意：月份+1)
                    var date = dateObj.getDate();//日
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
                {label: '操作人员', name: 'createUser', sortable: false},
                {
                    label: '操作', name: 'opFlag', width: 80, sortable: false,
                    formatter: function (value) {
                        if (value == 0) {
                            return "新增";
                        } else if (value == 1) {
                            return "修改";
                        } else if (value == 2) {
                            return "删除";
                        }
                    }
                },
                {
                    label: '上一套餐', name: 'lastFareKind', width: 90, sortable: false
                },
                {
                    label: '方案类型', name: 'channelFareType', width: 110, sortable: false,
                    formatter: function (value) {
                        if (value == 0) {
                            return "目前方案";
                        } else if (value == 1) {
                            return "下一方案";
                        }
                    }
                },
                {label: '套餐编号', name: 'fareKind', width: 90, sortable: false},
                {
                    label: '开始时间', name: 'beginDate', sortable: false,
                    formatter: function (value) {
                        var dateObj = new Date(value);
                        var year = dateObj.getFullYear();//年
                        var month = dateObj.getMonth() + 1;//月  (注意：月份+1)
                        var date = dateObj.getDate();//日

                        if (month < 10) {
                            month = "0" + month;
                        }
                        if (date < 10) {
                            date = "0" + date;
                        }
                        var newDate = year + "-" + month + "-" + date;
                        return newDate;
                    }
                },
                {
                    label: '结束时间', name: 'endDate', sortable: false,
                    formatter: function (value) {
                        var dateObj = new Date(value);
                        var year = dateObj.getFullYear();//年
                        var month = dateObj.getMonth() + 1;//月  (注意：月份+1)
                        var date = dateObj.getDate();//日

                        if (month < 10) {
                            month = "0" + month;
                        }
                        if (date < 10) {
                            date = "0" + date;
                        }
                        var newDate = year + "-" + month + "-" + date;
                        return newDate;
                    }
                },
                {
                    label: '审核状态', name: 'auditStatus', sortable: false,
                    formatter: function (value) {
                        if (value == 0) {
                            return "未审核";
                        } else if (value == 1) {
                            return "审核中";
                        } else if (value == 2) {
                            return "审核通过";
                        } else if (value == 3) {
                            return "审核不通过";
                        }
                    }
                }
            ],
            viewrecords: true,
            height: 'auto',
            rowNum: 10,
            rowList: [10, 30, 50],
            rownumbers: true,
            rownumWidth: 25,
            autowidth: true,
            width: "100%",
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

    if (vm.showHistory == true) {
        vm.showHistory = false;
    } else {
        vm.showHistory = true;
    }
}

var ztree;
var ztree2;

/**
 * 初始化菜单
 */
function initTree() {
    //加载菜单树
    var url1 = ""
    var url2 = ""
    if ($("#flag").val() == "areaTree") {
        url1 = "../userChannelInfo/areaPerms"
        url2 = "../userChannelInfo/areaSelectMenu"
    } else if ($("#flag").val() == "channelTree") {
        url1 = "../userChannelInfo/perms"
        url2 = "../userChannelInfo/selectMenu"
    }
    $.get(url1, function (r) {
        ztree2 = $.fn.zTree.init($("#allMenuTree"), setting2, r.userChannelList);
        //展开第一级节点
        var nodes = ztree2.getNodes();
        if (nodes.length > 0) {
            for (var i = 0; i < nodes.length; i++) {
                ztree2.expandNode(nodes[i], true, false, false);
            }
        }
    });

    $.get(url2, function (r) {
        //初始化zTree，三个参数一次分别是容器(zTree 的容器 className 别忘了设置为 "ztree")、参数配置、数据源
        ztree = $.fn.zTree.init($("#menuTree"), setting, r.userChannelList);
    })

    $.get("../userChannelInfo/areaSelectMenu", function (r) {
        //初始化zTree，三个参数一次分别是容器(zTree 的容器 className 别忘了设置为 "ztree")、参数配置、数据源
        ztree3 = $.fn.zTree.init($("#areaTree"), setting, r.userChannelList);
    })

}

var vm = new Vue({
    el: '#rrapp',
    data: {
        showInfo: false,
        showHistory: false,
        icon: true,
        nextFareCase: false,
        fareCase:true,
        showPlanButton: true,
        nextCaseButton: false,
        delCaseButton: false,
        title: null,
        menu: {
            parentName: null,
            parentId: 0,
            areaName: null,
            areaCode: 0
        },
    },
    created: function () {
        initTree();
    },
    methods: {
        add: function () {
            var nodes = ztree2.getSelectedNodes();
            if (nodes.length <= 0) {
                alertMsg("请选择父级菜单");
                return
            }
            $("#freeCommissionDays").removeAttr("readonly");
            $("#fareKind").removeAttr("disabled");
            $("#beginDate").removeAttr("disabled");
            $("#endDate").removeAttr("disabled");
            $("#free").removeAttr("disabled");
            $("#noFree").removeAttr("disabled");
            vm.fareCase = true;
            vm.showInfo = true;
            vm.showPlanButton = false;
            vm.nextFareCase = false;
            vm.showHistory = false;
            vm.nextCaseButton = true;
            vm.delCaseButton = false;
            vm.icon = false;
            vm.title = "新增渠道";
            vm.menu.parentId = nodes[0].channelId;
            vm.menu.name = "";
            vm.menu.auditStatus = null;
            vm.menu.channelName = "";
            vm.menu.parentName = nodes[0].name;
            vm.menu.rmk = "";
            vm.menu.id = null;
            vm.menu.fareKind = "";
            vm.menu.channelId = "";
            vm.menu.areaCode = "";
            vm.menu.areaName = ""
            vm.menu.isFreeCommission = null;
            vm.menu.freeCommissionDays = "";
            vm.menu.beginDate = "";
            vm.menu.endDate = "";
            $("#free").removeAttr('checked');
            $("#noFree").removeAttr('checked');
            // $("#beginDate").val("");
            // $("#endDate").val("");
        },
        del: function (event) {
            var nodes = ztree2.getSelectedNodes();
            if (nodes.length <= 0) {
                alertMsg("请选择要删除的菜单");
            }
            confirm('确定要删除菜单【' + nodes[0].name + '】,及下面的子菜单么？', function () {
                var childs = nodes[0].id;
                childs = getAllNodes(nodes[0], childs).toString();
                var url = "../userChannelInfo/delete";
                $.post(url, childs, function (r) {
                    if (r.code == 0) {
                        toast(r.msg, function () {
                            ztree2.removeNode(nodes[0]);
                            vm.showInfo = false;
                        });
                    } else {
                        alertMsg(r.msg);
                    }
                });
            });
        },
        saveOrUpdate: function (event) {
            var channelId = vm.menu.channelId.toString();
            url = "../channelFareSetup/checkAuditStatus";
            $.post(url,channelId,function (r) {
                if(r.code == -2){
                    isAudit = false;
                    alertMsg(r.msg);
                }else{
                    var flag = $("#flag").val();
                    var channelId = vm.menu.channelId;
                    var channelName = vm.menu.channelName;
                    if (channelId == null || channelId == "") {
                        layer.alert("渠道号不能为空！")
                    } else if (channelName == null || channelName == "") {
                        layer.alert("渠道名称不能为空！")
                    } else if (!isRealNum(channelId)) {
                        if (flag == "areaTree") {
                            layer.alert("大区号必须为纯数字！")
                        } else {
                            layer.alert("渠道号必须为纯数字！")
                        }
                    }else if(vm.fareCase==true){
                        if (vm.menu.isFreeCommission == null) {
                            layer.alert("是否参加官方免佣活动必选！")
                        } else if (vm.menu.fareKind == null || "" == vm.menu.fareKind) {
                            layer.alert("佣金方案必选！")
                        } else if (vm.menu.beginDate == null || "" == vm.menu.beginDate || vm.menu.endDate == null || "" == vm.menu.endDate) {
                            layer.alert("方案有效期必选！")
                        } else if (vm.nextFareCase == true && vm.menu.nextFreeCommission == null) {
                            layer.alert("(下一方案)是否参加官方免佣活动必选！")
                        } else if (vm.nextFareCase == true && (vm.menu.nextFareKind == null || "" == vm.menu.nextFareKind)) {
                            layer.alert("(下一方案)佣金方案必选！")
                        } else if (vm.nextFareCase == true && (vm.menu.nextBeginDate == null || "" == vm.menu.nextBeginDate || vm.menu.nextEndDate == null || "" == vm.menu.nextEndDate)) {
                            layer.alert("(下一方案)方案有效期必选！")
                        }else if (fallDate(vm.menu.endDate, vm.menu.beginDate) < 0) {
                            alertMsg("结束日期需在开始日期之后")
                        }else if(vm.menu.nextBeginDate!=null && vm.menu.nextBeginDate!='' && vm.menu.nextEndDate!=null && vm.menu.nextEndDate!='' && fallDate(vm.menu.nextEndDate, vm.menu.nextBeginDate) < 0){
                            alertMsg("结束日期需在开始日期之后")
                        }else if (resultId == channelId) {
                            if (channelName == resultName) {
                                doSaveAndUpdate();
                            } else {
                                checkChannelName();
                            }
                        } else {
                            checkChannleId();
                        }
                    }else if (resultId == channelId) {
                        if (channelName == resultName) {
                            doSaveAndUpdate();
                        } else {
                            checkChannelName();
                        }
                    } else {
                        checkChannleId();
                    }
                }
            });
        },
        menuTree: function () {

            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择菜单",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: true,
                content: jQuery("#menuLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    //选择上级菜单
                    vm.menu.parentId = node[0].channelId;
                    vm.menu.parentName = node[0].channelName;
                    layer.close(index);
                }
            });
        },
        areaTree: function () {
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择菜单",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: true,
                content: jQuery("#areaLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree3.getSelectedNodes();
                    //选择上级菜单
                    vm.menu.areaName = node[0].channelName;
                    vm.menu.areaCode = node[0].channelId;
                    layer.close(index);
                }
            });
        },
        reload: function () {
            var url = "../userChannelInfo/info/" + vm.menu.id;
            $.get(url, function (result) {
                vm.menu = result.menu;
                resultName = result.menu.channelName;
                resultId = result.menu.channelId;
                vm.showInfo = true;
                vm.showPlanButton = true;
                vm.showHistory = false;
                if (result.channelFare == true) {
                    vm.nextFareCase = true;
                    vm.nextCaseButton = false;
                    vm.delCaseButton = true;
                } else {
                    vm.nextFareCase = false;
                    vm.delCaseButton = false;
                    vm.nextCaseButton = true;
                }
                resultFareKind = vm.menu.fareKind;
                resultNextFareKind = vm.menu.nextFareKind;

                vm.icon = true;
                vm.title = '修改渠道';
                if (vm.menu.isFreeCommission == null) {
                    $("#free").removeAttr('checked');
                }
                if (vm.menu.isFreeCommission == null) {
                    $("#noFree").removeAttr('checked');
                }
                if (vm.menu.isFreeCommission == 1) {
                    $("#free").prop('checked', 'checked');
                } else if (vm.menu.isFreeCommission == 0) {
                    $("#noFree").prop('checked', 'checked');
                }
                if (vm.menu.nextFreeCommission == 1) {
                    $("#nextFree").prop('checked', 'checked');
                } else if (vm.menu.nextFreeCommission == 0) {
                    $("#noNextFree").prop('checked', 'checked');
                }

                changeFareCase();

                var now = getNowFormatDate();
                if (vm.menu.beginDate != null &&vm.menu.beginDate != '') {
                    if (fallDate(vm.menu.beginDate, now) <= 0) {
                        $("#beginDate").attr("disabled", "true")
                        // $("#free").attr("disabled", "true")
                        // $("#noFree").attr("disabled", "true")
                    } else {
                        // $("#fareKind").removeAttr("disabled");
                        $("#beginDate").removeAttr("disabled");
                        // $("#free").removeAttr("disabled");
                        // $("#noFree").removeAttr("disabled");
                    }
                } else {
                    // $("#fareKind").removeAttr("disabled");
                    $("#beginDate").removeAttr("disabled");
                    // $("#free").removeAttr("disabled");
                    // $("#noFree").removeAttr("disabled");
                }
            })
        }
    }
});

//展开套餐列表
function showFareProList() {
    url = "../marker/farePackageList.html",
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["客户佣金方案", true],
            area: ['90%', '70%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
            btn: ['确认', '取消'],
            yes: function (index, layero) { //或者使用btn1
                var fareKind = $(layero).find("iframe")[0].contentWindow.getFareKind();
                vm.menu.fareKind = fareKind;
                vm.icon = true;
                // alert(vm.channelInfo.fareKind);
                layer.close(index);
            }
        });
}

//展开套餐列表 (下一套餐中按钮)
function showNextFareProList() {
    url = "../marker/farePackageList.html",
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["客户佣金方案", true],
            area: ['90%', '70%'], //宽高
            content: [url, 'yes'],
            shadeClose: false,
            btn: ['确认', '取消'],
            yes: function (index, layero) { //或者使用btn1
                var fareKind = $(layero).find("iframe")[0].contentWindow.getFareKind();
                vm.menu.nextFareKind = fareKind;
                vm.icon = true;
                // alert(vm.channelInfo.fareKind);
                layer.close(index);
            }
        });
}

//检查channelId
function checkChannleId() {
    var channelId = vm.menu.channelId.toString();
    url = "../userChannelInfo/queryByChannelId",
        $.post(url, channelId, function (r) {
            if (r.code > 0) {
                alertMsg("渠道号已存在！")
            } else {
                checkChannelName();
            }
        });
}

//检查channelName
function checkChannelName() {
    var channelName = vm.menu.channelName;
    url = "../userChannelInfo/queryByChannelName",
        $.post(url, channelName, function (r) {
            if (r.code > 0) {
                alertMsg("渠道名已存在！")
            } else {
                doSaveAndUpdate();
            }
        })
}

//执行保存和修改
function doSaveAndUpdate() {
    var id = vm.menu.id;
    var flag = $("#flag").val();
    if ("areaTree" == flag) {
        var type = '0';
    } else {
        var type = '1';
    }
    var url = id == null ? "../userChannelInfo/save" : "../userChannelInfo/update";
    var param = {
        parentId: vm.menu.parentId,
        channelId: vm.menu.channelId,
        channelName: vm.menu.channelName,
        rmk: vm.menu.rmk,
        id: vm.menu.id,
        areaCode: vm.menu.areaCode,
        type: type,
        fareKind: vm.menu.fareKind,
        isFreeCommission: vm.menu.isFreeCommission,
        freeCommissionDays: vm.menu.freeCommissionDays,
        nextFreeCommission: vm.menu.nextFreeCommission,
        nextFreeCommissionDays: vm.menu.nextFreeCommissionDays,
        nextFareKind: vm.menu.nextFareKind,
        nextBeginDate: vm.menu.nextBeginDate,
        nextEndDate: vm.menu.nextEndDate,
        beginDate: vm.menu.beginDate,
        endDate: vm.menu.endDate,
        lastFareKind: resultFareKind,
        lastNextFareKind: resultNextFareKind
    };
    $.ajax({
        type: "POST",
        url: url,
        data: JSON.stringify(param),
        success: function (r) {
            if (r.code == 0) {
                var menu = r.menu;
                var nodes = ztree2.getSelectedNodes();
                if (vm.menu.id == null) {
                    toast(r.msg, function () {
                        location.reload();
                    });
                } else {
                    toast(r.msg, function () {
                        nodes[0].name = menu.channelName;
                        ztree2.updateNode(nodes[0]);
                        location.reload();
                    });
                }
            } else {
                alertMsg(r.msg);
            }
        }
    });
}


//tips
$("#iconTips").hover(function () {
    if (vm.menu.fareKind != null || vm.menu.fareKind != "") {
        openMsg(this.id);
    }
}, function () {
    layer.close(subtips);
});
//tips
$("#nextIconTips").hover(function () {
    if (vm.menu.nextFareKind != null || vm.menu.nextFareKind != "") {
        openMsg(this.id);
    }
}, function () {
    layer.close(subtips);
});
//tips
function openMsg(tipsIndex) {
    var fareKind = vm.menu.fareKind;
    if(tipsIndex=='nextIconTips'){
        fareKind = vm.menu.nextFareKind;
    }
    var url = "../farePackageSetup/info/" + fareKind;
    $.get(url, function (result) {
        if(result.tips!=null && result.tips!=''){
            subtips = layer.tips("<span style='font-size: 15px'>"+result.tips+"</span>", '#'+tipsIndex,
                {
                    tips: [1, '#0FA6D8'], //设置tips方向和颜色 类型：Number/Array，默认：2 tips层的私有参数。支持上右下左四个方向，通过1-4进行方向设定。如tips: 3则表示在元素的下面出现。有时你还可能会定义一些颜色，可以设定tips: [1, '#c00']
                    tipsMore: false, //是否允许多个tips 类型：Boolean，默认：false 允许多个意味着不会销毁之前的tips层。通过tipsMore: true开启
                    area: 'auto',
                    maxWidth:1000,
                    maxHeight:350,
                    time:0 //2秒后销毁，还有其他的基础参数可以设置。。。。这里就不添加了
                }
            );
        }
    })
}

// 数字判断
function isRealNum(val) {
    // isNaN()函数 把空串 空格 以及NUll 按照0来处理 所以先去除
    if (val === "" || val == null) {
        return false;
    }
    if (!isNaN(val)) {
        return true;
    } else {
        return false;
    }
}

//时间插件
layui.use('laydate', function () {
    var laydate = layui.laydate;
    //执行一个laydate实例
    laydate.render({
        elem: '#beginDate', //指定元素
        min: minDate(),
        done: function (value) {//控件选择完毕后的回调---点击日期、清空、现在、确定均会触发。
            vm.menu.beginDate = value;
        }
    });
    laydate.render({
        elem: '#endDate', //指定元素
        min: minDate(),
        done: function (value) {//控件选择完毕后的回调---点击日期、清空、现在、确定均会触发。
            vm.menu.endDate = value;
            vm.menu.nextBeginDate = dateAddDays(vm.menu.endDate, 1);
            vm.menu.nextEndDate = dateAddDays(vm.menu.endDate, fallDate(vm.menu.endDate, vm.menu.beginDate));
        }
    });
    laydate.render({
        elem: '#nextBeginDate', //指定元素
        min: minDate(),
        done: function (value) {//控件选择完毕后的回调---点击日期、清空、现在、确定均会触发。
            vm.menu.nextBeginDate = value;
        }
    });
    laydate.render({
        elem: '#nextEndDate', //指定元素
        min: minDate(),
        done: function (value) {//控件选择完毕后的回调---点击日期、清空、现在、确定均会触发。
            vm.menu.nextEndDate = value;
        }
    });
});


// 设置最小可选的日期
function minDate() {
    var now = new Date();
    return now.getFullYear() + "-" + (now.getMonth() + 1) + "-" + now.getDate();
}


//选择参加免佣活动
$("#free").click(function () {
    // vm.menu.freeCommissionDays = 90;
    vm.menu.isFreeCommission = 1;
    $("#freeCommissionDays").removeAttr("readonly");
});
//不参加免佣
$("#noFree").click(function () {
    // vm.menu.freeCommissionDays = 0 ;
    vm.menu.isFreeCommission = 0;
    $("#freeCommissionDays").attr("readonly", "true")
});

//选择参加免佣活动(下一方案)
$("#nextFree").click(function () {
    // vm.menu.nextFreeCommissionDays = 90;
    vm.menu.nextFreeCommission = 1;
    $("#nextFreeCommissionDays").removeAttr("readonly");
});
//不参加免佣(下一方案)
$("#noNextFree").click(function () {
    // vm.menu.nextFreeCommissionDays = 0 ;
    vm.menu.nextFreeCommission = 0;
    $("#nextFreeCommissionDays").attr("readonly", "true")
});


//添加下一菜单按钮
$("#newNextCase").click(function () {
    vm.nextFareCase = true;
    vm.nextCaseButton = false;
    vm.delCaseButton = true;

    vm.menu.nextFreeCommission = vm.menu.isFreeCommission;
    vm.menu.nextFreeCommissionDays = vm.menu.freeCommissionDays;
    vm.menu.nextFareKind = vm.menu.fareKind;
    if (vm.menu.endDate != null && vm.menu.endDate != "") {
        vm.menu.nextBeginDate = dateAddDays(vm.menu.endDate, 1);
        vm.menu.nextEndDate = dateAddDays(vm.menu.endDate, fallDate(vm.menu.endDate, vm.menu.beginDate));
    }
    if (vm.menu.nextFreeCommission == 1) {
        $("#nextFree").attr('checked', 'checked');
    } else if (vm.menu.nextFreeCommission == 0) {
        $("#noNextFree").attr('checked', 'checked');
    }
});

$("#delNextCase").click(function () {
    vm.nextFareCase = false;
    vm.nextCaseButton = true;
    vm.delCaseButton = false;
    vm.menu.nextFreeCommission = "";
    vm.menu.nextFareKind = "";
    vm.menu.nextBeginDate = "";
    vm.menu.nextEndDate = "";
});


// checkbox单选
$(function () {
    $(':checkbox[name=radio]').each(function () {
        $(this).click(function () {
            if ($(this).attr('checked')) {
                $(':checkbox[name=radio]').removeAttr('checked');
                $(this).attr('checked', 'checked');
            }
        });
    });
    $(':checkbox[name=nextRadio]').each(function () {
        $(this).click(function () {
            if ($(this).attr('checked')) {
                $(':checkbox[name=radio]').removeAttr('checked');
                $(this).attr('checked', 'checked');
            }
        });
    });


});

function dateAddDays(dataStr, dayCount) {
    var date = new Date(dataStr.replace(/-/g, "/"));  //把日期字符串转换成日期格式
    date = new Date((date / 1000 + (86400 * dayCount)) * 1000);  //日期加1天
    var year = date.getFullYear();//年
    var month = date.getMonth() + 1;//月  (注意：月份+1)
    var date = date.getDate();//日
    if (month < 10) {
        month = "0" + month;
    }
    if (date < 10) {
        date = "0" + date;
    }
    var result = year + "-" + month + "-" + date;
    return result;
}

function fallDate(bigDate, smallDate) {
    bigDate = new Date(bigDate.replace(/-/g, "/"));  //把日期字符串转换成日期格式
    smallDate = new Date(smallDate.replace(/-/g, "/"));  //把日期字符串转换成日期格式
    var days = (bigDate - smallDate) / (1000 * 60 * 60 * 24)
    return days;
}

function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}

function changeFareCase() {
    if(vm.menu.channelId<=0){
        vm.fareCase = false;
        vm.showPlanButton = false;
    }else{
        vm.fareCase = true;
    }
}

var isAudit = true;
// 未审核通过无法 继续修改或者删除
function checkAuditStatus(){
    var channelId = vm.menu.channelId.toString();
    url = "../channelFareSetup/checkAuditStatus";
    $.post(url,channelId,function (r) {
        if(r.code == -2){
            isAudit = false;
            alertMsg(r.msg);
        }
    });
    return isAudit;
}
