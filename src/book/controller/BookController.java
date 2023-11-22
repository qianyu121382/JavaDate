package book.controller;

import book.entity.BookInfo;
import book.service.UserService;
import book.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/Book.do")
public class BookController
{
    @Autowired()
    @Qualifier("userService")
    private UserService userService;
    @RequestMapping(params = "filterTxt")
    public String showBookSelect(String filterTxt, Model model)
    {
        Result<ArrayList<BookInfo>> result=userService.selectBookFilter(filterTxt);
        model.addAttribute("data",result.getData());
        return "staff/Book/showBook";
    }
    @RequestMapping(params = "method=alterBook")
    public String updateBookInfo(BookInfo bookInfo,Model model)
    {
        Result<BookInfo> result=userService.updateBookInfoById(bookInfo);
        model.addAttribute("data",result.getData());
        return "staff/Book/BookDetailAlterFather";
    }

}
