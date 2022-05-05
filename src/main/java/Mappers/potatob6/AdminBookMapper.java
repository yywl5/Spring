package Mappers.potatob6;

import Beans.potatob6.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PBAdminBookDAO")
public interface AdminBookMapper {

    //管理员获取所有的书籍
    List<Book> getAllBooks();

    //管理员更新图书信息
    Integer adminUpdateBook(Book book);

    //管理员删除书籍
    Integer deleteBook(@Param("bookId") Integer bookId);

    //管理员添加书籍
    Integer addBook(Book book);
}
