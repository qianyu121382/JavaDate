package book.entity;

import java.util.Objects;

public class Account
{
    private String userName;
    private String password;
    private int id;

    public int getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "userBean{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account Account = (Account) o;
        return Objects.equals(userName, Account.userName) && Objects.equals(password, Account.password);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(userName, password);
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
