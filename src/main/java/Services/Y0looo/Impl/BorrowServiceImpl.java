package Services.Y0looo.Impl;

import Beans.czt.Borrow;
import Beans.czt.BorrowWithBook;
import Mappers.czt.BorrowMapper;
import Services.Y0looo.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowMapper borrowDao;

    @Override
    public List<BorrowWithBook> getAllBorrowByUserId (int userId) {
        return borrowDao.getAllBorrowByUserId(userId);
    }

    @Override
    public Boolean borrowBook (Borrow borrow) {
        return borrowDao.borrowBook(borrow);
    }

    @Override
    public List<Borrow> getBorrowUserIsReturn (int userId) {
        return borrowDao.getBorrowUserIsReturn(userId);
    }

    @Override
    public List<Borrow> getBorrowUserNotReturn (int userId) {
        return borrowDao.getBorrowUserNotReturn(userId);
    }

    @Override
    public List<Borrow> getBorrowWillOverTime (int userId) {
        return borrowDao.getBorrowWillOverTime(userId);
    }

    @Override
    public Borrow getBorrowByBookId (int userId, int bookId) {
        return borrowDao.getBorrowByBookId(userId, bookId);
    }
}
