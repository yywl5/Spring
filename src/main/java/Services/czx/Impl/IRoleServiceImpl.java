package Services.czx.Impl;

import Beans.czx.IRole;
import Mappers.czx.IRoleDao;
import Services.czx.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("IroleService")
/*
 * 角色Service接口实现类
 */
public class IRoleServiceImpl implements IRoleService {
    //注入RoleDao
    @Autowired
    private IRoleDao roleDao;
    @Override
    public List<IRole> findRoleList() {
        List<IRole> roleList=roleDao.selectRoleList();
        return roleList;
    }
    @Override
    public IRole findRoleWithUsersByRoleId(Integer roleId) {
        IRole role=roleDao.selectRoleWithUsers(roleId);
        return role;
    }
}