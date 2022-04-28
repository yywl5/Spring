package Services.czx;

import Beans.czx.IRole;

import java.util.List;

public interface IRoleService {
    /**
     *
     * @return
     */
    public List<IRole> findRoleList();

    /**
     *
     * @param roleId
     * @return
     */
    public IRole findRoleWithUsersByRoleId(Integer roleId);
}
