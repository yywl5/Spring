package Services.potatob6;

import Beans.czt.Borrow;
import Beans.czt.BorrowWithBook;
import Mappers.potatob6.BorrowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PBBorrowService")
public class BorrowService {

    @Autowired
    @Qualifier("PBBorrowMapper")
    private BorrowMapper borrowMapper;

    // 添加时间期限
    public Integer addTimelimits(Integer id, Integer newTimelimits) {
        return borrowMapper.addTimelimits(id, newTimelimits);
    }

    // 查询Borrow
    public Borrow getBorrow(Integer id) {
        return borrowMapper.getBorrow(id);
    }

    // 添加新的借阅
    public Integer addNewBorrow(Borrow borrow) {
        return borrowMapper.addNewBorrow(borrow);
    }

    // 删除借阅
    public Integer removeBorrow(Integer borrowId) {
        return borrowMapper.removeBorrow(borrowId);
    }

    // 获取所有Borrow
    public List<BorrowWithBook> getAllBorrow() {
        return borrowMapper.getAllBorrow();
    }
}
