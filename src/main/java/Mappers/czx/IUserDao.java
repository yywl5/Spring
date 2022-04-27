package Mappers.czx;

import Beans.czx.IUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserDao {
    /***
     *
     * @param keywords
     * @param userListRoleId
     * @return
     */
    public List<IUser> selectUserList(@Param("keywords")String keywords, @Param("userListRoleId") Integer userListRoleId);
    public IUser findUser(@Param("loginName")String loginName,@Param("password")String password);
    public IUser getUserByLoginName(String loginName);
    public int addUser(IUser user);
    public int updateUser(IUser user);
    public int delUser(Integer userId);
    public int setUserStatus(IUser user);
    public IUser getUserByUserId(Integer userId);
}
