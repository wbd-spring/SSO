<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>读取其它域cookie信息</title>

<!-- 
	通过script标签执行另一个域实现的读取cookie的方法，
	script标签返回结果将是变量定义形式的js代码，其中每一个变量表示一个cookie项
	这些代码加载后，此页面后续js代码可直接读取已定义的变量值，即各cookie值
 -->
<script type="text/javascript" src="http://www.b.com:8080/read_cookies"></script>

</head>
<body>

<script type="text/javascript">
	//alert(a);
	alert(token);
	//alert(cc)
</script>
</body>
</html>