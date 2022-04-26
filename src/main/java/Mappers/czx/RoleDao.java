package Mappers.czx;

import Beans.czx.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 星包客
 */
    public interface RoleDao{
        /***
         * selectRoleList: 获取所有角色信息
         * @return
         */
        public List<Role> selectRoleList();
        public Role selectRoleWithUsers(@Param("roleId") Integer roleId);
    }
