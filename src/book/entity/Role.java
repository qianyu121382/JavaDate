package book.entity;

import java.util.Date;

public class Role
{
    private int roleId;
    private String roleName;
    private Date createTime;
    private String state;
    private String other;
    public void setSelf(String roleName)
    {
        setRoleName(roleName);
        setState("1");
        setCreateTime(new Date());
        setOther("");
    }
    public int getRoleId()
    {
        return roleId;
    }

    public void setRoleId(int roleId)
    {
        this.roleId = roleId;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public String getOther()
    {
        return other;
    }

    public void setOther(String other)
    {
        this.other = other;
    }

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }


    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }
}
