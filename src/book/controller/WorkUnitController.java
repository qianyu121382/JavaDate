package book.controller;

import book.entity.WorkUnit;
import book.service.UserService;
import book.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/workUnit.do")
public class WorkUnitController
{
    @Autowired()
    @Qualifier("userService")
    private UserService userService;
    @RequestMapping(params = "method=addWorkUnit")
    public String addWorkUnit(WorkUnit workUnit, Model model)
    {
        Result<Boolean>result= userService.addWorkUnit(workUnit);
        if(result.isSuccess())
        {
            return "Admin/workUnit";
        }
        model.addAttribute("error",result.getMessage());
        return "Admin/workUnitError";
    }
}
