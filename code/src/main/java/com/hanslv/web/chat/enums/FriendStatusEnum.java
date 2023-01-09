package com.hanslv.web.chat.enums;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/9 15:33
 * @description 好友状态枚举
 */
public enum FriendStatusEnum {
    /**
     * 请求中
     */
    REQUEST(1, "请求中"),
    /**
     * 已确认
     */
    CONFIRM(2, "已确认"),
    /**
     * 对方已删除
     */
    FRIEND_DELETE(3, "对方已删除"),

    ;

    /**
     * CODE
     */
    private int code;
    /**
     * 名称
     */
    private String name;

    FriendStatusEnum(int code, String name){
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    /**
     * 根据Code获取枚举
     * @param code code
     * @return 枚举
     */
    public static FriendStatusEnum selectByCode(int code){
        for (FriendStatusEnum item : FriendStatusEnum.values()){
            if(item.code == code){
                return item;
            }
        }
        return null;
    }
}
