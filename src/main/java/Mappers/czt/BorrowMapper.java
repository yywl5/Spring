package Mappers.czt;

import Beans.czt.Borrow;
import Beans.czt.BorrowWithBook;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BorrowMapper {

    /**
     * 查询当前用户所有借阅信息
     * @param userId
     * @return
     */
    @Select("select * from borrow,books where userId=#{userId} and borrow.bookId=books.bookId")
    public List<BorrowWithBook> getAllBorrowByUserId(int userId);

    /**
     * 用户借书
     * @param borrow
     * @return
     */
    @Insert("insert into borrow ( bookId, userId, borrowDate, timeLimit, returnDate) values( #{bookId}, #{userId}, #{borrowDate}, #{timeLimit}, #{returnDate})")
    public Boolean borrowBook(Borrow borrow);

    /**
     * 查询用户所有已经归还的借阅信息
     * @param userId
     * @return
     */
    @Select("select * from borrow where userId=#{userId} and returnDate is not null")
    public List<Borrow> getBorrowUserIsReturn(int userId);

    /**
     * 查询用户所有未归还的借阅信息
     * @param userId
     * @return
     */
    @Select("select * from borrow where userId=#{userId} and returnDate is null")
    public List<Borrow> getBorrowUserNotReturn(int userId);

    /**
     * 查询用户即将到期的借阅信息
     * @param userId
     * @return
     */
    @Select("select * from borrow where userId=#{userId} and returnDate is null order by timeLimit asc")
    public List<Borrow> getBorrowWillOverTime(int userId);

    @Select("select * from borrow where userId=#{userId} and bookId=#{bookId}" )
    public Borrow getBorrowByBookId(@Param("userId") int userId, @Param("bookId") int bookId);
}
