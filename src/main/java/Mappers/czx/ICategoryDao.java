package Mappers.czx;

import Beans.czx.ICategory;
import Beans.czx.IUser;

import java.util.List;

/**
 * @author 星包客
 */
public interface ICategoryDao {
    /***
     * 查询所有新闻类别
     * @return
     */
    public List<ICategory> selectCategoryList();
    /**
     *  根据新闻类别ID查询新闻类别
     */

    public ICategory getCategoryById(Integer categoryId);
    /*
     *根据目录分类类别设置公告分类
     */
    public ICategory getCategoryByname(String categoryName);
    /***
     *
     */
    public int addIcategory(ICategory category);
    public int updateIcategory(ICategory category);
    public int delIcategory(Integer categoryId);
    public int setIcategory(ICategory category);

}