package book.entity;

import java.util.Date;

public class Staff extends Role
{

    private String jobId;
    public Staff()
    {

    }
    public Staff(Role role)
    {
        this.setRoleName(role.getRoleName());
        this.setState(role.getState());
        this.setOther(role.getOther());
        this.setCreateTime(role.getCreateTime());
        this.setRoleId(role.getRoleId());
    }
    @Override
    public void setSelf(String jobId)
    {
        super.setSelf("staff");
        setJobId(jobId);
    }

    public String getJobId()
    {
        return jobId;
    }

    public void setJobId(String jobId)
    {
        this.jobId = jobId;
    }
}
