package book.entity.Mapping;

import java.util.Date;

public class Borrow
{
    private int id;
    private int bookId;
    private int unitId;
    private int userId;
    private Date borrowTime;
    private Date returnTime;
    private String state;
    private String other;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getBookId()
    {
        return bookId;
    }

    public void setBookId(int bookId)
    {
        this.bookId = bookId;
    }

    public int getUnitId()
    {
        return unitId;
    }

    public void setUnitId(int unitId)
    {
        this.unitId = unitId;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public Date getBorrowTime()
    {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime)
    {
        this.borrowTime = borrowTime;
    }

    public Date getReturnTime()
    {
        return returnTime;
    }

    public void setReturnTime(Date returnTime)
    {
        this.returnTime = returnTime;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getOther()
    {
        return other;
    }

    public void setOther(String other)
    {
        this.other = other;
    }
}
