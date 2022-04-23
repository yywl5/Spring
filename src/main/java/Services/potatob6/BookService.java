package Services.potatob6;

import Beans.potatob6.Book;
import Mappers.potatob6.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookService {

    @Autowired
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
}
