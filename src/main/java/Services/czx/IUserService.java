package Services.czx;

import Beans.czx.IUser;

import java.util.List;

public interface IUserService {
    public List<IUser> findUserList(String keywords, Integer userListRoleId);

    /**
     *
     * @param loginName
     * @param password
     * @return
     */
    public IUser findUser(String loginName,String password);

    /**
     *
     * @param userId
     * @return
     */
    public IUser getUserByUserId(Integer userId);

    /**
     *
     * @param loginName
     * @return
     */
    public IUser getUserByLoginName(String loginName);

    /**
     *
     * @param user
     * @return
     */
    public int editUser(IUser user);

    /**
     *
     * @param user
     * @return
     */
    public int addUser(IUser user);

    /**
     *
     * @param userId
     * @return
     */
    public int delUser(Integer userId);

    /**
     *
     * @param user
     * @return
     */
    public int setUserStatus(IUser user);
}
