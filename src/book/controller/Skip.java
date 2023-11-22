package book.controller;

import book.entity.BookInfo;
import book.entity.UserInfo;
import book.entity.UserInfoAndRole;
import book.entity.WorkUnit;
import book.service.UserService;
import book.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("/skip.do")
public class Skip
{
    @Autowired()
    @Qualifier("userService")
    private UserService userService;
    @RequestMapping(params = "method=addUser")
    public String skipAddUser()
    {
        return "Admin/indexAddUser";
    }

    @RequestMapping(params = "method=showUser")
    public String skipShowUser(Model model)
    {
        ArrayList<UserInfoAndRole> arrayList = userService.getAllUserAndRoles().getData();
        model.addAttribute("allUserRoles", arrayList);
        return "Admin/showUser";
    }
    @RequestMapping(params = "method=showWork")
    public String skipShowWork(Model model)
    {
        ArrayList<WorkUnit> arrayList = userService.getAllWorkUnit().getData();
        model.addAttribute("allWorkUnit", arrayList);
        return "Admin/showWorkUnit";
    }
    @RequestMapping(params = "method=addWork")
    public String skipaddWork(Model model)
    {
        return "Admin/workUnit";
    }

    @RequestMapping(params = "method=addBook")
    public String skipAddBook()
    {
        return "staff/Book/AddBook";
    }
    @RequestMapping(params = "method=showBook")
    public String skipShowBook(Model model)
    {
        model.addAttribute("data",userService.selectAllBooks().getData());
        return "staff/Book/showBook";
    }
    @RequestMapping(params = "bookName")
    public String skipShowBookDetail(String bookName,Model model)
    {
        Result<BookInfo>bookInfoResult=userService.selectBookByName(bookName);
        model.addAttribute("data",bookInfoResult.getData());
        return "staff/Book/BookDetail";
    }
    @RequestMapping(params = "update")
    public String skipBookUpdate(String bookName,Model model)
    {
        Result<BookInfo>bookInfoResult=userService.selectBookByName(bookName);
        model.addAttribute("data",bookInfoResult.getData());
        return "staff/Book/BookDetailAlter";
    }
    @RequestMapping(params = "id")
    public String skipBookAlter(int id,Model model)
    {
        Result<BookInfo>bookInfoResult=userService.selectBookById(id);
        model.addAttribute("data",bookInfoResult.getData());
        return "staff/Book/BookDetailAlterFather";
    }
    @RequestMapping(params = "method=alterUser")
    public String skipAlterUser(HttpServletRequest request,Model model)
    {
        UserInfo userInfo= (UserInfo) request.getSession().getAttribute("user");
        request.getSession().setAttribute("user",userService.selectUserInfo(userInfo.getId()).getData());
        return "All/PersonalCenter";
    }
}
