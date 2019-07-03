<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#money_bt_hundred").click(function(){
			postMoney($("#money_bt_hundred").val());
		})
	})
	
	function postMoney(obj){
		var money = new Object();
		money.value = obj;
		$.post({
			url:"/getMoney",
			data:money,
			success:function(data){
				alert(data.value);
			}
		})
	}
</script>
</head>
<body>
	<button id="money_bt_hundred" value="100"></button>
</body>
</html>