package Mappers.czt;

import Beans.potatob6.Book;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Book1Mapper {

    @Select("select * from books")
    public List<Book> getAllBooks();

    @Select("select * from books where bookName like '%${bookName}%'")
    public List<Book> getBooksByBookName(String bookName);

    @Update("update books set storageCount=#{storageCount} where bookId=#{bookId}")
    public boolean updateBookStorageCount(Book book);

    @Select("select * from books where bookId=#{bookId}")
    public Book queryBookByBookId(int bookId);

    @Select("select * from books where author like '%${author}%'")
    public List<Book> queryBookByAuthor(String author);
}
