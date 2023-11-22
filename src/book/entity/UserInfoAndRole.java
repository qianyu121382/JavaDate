package book.entity;

import java.util.ArrayList;

public class UserInfoAndRole
{
    UserInfo userInfo;
    ArrayList<Role>roles;

    public UserInfo getUserInfo()
    {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo)
    {
        this.userInfo = userInfo;
    }

    public ArrayList<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(ArrayList<Role> roles)
    {
        this.roles = roles;
    }
}
