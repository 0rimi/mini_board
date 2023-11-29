<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${result == true}">
	  <meta http-equiv="Refresh" content="0;url=/user/modify.me" >
</c:if>
<c:if test="${result != true}">
      <script language="JavaScript">        
        alert("이미지 파일만 업로드 가능합니다.");
        history.go(-1);
     </script>
</c:if>