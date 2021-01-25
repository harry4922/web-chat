/**
 * 将注册信息提交到数据库
 * @returns
 */
function doRegister(){
	debugger;
	var username = $("#register_username").val();//user_name
	var password = $("#register_password").val();//user_password
	var realName = $("#register_realName").val();//user_real_name
	var mobel = $("#register_mobel").val();//user_mobel
	var mail = $("#register_mail").val();//user_mail
	
	/*
	 * 发送给后台数据
	 */
	var register_info = {
			userName:username,
			userPassword:password,
			userRealName:realName,
			userMobel:mobel,
			userMail:mail
	};
	var register_info_json = JSON.stringify(register_info);
	
	/*
	 * 发送请求
	 */
	$.ajax({
		type:"POST",
		url:do_register_url,
		data:register_info_json,
		dataType:"text",
		contentType:"application/json;charset=UTF-8",
		success:function(result){
			debugger;
			if(result == "1"){
				alert("注册成功！");
			}else if(result == "2"){
				alert("系统异常，请稍后再试！");
			}else{
				alert("当前用户名已存在！");
			}
		}
	})
}