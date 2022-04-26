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

    /**
     * 通过用户id获取所有借阅信息
     * @param userId
     * @return
     */
    @Override
    public List<BorrowWithBook> getAllBorrowByUserId (int userId) {
        return borrowDao.getAllBorrowByUserId(userId);
    }

    /**
     * 借阅书籍
     * @param borrow
     * @return
     */
    @Override
    public Boolean borrowBook (Borrow borrow) {
        return borrowDao.borrowBook(borrow);
    }

    /**
     * 获取用户已归还的借阅信息
     * @param userId
     * @return
     */
    @Override
    public List<BorrowWithBook> getBorrowUserIsReturn (int userId) {
        return borrowDao.getBorrowUserIsReturn(userId);
    }

    /**
     * 获取用户未归还的借阅信息
     * @param userId
     * @return
     */
    @Override
    public List<BorrowWithBook> getBorrowUserNotReturn (int userId) {
        return borrowDao.getBorrowUserNotReturn(userId);
    }

    /**
     * 获取用户即将到期的借阅信息，按归还期限升序
     * @param userId
     * @return
     */
    @Override
    public List<BorrowWithBook> getBorrowWillOverTime (int userId) {
        return borrowDao.getBorrowWillOverTime(userId);
    }

    /**
     * 获取用户某本图书的借阅记录
     * @param userId
     * @param bookId
     * @return
     */
    @Override
    public Borrow getBorrowByBookId (int userId, int bookId) {
        return borrowDao.getBorrowByBookId(userId, bookId);
    }

    /**
     * 归还图书
     * @param borrow
     * @return
     */
    @Override
    public boolean returnBook (Borrow borrow) {
        return borrowDao.returnBook(borrow);
    }
}
