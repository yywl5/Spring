package Mappers.czx;

import Beans.czx.IRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 星包客
 */
    public interface IRoleDao {
        /***
         * selectRoleList: 获取所有角色信息
         * @return
         */
        public List<IRole> selectRoleList();
        public IRole selectRoleWithUsers(@Param("roleId") Integer roleId);
    }
