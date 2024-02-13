package com.yu.qiniu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 页面跳转控制
 */
@Controller
public class IndexController {

    /**
     * 测试的主页
     *
     * @return 访问 localhost:9010 ，即可访问主页
     */
    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("uploadDemo1")
    public String uploadDemo1() {
        return "uploadDemo1";
    }

    @GetMapping("uploadDemo2")
    public String uploadDemo2() {
        return "uploadDemo2";
    }

    @GetMapping("uploadDemo3")
    public String uploadDemo3() {
        return "uploadDemo3";
    }
}
