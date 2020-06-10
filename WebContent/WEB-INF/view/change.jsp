<%@page import="java.util.ArrayList"%>
<%@page import="bean.User"%>
<%@ page language="java"
	 contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>掲示板管理</title>
</head>
<body>
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
		int num = user.getid();
		int id = i;
	%>
		<tr>
			<td><%=user.getid() %></td>
			<td><%=user.getname() %></td>
			<td><%=user.gettext() %></td>
			<td><%=user.getdatenow() %></td>
			<td><%=user.getdateedit() %></td>
			<td><form method="get" action="/Java2-No9/edit">
				<input type="hidden" name="userid" value="<%= user.getid() %>">
				<button type="submit" values="編集">編集</button>
				</form>
			</td>
			<td><form method="get" action="/Java2-No9/delet">
				<input type="hidden" name="userid" value="<%= user.getid() %>">
				<button type="submit" values="削除">削除</button>
				</form>
			</td>
		</tr>
	<%
	}
	%>
	</table>



</body>
</html>