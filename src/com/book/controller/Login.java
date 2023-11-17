package com.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Login
{
    @RequestMapping("/login.do")
    public String login()
    {
        System.out.println(11);
        return "login";
    }
}
