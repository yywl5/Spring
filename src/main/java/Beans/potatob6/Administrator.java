package Beans.potatob6;

public class Administrator {
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminLogin() {
        return adminLogin;
    }

    public void setAdminLogin(String adminLogin) {
        this.adminLogin = adminLogin;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    private Integer adminId;

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public Administrator() {

    }

    public Administrator(Integer adminId, String adminLogin, String adminName, String adminPassword, String avatarPath) {
        this.adminId = adminId;
        this.avatarPath = avatarPath;
        this.adminLogin = adminLogin;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "adminId=" + adminId +
                ", avatarPath='" + avatarPath + '\'' +
                ", adminLogin='" + adminLogin + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }

    private String avatarPath;
    private String adminLogin;
    private String adminName;
    private String adminPassword;
}
