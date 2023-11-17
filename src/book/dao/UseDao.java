package book.dao;
import book.entity.user;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("user")
@Mapper
public interface UseDao
{
    user selectUserByName(String userName);
}
