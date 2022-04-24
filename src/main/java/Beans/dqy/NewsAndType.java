package Beans.dqy;

public class NewsAndType {

    private int Nno;
    private String Ntitle;
    private String Ncontent;
    private String Neditor;
    private String NcreateTime;
    private int Ntype;
    private String Npublisher;
    private String TtypeName;

    public int getNno () {
        return Nno;
    }

    public void setNno (int nno) {
        Nno = nno;
    }

    public String getNtitle () {
        return Ntitle;
    }

    public void setNtitle (String ntitle) {
        Ntitle = ntitle;
    }

    public String getNcontent () {
        return Ncontent;
    }

    public void setNcontent (String ncontent) {
        Ncontent = ncontent;
    }

    public String getNeditor () {
        return Neditor;
    }

    public void setNeditor (String neditor) {
        Neditor = neditor;
    }

    public String getNcreateTime () {
        return NcreateTime;
    }

    public void setNcreateTime (String ncreateTime) {
        NcreateTime = ncreateTime;
    }

    public int getNtype () {
        return Ntype;
    }

    public void setNtype (int ntype) {
        Ntype = ntype;
    }

    public String getNpublisher () {
        return Npublisher;
    }

    public void setNpublisher (String npublisher) {
        Npublisher = npublisher;
    }

    public String getTtypeName () {
        return TtypeName;
    }

    public void setTtypeName (String ttypeName) {
        TtypeName = ttypeName;
    }

    @Override
    public String toString () {
        return "NewsAndType{" +
                "Nno=" + Nno +
                ", Ntitle='" + Ntitle + '\'' +
                ", Ncontent='" + Ncontent + '\'' +
                ", Neditor='" + Neditor + '\'' +
                ", NcreateTime='" + NcreateTime + '\'' +
                ", Ntype=" + Ntype +
                ", Npublisher='" + Npublisher + '\'' +
                ", TtypeName='" + TtypeName + '\'' +
                '}';
    }
}
