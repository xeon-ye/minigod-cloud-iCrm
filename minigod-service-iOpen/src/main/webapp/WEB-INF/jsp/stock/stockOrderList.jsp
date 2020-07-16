<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>下单指令</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
</head>

<body>
<div class="main-container" id="main-container" style="width: 99%">
    <div class="row" style="margin-top: 20px;" >
        <form class="layui-form" id="search-from" method="post"  action="${webRoot}/stockOrderInfo/stockOrderList">
            <div class="layui-form-item">
                <table >
                    <tr>
                        <td>
                            <label class="layui-form-label" style="width:120px;">开始日期:</label>
                            <div class="layui-input-inline">
                                <input type="text" id="beginDate" name="beginDate" value="${stockOrderInfo.beginDate}"  placeholder="请选择开始日期"  class="layui-input" >
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width:180px;">结束日期:</label>
                            <div class="layui-input-inline">
                                <input type="text" id="endDate" name="endDate" value="${stockOrderInfo.endDate}"  placeholder="请选择结束日期"  class="layui-input" >
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width:180px;">股票代码:</label>
                            <div class="layui-input-inline">
                                <input type="text" id="stockCode" name="stockCode" value="${stockOrderInfo.stockCode}"  placeholder="请输入股票代码"  class="layui-input" >
                            </div>
                        </td>
                        <td>
                            <label class="layui-form-label" style="width:180px;">股票名称:</label>
                            <div class="layui-input-inline">
                                <input type="text" id="stockName" name="stockName" value="${stockOrderInfo.stockName}"  placeholder="请选择股票名称"  class="layui-input" >
                            </div>
                        </td>
                        <td>
                            &nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" class="layui-btn" id="searchSubmit"><i class="layui-icon">&#xe615;</i>搜 索</button>&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
                        <%--<td>
                            <button class="layui-btn layui-btn-warm" type="button" id="refresh">重 置</button>
                        </td>--%>
                    </tr>
                </table>
            </div>
        </form>
    </div>

    <div class="row">
        <div style="margin-top: 10px;margin-left: 20px">
            <button id="add" class="layui-btn layui-btn-radius layui-btn-primary" onclick="addStockOrder();"><i class="layui-icon " >&#xe654;</i>下单指令</button>
        </div>
        <div class="col-sm-12" >
            <table id="table-list" name="tableList" class="layui-table" >
                <thead>
                <tr width="99%" >
                    <th>序号</th>
                    <th>时间</th>
                    <th><span style="color: red">*</span>买卖方向</th>
                    <th><span style="color: red">*</span>股票代码</th>
                    <th><span style="color: red">*</span>股票名称</th>
                    <th><span style="color: red">*</span>最低价HKD</th>
                    <th><span style="color: red">*</span>最高价HKD</th>
                    <th><span style="color: red">*</span>股票数量</th>
                    <th><span style="color: red">*</span>截止日期</th>
                    <th>操作</th>
                    <th>下单员</th>
                </tr>
                </thead>
                <tbody >
                <c:forEach items="${page.result}" var="stockOrderInfo" varStatus="i">
                    <tr >
                       <td>${i.index+1}</td>
                       <td><fmt:formatDate value="${stockOrderInfo.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                       <td>${fns:getCodeName("STOCK_DIRECTION",stockOrderInfo.stockDirection)}</td>
                       <td>${stockOrderInfo.stockCode}</td>
                       <td>${stockOrderInfo.stockName}</td>
                       <td><c:if test="${stockOrderInfo.minPrice == null }">
                               --
                           </c:if>
                           <c:if test="${stockOrderInfo.minPrice != null }">
                               ${stockOrderInfo.minPrice}
                           </c:if></td>
                       <td><c:if test="${stockOrderInfo.maxPrice == null }">
                           --
                            </c:if>
                           <c:if test="${stockOrderInfo.maxPrice != null }">
                               ${stockOrderInfo.maxPrice}
                           </c:if></td>
                       <td>${stockOrderInfo.stockQuantity}</td>
                       <td>${stockOrderInfo.expiryDate}</td>
                       <td width="200px">
                           <c:if test="${stockOrderInfo.status == 0}">
                                <button type="button" onclick="sendOrder(${stockOrderInfo.id});" class="layui-btn layui-btn-mini layui-btn-normal">发送</button>
                                <button type="button" onclick="addStockOrder(${stockOrderInfo.id});" class="layui-btn layui-btn-mini layui-btn-normal">编辑</button>
                                <button type="button" onclick="deleteOrder(${stockOrderInfo.id});" class="layui-btn layui-btn-mini layui-btn-danger">删除</button>
                           </c:if>
                           <c:if test="${stockOrderInfo.status == 1}">
                               <button type="button" onclick="sendOrder(${stockOrderInfo.id});" class="layui-btn layui-btn-mini layui-btn-disabled" disabled>已发送</button>
                               <button type="button" onclick="addStockOrder(${stockOrderInfo.id});" class="layui-btn layui-btn-mini layui-btn-disabled" disabled>编辑</button>
                               <button type="button" onclick="deleteOrder(${stockOrderInfo.id});" class="layui-btn layui-btn-mini layui-btn-disabled" disabled>删除</button>
                           </c:if>
                       </td>
                       <td>${stockOrderInfo.createUser}</td>
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

    function showLog() {
        layer.msg('操作成功', {
            icon: 6,
            time: 2000 //2秒关闭（如果不配置，默认是3秒）
        }, function(){
            //do something
        });
//        layer.msg('操作成功',{time:2000,icon:1,});
    }

    /**
     * 下单详情
     */
    function addStockOrder(id) {
        var url = "";
        if(null==id || "" == id ){
            url="${webRoot}/stockOrderInfo/stockOrderDetail";
        }else{
            url="${webRoot}/stockOrderInfo/stockOrderDetail?id="+id;
        }
        //弹框层
        layer.open({
            scrollbar: false,
            type: 2,
            title : ["股票下单" , true],
            area: ['45%', '66%'], //宽高
            content: [url,'no']
        });
    }


    function sendOrder(id) {
        var url="${webRoot}/stockOrderInfo/sendOrderNotice";
        //弹框层
        layer.confirm('确认发送该下单指令通知，请确认是否继续！？', { btn: ['确定','取消'],btn1: function(){
            $.ajax({
                url:url,
                data:{
                    id:id
                },  //为值取个名字
                type:"POST",  //传值方式
                dataType:"json",  //数据类型
                success: function(result){
                    if(result.code == 0){
                        layer.msg(result.msg, {
                            icon: 1,
                            time: 2000 //2秒关闭（如果不配置，默认是3秒）
                        }, function(){
                            window.location.reload();
                        });
                    }else{
                        layer.msg(result.msg, {
                            icon: 1,
                            time: 2000 //2秒关闭（如果不配置，默认是3秒）
                        })
                    }
                }
            })
        }
        })
    }


    function deleteOrder(id) {

        layer.confirm('确认删除该下单指令，请确认是否继续！？', { btn: ['确定','取消'],btn1: function(){
            $.ajax({
                url:"${webRoot}/stockOrderInfo/deleteOrder",   //处理页面的名称
                data:{
                    id:id
                },  //为值取个名字
                type:"POST",  //传值方式
                dataType:"json",  //数据类型
                success: function(result){
                    if(result.code == 0){
                        layer.msg(result.msg, {
                            icon: 1,
                            time: 2000 //2秒关闭（如果不配置，默认是3秒）
                        }, function(){
                            window.location.reload();
                        });
                    }else{
                        layer.msg(result.msg, {
                            icon: 1,
                            time: 2000 //2秒关闭（如果不配置，默认是3秒）
                        })
                    }
                }
            })
        }
        })
    }

    layui.form.render('select');

    layui.laydate.render({
        elem: '#beginDate' //指定元素
    });
    layui.laydate.render({
        elem: '#endDate' //指定元素
    });
</script>

</html>