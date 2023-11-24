package book.controller;

import book.entity.BookInfo;
import book.entity.Mapping.Circulate;
import book.entity.UserInfo;
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
@RequestMapping("/Book.do")
public class BookController
{
    @Autowired()
    @Qualifier("userService")
    private UserService userService;
    @RequestMapping(params = "filterTxt")
    public String showBookSelect(String filterTxt, Model model)
    {
        System.out.println(11);
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
    @RequestMapping(params = "method=circulateBook")
    public String circulateBook(Circulate circulate,Model model)
    {
        System.out.println(circulate.toString());
        userService.insertCirculate(circulate);
        Result<BookInfo>bookInfoResult=userService.selectBookById(circulate.getBookId());
        model.addAttribute("data",bookInfoResult.getData());
        return "staff/Book/BookDetail";
    }
    @RequestMapping(params = "agreeId")
    public String agreeBookApp(int agreeId, HttpServletRequest request,Model model)
    {
        userService.AgreeApp(agreeId);
        UserInfo userInfo= (UserInfo) request.getSession().getAttribute("user");
        ArrayList<Circulate> arrayList=new ArrayList<>();
        arrayList.addAll(userService.selectBookByState(userInfo.getId(),"待审核").getData());
        arrayList.addAll(userService.selectBookByState(userInfo.getId(),"待审核归还").getData());
        model.addAttribute("data",arrayList);
        return "staff/circulate/circulateApp";
    }
    @RequestMapping(params = "returnId")
    public String returnBook(int returnId,HttpServletRequest request,Model model)
    {
        userService.updateReturn(returnId);
        UserInfo userInfo= (UserInfo) request.getSession().getAttribute("user");
        model.addAttribute("data",userService.selectBookCirInto(userInfo.getId()).getData());
        return "staff/circulate/circulateInto/index";
    }

    @RequestMapping(params = "returnAppId")
    public String returnApp(int returnAppId,HttpServletRequest request,Model model)
    {
        userService.agreeReturn(returnAppId);
        UserInfo userInfo= (UserInfo) request.getSession().getAttribute("user");
        ArrayList<Circulate> arrayList=new ArrayList<>();
        arrayList.addAll(userService.selectBookByState(userInfo.getId(),"待审核").getData());
        arrayList.addAll(userService.selectBookByState(userInfo.getId(),"待审核归还").getData());
        model.addAttribute("data",arrayList);
        return "staff/circulate/circulateApp";
    }

    @RequestMapping(params = "borrowId")
    public String borrowBook(int borrowId,HttpServletRequest request,Model model)
    {
        UserInfo userInfo= (UserInfo) request.getSession().getAttribute("user");
        userService.BorrowBook(borrowId,userInfo.getId());
        model.addAttribute("data",userService.selectAllBooks().getData());
        return "reader/index";
    }

    @RequestMapping(params = "returnBorrowId")
    public String returnBorrow(int returnBorrowId,HttpServletRequest request,Model model)
    {
        userService.returnBorrow(returnBorrowId);
        UserInfo userInfo= (UserInfo) request.getSession().getAttribute("user");
        model.addAttribute("data",userService.selectBorrowToReturn(userInfo.getId()).getData());
        return "reader/returnIndex";
    }

}
