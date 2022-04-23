package Mappers.potatob6;

import Beans.potatob6.Book;
import org.apache.ibatis.annotations.Param;

public interface BookMapper {

    // 根据Id获取图书
    Book getBookById(@Param("bookId") Integer bookId);

}
