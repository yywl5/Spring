package Mappers.czx;

import Beans.czx.ICategory;

import java.util.List;

/**
 * @author 星包客
 */
public interface ICategoryDao {
    //查询所有新闻类别
    public List<ICategory> selectCategoryList();
    //根据新闻类别ID查询新闻类别
    public ICategory getCategoryById(Integer categoryId);
}