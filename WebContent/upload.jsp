<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload Example in JSP and Servlet - Java web
	application</title>
</head>

<body>
	<div>
		<h3>Choose File to Upload in Server</h3>
		<form action="/prisoners/upload" method="post" enctype="multipart/form-data">
			<select name="text">
				<option value="baoli">暴力犯</option>
				<option value="zhiwu">职务犯</option>
				<option value="sharen">杀人犯</option>
				<option value="qiangjian">强奸犯</option>
			</select> 选择一个文件: <input type="file" name="file" /> <br />
			<br /> <input type="submit" value="upload" />
		</form>
	</div>

</body>
</html>
