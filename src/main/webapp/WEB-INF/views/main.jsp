<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#main_bt_getMoney").click(
			function(){
				getMoney();
			}
		);
	})
		
	function getMoney(){
		alert($("#main_bt_getMoney").val("11"));//设置button的value
		window.location.href="/money/getMoney";
	}
	
</script>
</head>
<body>
	<input type="button" id="main_bt_getMoney" value="取钱">
</body>
</html>