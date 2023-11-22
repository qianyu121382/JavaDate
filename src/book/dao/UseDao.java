package book.dao;

import book.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository()
@Mapper
public interface UseDao
{
    /**
     * 查询账号密码
     */
    Account selectAccount(Account account);

    /**
     * 查询账号
     */
    Account selectAccountByName(String userName);
    /**
     * 查询角色
     */
    Role selectRoleByName(String userName);
    WorkUnit selectWorkUnitByUnitName(String name);
    ArrayList<Role> selectRolesByName(String userName);
    int insertWork(WorkUnit workUnit);
    int insertAccount(Account account);
    int insertUserInfo(UserInfo userInfo);
    int insertUserRoleMapping(UserRoleMapping userRoleMapping);
    int insertStaff(Staff staff);
    int insertRole(Role role);
    int updateBookInfoById(BookInfo bookInfo);
    int insertBookInfo(BookInfo bookInfo);
    WorkUnit selectUnitById(int id);
    ArrayList<BookInfo> selectBookThroughFilter(String filterTxt);
    BookInfo selectBookInfoByName(String bookName);
    ArrayList<Role> selectAllRole();
    BookInfo selectBookInfoById(int id);
    ArrayList<UserInfo> selectAllUser();
    ArrayList<WorkUnit> selectAllWorkUnit();
    ArrayList<BookInfo> selectAllBookInfo();
    int updateUserInfoById(UserInfo userInfo);
    UserInfo selectUserInfoById(int id);
    int selectUserId(Account account);

}
