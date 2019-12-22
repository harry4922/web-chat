package com.hanslv.webchat.commons.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 角色表						tab_role
 * 角色ID						role_id									BIGINT								PRIMARY KEY							AUTO_INCREMENT
 * 角色名称						role_name								VARCHAR(255)
 * 登录权限						is_logonable							BOOLEAN								DEFAULT false
 * 管理者权限					is_admin								BOOLEAN								DEFAILT false
 * 创建群聊权限					is_group_creater						BOOLEAN								DEFAULT false
 * @author hanslv
 *
 */
@Data
@ApiModel(value="角色类" , description="当前存在的全部角色，包含角色ID、角色对应的权限等")
public class TabRole {
	@ApiModelProperty(value="角色ID" , example="1" , required=true , position=1)
	private Integer roleId;
	@ApiModelProperty(value="角色名称" , example="admin" , required=true , position=2)
	private String roleName;
	@ApiModelProperty(value="当前角色是否可以登录" , required=true , position=3)
	private Boolean isLogonable;
	@ApiModelProperty(value="当前角色是否为管理员" , required=true , position=4)
	private Boolean idAdmin;
	@ApiModelProperty(value="当前角色是否可以创建组" , required=true , position=5)
	private Boolean isGroupCreater;
}
