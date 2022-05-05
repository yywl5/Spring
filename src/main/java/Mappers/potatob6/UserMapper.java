package Mappers.potatob6;

import Beans.potatob6.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PBAdminUserDAO")
public interface UserMapper {

    // 从特定Id查用户
    User getUserById(@Param("userId") Integer userId);

    // 查询指定页数的用户列表
    List<User> getPageOfUser(@Param("startIndex") Integer startIndex, @Param("pageCount") Integer pageCount);

    // 编辑图书
    Integer editUser(User user);

    // 删除用户
    Integer deleteUser(@Param("userId") Integer userId);

    // 添加图书
    Integer addUser(User user) throws Exception;

    // 查询图书
    List<User> searchUser(@Param("words") String words);
}
