package Mappers.potatob6;

import Beans.czt.Borrow;
import Beans.czt.BorrowWithBook;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PBBorrowMapper")
public interface BorrowMapper {

    // 更新时间期限
    Integer addTimelimits(@Param("borrowId") Integer borrowId, @Param("newAddTimelimits") Integer newAddTimelimits);

    // 添加新的借阅
    Integer addNewBorrow(Borrow borrow);

    // 删除借阅
    Integer removeBorrow(@Param("borrowId") Integer borrowId);

    // 获取所有Borrow
    List<BorrowWithBook> getAllBorrow();

    // 获取Borrow
    Borrow getBorrow(@Param("id") Integer id);
}
