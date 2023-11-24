package book.service;

import book.dao.UseDao;
import book.entity.*;
import book.entity.Mapping.Borrow;
import book.entity.Mapping.Circulate;
import book.entity.Turple.*;
import book.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service("userService")
public class UserServiceImpl implements UserService
{
    @Autowired()
    private UseDao useDao;

    @Override
    public Result<Integer> getUserId(Account account)
    {
        return new Result<>(true, "", useDao.selectUserId(account));
    }

    /**
     * 登录界面
     *
     * @param account 用户登录的参数
     * @return 查询结果
     */
    @Override
    public Result<Role> login(Account account)
    {
        Role role = new Role();
        Account accountSelect = useDao.selectAccount(account);
        if (accountSelect == null)
        {
            return new Result<>(false, "用户信息错误");
        }
        role = useDao.selectRoleByName(account.getUserName());
        switch (role.getRoleName())
        {
            case "Admin" -> role = new Admin(role);
            case "staff" -> role = new Staff(role);
            case "reader" -> role = new Reader(role);
        }
        return new Result<Role>(true, "", role);
    }

    public UserInfo getUserInfo(Account account)
    {
        System.out.println(account.getId());
        System.out.println(useDao.selectUserInfoById(account.getId()));
        return useDao.selectUserInfoById(account.getId());
    }

    /**
     * 查询并注册用户
     */
    public boolean registerAccount(Account account)
    {
        if (useDao.selectAccount(account) != null)
        {
            return false;
        }
        return useDao.insertAccount(account) == 1;
    }

    /**
     * 注册
     *
     * @return -1 用户重复 0 必要信息为空 1 成功
     */
    @Override
    public Result<Boolean> register(Account account, String email)
    {
        if (!registerAccount(account))
        {
            return new Result<>(false, "用户已存在");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserInfoByAccount(account);
        userInfo.setEmail(email);
        if (useDao.insertUserInfo(userInfo) != 1)
        {
            return new Result<>(false, "未知错误");
        }
        Role role = new Reader();
        role.setSelf("reader");
        if (useDao.insertRole(role) != 1)
        {
            return new Result<>(false, "未知错误");
        }
        UserRoleMapping userRoleMapping=new UserRoleMapping();
        userRoleMapping.setId(account.getId());
        userRoleMapping.setRoleId(role.getRoleId());
        if(useDao.insertUserRoleMapping(userRoleMapping)!=1)
        {
            return new Result<>(false, "未知错误");
        }
        return new Result<>(true, "");
    }

    @Override
    public Result<Boolean> registerStaff(UserInfo userInfo, Account account, String role, String jobId)
    {
        if (!registerAccount(account))
        {
            return new Result<>(false, "用户已存在");
        }
        userInfo.setUserInfoByAccount(account);
        if (useDao.insertUserInfo(userInfo) != 1)
        {
            return new Result<>(false, "未知错误");
        }
        Staff staff = new Staff();
        staff.setSelf(jobId);
        if (useDao.insertRole(staff) != 1)
        {
            return new Result<>(false, "未知错误");
        }
        if (useDao.insertStaff(staff) != 1)
        {
            return new Result<>(false, "未知错误");
        }
        if (useDao.insertUserRoleMapping(new UserRoleMapping(account, staff)) != 1)
        {
            return new Result<>(false, "未知错误");
        }
        return new Result<>(true, "成功");
    }

    @Override
    public Result<ArrayList<Role>> getAllRoles()
    {
        return new Result<>(true, "", useDao.selectAllRole());
    }

    @Override
    public Result<ArrayList<UserInfo>> getAllUserInfo()
    {
        return new Result<>(true, "", useDao.selectAllUser());
    }

    private ArrayList<Role> getRolesByName(String name)
    {
        return useDao.selectRolesByName(name);
    }

    @Override
    public Result<ArrayList<WorkUnit>> getAllWorkUnit()
    {
        return new Result<>(true, "", useDao.selectAllWorkUnit());
    }

    @Override
    public Result<ArrayList<UserInfoAndRole>> getAllUserAndRoles()
    {
        ArrayList<UserInfoAndRole> userInfoAndRoles = new ArrayList<>();
        ArrayList<UserInfo> userInfos = getAllUserInfo().getData();
        System.out.println(11);
        for (UserInfo u : userInfos)
        {
            System.out.println("user" + " " + u.getUserName());
            ArrayList<Role> roles = useDao.selectRolesByName(u.getUserName());
            UserInfoAndRole userInfoAndRole = new UserInfoAndRole();
            userInfoAndRole.setUserInfo(u);
            if (roles != null && !roles.isEmpty())
            {
                System.out.println(roles.get(0));
                userInfoAndRole.setRoles(roles);
            }
            userInfoAndRoles.add(userInfoAndRole);
        }
        return new Result<>(true, "", userInfoAndRoles);
    }

    @Override
    public Result<Boolean> addWorkUnit(WorkUnit workUnit)
    {
        if (useDao.selectWorkUnitByUnitName(workUnit.getUnitName()) != null)
        {
            return new Result<>(false, "单位名称重复");
        }
        if (useDao.insertWork(workUnit) != 1)
        {
            return new Result<>(false, "未知错误");
        }
        return new Result<>(true, "");
    }

    @Override
    public Result<BookInfo> selectBookByName(String bookName)
    {
        return new Result<BookInfo>(true, "", useDao.selectBookInfoByName(bookName));
    }

    @Override
    public Result<BookInfo> selectBookById(int id)
    {
        return new Result<BookInfo>(true, "", useDao.selectBookInfoById(id));
    }

    @Override
    public Result<ArrayList<BookInfo>> selectBookFilter(String filterTxt)
    {
        return new Result<ArrayList<BookInfo>>(true, "", useDao.selectBookThroughFilter(filterTxt));
    }

    @Override
    public Result<BookInfo> updateBookInfoById(BookInfo bookInfo)
    {
        if (useDao.updateBookInfoById(bookInfo) != 1)
        {
            return new Result<>(false, "未知错误", new BookInfo());
        }
        return new Result<>(true, "", useDao.selectBookInfoById(bookInfo.getId()));
    }

    @Override
    public Result<Boolean> addBookInfo(BookInfo bookInfo)
    {
        bookInfo.setCreateTime(new Date());
        if (useDao.selectUnitById(bookInfo.getUnitId()) == null)
        {
            return new Result<>(false, "单位不存在!");
        }
        if (useDao.selectBookInfoByName(bookInfo.getBookName()) != null)
        {
            return new Result<>(false, "书名重复");
        }
        if (useDao.insertBookInfo(bookInfo) != 1)
        {
            return new Result<>(false, "未知错误");
        }
        return new Result<>(true, "");
    }

    @Override
    public Result<UserInfo> selectUserInfo(int id)
    {
        return new Result<>(true, "", useDao.selectUserInfoById(id));
    }

    @Override
    public Result<ArrayList<BookInfo>> selectAllBooks()
    {
        return new Result<>(true, "", useDao.selectAllBookInfo());
    }

    @Override
    public Result<UserInfo> updateUserInfoById(UserInfo userInfo)
    {
        useDao.updateUserInfoById(userInfo);
        return new Result<>(true, "", userInfo);
    }

    @Override
    public Result<Boolean> insertCirculate(Circulate circulate)
    {
        circulate.setCirculateTime(new Date());
        if (useDao.updateBookCirculateStateById(new IdCirState(circulate.getBookId(),"待审核"))!=1)
        {
            System.out.println(1);
            return new Result<>(false, "图书正在流通中");
        }
        if (useDao.insertCirculate(circulate) != 1)
        {
            System.out.println(2);
            return new Result<>(false, "未知错误");
        }
        return new Result<>(true, "");
    }

    @Override
    public Result<ArrayList<BookInfo>> selectBookWait(int userId)
    {
        int unitId = useDao.selectUnitIdByUserId(userId);
        UnitIdAndCirculateState u = new UnitIdAndCirculateState();
        u.setState("待审核");
        u.setUnitId(unitId);
        return new Result<>(true, "", useDao.selectAllBookInfoByStateAndUnitId(u));
    }

    @Override
    public Result<ArrayList<Circulate>> selectBookByState(int userId,String state)
    {
        int unitId = useDao.selectUnitIdByUserId(userId);
        ArrayList<Circulate> circulates = useDao.selectCirculateByUnitIdState(new UnitIdCirState(unitId,state));
        return new Result<>(true, "", circulates);
    }
    @Override
    public Result<Boolean> AgreeApp(int id)
    {
        Circulate circulate=useDao.selectCirculateById(id);
        if(useDao.updateBookCirculateStateById(new IdCirState(circulate.getBookId(),"正在流通中"))!=1)
        {
            return new Result<>(false,"未知错误");
        }
        if(useDao.updateCirculateAppAgreeById(id)!=1)
        {
            return new Result<>(false,"未知错误");
        }
        return new Result<>(true,"");
    }
    @Override
    public Result<ArrayList<Circulate>> selectBookCirInto(int id)
    {
        int unitId = useDao.selectUnitIdByUserId(id);
        System.out.println("unitId "+unitId);
        ArrayList<Circulate> circulates=new ArrayList<>();
        circulates.addAll(useDao.selectBookFromCirByUnitIdState(new UnitIdCirState(unitId,"正在流通中")));
        circulates.addAll(useDao.selectBookFromCirByUnitIdState(new UnitIdCirState(unitId,"待审核归还")));
        return new Result<>(true,"",circulates);
    }
    @Override
    public Result<Boolean> updateReturn(int id)
    {
        if(useDao.updateCirStateById(new IdCirState(id,"待审核归还"))!=1)
        {
            return new Result<>(false,"未知错误");
        }
        return new Result<>(true,"");
    }
    @Override
    public Result<Boolean> agreeReturn(int id)
    {
        Circulate circulate=useDao.selectCirculateById(id);
        System.out.println("cirId "+id);
        System.out.println("bookId "+circulate.getBookId());
        if(useDao.updateCirStateById(new IdCirState(id,"已结束"))!=1)
        {
            return new Result<>(false,"");
        }
        if(useDao.updateBookCirculateStateById(new IdCirState(circulate.getBookId(),"未流通"))!=1)
        {
            return new Result<>(false,"");
        }
        IdDate idDate=new IdDate();
        idDate.setId(id);
        idDate.setDate(new Date());
        useDao.updateCirTimeById(idDate);
        return new Result<>(true,"");
    }
    @Override
    public Result<Integer> NumOfBook(int unitId)
    {
        return new Result<>(true,"",useDao.selectNumBookByUnitId(unitId));
    }
    @Override
    public Result<Integer> returnUnitId(int userId)
    {
        return new Result<>(true,"",useDao.selectUnitByUserId(userId));
    }
    @Override
    public Result<Nums> resultNums(int unitId)
    {
        Nums nums=new Nums();
        nums.setAllNum(useDao.selectNumBookByUnitId(unitId));
        nums.setAliveNum(useDao.selectNumCirByUnitId(unitId));
        nums.setBorrowNum(useDao.selectNumRoleByUnitId(unitId));
        nums.setCirNum(useDao.selectNumBorByUnitId(unitId));
        return new Result<>(true,"",nums);
    }
    @Override
    public Result<Boolean> BorrowBook(int id,int userId)
    {
        useDao.updateBookBStateById(new IdCirState(id,"未归还"));
        Borrow borrow=new Borrow();
        borrow.setBorrowTime(new Date());
        borrow.setUserId(userId);
        borrow.setBookId(id);
        borrow.setState("未归还");
        useDao.insertBorrow(borrow);
        return new Result<>(true,"false");
    }

    @Override
    public Result<ArrayList<Borrow>> selectBorrowToReturn(int userId)
    {
        return new Result<>(true,"",useDao.selectBorrowBookByUserId(userId));
    }
    @Override
    public Result<Boolean>returnBorrow(int id)
    {
        useDao.updateBorrowStateById(new IdCirState(id,"已归还"));
        Borrow borrow=useDao.selectBorrowStateById(id);
        useDao.updateBookBStateById(new IdCirState(borrow.getBookId() ,"未借阅"));
        IdDate idDate=new IdDate();
        idDate.setId(id);
        idDate.setDate(new Date());
        useDao.updateBorrowTimeById(idDate);
        return new Result<>(true,"");
    }

}
