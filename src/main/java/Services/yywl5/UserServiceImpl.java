package Services.yywl5;

import Beans.potatob6.User;
import Mappers.wyl.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;
    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer userId) {
        return this.userDao.queryByuserId(userId);
    }

    /**
     * 通过phone查询单条数据
     *
     * @param userName
     * @return 实例对象
     */
    @Override
    public User queryByuserName(String userName) {
        return this.userDao.queryByuserName(userName);
    }
}
