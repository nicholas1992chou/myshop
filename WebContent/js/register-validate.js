/**
 * 
 */
$(document).ready(function(){
	//自定义验证方法
	$.validator.addMethod("phone",function(value, element, params){
		return new RegExp(/^1[358]\d{9}$/).test(value);
	},"please provide a valid phone number");
	
	var validator = $("#register_form").validate({
		//debug:true,
		onkeyup:false,
		onfocusout: function(element) { $(element).valid(); },
		rules:{
			name:{
				required:true,
				remote:{
					 url: "customer_register.action",     //后台处理程序
					    type: "post",               //数据发送方式
					    dataType: "text"          //接受数据格式   
					    },
				rangelength:[2,16]
				},
			password:{
				required:true,
				minlength:6
			},
			
			confirm:{
				required:true,
				equalTo: "#register_password"
			},
			phone:{
				required:true,
				phone:true,
			},
			email:{
				required:true,
				email:true
				}
			},
			
	messages:{
		name:{
			required:"please Enter a userName",
			minlength:$.validator.format("Please enter a userName between {0} and {1} characters long"),
			remote: $.validator.format("{0} is already in use")
		},
		password:{
			required:"please provide a password ",
			minlength:$.validator.format("please Enter at least {0} characters")
		},
		confirm:{
			required: "Repeat your password",
			equalTo: "Enter the same password as above"
		},
		email: {
			required: "Please enter a valid email address"
				}
		},
		errorElement:"div",
		errorPlacement:function(error, element){
			$(element).parent().next().html(error);
		},
		success:"ok",
		highlight:function(element){
			$(element).parent().next().find("div").removeClass("ok");
		},
		submitHandler:function(form){
			$("#register_form input[name=register_password]").attr("name","password");
			
            form.submit();
            }
	});
	$(".reset").click(function() {
        validator.resetForm();
        $("#register_form")[0].reset();
    });
});