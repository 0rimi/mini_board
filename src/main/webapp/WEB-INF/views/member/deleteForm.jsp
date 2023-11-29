<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/etc/color.jsp" %>
<html>
<head><title>회원탈퇴</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="/resources/js/member.js"></script>
</head>

<BODY onload="begin()" bgcolor="${bodyback_c}">
	<form name="myform" action="/user/deletePro.me" method="post" onSubmit="return deleteCheckIt()">
	<TABLE cellSpacing=1 cellPadding=1 width="260" border=1 align="center" >
	  
	  <TR height="30">
	    <TD colspan="2" align="middle" bgcolor="${title_c}">
		  <font size="+1" ><b>회원 탈퇴</b></font></TD></TR>
	  
	  <TR height="30">
	    <TD width="110" bgcolor="${value_c}" align=center>비밀번호</TD>
	    <TD width="150" align=center>
	      <INPUT type=password name="passwd"  size="15" maxlength="12"></TD></TR>
	  <TR height="30">
	    <TD colspan="2" align="middle" bgcolor="${value_c}" >
	      <INPUT type=submit value="회원탈퇴"> 
	      <input type="button" value="취  소" onclick="javascript:window.location='/user/main.me'"></TD></TR>
	</TABLE>
	</form>
</BODY>
</HTML>
