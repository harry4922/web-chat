package com.hanslv.web.chat.dto.res;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/9 13:39
 * @description 好友列表返回对象
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FriendListResDto extends BaseResDto{
    /**
     * 好友信息列表
     */
    private List<FriendListInfo> friendInfoList = new ArrayList<>();

    /**
     * 好友信息列表详情
     */
    @Data
    public static class FriendListInfo{
        /**
         * 好友ID
         */
        private Integer friendUserId;
        /**
         * 好友名称
         */
        private String friendUserName;
    }
}
