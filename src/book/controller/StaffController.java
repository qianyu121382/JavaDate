package book.controller;

import book.entity.BookInfo;
import book.service.UserService;
import book.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staff.do")
public class StaffController
{
    @Autowired()
    @Qualifier("userService")
    private UserService userService;
    @RequestMapping(params = "method=book1")
    public String addBook(BookInfo info)
    {
        System.out.println(info.getUnitId());
        Result<Boolean> result=userService.addBookInfo(info);
        if(result.isSuccess())
        {
            return "staff/Book/AddBook";
        }
        System.out.println(result.getMessage());
        return "";
    }
}
