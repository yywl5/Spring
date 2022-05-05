package Controllers.potatob6.APIs;

import Beans.potatob6.Book;
import Services.potatob6.BookService;
import com.alibaba.fastjson.JSON;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/admin/books")
@ResponseBody
public class AdminBooksHandler {

    @Autowired
    @Qualifier("PBAdminBookService")
    private BookService bookService;

    /**
     * 获取一页图书
     * @param map JSON，包含page
     * @return    JSON，包含list和status
     */
    @PostMapping("/pageBooks")
    public String pageBooks(@RequestBody Map map) {
        JSONObject jsonObject = new JSONObject();
        Integer page = (Integer) map.get("page");
        if(page == null) {
            jsonObject.put("status", "error");
            return jsonObject.toString();
        }

        jsonObject.put("status", "success");
        jsonObject.put("list", bookService.getPageOfBook(page));
        return jsonObject.toString();
    }

    /**
     * 修改图书信息
     * @param map JSON,包含bookId, bookName, author, publisher, storageCount, price
     * @return    JSON,包含status
     */
    @PostMapping("/edit")
    @ResponseBody
    public String editBook(@RequestBody Map map) {
        JSONObject jsonObject = new JSONObject();
        try {
            Integer ret = bookService.editBook(String.valueOf(map.get("bookId")), (String) map.get("bookName"),
                    (String) map.get("author"), (String) map.get("publisher"),
                    String.valueOf(map.get("storageCount")), (String) map.get("price"));
            if(ret != 0) {
                jsonObject.put("status", "success");
                return jsonObject.toString();
            }
            jsonObject.put("status", "error");
            jsonObject.put("message", "参数异常");
            return jsonObject.toString();
        } catch (Exception e) {
            jsonObject.put("status", "error");
            jsonObject.put("message", e.toString());
            return jsonObject.toString();
        }
    }

    /**
     * 管理员删除图书API
     * @param map JSON，包含bookId
     * @return    JSON，包含status和bookId
     */
    @PostMapping("/delete")
    @ResponseBody
    public String deleteBook(@RequestBody Map map) {
        JSONObject jsonObject = new JSONObject();
        try {
            Integer bookId = (Integer) map.get("bookId");
            Integer ret = bookService.deleteBook(bookId);

            if(ret != 0) {
                jsonObject.put("status", "success");
                return jsonObject.toString();
            }

            jsonObject.put("status", "error");
            jsonObject.put("message", "参数错误");
            return jsonObject.toString();
        } catch (Exception e) {
            jsonObject.put("status", "error");
            jsonObject.put("message", e.toString());
            return jsonObject.toString();
        }
    }

    /**
     *  管理员添加图书API
     * @param book 图书JSON
     * @return     JSON，包含status
     */
    @PostMapping("/add")
    @ResponseBody
    public String addBook(@RequestBody Book book) {
        JSONObject jsonObject = new JSONObject();
        if(book.getBookName().equals("")) {
            jsonObject.put("status", "error");
            return jsonObject.toString();
        }
        Integer ret = bookService.addBook(book);
        if(ret > 0) {
            jsonObject.put("status", "success");
            jsonObject.put("bookId", book.getBookId());
            return jsonObject.toString();
        }

        jsonObject.put("status", "error");
        return jsonObject.toString();
    }

    /**
     * 查询图书
     * @param words 关键字
     * @return      JSON,包含list
     */
    @GetMapping("/search/{words}")
    @ResponseBody
    public String searchBook(@PathVariable(value = "words", required = true) String words) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list", bookService.searchBook(words));
        return jsonObject.toString();
    }
}
