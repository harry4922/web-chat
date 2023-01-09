package com.hanslv.web.chat.dto.req;

import lombok.Data;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/9 13:38
 * @description 好友列表请求对象
 */
@Data
public class FriendListReqDto {
    /**
     * 当前用户ID
     */
    private Integer userId;
}
