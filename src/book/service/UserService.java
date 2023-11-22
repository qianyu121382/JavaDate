package book.service;

import book.entity.*;
import book.util.Result;

import java.util.ArrayList;


public interface UserService
{
    public Result<Role> login(Account account);
    public Result<Boolean> register(Account account, String email);
    public UserInfo getUserInfo(Account account);
    public Result<Boolean> registerStaff(UserInfo UserInfo, Account account, String role, String jobId);
    public Result<ArrayList<Role>> getAllRoles();
    public Result<ArrayList<WorkUnit>> getAllWorkUnit();

    Result<ArrayList<UserInfo>> getAllUserInfo();
    public Result<ArrayList<UserInfoAndRole>> getAllUserAndRoles();
    public Result<Boolean> addWorkUnit(WorkUnit workUnit);
    public Result<ArrayList<BookInfo>>selectAllBooks();
    public Result<Boolean>addBookInfo(BookInfo bookInfo);
    public Result<BookInfo>selectBookByName(String bookName);
    public Result<ArrayList<BookInfo>>selectBookFilter(String filterTxt);
    public Result<BookInfo>updateBookInfoById(BookInfo bookInfo);
    public Result<BookInfo>selectBookById(int id);
    public Result<UserInfo>updateUserInfoById(UserInfo userInfo);
    public Result<UserInfo>selectUserInfo(int id);
    public Result<Integer>getUserId(Account account);
}
