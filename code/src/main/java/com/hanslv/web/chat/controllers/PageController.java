package com.hanslv.web.chat.controllers;

import com.hanslv.web.chat.constants.PagePathConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author : hansLv
 * @date : 2022/12/30 11:10
 * 页面加载控制器
 */
@Controller
public class PageController {

    /**
     * 主页
     * @return 主页页面
     */
    @GetMapping("/mainPage")
    public String mainPage(){
        return PagePathConstants.MAIN_PAGE;
    }
}
