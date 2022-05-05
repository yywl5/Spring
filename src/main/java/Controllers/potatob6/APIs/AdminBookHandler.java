package Controllers.potatob6.APIs;

import Beans.potatob6.Book;
import Mappers.potatob6.AdminBookMapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminBookHandler {

    @Autowired
    @Qualifier("PBAdminBookDAO")
    private AdminBookMapper adminBookDAO;
    /**
     * 管理员添加图书API
     * @param book 图书
     * @return
     */
    @RequestMapping(
            value = "/updateBook",
            params = {"bookId","bookName","author","publisher","storageCount","price"}
    )
    @ResponseBody
    public String updateBook(Book book) {
        Integer affectedRows = adminBookDAO.adminUpdateBook(book);
        JSONObject json = new JSONObject();
        if(affectedRows == 0) {
            json.put("status", "error");
            return json.toJSONString();
        }
        json.put("status", "success");
        return json.toJSONString();
    }

    /**
     * 管理员更新图书API
     * @param book 图书
     * @return
     */
    @RequestMapping(
            value = "/addBook",
            params = {"bookName","author","publisher","storageCount","price"}
    )
    @ResponseBody
    public String addBook(Book book) {
        Integer affectedRows = adminBookDAO.addBook(book);
        JSONObject json = new JSONObject();
        if(affectedRows == 0) {
            json.put("status", "error");
            return json.toJSONString();
        }
        json.put("status","success");
        json.put("book", book);
        return json.toJSONString();
    }
}
