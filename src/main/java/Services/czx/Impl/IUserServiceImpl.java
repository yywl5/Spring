package Services.czx.Impl;

import Beans.czx.IUser;
import Mappers.czx.IUserDao;
import Services.czx.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("IuserService")
/*
 * 用户Service接口实现类
 */
public class IUserServiceImpl implements IUserService {
    //注入UserDao
    @Autowired
    private IUserDao userDao;
    @Override
    public List<IUser> findUserList(String keywords, Integer userListRoleId) {
        List<IUser> userList=this.userDao.selectUserList(keywords,userListRoleId);
        return userList;
    }
    @Override
    public IUser findUser(String loginName, String password) {
        IUser user=this.userDao.findUser(loginName, password);
        return user;
    }
    @Override
    public IUser getUserByUserId(Integer userId) {
        return this.userDao.getUserByUserId(userId);
    }
    @Override
    public IUser getUserByLoginName(String loginName) {
        return this.userDao.getUserByLoginName(loginName);
    }
    @Override
    public int addUser(IUser user) {
        return userDao.addUser(user);
    }
    @Override
    public int editUser(IUser user) {
        return this.userDao.updateUser(user);
    }
    @Override
    public int delUser(Integer userId) {
        return userDao.delUser(userId);
    }
    @Override
    public int setUserStatus(IUser user) {
        return userDao.setUserStatus(user);
    }
}