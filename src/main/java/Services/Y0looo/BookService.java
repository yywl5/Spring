package Services.Y0looo;

import Beans.potatob6.Book;

import java.util.List;

public interface BookService {

    public List<Book> getAllBooks();

    public List<Book> getBooksByBookName(String bookName);

    public boolean updateBookStorageCount(Book book);

    public Book queryBookByBookId(int bookId);
}
