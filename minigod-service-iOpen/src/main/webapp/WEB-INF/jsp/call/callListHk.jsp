<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>香港通话列表</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>

<body>
<div class="main-container" id="main-container" style="width: 120%">
    <div class="row" style="margin-top: 10px;">
        <div class="col-md-12">
            <form class="layui-form" id="search-from" action="${webRoot}/callrecord/callListHk">
                <div class="layui-form-item">
                    <input name="extenAttach" style="display: none" value="0">
                    <table>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width:120px;">坐席工号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="exten" value="${call.exten}" placeholder="坐席工号"
                                           class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width: 120px;">通话时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="beginTime" name="beginTime" value="${call.beginTime}"
                                           placeholder="通话时间" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">---至:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="endTime" name="endTime" value="${call.endTime}" placeholder="至"
                                           class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">呼叫发起时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="offeringTime" name="offeringTime" value="${call.offeringTime}"
                                           placeholder="呼叫发起时间" class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">呼叫类型:</label>
                                <div class="layui-input-inline">
                                    <tag:select initSelectedKey="${call.connectType}" nameKey="CALL_CONNECT_TYPE"
                                                name="connectType" isAddDefaltOption="true"></tag:select>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width:120px;">关联状态:</label>
                                <div class="layui-input-inline">
                                    <tag:select initSelectedKey="${call.relationState}" nameKey="CALL_RELATION_STATE"
                                                name="relationState" isAddDefaltOption="true"></tag:select>
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">主叫号码:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="callNo" value="${call.callNo}" placeholder="主叫号码"
                                           class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">被叫号码:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="calledNo" value="${call.calledNo}" placeholder="被叫号码"
                                           class="layui-input">
                                </div>
                            </td>
                            <td>

                                <label class="layui-form-label" style="width:120px;">客户帐号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="clientId" value="${call.clientId}" placeholder="客户帐号"
                                           class="layui-input">
                                </div>
                            </td>
                            <td>
                                <label class="layui-form-label" style="width:120px;">小神号:</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="userId" value="${call.userId}" placeholder="小神号"
                                           class="layui-input">
                                </div>

                        </tr>
                        <tr>
                            <td>
                                <label class="layui-form-label" style="width:120px;"></label>
                                <button class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索</button>
                                <button class="layui-btn layui-btn-warm" type="button" id="refresh">重 置</button>
                                <button class="layui-btn layui-btn-danger" type="button" id="export" onclick="exportExcel();">导 出</button>
                            </td>
                        </tr>
                    </table>
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <table id="table-list" class="layui-table">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>座席工号</th>
                    <th>座席姓名</th>
                    <th>通话ID</th>
                    <th>通话开始时间</th>
                    <th>通话结束时间</th>
                    <th>呼叫发起时间</th>
                    <th>通话时长</th>
                    <th>呼叫类型</th>
                    <th>主叫号码</th>
                    <th>被叫号码</th>
                    <th>处理状态</th>
                    <th>小神号</th>
                    <th>客户账号</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.result}" var="callRecord" varStatus="i">
                    <tr id="notice_${notice.id }">
                        <td>${i.index+1 }</td>
                        <td>${callRecord.exten}</td>
                        <td>${callRecord.extenName}</td>
                        <td>${callRecord.callId}</td>
                        <td>${callRecord.beginTime}</td>
                        <td>${callRecord.endTime}</td>
                        <td>${callRecord.offeringTime}</td>
                        <td>${callRecord.callTimeLength}</td>
                        <td>${fns:getCodeName("CALL_CONNECT_TYPE",callRecord.connectType)}</td>
                        <td>${callRecord.callNo}</td>
                        <td>${callRecord.calledNo}</td>
                        <td>${fns:getCodeName("CALL_DEAL_STATUS",callRecord.status)}</td>
                        <td>${callRecord.userId}</td>
                        <td>${callRecord.clientId}</td>
                        <td>
                            <div class=" btn-group ">
                                <audio src="" id="myaudio" controls="controls" loop="false" hidden="true" ></audio>
                                <button id="paly${i.index}" class="layui-btn layui-btn-normal layui-btn-mini" type="button"
                                        onclick="autoPlay('${webRoot}/file${callRecord.localFilePath}',id);"><i
                                        class="layui-icon">&#xe652;</i>播放
                                </button>
                                <%--<button class="layui-btn layui-btn-danger layui-btn-mini" type="button"--%>
                                        <%--onclick="stopPlay();"><i class="layui-icon">&#x1007;</i>停止--%>
                                <%--</button>--%>
                                <button class="layui-btn layui-btn-normal layui-btn-mini" type="button"
                                        onclick="downLoadFile('${callRecord.localFilePath}');"><i class="layui-icon">&#xe601;</i>下载
                                </button>
                                <c:if test="${callRecord.relationState == -1}">
                                    <button class="layui-btn layui-btn-mini" type="button"
                                            onclick="connect('${callRecord.id}');"><i class="layui-icon">&#xe604;</i>
                                        关联
                                    </button>
                                </c:if>
                                <c:if test="${callRecord.relationState == 1}">
                                    <button class="layui-btn layui-btn-danger layui-btn-mini" type="button"
                                            onclick="cancelConnect('${callRecord.id}');"><i
                                            class="layui-icon">&#xe604;</i>
                                        取消关联
                                    </button>
                                </c:if>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <sys:page page="${page}"></sys:page>
        </div>
    </div>
</div>
</body>
<script>
    function connect(id) {
        url = "../callrecord/callConnInit?id=" + id;
        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title: ["通话记录关联", true],
            area: ['45%', '66%'], //宽高
            content: [url, 'no']
        });
    }

    function cancelConnect(id) {
        confirm("确认取消关联？", function () {
            var url = '${webRoot}/callrecord/cancelConnect';
            var params = {
                id: id
            }
            $.post(url, params, function (result) {
                toast(result, function () {
                    location.reload();
                });
            });
        })
    }


    function exportExcel() {
        var loading = layer.msg('loading...', {icon: 16, shade: 0.01});
        $('#export').attr("disabled","true").addClass('layui-btn-disabled');
        setTimeout(function(){$("#export").attr("disabled",false).removeClass("layui-btn-disabled");}, 6000);
        var obj = $('#search-from').serialize();
        window.location.href = '${webRoot}/callrecord/callListExcel?info=&' + obj;
    }

    //音频文件下载
    function downLoadFile(filePath) {
        window.location.href = "${webRoot}/common/downloadFile?fullFilePath=" + filePath;
    }


    //播放音乐置为true
    var isPlay = false;
    var palySrc = "";
    function autoPlay(filePath,id) {
        if(!isPlay){
            document.getElementById(id).innerHTML = "正在播放中";
        }else{
            document.getElementById(id).innerHTML = '<i class="layui-icon">&#xe652;</i>播放';
        }
        var path = filePath.replace("D:", "");
        var player = document.getElementById('myaudio');
        if (palySrc == path){
            if (isPlay) {
                // 如果正在播放, 停止播放并停止读取此音乐文件
                player.pause();
                player.src = '';
            } else {
                player.src = path;
                player.play();
            }
        }else{
            player.src = path;
            player.play();
        }
        palySrc = path;
        isPlay = !isPlay;
    }



    layui.laydate.render({
        elem: '#beginTime'
        , type: 'datetime'
    });
    layui.laydate.render({
        elem: '#endTime'
        , type: 'datetime'
    });
    layui.laydate.render({
        elem: '#offeringTime'
        , type: 'datetime'
    });
    layui.form.render('select');
</script>

</html>