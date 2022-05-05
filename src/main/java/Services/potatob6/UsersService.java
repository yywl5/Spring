package Services.potatob6;

import Beans.potatob6.User;
import Mappers.potatob6.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PBAdminUserService")
public class UsersService {
    @Autowired
    @Qualifier("PBAdminUserDAO")
    private UserMapper userMapper;

    private static Integer numberOfPages = 20;

    // 查询一页用户
    public List<User> getPageOfUser(Integer page) {
        return userMapper.getPageOfUser(numberOfPages*(page-1), numberOfPages);
    }

    // 编辑用户
    public Integer editUser(String _userId, String _userLogin, String _userName,
                            String _userPassword) throws Exception {
        Integer userId = Integer.parseInt(_userId);

        User user = new User(userId, _userLogin, _userName, _userPassword);
        return userMapper.editUser(user);
    }

    // 删除用户
    public Integer deleteUser(Integer userId) {
        return userMapper.deleteUser(userId);
    }

    // 添加用户
    public Integer addUser(User user) {
        try {
            return userMapper.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    // 查询用户
    public List<User> searchUser(String words) {
        return userMapper.searchUser(words);
    }
}
