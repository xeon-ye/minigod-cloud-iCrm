var selectRowId;
$(function(){
    $("#jqGrid").jqGrid({
        url: '../farePackageSetup/list',
        datatype: "json",
        colModel: [
            {
                label: '套餐编号', name: 'fareKind', sortable:false,
                formatter:function (value,row) {
                    if(window.parent.ToChildren!=null){
                        var fareKind =  parent.ToChildren();
                        if(fareKind == value){
                            selectRowId = row.rowId;
                        }
                    }
                    return value;
                }
            },
            {
                label: '证券市场', name: 'exchangeType',sortable:false,
                formatter:function (value) {
                    if (value == 'K') {
                        return "港交所";
                    } else if (value == 'P') {
                        return "美国市场";
                    }
                }
            },
            {label: '付费数值', name: 'balanceRatio',sortable:false},
            {label: '固定费用', name: 'feeCountFix', sortable:false},
            {label: '最高费用', name: 'maxFare', sortable:false},
            {label: '最低费用', name: 'minFare',sortable:false},
            {label: '套餐描述', name: 'fareRemark',sortable:false,width:450}
        ],
        viewrecords: true,
        height: 380,
        pager: "#jqGridPager",
        multiselect: true,
        multiboxonly:true,
        beforeSelectRow: beforeSelectRow,
        autowidth: true,
        rowNum : 10,
        rowList : [ 10, 20, 30 ],
        recordpos : 'left',
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
            $("#jqGrid").jqGrid('setSelection',selectRowId);
            $("#cb_jqGrid").attr("disabled","disabled");
        }
    });
});

    var vm = new Vue({
        el:'#rrapp',
        data:{
            showList: true,
            title: null,
            query: {}
        },
        methods: {
            ensure: function () {
                vm.reload();
            }
        }
    });

    function reloadList() {
        vm.showList = true;
        $("#jqGrid").jqGrid('setGridParam', {
            page: 1,
            dataType:'json',
            postData:{'fareKind':$("#fareKind").val(),'exchangeType':$("#exchangeType").val()}
        }).trigger("reloadGrid");
    }

    window.getFareKind=function() {
        var rowId = $('#jqGrid').jqGrid('getGridParam','selrow');
        var rowData = $("#jqGrid").jqGrid('getRowData',rowId);
        var fareKind =  rowData.fareKind;
        return fareKind;
    };

    function beforeSelectRow()
    {
        $("#jqGrid").jqGrid('resetSelection');
        return(true);
    }
