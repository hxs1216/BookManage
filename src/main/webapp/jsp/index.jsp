<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="common/head.jsp" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>首页 | 我的书生</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/layout.css"/>
</head>
<body>
<center>
    <%@ include file="common/IndexHead.jsp"%>
    <form method="post">
    <input type="hidden" name="bookSeries" value=""/>
    <input type="hidden" name="bookAuro" value=""/>
    <input type="hidden" name="library" value=""/>
    <div id="main">
        <div class="tablebox">
            <div style="position: absolute;top: 60px;left: 128px;">
                <input type="text" name="searchKey" class="search_text" value="${searchKey}" placeholder="搜索书名/作者/图书系列/个人图书馆"/>
                <input type="button" onclick="search();" class="search_button" value="搜索"/>
            </div>
            <table class="index_table">
            <thead>
            <tr>
                <td class="td2">书名</td>
                <td class="td2">系列</td>
                <td class="td2">作者</td>
                <td class="td2">类别</td>
                <td class="td2">年龄段</td>
                <td class="td2">状态</td>
                <td class="td2">个人图书馆</td>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${books}" var="book" varStatus="status">
                    <tr bgcolor="${(status.index)%2==0?'#eee':'#ffffff'}">
                        <td><a href="<%=basePath%>system/bookDetail/${book.id}">${book.bookName}</a></td>
                        <td><a href="javascript:void(0);" onclick="showOtherBook('1','${book.bookSeries}');">${book.bookSeries}</a></td>
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
</body>
</html>
<script type="text/javascript">

    //首页搜索
    function search(){
        $("[name='currentPage']").val(0);
        document.forms[0].action = "<%=basePath%>system/searchBooks";
        document.forms[0].submit();
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
        document.forms[0].action = "<%=basePath%>system/searchByCondition/"+type;
        document.forms[0].submit();

    }
</script>
