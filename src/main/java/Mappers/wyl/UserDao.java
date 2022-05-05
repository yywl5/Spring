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
     *使用userId查询用户信息
     * @param userId
     * @return
     *
     */
    @Select("select * from Users where userId = #{userId}")
    User queryByuserId(Integer userId);

    /**
     *使用userName查询用户信息
     * @param userName
     * @return
     *
     */
    @Select("select * from Users where userName = #{userName}")
    User queryByuserName(String userName);
    /***
     *
     * 更新账户
     * @param user
     */

    @Update("update Users set userName = #{userName}, userPassword = #{userPassword},userLogin = #{userLogin} where userId = #{userId}")
    void update(User user);

    /****
     *
     * @param userName
     */
    @Delete("delete from Users where userName = #{userName}")
    void deleteByuserName(String userName);

    /***
     * 用户userId删除
     * @param userId
     */
    @Delete("delete from Users where userId = #{userId}")
    void deleteById(Integer userId);

    /**
     *
     *使用userId查询用户信息
     * @param userLogin
     * @return
     *
     */
    @Select("select * from Users where userLogin = #{userLogin}")
    User queryByuserLogin(String userLogin);

    /***
     * 添加用户
     * @param user
     */
    @Insert("insert into Users values(null,#{userLogin},#{userName},#{userPassword})")
    @Options(useGeneratedKeys=true,keyProperty="userId", keyColumn="userId")

    void insert(User user);
}