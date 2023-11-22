package book.controller;

import book.entity.UserInfo;
import book.entity.Account;
import book.service.UserService;
import book.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/Admin.do")
public class AdminController
{
    @Autowired()
    @Qualifier("userService")
    private UserService userService;
    @RequestMapping(params = "method=addUser")
    public String addUser(UserInfo userInfo, Account account, String role, String jobId, Model model)
    {
        Result<Boolean> result=userService.registerStaff(userInfo,account,role,jobId);
        if(result.isSuccess())
        {
            return "Admin/indexAddUser";
        };
        model.addAttribute("error",result.getMessage());
        return "Admin/indexAddUserError";
    }
    @RequestMapping(params = "method=alterUser")
    public String alterUser(UserInfo userInfo, HttpServletRequest request)
    {
        UserInfo userInfo1= (UserInfo) request.getSession().getAttribute("user");
        userInfo.setId(userInfo1.getId());
        Result<UserInfo> result=userService.updateUserInfoById(userInfo);
        request.getSession().setAttribute("user",userService.selectUserInfo(userInfo1.getId()).getData());
        return "All/PersonalCenter";
    }
}
