package book.dao;

import book.entity.*;
import book.entity.Mapping.Borrow;
import book.entity.Mapping.Circulate;
import book.entity.Turple.IdCirState;
import book.entity.Turple.IdDate;
import book.entity.Turple.UnitIdAndCirculateState;
import book.entity.Turple.UnitIdCirState;
import book.util.Result;
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
    int insertCirculate(Circulate circulate);
    int updateBookCirculateStateById(IdCirState idCirState);
    ArrayList<BookInfo> selectAllBookInfoByStateAndUnitId(UnitIdAndCirculateState unitIdAndCirculateState);
    int selectUnitIdByUserId(int id);
    ArrayList<BookInfo> selectAppBookByUnitId(int unitId);
    int selectAppUnitIdByUnitId(int unitId);
    ArrayList<UserInfo> selectUserInfoByUnitId(int unitId);
    ArrayList<Circulate> selectCirculateByUnitIdState(UnitIdCirState unitIdCirState);

    int updateCirculateAppAgreeById(int id);
    BookInfo selectBookByCirId(int id);
    Circulate selectCirculateById(int id);
    ArrayList<Circulate> selectBookFromCirByUnitIdState(UnitIdCirState unitIdCirState);
    int updateCirStateById(IdCirState idCirState);
    int insertBorrow(Borrow borrow);
    int updateBorrowStateById(IdCirState idCirState);
    int updateBookBStateById(IdCirState idCirState);
    ArrayList<Borrow> selectBorrowBookByUserId(int userId);
    Borrow selectBorrowByBookId(int bookId);
    Borrow selectBorrowStateById(int id);
    int updateBorrowTimeById(IdDate idDate);
    int updateCirTimeById(IdDate idDate);
    int selectNumBookByUnitId(int unitId);
    int selectUnitByUserId(int userId);
    int selectNumRoleByUnitId(int unitId);
    int selectNumBorByUnitId(int unitId);
    int selectNumCirByUnitId(int unitId);
}
