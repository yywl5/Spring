package Services.Y0looo;

import Beans.czt.Borrow;
import Beans.czt.BorrowWithBook;

import java.util.List;

public interface BorrowService {

    public List<BorrowWithBook> getAllBorrowByUserId(int userId);

    public Boolean borrowBook(Borrow borrow);

    public List<BorrowWithBook> getBorrowUserIsReturn(int userId);

    public List<BorrowWithBook> getBorrowUserNotReturn(int userId);

    public List<BorrowWithBook> getBorrowWillOverTime(int userId);

    public Borrow getBorrowByBookId(int userId,int bookId);

    public boolean returnBook(Borrow borrow);
}
