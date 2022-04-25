package Mappers.potatob6;

import Beans.potatob6.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    // 根据Id获取图书
    Book getBookById(@Param("bookId") Integer bookId);

    // 查询指定页数的图书列表
    List<Book> getPageOfBook(@Param("startIndex") Integer startIndex, @Param("pageCount") Integer pageCount);

    // 编辑图书
    Integer editBook(Book book);

    // 删除图书
    Integer deleteBook(@Param("bookId") Integer bookId);

    // 添加图书
    Integer addBook(Book book) throws Exception;
}
