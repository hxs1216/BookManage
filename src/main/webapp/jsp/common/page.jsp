<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table >
	<tr>
		<td>
			<ol>
				<c:forEach begin="${page.startPage}" step="1" end="${page.endPage}" var="count">
					<input type="hidden" name="currentPage" value="${page.currentPage}"/>
					<li class="${count==page.currentPage?'current_page':null}" onclick="goto('${count}');">${count}</li>
				</c:forEach>
			</ol>
		</td>
	</tr>
</table>
<script type="text/javascript">

	//分页跳转
	function goto(count) {
		$("[name='currentPage']").val(count);
		document.forms[0].submit();
	}
</script>