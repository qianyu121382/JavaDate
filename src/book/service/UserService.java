package book.service;

import book.dao.UseDao;
import book.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired()
    private UseDao useDao;

    /**
     * 登录界面
     * @param user 用户登录的参数
     * @return 查询结果
     */
    public boolean login(user user)
    {
        user userSelect = useDao.selectUserByName(user.getUserName());
        return userSelect.equals(user);
    }


}
