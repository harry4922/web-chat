package com.hanslv.web.chat.dto.res;

import lombok.Data;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/9 13:39
 * @description 好友列表返回对象
 */
@Data
public class FriendListResDto extends BaseResDto{
    /**
     * 好友ID
     */
    private Integer friendUserId;
    /**
     * 好友名称
     */
    private String friendUserName;
}
