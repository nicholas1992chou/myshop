$(document).ready(function() {
	var price = parseInt($("span span").attr("lang"));
	$("span span").html((price * (price + 0.6) + 200).toFixed(2));
	//设置ajax请求为同步，这样才能拿到返回结果。
	$.ajaxSetup({
		  async: false
		  });
	var flag = false;
	function check() {
		// 发送ajax请求去任一action,查看是否已登录，
		// 如果没有登录，登出登录窗口
		$.post("customer_check.action", {}, function(result) {
			if (result == "false") {
				
				var duc_w;
				var duc_h;
				var log_w;
				var log_h;
				duc_w = $(document).width();
				duc_h = $(document).height();
				log_w = $("#login").width();
				$("#login .interceptor").css("display", "block");
				$("#login").css("left", (duc_w - log_w) / 2);
				$("#login").css("display", "block");
				$("#lock").css({
					width : duc_w,
					height : duc_h,
					display : "block"
				});
			} else {
				flag = true;
				
			}
		});
		return flag;
	}
	;
	
	$("#cart").click(function() {
		return check();
	});

});