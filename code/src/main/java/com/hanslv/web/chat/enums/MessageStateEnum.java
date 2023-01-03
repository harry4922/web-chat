package com.hanslv.web.chat.enums;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/3 16:48
 * @description 消息类型枚举
 */
public enum MessageStateEnum {

    /**
     * 未接收
     */
    NOT_RECEIVED(0, "未接收"),
    /**
     * 已接收
     */
    RECEIVED(1, "已接收"),
    /**
     * 已读
     */
    READED(2, "已读"),



    ;

    /**
     * CODE
     */
    private int code;
    /**
     * 名称
     */
    private String name;

    MessageStateEnum(int code, String name){
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
    public static MessageStateEnum selectByCode(int code){
        for (MessageStateEnum item : MessageStateEnum.values()){
            if(item.code == code){
                return item;
            }
        }
        return null;
    }

}
