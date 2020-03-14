package com.hanslv.webchat.commons.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * （分表）
 * 聊天信息表											tab_chat_info
 * 用户ID												user_id										BIGINT									PRIMARY KEY					FOREIGN_KEY fk_chat_user
 * 对方用户ID											other_user_id								BIGINT									PRIMARY KEY					FOREIGN_KEY fk_chat_other_user
 * 当前信息版本号										version										BIGINT									PRIMARY KEY
 * 聊天内容												chat_content								VARCHAR(255)
 * @author hanslv
 *
 */
@Data
@ApiModel(value="聊天信息表" , description="共拆分成5张表，用来存储全部用户的聊天信息")
public class TabChatInfo {
	@ApiModelProperty(value="当前用户ID，存储当前用户信息" , example="12345" , required=true , position=1)
	private Integer userId;
	@ApiModelProperty(value="对方用户信息，当前用户的聊天对象" , example="12345" , required=true , position=2)
	private Integer otherUserId;
	@ApiModelProperty(value="当前聊天信息对应当前用户的全局版本号，每个用户都会有一个全局版本号用来保证接收消息" , example="1" , required=true , position=3)
	private Integer version;
	@ApiModelProperty(value="当前聊天记录内容" , example="Hello World" , required=true , position=4)
	private String chatContent;
}
