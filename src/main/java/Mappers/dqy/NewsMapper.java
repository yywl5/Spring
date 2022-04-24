package Mappers.dqy;

import Beans.dqy.News;
import Beans.dqy.NewsAndType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface NewsMapper {

    @Select("select * from news where Ntype=#{Ntype} order by NcreateTime Desc limit 5")
    public List<News> getNewsByTypeOrderByTime(int Ntype);

    @Select("select * from news where Nno=#{Nno}")
    public News getNewsById(int Nno);

    @Select("select * from news,newstype where Nno=#{Nno} and news.Ntype=newstype.Tno")
    public NewsAndType getNewsAndTypeById(int Nno);

    @Select("select * from news,newstype where news.Ntype=#{Ntype} and news.Ntype=newstype.Tno")
    public List<NewsAndType> getNewsByType(int Ntype);

    @Select("select * from news,newstype where news.Ntype=newstype.Tno order by NcreateTime desc limit 6")
    public List<NewsAndType> getNewsLimitAndOrder();

    @Delete("delete from news where Nno=#{Nno}")
    public Boolean deleteNews(int Nno);

    @Insert("insert into news (Ntitle, Ncontent, Neditor, NcreateTime, Ntype, Npublisher) values (#{Ntitle}, #{Ncontent}, #{Neditor}, #{NcreateTime}, #{Ntype}, #{Npublisher})")
    public Boolean addNews(News news);

    @Update("update news set  Ntitle=#{Ntitle}, Ncontent=#{Ncontent}, Neditor=#{Neditor}, NcreateTime=#{NcreateTime}, Ntype=#{Ntype}, Npublisher=#{Npublisher} where Nno=#{Nno}")
    public Boolean modifyNews(News news);
}
