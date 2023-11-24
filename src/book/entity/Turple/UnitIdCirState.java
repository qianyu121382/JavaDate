package book.entity.Turple;

public class UnitIdCirState
{
    private int unitId;
    private String state;

    public UnitIdCirState()
    {
    }

    public UnitIdCirState(int unitId, String state)
    {
        this.unitId = unitId;
        this.state = state;
    }

    public int getUnitId()
    {
        return unitId;
    }

    public void setUnitId(int unitId)
    {
        this.unitId = unitId;
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
