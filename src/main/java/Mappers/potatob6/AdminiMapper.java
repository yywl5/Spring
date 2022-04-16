package Mappers.potatob6;

import Beans.potatob6.Administrator;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminiMapper {

    //获取所有的管理员
    List<Administrator> getAllAdmins();

    //获取特定的管理员
    Administrator getAdmin(@Param("loginName") String loginName,@Param("password") String password);

    //管理员修改密码
    Integer updatePassword(@Param("adminId") String adminId, @Param("password") String password);
}
