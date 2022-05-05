package Services.czx;

import Beans.czx.ICategory;

import java.util.List;

/**
 * @author 星包客
 */
public interface ICategoryService {
    public List<ICategory> findCategoryList();
    public ICategory findCategoryById(Integer categoryId);

    public ICategory getCategoryByname(String categoryName);

    public int addIcategory(ICategory category);
    public int updateIcategory(ICategory category);
    public int delIcategory(Integer categoryId);
    public int setIcategory(ICategory category);
}