package Services.potatob6;

import Beans.potatob6.Book;
import Mappers.potatob6.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@Service("PBAdminBookService")
public class BookService {

    @Autowired
    @Qualifier("PBAdminBookDAO1")
    private BookMapper bookMapper;

    private static Integer numberOfPages = 20;

    // 查询一页图书
    public List<Book> getPageOfBook(Integer page) {
        return bookMapper.getPageOfBook(numberOfPages*(page-1), numberOfPages);
    }

    // 编辑图书
    public Integer editBook(String _bookId, String _bookName, String _author,
                            String _publisher, String _storageCount, String _price) throws Exception {
        Integer bookId = Integer.parseInt(_bookId);
        BigDecimal price = new BigDecimal(_price);
        Integer storageCount = Integer.parseInt(_storageCount);

        Book book = new Book(bookId, _bookName, _author, _publisher, storageCount, price);
        return bookMapper.editBook(book);
    }

    // 删除图书
    public Integer deleteBook(Integer bookId) {
        return bookMapper.deleteBook(bookId);
    }

    // 添加图书
    public Integer addBook(Book book) {
        try {
            return bookMapper.addBook(book);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    // 查询图书
    public List<Book> searchBook(String words) {
        return bookMapper.searchBook(words);
    }

    // 添加图书数量
    public Integer addBookNumber(Integer bookId, Integer num) {
        return bookMapper.addBookNumber(bookId, num);
    }
}
