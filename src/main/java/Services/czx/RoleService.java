package Services.czx;

import Beans.czx.Role;

import java.util.List;

/**
 * @author 星包客
 */ /*
 * 角色Service层接口
 */
public interface RoleService {
    public List<Role> findRoleList();
    public Role findRoleWithUsersByRoleId(Integer roleId);
}
