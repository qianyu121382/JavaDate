package book.entity;

public class UserRoleMapping
{
    private int id;
    private int roleId;

    public UserRoleMapping()
    {
    }
    public UserRoleMapping(Account account,Role role)
    {
        id=account.getId();
        roleId=role.getRoleId();
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getRoleId()
    {
        return roleId;
    }

    public void setRoleId(int roleId)
    {
        this.roleId = roleId;
    }
}
