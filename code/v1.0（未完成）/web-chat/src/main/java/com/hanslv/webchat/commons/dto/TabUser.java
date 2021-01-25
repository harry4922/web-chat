package com.hanslv.webchat.commons.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户表						tab_user
 * 用户ID						user_id									BIGINT								PRIMARY KEY				 			AUTO_INCREMENT
 * 用户登录名					user_name								VARCHAR(50)
 * 用户真实姓名					user_real_name							VARCHAR(100)
 * 用户手机号					user_mobel								VARCHAR(255)
 * 用户邮箱						user_mail								VARCHAR(255)
 * 用户密码						user_password							VARCHAR(255)
 * 用户上次登出前最后的版本号		last_version							BIGINT								DEFAULT 1
 * 用户角色ID					role_id									BIGINT								FOREIGN_KEY(fk_user_role)
 * @author hanslv
 *
 */
@Data
@ApiModel(value="用户表" , description="包含用户的基本信息，登录名、真实姓名、电话、角色、当前是否在线等")
public class TabUser {
	public static final String JSON_USERNAME_KEY = "userName";//用户名Json中的key
	public static final String JSON_PASSWORD_KEY = "userPassword";//用户密码Json中的key
	public static final String JSON_REALNAME_KEY = "userRealName";//用户真实姓名Json中的key
	public static final String JSON_MOBEL_KEY = "userMobel";//用户联系电话Json中的key
	public static final String JSON_MAIL_KEY = "userMail";//用户邮箱Json中的key
	
	
	@ApiModelProperty(value="用户ID" , required=true , position=1)
	private Integer userId;
	@ApiModelProperty(value="用户登录名" , required=true , position=2)
	private String userName;
	@ApiModelProperty(value="用户真实姓名" , required=true , position=3)
	private String userRealName;
	@ApiModelProperty(value="用户手机号" , required=true , position=4)
	private String userMobel;
	@ApiModelProperty(value="用户邮箱" , required=true , position=5)
	private String userMail;
	@ApiModelProperty(value="用户密码" , required=true , position=6)
	private String userPassword;
	@ApiModelProperty(value="用户上次登出前最后的版本号" , example="1" , required=true , position=7)
	private Integer lastVersion;
	@ApiModelProperty(value="用户角色ID", reference="参考tab_role表的role_id" , required=true , position=8)
	private Integer roleId;
}
