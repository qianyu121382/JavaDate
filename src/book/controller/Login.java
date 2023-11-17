package book.controller;

import book.entity.user;
import book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login.do")
public class Login
{
    @Autowired()
    private UserService userService;

    @RequestMapping(params = "method=login1")
    public String login(user user)
    {
        if (userService.login(user))
        {
            System.out.println("登录成功");
        }
        else
        {
            System.out.println("登录失败");
        }
        return "login";
    }
}
