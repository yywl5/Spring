package Mappers.potatob6;

import Beans.potatob6.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    // 从特定Id查用户
    User getUserById(@Param("userId") Integer userId);
}
