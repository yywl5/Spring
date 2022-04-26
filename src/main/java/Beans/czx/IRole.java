package Beans.czx;


import java.util.List;

/**
 * @author 星包客
 */
public class IRole {
    private Integer roleId;
    private String roleName;
    private List<IUser> userList;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<IUser> getUserList() {
        return userList;
    }

    public void setUserList(List<IUser> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", userList=" + userList +
                '}';
    }
}
