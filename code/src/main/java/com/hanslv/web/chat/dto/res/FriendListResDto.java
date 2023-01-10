package com.hanslv.web.chat.dto.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("好友列表response对象")
@EqualsAndHashCode(callSuper = true)
@Data
public class FriendListResDto extends BaseResDto{
    /**
     * 好友信息列表
     */
    @ApiModelProperty("好友列表信息List")
    private List<FriendListInfo> friendInfoList = new ArrayList<>();

    /**
     * 好友信息列表详情
     */
    @ApiModel("好友列表信息")
    @Data
    public static class FriendListInfo{
        /**
         * 好友ID
         */
        @ApiModelProperty("好友ID")
        private Integer friendUserId;
        /**
         * 好友名称
         */
        @ApiModelProperty("好友名称")
        private String friendUserName;
    }
}
