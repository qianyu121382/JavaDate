package book.entity.Mapping;

import java.util.Date;

public class circulate
{
    private int id;
    private int bookId;
    private int unitId;
    private int userId;
    private Date circulateTime;
    private Date returnTime;
    private String circulateReason;
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

    public Date getCirculateTime()
    {
        return circulateTime;
    }

    public void setCirculateTime(Date circulateTime)
    {
        this.circulateTime = circulateTime;
    }

    public Date getReturnTime()
    {
        return returnTime;
    }

    public void setReturnTime(Date returnTime)
    {
        this.returnTime = returnTime;
    }

    public String getCirculateReason()
    {
        return circulateReason;
    }

    public void setCirculateReason(String circulateReason)
    {
        this.circulateReason = circulateReason;
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
