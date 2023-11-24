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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
    @RequestMapping(params = "method=batch")
    public String batch() throws IOException
    {
        String pythonScriptPath = "D:\\MyCode\\Python\\SQL_experiment2\\mysql.py"; // 请替换为您的Python脚本路径
        try {
            // 创建并启动一个进程，执行Python脚本
            Process process = Runtime.getRuntime().exec("python " + pythonScriptPath);
            // 获取进程的标准输出
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            // 获取进程的标准错误
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            // 读取并打印标准输出的内容
            String s = null;
            System.out.println("标准输出:");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
            // 读取并打印标准错误的内容
            System.out.println("标准错误:");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
            // 等待进程执行完成，并获取退出状态
            int exitCode = process.waitFor();
            System.out.println("退出状态: " + exitCode);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Admin/indexAddUser";
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
