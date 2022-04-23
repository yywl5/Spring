package Mappers.dqy;

import Beans.dqy.NewsType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface NewsTypeMapper {

    @Select("select * from newstype")
    public List<NewsType> getAllNewsType();

    @Insert("insert into newstype(TtypeName) values (#{TtypeName})")
    public boolean addType(String TtypeName);

    @Update("update newstype set TtypeName=#{TtypeName} where Tno=#{Tno}")
    public boolean modifyType(NewsType newsType);

    @Delete("delete from newstype where Tno=#{Tno}")
    public boolean deleteType(int Tno);

    @Select("select * from type where Tno=#{Tno}")
    public NewsType getNewsTypeByTno(int Tno);
}
