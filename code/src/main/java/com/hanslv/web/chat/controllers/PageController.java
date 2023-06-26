package com.hanslv.web.chat.controllers;

import com.hanslv.web.chat.constants.PagePathConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : hansLv
 * @date : 2023/6/26 15:19
 * 页面Controller
 */
@Controller
public class PageController {
    /**
     * PC端主页
     * @return 主页地址
     */
    @RequestMapping("/pc/main")
    public String pcMain(){
        return PagePathConstants.PC_MAIN_PAGE;
    }
}
