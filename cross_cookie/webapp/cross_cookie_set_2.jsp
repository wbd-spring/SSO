<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>将cookie写入其它域</title>

</head>
<body>
cross domain cookie set

<iframe src="http://www.b.com:8080/set_cookie?cname=token&cval=tttt"></iframe>

<script type="text/javascript">
	// 完成了向其它域的cookie set之后，此处一般执行一个跳转
	// location.href = "url to reidrect";
</script> 
</body>
</html>