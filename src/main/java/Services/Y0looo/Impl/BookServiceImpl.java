package Services.Y0looo.Impl;

import Beans.potatob6.Book;
import Mappers.czt.Book1Mapper;
import Services.Y0looo.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private Book1Mapper bookDao;

    /**
     * 获取所有图书信息
     * @return
     */
    @Override
    public List<Book> getAllBooks () {
        return bookDao.getAllBooks();
    }

    /**
     * 根据图书名称查询图书
     * @param bookName
     * @return
     */
    @Override
    public List<Book> getBooksByBookName (String bookName) {
        return bookDao.getBooksByBookName(bookName);
    }

    /**
     * 更新图书库存
     * @param book
     * @return
     */
    @Override
    public boolean updateBookStorageCount (Book book) {
        return bookDao.updateBookStorageCount(book);
    }

    /**
     * 查询某本图书具体信息
     * @param bookId
     * @return
     */
    @Override
    public Book queryBookByBookId (int bookId) {
        return bookDao.queryBookByBookId(bookId);
    }
}
