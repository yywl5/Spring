package Mappers.czt;

import Beans.potatob6.Book;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Book1Mapper {

    @Select("select * from Books")
    public List<Book> getAllBooks();

    @Select("select * from Books where bookName like '%${bookName}%'")
    public List<Book> getBooksByBookName(String bookName);

    @Update("update Books set storageCount=#{storageCount} where bookId=#{bookId}")
    public boolean updateBookStorageCount(Book book);

    @Select("select * from Books where bookId=#{bookId}")
    public Book queryBookByBookId(int bookId);

    @Select("select * from Books where author like '%${author}%'")
    public List<Book> queryBookByAuthor(String author);
}
