//======================常量======================
var base_url = "http://localhost:8081/";
var logon_submit_url = base_url + "logon/dologon";
var to_register_url = base_url + "register/toRegister";
var do_register_url = base_url + "register/doRegister";




//======================functions======================
/**
 * 判断传入是否为空							function checkNull(param)
 * 
 */
/**
 * 判断传入是否为空
 * @param param
 * @returns
 */
function checkNull(param){
	debugger;
    //正则表达式用于判斷字符串是否全部由空格或换行符组成
    var reg = /^\s*$/
    //返回值为true表示不是空字符串
	return (param != null && param != undefined && !reg.test(param))
}
