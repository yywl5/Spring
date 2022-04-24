package Controllers.czt;

import Beans.czt.Borrow;
import Beans.potatob6.Book;
import Beans.potatob6.User;
import Services.Y0looo.Impl.BookServiceImpl;
import Services.Y0looo.Impl.BorrowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private BorrowServiceImpl borrowService;

    @RequestMapping("toBooks")
    public String allBooks(Model model){
        List list = bookService.getAllBooks();
        if(list != null) {
            model.addAttribute("books", list);
            return "Y0looo/ShowBooks";
        } else {
            model.addAttribute("errorMsg", "查询不到图书信息");
            return "Y0looo/error";
        }
    }


    @RequestMapping("borrow")
    public String borrowBook(HttpServletRequest request, Model model, int bookId){
        User user = (User) request.getSession().getAttribute("user");
        Book book = bookService.queryBookByBookId(bookId);
        Borrow exist = borrowService.getBorrowByBookId(user.getUserId(), bookId);
        if(book == null) {
            model.addAttribute("sup","查找不到此书");
            return "Y0looo/sup";
        }
        if(book.getStorageCount() == 0){
            model.addAttribute("sup","书籍无库存");
            return "Y0looo/sup";
        }
        if(exist != null){
            model.addAttribute("sup","你已经借过此书了");
            return "Y0looo/sup";
        }
        Borrow borrow = new Borrow();
        borrow.setBookId(bookId);
        borrow.setUserId(user.getUserId());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        borrow.setBorrowDate(format.format(date));
        borrow.setTimeLimit(30);
        if(borrowService.borrowBook(borrow)){
            book.setStorageCount(book.getStorageCount());
            bookService.updateBookStorageCount(book);
            model.addAttribute("sup","借阅成功");
            return "Y0looo/sup";
        } else {
            model.addAttribute("sup","借阅失败");
            return "Y0looo/sup";
        }
    }
}
