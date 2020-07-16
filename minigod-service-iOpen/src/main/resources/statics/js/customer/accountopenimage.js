$(function () {
    $("#jqGrid").jqGrid({
        url: '../accountopenimage/list',
        datatype: "json",
        colModel: [			
			{ label: 'gid', name: 'gid', index: 'gid', width: 50, key: true },
			{ label: '文件名', name: 'fileName', index: 'file_Name', width: 80 }, 			
			{ label: '存储文件名', name: 'fileStorageName', index: 'file_Storage_Name', width: 80 }, 			
			{ label: '文件拓展名', name: 'extName', index: 'ext_Name', width: 80 }, 			
			{ label: '申请ID', name: 'accountOpenapplicationId', index: 'account_OpenApplication_Id', width: 80 }, 			
			{ label: '图片位置[0=未知 1=身份证正面照坐标 2=身份证反面照片坐标 3=指定动作1照坐标 4=指定动作2照坐标 5=指定动作3照坐标 6=电子签名照坐标]', name: 'imageLocation', index: 'image_Location', width: 80 }, 			
			{ label: '图片位置类型[0=未知 1=身份证正面照 2=身份证反面照片 3=左手竖起1个指头 4=右手竖起1个指头 5=左手竖起2个指头 6=右手竖起2个指头 7=左手竖起3个指头 8=右手竖起3个指头 9=正面照 10=电子签名照]', name: 'imageLocationType', index: 'image_Location_Type', width: 80 }, 			
			{ label: '指定存储点路径', name: 'storagePath', index: 'storage_Path', width: 80 }, 			
			{ label: '更新时间', name: 'updateTime', index: 'update_Time', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_Time', width: 80 }, 			
			{ label: '备注', name: 'comment', index: 'comment', width: 80 }			
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
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		accountOpenImage: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.accountOpenImage = {};
		},
		update: function (event) {
			var gid = getSelectedRow();
			if(gid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(gid)
		},
		saveOrUpdate: function (event) {
			var url = vm.accountOpenImage.gid == null ? "../accountopenimage/save" : "../accountopenimage/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.accountOpenImage),
			    success: function(r){
			    	if(r.code === 0){
						alert(r, function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var gids = getSelectedRows();
			if(gids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../accountopenimage/delete",
				    data: JSON.stringify(gids),
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
		getInfo: function(gid){
			$.get("../accountopenimage/info/"+gid, function(r){
                if(r.code == 0){
                    vm.accountOpenImage = r.accountOpenImage;
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
		}
	}
});