<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/resources/etc/color.jsp"%>
<html>
	<head>
		<title>게시판</title>
		<link href="/resources/css/style.css" rel="stylesheet" type="text/css">
	</head>
	<body bgcolor="${bodyback_c}">
		<center>
			<b>글목록(전체 글:${count})</b>
			<table width="700">
				<tr>
    				<td align="right" bgcolor="${value_c}">
    					<a href="/free/writeForm">글쓰기</a>
    				</td>
    			</tr>
			</table>
			<c:if test="${count == 0}">
				<table width="700" border="1" cellpadding="0" cellspacing="0">
					<tr>
				    	<td align="center">
				    		게시판에 저장된 글이 없습니다.
				    	</td>
				    </tr>
				</table>
			</c:if>
			<c:if test="${count > 0}">
				<table border="1" width="700" cellpadding="0" cellspacing="0" align="center"> 
				    <tr height="30" bgcolor="${value_c}"> 
						<td align="center"  width="50"  >번 호</td> 
						<td align="center"  width="250" >제   목</td> 
						<td align="center"  width="100" >작성자</td>
						<td align="center"  width="150" >작성일</td> 
						<td align="center"  width="50" >조 회</td> 
						<td align="center"  width="100" >IP</td>   
				    </tr>
				    <c:forEach var="article" items="${list}">
					    <tr height="30">
					    	<td align="center"  width="50" >${article.num}</td>
					    	<td  width="250" >
								<c:if test="${article.re_level > 0}">
							  		<img src="/resources/image/level.gif" width="${20 * article.re_level}" height="16">
							  		<img src="/resources/image/re.gif">
							  	</c:if>
								<c:if test="${article.re_level == 0}">
							  		<img src="/resources/image/level.gif" width="0" height="16">
								</c:if>
					           
								<a href="content?num=${article.num}&pageNum=${pageNum}">
						           ${article.subject}
								</a> 
								<c:if test="${article.isfile > 0}">
									<img src="/resources/file/board/img.png" border="0"  height="16">
								</c:if>
								<c:if test="${article.readcount >= 20 }">
									<img src="/resources/image/hot.gif" border="0"  height="16">
								</c:if>
							</td>
						    <td align="center"  width="100"> 
								<a href="mailto:${article.email}">${article.writer}</a></td>
						    <td align="center"  width="150"><fmt:formatDate value="${article.reg_date}" type="date" dateStyle="short" /></td>
						    <td align="center"  width="50">${article.readcount}</td>
						    <td align="center" width="100" >${article.ip}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			
			<c:if test="${count > 0 }">
				<c:if test="${startPage > 10}">
					<a href="/free/list?pageNum=${startPage-10}">[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<a href="/free/list?pageNum=${i}">[${i}]</a>
				</c:forEach>
				<c:if test="${endPage < pageCount}">
					<a href="/free/list?pageNum=${startPage+10}">[다음]</a>
				</c:if>
			</c:if>
			
		</center>
	</body>
</html>














