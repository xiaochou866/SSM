package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class TestAjaxController {

    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, HttpServletResponse response) throws IOException {
        // ajax是在页面不刷新的情况下实现请求 不能使用转发和重定向
        System.out.println("id:"+id);
        response.getWriter().write("hello,axios");
    }
}
