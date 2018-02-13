<%@ page import="com.biyao.common.util.SysConfigUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/head.jsp" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>求借和索取书目清单 | 我的书生</title>
    <link href="<%=basePath%>css/mylibrary.css" rel="stylesheet" type="text/css" />
</head>

<body>
<center>
    <%@ include file="../common/loginHead.jsp"%>
    <div id="main">
    <div class="tablebox">
    <h1 class="list">求借和索取书目清单</h1>
    <table class="index_table" id="table1">
        <thead>
            <tr>
                <td class="td2">书名</td>
                <td class="td2">系列</td>
                <td>作者</td>
                <td>类别</td>
                <td>年龄段</td>
                <td>状态</td>
                <td>个人图书馆</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${bookShoppings}" var="book">
                <tr>
                    <td class="bookname">${book.book_name}</td>
                    <td class="td2">${book.book_series}</td>
                    <td>${book.book_author}</td>
                    <td>${book.book_type}</td>
                    <td>${book.book_age}</td>
                    <td>${book.book_status}</td>
                    <td class="td3">${book.book_account}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p class="notice">点击个人图书馆名称，可以查看用户的联系信息，请根据联系信息，自行联系！谢谢！</p>
    </div>
    </div>
</center>
<div id="foot">&nbsp;</div>
</body>
</html>
<script type="text/javascript">

    $(function(){
        _w_table_rowspan("#table1",7);
    })

    //合并表格
    function _w_table_rowspan(_w_table_id,_w_table_colnum){
        _w_table_firsttd = "";
        _w_table_currenttd = "";
        _w_table_SpanNum = 0;
        _w_table_Obj = $(_w_table_id + " tr td:nth-child(" + _w_table_colnum + ")");
        _w_table_Obj.each(function(i){
            if(i==0){
                _w_table_firsttd = $(this);
                _w_table_SpanNum = 1;
            }else{
                _w_table_currenttd = $(this);
                if(_w_table_firsttd.text()==_w_table_currenttd.text()){
                    _w_table_SpanNum++;
                    _w_table_currenttd.hide(); //remove();
                    _w_table_firsttd.attr("rowSpan",_w_table_SpanNum);
                }else{
                    _w_table_firsttd = $(this);
                    _w_table_SpanNum = 1;
                }
            }
        });

    }
</script>