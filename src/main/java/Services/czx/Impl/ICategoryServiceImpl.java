package Services.czx.Impl;

import Mappers.czx.ICategoryDao;
import Services.czx.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import Beans.czx.ICategory;
import org.springframework.stereotype.Service;

/**
 * @author 星包客
 */
@Service("IcategoryService")
public class ICategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryDao categoryDao;
    @Override
    public List<ICategory> findCategoryList() {
        return this.categoryDao.selectCategoryList();
    }
    @Override
    public ICategory findCategoryById(Integer categoryId) {
        return this.categoryDao.getCategoryById(categoryId);
    }

    @Override
    public ICategory getCategoryByname(String categoryName){
        return this.categoryDao.getCategoryByname(categoryName);
    }
    @Override
    public int addIcategory(ICategory category){
        return this.categoryDao.addIcategory(category);
    }
        @Override
    public int updateIcategory(ICategory category){
        return this.categoryDao.updateIcategory(category);
    }
    @Override
    public int delIcategory(Integer categoryId){
        return this.categoryDao.delIcategory(categoryId);
    }
    @Override
    public int setIcategory(ICategory category){
        return this.categoryDao.setIcategory(category);
    }
}