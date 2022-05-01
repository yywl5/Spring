package Services.czx;

import Beans.czx.ICategory;

import java.util.List;

/**
 * @author 星包客
 */
public interface ICategoryService {
    public List<ICategory> findCategoryList();
    public ICategory findCategoryById(Integer categoryId);
}