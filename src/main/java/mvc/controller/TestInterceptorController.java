package mvc.controller;

import mvc.utils.MyInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.interceptor.Interceptor;
import javax.interceptor.Interceptors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试拦截器与过滤器
 * @author NikoBelic
 * @create 2017/4/11 18:00
 */
@Controller
@RequestMapping(value = "/interceptor")
@Interceptors(value = {MyInterceptor.class})
public class TestInterceptorController
{
    @RequestMapping(value = "/dosomething")
    @ResponseBody
    public String doSomething(HttpServletRequest request, HttpServletResponse response)
    {
        System.out.println("I am doing something...");
        return "Fuck You!";
    }
}
