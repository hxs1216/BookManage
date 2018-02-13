<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/head.jsp" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>书本系列 | 我的书生</title>
    <link href="<%=basePath%>css/content.css" rel="stylesheet" type="text/css" />
</head>

<body>
<center>
    <%@ include file="../common/IndexHead.jsp"%>
    <form method="post">
        <input type="hidden" name="bookSeries" value="${searchKey}"/>
        <input type="hidden" name="bookAuro" value=""/>
        <input type="hidden" name="library" value=""/>
        <div id="main">
            <div class="tablebox">
                <h1 class="series" style="margin-top: 188px;">${searchKey}<span class="small">系列</span></h1>
                <table class="index_table">
                    <thead>
                    <tr>
                        <td class="td2">书名</td>
                        <td class="td2">系列</td>
                        <td class="td2">作者</td>
                        <td class="td2" >类别</td>
                        <td class="td2">年龄段</td>
                        <td class="td2">状态</td>
                        <td class="td2">个人图书馆</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${books}" var="book" varStatus="status">
                        <tr bgcolor="${(status.index)%2==0?'#eee':'#ffffff'}">
                            <td><a href="<%=basePath%>system/bookDetail/${book.id}">${book.bookName}</a></td>
                            <td>${book.bookSeries}</td>
                            <td><a href="javascript:void(0);" onclick="showOtherBook('2','${book.bookAuthor}');">${book.bookAuthor}</a></td>
                            <td>${book.bookType}</td>
                            <td>${book.bookAge}</td>
                            <td>${book.bookStatus}</td>
                            <td><a href="javascript:void(0);" onclick="showOtherBook('3','${book.bookLibrary}');">${book.bookLibrary}</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <tfoot>
                    <tr>
                        <td colspan="8">
                            <ol>
                                <c:forEach begin="${page.startPage}" step="1" end="${page.endPage}" var="count">
                                    <input type="hidden" name="currentPage" value="${page.currentPage}"/>
                                    <li class="${count==page.currentPage?'current_page':null}" onclick="goto('${count}');">${count}</li>
                                </c:forEach>
                            </ol>
                        </td>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </form>
</center>
<div id="foot">&nbsp;</div>
</body>
</html>
<script type="text/javascript">

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
        document.forms[0].action = "<%=basePath%>system/searchByCondition/"+type;
        document.forms[0].submit();

    }
</script>
