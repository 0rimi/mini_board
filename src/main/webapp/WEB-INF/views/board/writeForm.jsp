<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/resources/etc/color.jsp"%>
<html>
	<head>
		<title>게시판</title>
		<link href="/resources/css/style.css" rel="stylesheet" type="text/css">
		<script language="JavaScript" src="/resources/js/script.js"></script>
		<script>
			function fileAdd(){
				console.log("파일 추가 버튼");
				document.getElementById("files").innerHTML += "<input type='file' size='40' maxlength='30' name='files' >";
			}
		</script>
	</head>
	<body bgcolor="${bodyback_c}">  
	<center>
		<b>글쓰기</b>
		<br>
		<form method="post" name="writeform" action="/free/writePro" onsubmit="return writeSave()" enctype="multipart/form-data">
			<input type="hidden" name="num" value="${num}">
			<input type="hidden" name="ref" value="${ref}">
			<input type="hidden" name="re_step" value="${re_step}">
			<input type="hidden" name="re_level" value="${re_level}">
			<table width="400" border="1" cellspacing="0" cellpadding="0"  bgcolor="${bodyback_c}" align="center">
	   			<tr>
				    <td align="right" colspan="2" bgcolor="${value_c}">
					    <a href="/free/list"> 글목록</a> 
				   </td>
	   			</tr>
	  			<tr>
				    <td  width="70"  bgcolor="${value_c}" align="center" >제 목</td>
				    <td  width="330">
					    <c:if test="${num == 0}">
					       <input type="text" size="40" maxlength="50" name="subject">
						</c:if>
						<c:if test="${num != 0}">
						   <input type="text" size="40" maxlength="50" name="subject" value="[답변]">
						</c:if>
					</td>
				</tr>
				<tr>
					<td  width="70"  bgcolor="${value_c}" align="center">작성자</td>
					<td  width="330">
						<input type="text" size="40" maxlength="30" name="writer" >
					</td>
	  			</tr>
				<tr>
					<td  width="70"  bgcolor="${value_c}" align="center">Email</td>
					<td  width="330">
						<input type="text" size="40" maxlength="30" name="email" >
					</td>
	  			</tr>
	  			
	  			<tr>
					<td  width="330" colspan="2" align="center">
						<input type="button" value="파일 추가" onclick="fileAdd()">
					</td>
	   			</tr>
	  			
	   			<tr>
				    <td  width="70"  bgcolor="${value_c}" align="center">파 일</td>
					<td  width="330" id="files">
						<input type="file" size="40" maxlength="30" name="files" >
					</td>
	   			</tr>
	   			
				<tr>
					<td  width="70"  bgcolor="${value_c}" align="center" >내 용</td>
					<td  width="330" >
						<textarea name="content" rows="13" cols="40"></textarea> 
					</td>
				</tr>
				<tr>
					<td  width="70"  bgcolor="${value_c}" align="center" >비밀번호</td>
					<td  width="330" >
				 		<input type="password" size="8" maxlength="12" name="passwd"> 
					</td>
				</tr>
				<tr>      
	 				<td colspan=2 bgcolor="${value_c}" align="center"> 
						<input type="submit" value="글쓰기" >  
						<input type="reset" value="다시작성">
						<input type="button" value="목록보기" OnClick="window.location='/free/list'">
					</td>
				</tr>
			</table>       
		</form>      
	</body>
</html>      
    
