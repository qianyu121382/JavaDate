package book.entity.Turple;

public class IdCirState
{
    private int id;
    private String state;

    public IdCirState()
    {
    }

    public IdCirState(int id, String state)
    {
        this.id = id;
        this.state = state;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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
