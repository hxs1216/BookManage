<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/head.jsp" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>个人图书馆 | 我的书生</title>
    <link href="<%=basePath%>css/mylibrary.css" rel="stylesheet" type="text/css" />
</head>

<body>
<center>
    <%@ include file="../common/loginHead.jsp"%>
    <div id="main">
    <div class="tablebox">
    <h1 class="library">我的个人的图书馆</h1>
    <form method="post">
        <table class="index_table">
        <thead>
            <tr>
                <td class="td2" style="width: 20%;">书名</td>
                <td class="td2" style="width: 20%;">系列</td>
                <td style="width: 10%;">作者</td>
                <td style="width: 10%;">类别</td>
                <td style="width: 10%;">年龄段</td>
                <td style="width: 10%;">状态</td>
                <td style="width: 30%;"></td>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${books}" var="book">
            <tr>
                <td class="bookname">${book.bookName}</td>
                <td class="td2">${book.bookSeries}</td>
                <td>${book.bookAuthor}</td>
                <td>${book.bookType}</td>
                <td>${book.bookAge}</td>
                <td>${book.bookStatus}</td>
                <td>
                    <span class="edit" onclick="editBook('${book.id}');">编辑</span>
                    <span class="edit" onclick="deleteBook('${book.id}');">删除</span>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="8">
                <ol>
                    <li class="cart" onclick="addBook();"><a href="javascript:void(0);">添加新书目</a></li>
                    <c:forEach begin="${page.startPage}" step="1" end="${page.endPage}" var="count">
                        <input type="hidden" name="currentPage" value="${page.currentPage}"/>
                        <li class="${count==page.currentPage?'current_page':null}" onclick="goto('${count}');">${count}</li>
                    </c:forEach>
                </ol>
                </td>
            </tr>
        </tfoot>
    </table>
    </form>
    </div>
    </div>
</center>
<div id="foot">&nbsp;</div>
</body>
</html>
<script type="text/javascript">

    //添加新的书目
    function addBook(){
        window.location.href = "<%=basePath%>book/bookShow";
    }

    //编辑书目
    function  editBook(id) {
        window.location.href = "<%=basePath%>book/editBookShow/"+id;
    }

    //删除书目
    function deleteBook(id){
        if(confirm("你确定删除吗")){
            $.ajax({
                url:'<%=basePath%>book/deleteBook/'+id,
                type:'post',
                dataType:'json',
                async:'false',
                data:$('form').serialize(),
                success:function(data){
                    if(data.show){
                        alert(data.content);
                        window.location.href = "<%=basePath%>book/myLibrary";
                    }else{
                        alert(data.content);
                    }
                }
            });
        }
    }
</script>

