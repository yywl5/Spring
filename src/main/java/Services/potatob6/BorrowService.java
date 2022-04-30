package Services.potatob6;

import Beans.czt.Borrow;
import Mappers.potatob6.BorrowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("PBBorrowService")
public class BorrowService {

    @Autowired
    @Qualifier("PBBorrowMapper")
    private BorrowMapper borrowMapper;

    // 添加时间期限
    public Integer addTimelimits(Integer id, Integer newTimelimits) {
        return borrowMapper.addTimelimits(id, newTimelimits);
    }

    // 添加新的借阅
    public Integer addNewBorrow(Borrow borrow) {
        return borrowMapper.addNewBorrow(borrow);
    }

    // 删除借阅
    public Integer removeBorrow(Integer borrowId) {
        return borrowMapper.removeBorrow(borrowId);
    }
}
