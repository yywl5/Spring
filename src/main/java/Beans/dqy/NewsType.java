package Beans.dqy;

public class NewsType {

    private int Tno;
    private String TtypeName;

    public int getTno () {
        return Tno;
    }

    public void setTno (int tno) {
        Tno = tno;
    }

    @Override
    public String toString () {
        return "NewsType{" +
                "Tno=" + Tno +
                ", TtypeName='" + TtypeName + '\'' +
                '}';
    }

    public String getTtypeName () {
        return TtypeName;
    }

    public void setTtypeName (String ttypeName) {
        TtypeName = ttypeName;
    }
}
