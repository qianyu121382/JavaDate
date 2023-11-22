package book.entity;

public class Reader extends Role
{
    public Reader()
    {

    }
    public Reader(Role role)
    {
        this.setRoleName(role.getRoleName());
        this.setState(role.getState());
        this.setOther(role.getOther());
        this.setCreateTime(role.getCreateTime());
        this.setRoleId(role.getRoleId());
    }
}
