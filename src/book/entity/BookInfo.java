package book.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BookInfo
{
    private int id=0;
    private String bookName;
    private Date createTime=new Date();
    private String author;
    private String publish;
    private String kind;
    private int pageNum;
    private float price;
    private int unitId;
    private String path;
    private String borrowState="未借出";
    private String circulateState="未流通";
    private String permission="允许";
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getBookName()
    {
        return bookName;
    }

    public void setBookName(String bookName)
    {
        this.bookName = bookName;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getPublish()
    {
        return publish;
    }

    public void setPublish(String publish)
    {
        this.publish = publish;
    }

    public String getKind()
    {
        return kind;
    }

    public void setKind(String kind)
    {
        this.kind = kind;
    }

    public int getPageNum()
    {
        return pageNum;
    }

    public void setPageNum(int pageNum)
    {
        this.pageNum = pageNum;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public int getUnitId()
    {
        return unitId;
    }

    public void setUnitId(int unitId)
    {
        this.unitId = unitId;
    }

    public String getBorrowState()
    {
        return borrowState;
    }

    public void setBorrowState(String borrowState)
    {
        this.borrowState = borrowState;
    }

    public String getCirculateState()
    {
        return circulateState;
    }

    public void setCirculateState(String circulateState)
    {
        this.circulateState = circulateState;
    }
}
