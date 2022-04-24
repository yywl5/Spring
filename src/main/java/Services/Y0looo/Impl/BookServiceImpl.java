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

    @Override
    public List<Book> getAllBooks () {
        return bookDao.getAllBooks();
    }

    @Override
    public List<Book> getBooksByBookName (String bookName) {
        return bookDao.getBooksByBookName(bookName);
    }

    @Override
    public boolean updateBookStorageCount (Book book) {
        return bookDao.updateBookStorageCount(book);
    }

    @Override
    public Book queryBookByBookId (int bookId) {
        return bookDao.queryBookByBookId(bookId);
    }
}
