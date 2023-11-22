package book.entity;

import java.util.Date;

public class UserInfo
{
    private int id;
    private String userName;
    private String realName;
    private String iphone;
    private String email;
    private String place;
    private boolean isRegister;
    private Date createTime;
    private String sex;
    private String image;
    private String state;
    private Date lastTime;
    public void setUserInfoByAccount(Account account)
    {
        setCreateTime(new Date());
        setId(account.getId());
        setUserName(account.getUserName());
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getRealName()
    {
        return realName;
    }

    public void setRealName(String realName)
    {
        this.realName = realName;
    }

    public String getIphone()
    {
        return iphone;
    }

    public void setIphone(String iphone)
    {
        this.iphone = iphone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPlace()
    {
        return place;
    }

    public void setPlace(String place)
    {
        this.place = place;
    }

    public boolean isRegister()
    {
        return isRegister;
    }

    public void setRegister(boolean register)
    {
        isRegister = register;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public Date getLastTime()
    {
        return lastTime;
    }

    public void setLastTime(Date lastTime)
    {
        this.lastTime = lastTime;
    }
    @Override
    public String toString()
    {
        return "account{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", iphone='" + iphone + '\'' +
                ", email='" + email + '\'' +
                ", place='" + place + '\'' +
                ", isRegister=" + isRegister +
                ", createTime=" + createTime +
                ", sex='" + sex + '\'' +
                ", image='" + image + '\'' +
                ", state='" + state + '\'' +
                ", lastTime=" + lastTime +
                '}';
    }
}
