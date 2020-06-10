<%@page import="java.util.ArrayList"%>
<%@page import="java.io.File" %>
<%@page import="bean.User"%>
<%@ page language="java"
	 contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/main.css">
<title>掲示板管理</title>
</head>
<body>
<p class="mi"><a href="/Java2-No9/change">管理画面へ</a></p>

	<form method="get" action="/Java2-No9/Insert">
	投稿者<br>
	<input type="text" name="name"><br>
	本文<br>
	<textarea name="text" rows="5" cols="50">200文字まで</textarea><br>
	<input type="submit" value="投稿"><br>
	</form>

	<form method="POST" enctype="multipart/form-data" action="/Java2-No9/KeijibanPre">
	<input type="text" name="id">
	<input type="file" name="file"/><br />
	<input type="submit" value="アップロード" />
	</form>
	<hr>

	</form>

	<table  border="1">
		<tr>
			<th>ID</th>
			<th>投稿者</th>
			<th>投稿内容</th>
			<th>投稿日時</th>
			<th>編集日時</th>
		</tr>
	<%
	ArrayList<User> UserList = (ArrayList<User>)request.getAttribute("list");
	for(int i = 0 ; i < UserList.size() ; i++){
		User user = UserList.get(i);
	%>
		<tr>
			<td><%=user.getid() %></td>
			<td><%=user.getname() %></td>
			<td><%=user.gettext() %></td>
			<td><%=user.getdatenow() %></td>
			<td><%=user.getdateedit() %></td>
			</tr>
	<%
	}
	%>
	</table>
	<%
	File file = new File("C:\\pleiades\\workspace\\Java2-No9\\WebContent\\upload");
	File files[] = file.listFiles();
	for(int i = 0 ; i < files.length ; i++) {
	%>
		<img src=<%= files[i] %> width="60" height="60">
	<%
	}
	%>

</body>
</html>