package Mappers.wyl;

import org.apache.ibatis.annotations.*;
import Beans.potatob6.User;

import java.util.List;

/**
 * @author 星包客
 */
public interface UserDao {
    /**
     *
     *
     * @param userId
     * @return
     * 使用userId查询用户信息
     */
    @Select("select * from Users where userId = #{userId}")
    User queryByuserId(Integer userId);

    /**
     *
     * @param userName
     * @return
     * 使用userName查询用户信息
     */
    @Select("select * from Users where userName = #{userName}")
    User queryByuserName(String userName);
}