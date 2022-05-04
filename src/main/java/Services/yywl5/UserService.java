package Services.yywl5;

import Beans.potatob6.User;

import java.util.List;

/**
 * @author 星包客
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(Integer userId);

    /**
     * 通过phone查询单条数据
     *
     * @param userName
     * @return 实例对象
     */
    User queryByuserName(String userName);
    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userName 主键
     * @return 是否成功
     */
    void deleteByuserName(String userName);
    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    void deleteById(Integer userId);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);
}
