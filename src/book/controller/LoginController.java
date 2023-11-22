package book.controller;

import book.entity.*;
import book.service.UserService;
import book.service.UserServiceImpl;
import book.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;

@Controller
@SessionAttributes(value = {"role", "user"})
@RequestMapping("/login.do")
public class LoginController
{
    @Autowired()
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping(params = "method=login1")
    public String login(Account account, Model model)
    {
        int id=userService.getUserId(account).getData();
        account.setId(id);
        Result<Role> result = userService.login(account);
        if (!result.isSuccess())
        {
            model.addAttribute("error",result.getMessage());
            return "Login/loginError";
        }
        UserInfo userInfo = userService.getUserInfo(account);
        if (result.getData() instanceof Admin)
        {
            model.addAttribute("role", result.getData());
            model.addAttribute("user", userInfo);
            System.out.println("You will login Admin/index");
            return "Admin/indexAddUser";
        }
        if (result.getData() instanceof Staff)
        {
            model.addAttribute("role", result.getData());
            model.addAttribute("user", userInfo);
            System.out.println("You will login staff/index");
            return "staff/Book/AddBook";
        }
        System.out.println("You will login reader/index");
        return "reader/index";
    }

}
