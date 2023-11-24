package book.controller;

import book.entity.BookInfo;
import book.entity.Mapping.Circulate;
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
    @RequestMapping(params = "method=index")
    public String skipIndex(Model model)
    {
        model.addAttribute("data",userService.selectAllBooks().getData());
        return "Admin/Book/showIndex";
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
    @RequestMapping(params = "method=waitReview")
    public String skipWaitReview(Model model,HttpServletRequest request)
    {
        UserInfo userInfo= (UserInfo) request.getSession().getAttribute("user");
        Result<ArrayList<BookInfo>> result=userService.selectBookWait(userInfo.getId());
        model.addAttribute("data",result.getData());
        return "staff/circulate/waitReview";
    }
    @RequestMapping(params = "circulateId")
    public String skipCirculate(int circulateId,Model model)
    {
        model.addAttribute("data",userService.selectBookById(circulateId).getData());
        return "staff/circulate/circulateFather";
    }
    @RequestMapping(params = "method=static")
    public String skipSta(Model model,HttpServletRequest request)
    {
        UserInfo userInfo= (UserInfo) request.getSession().getAttribute("user");
        int unitId= userService.returnUnitId(userInfo.getId()).getData();
        model.addAttribute("data",userService.resultNums(unitId).getData());
        return "staff/statistics/index";
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
    @RequestMapping(params = "method=app")
    public String skipApp(Model model,HttpServletRequest request)
    {
        UserInfo userInfo= (UserInfo) request.getSession().getAttribute("user");
        ArrayList<Circulate> arrayList=new ArrayList<>();
        arrayList.addAll(userService.selectBookByState(userInfo.getId(),"待审核").getData());
        arrayList.addAll(userService.selectBookByState(userInfo.getId(),"待审核归还").getData());
        model.addAttribute("data",arrayList);
        return "staff/circulate/circulateApp";
    }
    @RequestMapping(params = "method=circulating")
    public String skipCir(Model model,HttpServletRequest request)
    {
        UserInfo userInfo= (UserInfo) request.getSession().getAttribute("user");
        model.addAttribute("data",userService.selectBookByState(userInfo.getId(),"正在流通中").getData());
        return "staff/circulate/circulating/index";
    }
    @RequestMapping(params = "method=into")
    public String skipInto(Model model,HttpServletRequest request)
    {
        UserInfo userInfo= (UserInfo) request.getSession().getAttribute("user");
        model.addAttribute("data",userService.selectBookCirInto(userInfo.getId()).getData());
        return "staff/circulate/circulateInto/index";
    }
    @RequestMapping(params = "method=endCir")
    public String skipEndCir(Model model,HttpServletRequest request)
    {
        UserInfo userInfo= (UserInfo) request.getSession().getAttribute("user");
        model.addAttribute("data",userService.selectBookByState(userInfo.getId(), "已结束").getData());
        return "staff/circulate/end/index";
    }

    @RequestMapping(params = "method=readerShow")
    public String skipBookShowReader(Model model)
    {
        model.addAttribute("data",userService.selectAllBooks().getData());
        return "reader/index";
    }

    @RequestMapping(params = "method=returnBorrow")
    public String skipReturnBorrow(Model model,HttpServletRequest request)
    {
        UserInfo userInfo= (UserInfo) request.getSession().getAttribute("user");
        model.addAttribute("data",userService.selectBorrowToReturn(userInfo.getId()).getData());
        return "reader/returnIndex";
    }


}
