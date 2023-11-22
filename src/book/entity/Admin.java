package book.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


public class Admin extends Role
{
    public Admin(Role role)
    {
        this.setRoleName(role.getRoleName());
        this.setState(role.getState());
        this.setOther(role.getOther());
        this.setCreateTime(role.getCreateTime());
        this.setRoleId(role.getRoleId());
    }

}
