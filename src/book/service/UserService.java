package book.service;

import book.entity.*;
import book.entity.Mapping.Borrow;
import book.entity.Mapping.Circulate;
import book.entity.Turple.Nums;
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
    public Result<Boolean>insertCirculate(Circulate circulate);
    public Result<ArrayList<BookInfo>> selectBookWait(int unitId);
    public Result<ArrayList<Circulate>> selectBookByState(int userId,String state);
    public Result<Boolean> AgreeApp(int id);
    public Result<ArrayList<Circulate>> selectBookCirInto(int id);
    public Result<Boolean> updateReturn(int id);
    public Result<Boolean> agreeReturn(int id);
    public Result<Boolean> BorrowBook(int id,int userId);
    public Result<ArrayList<Borrow>> selectBorrowToReturn(int userId);
    public Result<Boolean>returnBorrow(int id);
    public Result<Integer> NumOfBook(int unitId);
    public Result<Integer> returnUnitId(int userId);
    public Result<Nums> resultNums(int unitId);

}
