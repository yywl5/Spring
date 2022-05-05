package Beans.wyl;

public class HeadImg {
    private String userName;
    private String imgPath;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "HeadImg{" +
                "userName='" + userName + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
