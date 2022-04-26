package Mappers.czx;

import Beans.czx.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    /***
     *
     * @param keywords
     * @param userListRoleId
     * @return
     */
    public List<User> selectUserList(@Param("keywords")String keywords, @Param("userListRoleId") Integer userListRoleId);
    public User findUser(@Param("loginName")String loginName,@Param("password")String password);
    public User getUserByLoginName(String loginName);
    public int addUser(User user);
    public int updateUser(User user);
    public int delUser(Integer userId);
    public int setUserStatus(User user);
    public User getUserByUserId(Integer userId);
}
