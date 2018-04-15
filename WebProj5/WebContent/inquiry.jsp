<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>お問合せフォーム</title>
</head>
<body>
<s:from method="post" action="InquiryCompleteAction">
名前:<input type="text" name="name"><br>
お問合せの種類<br>
<select name ="qtype">
	<option value="company">会社について</option>
	<option value="product">製品について</option>
	<option value="support">アフターサポートについて</option>
</select>
<br>
お問合せ内容:
<s:textarea name="body"/>
<br><s:submit value="登録"></s:submit>
</s:from>
</body>
</html>