<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/commonCSS.jsp" %>
<%@include file="/common/commonJS.jsp" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<body>
<div id="div0" v-cloak>
    <div v-show="!showList" class="panel panel-default">
        <%--<div class="panel-heading"><b style="color: #368763">股票下单</b></div>--%>
        </br>

        <input id="id" name="id" type="text" style="display: none;"
               class="form-control" value="${stockOrderResult.id}"
        />
        <div class="row" style="margin-top: 20px">
            <form class="" id="search-from" method="post" action="">

                <div class="row" style="margin-left: 50px">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-sm-3 control-label  no-padding-right"><span
                                style="color: red">*</span>买卖方向</label>
                        <div class="col-xs-9">
                            <span class="col-xs-8 block input-icon input-icon-right">
                                <%--<tag:select nameKey="STOCK_DIRECTION" id="stockDirection" name="stockDirection"--%>
                                            <%--clazz="form-control "--%>
                                            <%--style="display:inline;"/>--%>
                                <select id="stockDirection" name="stockDirection" class="form-control"
                                        onchange="changeDirection();">
                                    <option value="0" selected>买入</option>
                                    <option value="1">卖出</option>
                                </select>
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row" style="margin-left: 50px">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-sm-3 control-label  no-padding-right"><span
                                style="color: red">*</span>股票代码</label>
                        <div class="col-xs-9">
                            <span class="col-xs-8 block input-icon input-icon-right">
                                 <input id="stockCode" name="stockCode" type="text"
                                        value="${stockOrderResult.stockCode}"
                                        class="form-control" placeholder="请输入股票代码"
                                 />
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row" style="margin-left: 50px">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-sm-3 control-label no-padding-right"><span
                                style="color: red">*</span>股票名称</label>
                        <div class="col-xs-9">
                            <span class="col-xs-8 block input-icon input-icon-right">
                                 <input id="stockName" name="stockName" type="text"
                                        value="${stockOrderResult.stockName}"
                                        class="form-control" placeholder="请输入股票名称"
                                 />
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row" style="margin-left: 50px">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-sm-3 control-label no-padding-right"><span
                                style="color: red">*</span>最低价HKD</label>
                        <div class="col-xs-9">
                            <span class="col-xs-8 block input-icon input-icon-right">
                                 <input id="minPrice" name="minPrice" type="text" value="${stockOrderResult.minPrice}"
                                        class="form-control" placeholder="请输入最低卖出价"
                                 />
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row" style="margin-left: 50px">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-sm-3 control-label no-padding-right"><span
                                style="color: red">*</span>最高价HKD</label>
                        <div class="col-xs-9">
                            <span class="col-xs-8 block input-icon input-icon-right">
                                 <input id="maxPrice" name="maxPrice" type="text" value="${stockOrderResult.maxPrice}"
                                        class="form-control" placeholder="请输入最高买入价"
                                 />
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row" style="margin-left: 50px">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-sm-3 control-label no-padding-right"><span
                                style="color: red">*</span>股票数量</label>
                        <div class="col-xs-9">
                            <span class="col-xs-8 block input-icon input-icon-right">
                                 <input id="stockQuantity" name="stockQuantity" type="text"
                                        value="${stockOrderResult.stockQuantity}"
                                        class="form-control" placeholder="请输入股票数量"
                                 />
                            </span>
                        </div>
                    </div>
                </div>

                <div class="row" style="margin-left: 50px">
                    <div class="form-group col-sm-12 col-md-12">
                        <label class="col-sm-3 control-label no-padding-right"><span
                                style="color: red">*</span>截止日期</label>
                        <div class="col-xs-9">
                            <span class="col-xs-8 block input-icon input-icon-right">
                                 <input id="expiryDate" name="expiryDate" type="text"
                                        value="${stockOrderResult.expiryDate}"
                                        class="form-control" placeholder="请输入截止日期"
                                 />
                            </span>
                        </div>
                    </div>
                </div>
                <div class="row" align="center" style="margin-top: 50px">
                    <td align="center">
                        <input id="formSubmit" type="button" class="layui-btn layui-btn-small" value="下单"
                               onclick="save();">
                        <input id="cancelButton" type="button" class="layui-btn layui-btn-small layui-btn-primary"
                               value="取消" onclick="cencelPage();">
                    </td>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script>

    $(function () {
        changeDirection();
    });

    function changeDirection() {
        if ($("#stockDirection").val() == 0) {
            $("#minPrice").attr("disabled", "disabled").val("");
            $("#maxPrice").removeAttr("disabled", "disabled").val("${stockOrderResult.maxPrice}");

        } else if ($("#stockDirection").val() == 1) {
            $("#maxPrice").attr("disabled", "disabled").val("");
            $("#minPrice").removeAttr("disabled", "disabled").val("${stockOrderResult.minPrice}");
        }
    }


    function save() {
        if ($("#stockCode").val() == null || $("#stockCode").val() == '') {
            myToast("股票代码不能为空！",2)
            return;
        }
        if ($("#stockName").val() == null || $("#stockName").val() == '') {
            myToast("股票名称不能为空！",2)
            return;
        }
        if ($("#stockQuantity").val() == null || $("#stockQuantity").val() == '') {
            myToast("股票数量不能为空！",2)
            return;
        }
        if ($("#stockDirection").val() == 0 && ($("#maxPrice").val() == null || $("#maxPrice").val() == '')) {
            myToast("最高价不能为空！",2)
            return;
        }
        if ($("#stockDirection").val() == 1 && ($("#minPrice").val() == null || $("#minPrice").val() == '')) {
            myToast("最低价不能为空！",2)
            return;
        }
        if ($("#expiryDate").val() == null || $("#expiryDate").val() == '') {
            myToast("截止日期不能为空！",2)
            return;
        }
        if($("#stockDirection").val() == 0){
            $("#minPrice").val() == "";
        }else if($("#stockDirection").val() == 1){
            $("#maxPrice").val() == "";
        }
        layer.confirm('交易员将执行该下单指令，请确认是否继续！？', {
            btn: ['确定', '取消'], btn1: function () {
                $.ajax({
                    url: "${webRoot}/stockOrderInfo/saveAndUpdate",   //处理页面的名称
                    data: {
                        id: $("#id").val(),
                        stockCode: $("#stockCode").val(),
                        stockName: $("#stockName").val(),
                        stockQuantity: $("#stockQuantity").val(),
                        stockDirection: $("#stockDirection").val(),
                        minPrice: $("#minPrice").val(),
                        maxPrice: $("#maxPrice").val(),
                        expiryDate: $("#expiryDate").val()
                    },  //为值取个名字
                    type: "POST",  //传值方式
                    dataType: "json",  //数据类型
                    success: function (result) {
                        if (result.code == 0) {
                            layer.msg(result.msg, {
                                icon: 1,
                                time: 2000 //2秒关闭（如果不配置，默认是3秒）
                            }, function () {
                                var index = parent.layer.getFrameIndex(window.name);
                                parent.layer.close(index);
                                window.parent.location.reload();
                            });
                        } else {
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


    function cencelPage() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    }

    layui.laydate.render({
        elem: '#expiryDate' //指定元素
    });
</script>
</html>
