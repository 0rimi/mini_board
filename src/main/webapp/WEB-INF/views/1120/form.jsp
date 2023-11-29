<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<h1>/1120/form.jsp</h1>
<form action="/1120/main3.do" method="post">
	name : <input type="text" name="name"><br>
	number : <input type="number" name="number"><br>
			<input type="submit" value="전송">
</form>

<hr color="red">

<form action="/1120/upload.do" method="post" enctype="multipart/form-data">
	file : <input type="file" name="save"><br>
			<input type="submit" value="전송">
</form>