package Controllers.potatob6.APIs;

import Beans.czt.Borrow;
import Services.potatob6.BookService;
import Services.potatob6.BorrowService;
import com.alibaba.fastjson.JSON;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/admin/borrow")
public class AdminBorrowHandler {

    @Autowired
    @Qualifier("PBBorrowService")
    private BorrowService borrowService;

    @Autowired
    @Qualifier("PBAdminBookService")
    private BookService bookService;

    @RequestMapping("/getAllBorrow")
    public String getAllBorrow() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list", borrowService.getAllBorrow());
        return jsonObject.toString();
    }

    @PostMapping("/forceReturn")
    public String forceReturn(@RequestBody Map map) {
        try {
            Integer id = (Integer) map.get("Id");
            Borrow borrow = borrowService.getBorrow(id);
            bookService.addBookNumber(borrow.getBookId(), 1);
            borrowService.removeBorrow(id);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", "success");
            return jsonObject.toString();
        }catch (Exception e) {
            return "{\"status\":\"error\"}";
        }
    }
}
