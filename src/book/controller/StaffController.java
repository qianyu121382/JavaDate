package book.controller;

import book.entity.BookInfo;
import book.service.UserService;
import book.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@Controller
@RequestMapping("/staff.do")
public class StaffController
{
    @Autowired()
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping(params = "method=book1")
    public String addBook(BookInfo info, MultipartFile file, HttpServletResponse response) throws IOException
    {
        String filename = null;
        //定义文件保存的本地路径
        String localPath = "D:\\MyCode\\JavaWeb\\Homework\\web\\bookImage\\";
        // 保存数据库的路径名称，即数据库中的image列
        String sqlPath = null;
        /*
         * 获取前台传过来的file值，如果不为空，则执行该if里面的代码
         * 需要注意的是：这里我将MultipartFile即file属性定义在了商品的实体类中。
         */
        if (!file.isEmpty())
        {
            //用uuid随机生成一个文件裸名
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType = file.getContentType();
            //获得文件后缀名
            String suffixName = contentType.substring(contentType.indexOf("/") + 1);
            //得到文件名（文件名由文件裸名与后缀名组合而成）
            filename = uuid + "." + suffixName;
            //获取商品实体类中的file属性赋值，而file属性是MultipartFile类型的，将前台上传的该图片保存至该本地路径的文件夹中
            file.transferTo(new File(localPath + filename));
        }
        //把图片的相对路径保存至数据库
        sqlPath = localPath + filename;
        info.setPath(sqlPath); //设置商品实体类中的image属性的值
        System.out.println(info.getUnitId());
        Result<Boolean> result = userService.addBookInfo(info);
        if (result.isSuccess())

        {
            return "staff/Book/AddBook";
        }
        System.out.println(result.getMessage());
        return "";
    }
}
