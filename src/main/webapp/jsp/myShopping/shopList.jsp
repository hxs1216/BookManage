<%@ page import="com.biyao.common.util.SysConfigUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <form method="post" target="_blank">
        <table class="index_table">
            <thead>
                <tr>
                    <td class="td1"><input type="checkbox"  onclick="allCheck(this);"/></td>
                    <td class="td2">书名</td>
                    <td class="td2">系列</td>
                    <td>作者</td>
                    <td>类别</td>
                    <td>年龄段</td>
                    <td>状态</td>
                    <td></td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${bookShoppings}" var="book">
                    <tr>
                        <td><input type="checkbox" id="shopping_${book.shopId}"/><input name="show" id="show_${book.shopId}" type="hidden"/></td>
                        <td class="bookname">${book.book_name}<input name="shoppingId" type="hidden" value="${book.shopId}"/></td>
                        <td class="td2">${book.book_series}</td>
                        <td>${book.book_author}</td>
                        <td>${book.book_type}</td>
                        <td>${book.book_age}</td>
                        <td>${book.book_status}</td>
                        <td><span class="edit" onclick="delShop('${book.shopId}');">删除</span></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </form>
    <ol><li class="cart" onclick="collectBook();" style="color: white;cursor: pointer;">提交求借和索取清单进行汇总</li></ol>
    </div>
    </div>
</center>
<div id="foot">&nbsp;</div>
</body>
</html>
<script type="text/javascript">

    //全选
    function allCheck(obj){
        var check = $(obj)[0].checked;
        <c:forEach items="${bookShoppings}" var="book">
        if(check){
            $("#shopping_"+${book.shopId})[0].checked = true;
        }else{
            $("#shopping_"+${book.shopId})[0].checked = false;
        }
        </c:forEach>
    }

    //删除书目清单
    function delShop(id) {

        if(confirm("你确定删除该书目吗")){
            window.location.href="<%=basePath%>shopping/delShopping/"+id;
        }
    }

    //汇总
    function collectBook(){
        var num = 0;
        <c:forEach items="${bookShoppings}" var="book">
            var status = $("#shopping_"+${book.shopId})[0].checked;
            if(status){
                $("#show_"+${book.shopId}).val("1");
            }else{
                $("#show_"+${book.shopId}).val("");
                num++;
            }
        </c:forEach>
        if(num == "${fn:length(bookShoppings)}"){
            alert("请至少勾选一个书目");
            return ;
        }
        document.forms[0].action="<%=basePath%>shopping/collectBook";
        document.forms[0].submit();
    }

</script>
