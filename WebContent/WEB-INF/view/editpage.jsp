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
<p>投稿内容編集</p>
<form method="get" action="/Java2-No9/editresult">

	本文<br>
	<textarea name="text" rows="5" cols="50">200文字まで</textarea><br>
	<input type="submit" value="編集"><br>

<a href="/Java2-No9/KeijibanPre">戻る</a>


</body>
</html>