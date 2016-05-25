/**
 * 
 */
var t;
$(document).ready(
		function() {
			$('.inner').css('display', 'none');
			$('#head').children().children().mouseover(
					function() {
						var li = $(this);
						clearTimeout(t);
						$('.inner').css('display', 'none');
						$('#head ul li a')
								.css('background', 'rgb(250,250,250)').css(
										'color', 'rgb(14, 15, 18)');
						$(this).find('a').css('background', 'rgb(72,82,94)')
								.css('color', 'white');
						$(this).find('.inner').css('display', 'block');
					});
			$('#head').children().children().mouseout(
					function() {
						var li = $(this);
						t = setTimeout(function() {
							li.find('.inner').css('display', 'none');
							li.find('a').css('background', 'rgb(250,250,250)')
									.css('color', 'rgb(14, 15, 18)');
						}, 100);

					});
			$("#bg ul").animate({
				left : '-6476.2px'
			}, 60000, "linear", function callback() {
				var left = -6476.2;

				if ($("#bg ul").offset().left < left) {

					$("#bg ul").css("left", "0px");

				}
				$("#bg ul").animate({
					left : '-6476.2px'
				}, 60000, "linear", callback);
			});
			$(".inner a").mouseover(function() {
				$(this).css({
					'-moz-transform' : 'rotateX(360deg)',
					'-webkit-transform' : 'rotateX(360deg)',
					'-ms-transform' : 'rotateX(360deg)'
				});
			});
			$(".inner a").mouseout(function() {
				$(this).css({
					'-moz-transform' : 'rotateX(0deg)',
					'-webkit-transform' : 'rotateX(0deg)',
					'-ms-transform' : 'rotateX(0deg)'
				});
			});
			$("#sc .search").click(function() {
				$("#searchbox").css("display", "block");
			});
			$("#cancel").click(function() {
				$("#searchbox").css("display", "none");
			});

			$("#sc .register").click(function() {
				var text = $(this).html();
				if(text == "sign up"){
				var duc_w;
				var duc_h;
				var reg_w;
				var reg_h;
				
				duc_w = $(document).width();
				duc_h = $(document).height();
				reg_w = $("#register").width();
				
				
				$("#register").css("left", (duc_w - reg_w) / 2);
				
				$("#register").css("display", "block");

				$("#lock").css({
					width : duc_w,
					height : duc_h,
					display : "block"
				});
				}else{
						var url="customer_exit.action";
						var params={"name":text};
						$.post(url,params,function(){
							$("#sc .login").html("login");
							$("#sc .register").html("sign up");
						});
				}
			});
			$("#register .close").click(function() {

				$("#register").css("display", "none");
				$("#lock").css({

					display : "none"
				});
			});
			$("#sc .login").click(function() {
				var text = $(this).html();
				if(text == "login"){
					var duc_w;
					var duc_h;
					var log_w;
					var log_h;
					
					duc_w = $(document).width();
					duc_h = $(document).height();
					log_w = $("#login").width();
					
					
					
					$("#login").css("left", (duc_w - log_w) / 2);
					$("#login").css("display", "block");
					$("#lock").css({
						width : duc_w,
						height : duc_h,
						display : "block"
					});
				}
			});
			$("#login .closeicon").click(function() {
				$("#login .interceptor").css("display","none");
				$("#login .interceptor").css("display","none");
				$("#login .error").css("display","none");
				$("#login").css("display", "none");
				$("#lock").css({
					display : "none"
				});
			});
			$("#login .go").click(function(){
				
				var name=$("#login_form input[name='name']").val();
				var password=$("#login_form input[name='password']").val();
				
				var url="customer_loginByAjax.action";
				var params={"name":name,"password":password};
				$.post(url,params,function(result){
					if(result != "false"){
						$("#login .error").css("display","none");
						$("#login .interceptor").css("display","none");
						$("#login").css("display","none");
						$("#lock").css("display","none");
						$("#sc .login").html(result);
						$("#sc .register").html("sign out");
					}else{
						
						$("#login .error").css("display","block");
						return false;
					}
				});
			});
		});