package chapter07.controller;

import chapter05.model.Spitter;
import chapter07.exception.DuplicateException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.webflow.context.servlet.HttpServletRequestMap;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

/**
 * @author NikoBelic
 * @create 09/01/2017 20:48
 */
@Controller
@RequestMapping(value = "weibo")
public class WeiboController
{
    /**
     * 跳转到注册界面
     * @Author NikoBelic
     * @Date 09/01/2017 22:35
     */
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String showRegister()
    {
        return "weibo/register";
    }

    /**
     * 处理注册流程
     * @Author NikoBelic
     * @Date 09/01/2017 22:36
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String processRegister(@RequestPart("profilePic")MultipartFile profilePic, @Valid Spitter spitter, Errors errors, RedirectAttributes model) throws IOException, DuplicateException
    {
        profilePic.transferTo(new File("/Users/lixiwei-mac/Desktop/data/" + profilePic.getOriginalFilename()));
        System.out.println(spitter);
        if (spitter.getUsername().equals("dup"))
            throw new DuplicateException();
        model.addAttribute("username",spitter.getUsername());
        model.addAttribute("password",spitter.getPassword());
        model.addFlashAttribute(spitter);
        return "redirect:/weibo/profile/{username}";
    }

    /**
     * 测试安全性拦截
     * @Author NikoBelic
     * @Date 12/01/2017 14:53
     */
    @RequestMapping(value = "/testSecurity")
    public String testSecurity(HttpServletRequest req)
    {
        return "/home";
    }

    /**
     * 个人信息校验
     * @Author NikoBelic
     * @Date 12/01/2017 14:51
     */
    @RequestMapping(value = "/profile/{username}",method = RequestMethod.GET)
    public String profile(@PathVariable("username") String username,String password,Model model)
    {
        System.out.println(username);
        System.out.println(password);
        System.out.println(model.containsAttribute("spitter"));
        return "profile";
    }

    /**
     * 跳转登陆页面
     * @Author NikoBelic
     * @Date 12/01/2017 19:46
     */
    @RequestMapping(value = "/showLogin",method = RequestMethod.GET)
    public String showLogin()
    {
        return "/weibo/login";
    }

}
