package Controllers.potatob6.APIs;

import Services.potatob6.ExamService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Controller
@RequestMapping("/admin/exams")
public class AdminExamHandler {

    @Autowired
    private ExamService examService;

    /**
     * 已测试 √
     * 获取全部的待处理清单数量API
     * @return JSON，包含nums
     */
    @GetMapping("/nums")
    @ResponseBody
    public String getNums() throws NullPointerException {
        JSONObject json = new JSONObject();
        json.put("nums", examService.getNumberOfAllNotHandledExams());
        return json.toJSONString();
    }

    /**
     * 已测试 √
     * 获取一页的待处理清单API
     * @param map JSON，包含page
     * @return    JSON，包含status和list
     */
    @GetMapping("/pageNotHandled")
    @ResponseBody
    public String pageNotHandled(@RequestBody Map map) throws NullPointerException{
        JSONObject json = new JSONObject();
        Integer page;
        page = (Integer) map.get("page");
        if ( page == null )
            throw new NullPointerException("不存在Page参数");
        json.put("status", "success");
        json.put("list", examService.getAPageOfNotHandledExams(page));
        return json.toJSONString();
    }

    /**
     * 已测试 √
     * 获取全部的待处理清单
     * @return JSON
     */
    @GetMapping("/notHandled")
    @ResponseBody
    public String getAllNotHandledExams() {
        return JSON.toJSONString(examService.getAllNotHandledExams());
    }

    /**
     * 已测试 √
     * @param map JSON，包含page
     * @return    JSON，包含status和list
     */
    @GetMapping("/pageHandled")
    @ResponseBody
    public String getAllPageOfHandledExams(@RequestBody Map map) throws NullPointerException {
        JSONObject json = new JSONObject();
        Integer page;
        page = (Integer) map.get("page");
        if ( page == null )
            throw new NullPointerException("不存在Page参数");
        json.put("status", "success");
        json.put("list", examService.getAllPageOfHandledExams(page));
        return json.toJSONString();
    }

    /**
     * 已测试 √
     * @param map JSON，包含page和adminId
     * @return    JSON，包含status和list
     */
    @GetMapping("/pageHandledAdminId")
    @ResponseBody
    public String getAllHandledPageOfExamsBySelf(@RequestBody Map map) throws NullPointerException {

        JSONObject json = new JSONObject();
        Integer page;
        Integer adminId;

        page = (Integer) map.get("page");
        adminId = (Integer) map.get("adminId");
        if ( page == null || adminId == null)
            throw new NullPointerException("不存在Page参数或adminId参数");

        json.put("status", "success");
        json.put("list", examService.getAllHandledPageOfExamsBySelf(page, adminId));
        return json.toJSONString();
    }

    /**
     * 已测试 √
     * @param map JSON，包含page
     * @return    JSON，包含status和list
     */
    @GetMapping("/pageAll")
    @ResponseBody
    public String getAllPageExam(@RequestBody Map map) throws NullPointerException {
        JSONObject json = new JSONObject();
        Integer page;
        try {
            page = (Integer) map.get("page");
            if ( page == null )
                throw new NullPointerException("不存在Page参数或adminId参数");
        } catch (Exception e) {
            json.put("status", "error");
            return json.toJSONString();
        }
        json.put("status", "success");
        json.put("list", examService.getAllPageExam(page));
        return json.toJSONString();
    }
}
