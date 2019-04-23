<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookie_reader.jsp</title>
<script type="text/javascript" src="js/utils.js"></script>
</head>
<body>

<script type="text/javascript">
	window.onload = function () {
		var token = Utils.getCookie("token");
		document.write("token is: " + token);
	}
</script>
</body>
</html>