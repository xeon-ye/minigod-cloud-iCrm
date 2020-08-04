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
        vm.title = '修改渠道';
    })
};
var ztree;
var ztree2;

/**
 * 初始化菜单
 */
function initTree() {
    $.get("../userChannelInfo/channelButton", function (r) {
        //初始化zTree，三个参数一次分别是容器(zTree 的容器 className 别忘了设置为 "ztree")、参数配置、数据源
        ztree = $.fn.zTree.init($("#menuTree"), setting, r.userChannelList);
    })
}

function menuTree() {
    initTree();
    layer.open({
        type: 1,
        offset: '50px',
        skin: 'layui-layer-molv',
        title: "选择渠道",
        area: ['300px', '450px'],
        shade: 0,
        shadeClose: true,
        content: jQuery("#menuLayer"),
        btn: ['确定', '取消'],
        btn1: function (index) {
            var node = ztree.getSelectedNodes();
            var channelName = node[0].channelName;
            var channelId = node[0].channelId;
            $("#channelName").val(channelName);
            $("#checkedChannelId").val(channelId);
            layer.close(index);
        }
    });
}
