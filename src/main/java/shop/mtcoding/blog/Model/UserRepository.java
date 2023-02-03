package shop.mtcoding.blog.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository {

    public int insertUser(@Param("username") String username, @Param("password") String password,
            @Param("email") String email);

    public List<User> findAllUser();

    public int updateUser(@Param("id") int id, @Param("password") String password);

    public int deleteUser(int id);

    public User login(@Param("username") String username, @Param("password") String password);

}
