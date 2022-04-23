package Services.dqy;

import Beans.dqy.NewsType;

import java.util.List;

public interface NewsTypeService {

    public List<NewsType> getAllNewsType();

    public boolean addType(String TtypeName);

    public boolean modifyType(NewsType newsType);

    public boolean deleteType(int Tno);

    public NewsType getNewsTypeByTno(int Tno);
}
