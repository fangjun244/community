package life.majiang.community.mapper;


import life.majiang.community.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    void insertUser(User user);


    User findByToken(String token);

    User findByAccountid(Integer id);
}
