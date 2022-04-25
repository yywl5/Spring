package Controllers.potatob6.Pages;

import Beans.potatob6.Book;
import Services.potatob6.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/Admin")
public class AdminBooks {

    @Autowired
    private BookService bookService;

    /**
     * 管理员查询书籍页面
     * @param model
     * @return
     */
    @GetMapping("/Books")
    public String checkAllBooks(Model model,@RequestParam(value = "words", required = false) String words) {
        if(words == null || words.equals("")) {
            List<Book> bookList = bookService.getPageOfBook(1);
            model.addAttribute("list", bookList);
            model.addAttribute("page", 1);
            return "potatob6/AdminBooks";
        } else {
            List<Book> seached = bookService.searchBook(words);
            model.addAttribute("page", 1);
            model.addAttribute("list", seached);
            model.addAttribute("searchWord", words);
            return "potatob6/AdminBooks";
        }
    }
}
