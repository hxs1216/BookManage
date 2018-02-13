<%@ page import="com.biyao.common.util.SysConfigUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../common/head.jsp" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>书本详情 | 我的书生</title>
    <link href="<%=basePath%>css/content.css" rel="stylesheet" type="text/css" />
</head>
<body>
<center>
<%@ include file="../common/loginHead.jsp"%>
<form method="post">
    <input type="hidden" name="bookSeries" value=""/>
    <input type="hidden" name="bookAuro" value=""/>
    <input type="hidden" name="library" value=""/>
    <input type="hidden" name="bookId" value="${bookId}"/>
    <div id="main">
    <div style="margin-top: 85px;"></div>
    <div class="tablebox">
        <div class="bookimg"><img style="height: 246px;width: 211px;" src="<%=SysConfigUtil.configProperties.getProperty("ftp.url")%>${book.bookImage}" /></div>
        <div class="content">
            <h2>${book.bookName}</h2>
            <h3><a href="javascript:void(0);" onclick="showOtherBook('2','${book.bookAuthor}');">${book.bookAuthor}</a> (作者)</h3>
            <table>
                <tr><td class="title">系列：</td><td class="table_content"><a href="javascript:void(0);" onclick="showOtherBook('1','${book.bookSeries}');">${book.bookSeries}</a></td></tr>
                <tr><td class="title">类别：</td><td class="table_content">${book.bookType}</td></tr>
                <tr><td class="title">年龄段：</td><td class="table_content">${book.bookAge}</td></tr>
                <tr><td class="title">状态：</td><td class="table_content">${book.bookStatus}</td></tr>
                <tr><td class="title">图书馆：</td><td class="table_content"><a href="javascript:void(0);" onclick="showOtherBook('3','${book.bookLibrary}');">${book.bookLibrary}</a></td></tr>
                <tr><td class="title">简介：</td><td class="table_content">${book.express1}</td></tr>
            </table>
            <h3></h3>
            <dl>
                <dt>用户自评</dt>
                <dd class="name">留言者${book.bookLibrary}于<fmt:formatDate value="${book.createTime}" pattern="yyyy年MM月dd日"/></dd>
                <dd class="comment">${book.bookComment}</dd>
                <dt>其他用户的评论</dt>
                <c:forEach items="${bookComments}" var="comment">
                    <dd class="name">留言者${comment.commentPerson}于<fmt:formatDate value="${comment.createTime}" pattern="yyyy年MM月dd日 HH:mm:ss"/></dd>
                    <dd class="comment">${comment.comment}</dd>
                </c:forEach>
            </dl>
            <textarea name="comment"></textarea>
            <div class="loginbox"><span class="register" onclick="showComment();"><a href="javascript:void(0);">发表评论</a></span><span class="login"  onclick="quxiao();"><a href="javascript:void(0);">取消</a></span></div>
        </div>
    </div>
    </div>
</form>
</center>
<div id="foot">&nbsp;</div>
</body>
</html>
<script type="text/javascript">

    //添加评论
    function showComment(){
        document.forms[0].action = "<%=basePath%>book/addComment";
        document.forms[0].submit();
    }

    //取消
    function quxiao(){
        window.location.href="<%=basePath%>system/allBook";
    }


    //根据不同条件进行选择
    function showOtherBook(type,obj) {
        if(type == '1'){
            $("[name='bookSeries']").val(obj);
        }else if(type == '2'){
            $("[name='bookAuro']").val(obj);
        }else if(type == '3'){
            $("[name='library']").val(obj);
        }

        $("[name='currentPage']").val(1);
        document.forms[0].action = "<%=basePath%>system/searchLoginBooks/"+type;
        document.forms[0].submit();

    }
</script>
