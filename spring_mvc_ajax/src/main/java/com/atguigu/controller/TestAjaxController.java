package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 1、@RequestBody: 将请求体中的内容和控制器方法中的形参进行绑定
*
* 2、使用@RequestBody注解将json格式的请求参数转换为java对象
* 要满足三个条件:
* a>导入jackson的依赖
* b>我们需要在springMVC的配置文件中设置 开启MVC的注解驱动
* C>处理请求的控制器方法的形参位置，直接设置json格式的请求参数要转换的java类型的形参，再使用@RequestBody标识即可
*
*3.@ResponseBody: 将所标识的控制器方法的返回值作为响应报文的响应体相应到浏览器
*
*4.使用@ResponseBody注解响应浏览器json格式的数据
* a>导入jackson的依赖
* b>在SpringMVC的配置文件中设置<mvc:annotation-driven/>
* c>将需要转换为json字符串的java对象直接作为控制器方法的返回值，使用@ResponseBody注解标识控制器方法
* 就可以将java对象直接转换为json字符串，并相响应到浏览器。
*
* 常用的Java对象转换为json对象的结果:
* 实体类-->json对象
* map-->json对象
* list-->json数组
* */
@Controller
//@RestController @controller+@ResponseBody
public class TestAjaxController {

    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        // ajax是在页面不刷新的情况下实现请求 不能使用转发和重定向
        System.out.println("requestBody:"+requestBody); // 输出请求所携带的请求体
        System.out.println("id:"+id);
        response.getWriter().write("hello,axios");
    }

    @RequestMapping("/test/RequestBody/json")
    public void testRequestBody(@RequestBody Map<String, Object> map, HttpServletResponse response) throws IOException {
        System.out.println(map);
        response.getWriter().write("hello, RequestBody");
    }

    public void testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException {
        System.out.println(user);
        response.getWriter().write("hello, RequestBody");
    }

    @RequestMapping("/test/ResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "success";
    }

    //@RequestMapping("/test/ResponseBody/json")
    //@ResponseBody
    ////public User testResponseBodyJson(){
    //public Map<String, Object> testResponseBodyJson(){
    //    User user1 = new User(1001, "admin1", "123456", 20,"男");
    //    User user2 = new User(1002, "admin2", "123456", 20,"男");
    //    User user3 = new User(1003, "admin3", "123456", 20,"男");
    //    Map<String, Object> hm = new HashMap<>();
    //    hm.put("1001",user1);
    //    hm.put("1002",user2);
    //    hm.put("1003",user3);
    //    return hm;
    //}

    @RequestMapping("/test/ResponseBody/json")
    @ResponseBody
    //public User testResponseBodyJson(){
    public List<User> testResponseBodyJson(){
        User user1 = new User(1001, "admin1", "123456", 20,"男");
        User user2 = new User(1002, "admin2", "123456", 20,"男");
        User user3 = new User(1003, "admin3", "123456", 20,"男");
        List<User> list = Arrays.asList(user1, user2, user3);
        return list;
    }
}
