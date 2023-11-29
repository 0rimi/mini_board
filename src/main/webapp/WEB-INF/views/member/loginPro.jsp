<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8");%>

<c:if test="${check == 1}">	<!-- dto는 뷰페이지까지 넘어감 -->
	<c:set var="memId" value="${memberDTO.id}" scope="session" />
	<c:redirect url="/user/main.me" />
</c:if>
<c:if test="${check == 0}">
	<script> 
	  alert("아이디/비밀번호를 확인하세요");
      history.go(-1);
	</script>
</c:if>
<c:if test="${check == -1}">
	<script>
	  alert("아이디가 맞지 않습니다..");
	  history.go(-1);
	</script>
</c:if>