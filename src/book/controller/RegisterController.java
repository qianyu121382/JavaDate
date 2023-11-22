package book.controller;

import book.entity.*;
import book.service.UserService;
import book.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register.do")
public class RegisterController
{
    @Autowired()
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping(params = "method=register1")
    public String register(Account account,String email,Model model)
    {
        Result<Boolean> result=userService.register(account, email);
        if(result.isSuccess())
        {
            return "Login/registerSuccess";
        }
        model.addAttribute("error",result.getMessage());
        return "Login/registerError";
    }
}
