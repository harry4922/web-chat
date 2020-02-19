/**
 * 页面载入时执行
 */
window.onload = function(){
	/*
	 * 1、拼接注册页面信息到<a>
	 */
	$("#logon_toRegister").attr("href" , to_register_url);
}

/**
 * 提交当前用户输入的登录信息
 * @returns
 */
function submit(){
	debugger;
	/*
	 * 获取当前用户输入的用户名和密码
	 */
	var submit_username = $("#logon_username").val();
	var submit_password = $("#logon_userpass").val();
	
	/*
	 * 判断用户名或密码是否为空
	 */
	if(!checkNull(submit_username) || !checkNull(submit_password)){
		alert("请输入用户名和密码！");
		return;
	}
	
	/*
	 * 验证用户登录信息
	 */
	var submit_data = {
			"username" : submit_username,
			"pass":submit_password
	};
	$.post(logon_submit_url,submit_data,
		function(result){
			debugger;
			alert(result);
		}
	)
}