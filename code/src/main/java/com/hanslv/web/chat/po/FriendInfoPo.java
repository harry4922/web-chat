package com.hanslv.web.chat.po;

import lombok.Data;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/9 10:29
 * @description 好友信息PO
 */
@Data
public class FriendInfoPo {
    /**
     * 好友用户ID
     */
    private Integer friendUserId;
    /**
     * 好友用户名称
     */
    private String friendUserName;
}
