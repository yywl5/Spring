package Services.Y0looo;

import Beans.czt.Borrow;
import Beans.czt.BorrowWithBook;

import java.util.List;

public interface BorrowService {

    public List<BorrowWithBook> getAllBorrowByUserId(int userId);

    public Boolean borrowBook(Borrow borrow);

    public List<Borrow> getBorrowUserIsReturn(int userId);

    public List<Borrow> getBorrowUserNotReturn(int userId);

    public List<Borrow> getBorrowWillOverTime(int userId);

    public Borrow getBorrowByBookId(int userId,int bookId);
}
