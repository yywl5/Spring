package Controllers.potatob6.APIs;

import Beans.potatob6.Administrator;
import Beans.potatob6.Exam;
import Services.potatob6.BorrowService;
import Services.potatob6.ExamService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/admin/exams")
public class AdminExamHandler {

    @Autowired
    private ExamService examService;

    @Autowired
    @Qualifier("PBBorrowService")
    private BorrowService borrowService;

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
    @PostMapping("/pageNotHandled")
    @ResponseBody
    public String pageNotHandled(@RequestBody Map map) {
        org.json.JSONObject jsonObject = new org.json.JSONObject();
        Integer page;
        try {
            page = (Integer) map.get("page");
        } catch (NumberFormatException e) {
            jsonObject.put("status", "error");
            return jsonObject.toString();
        }
        if ( page == null ) {
            jsonObject.put("status", "error");
            return jsonObject.toString();
        }
        jsonObject.put("status", "success");
        jsonObject.put("list", examService.getAPageOfNotHandledExams(page));
        return jsonObject.toString();
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

    /**
     * 同意审核
     * @param map
     * @return
     */
    @GetMapping("/accept")
    @ResponseBody
    public String accept(@RequestBody Map map, HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        try {
            Integer examId = (Integer) map.get("Id");
            if (examId == null)
                throw new Exception();

            Exam exam = examService.getExamById(examId);
            if(exam == null)
                throw new Exception();
            if(exam.getExamType().equals("申请延期")) {
                // Get Borrow Id
                Integer borrowId = Integer.valueOf(exam.getExamExtra());
                // Get Days
                Integer days = Integer.valueOf(exam.getExamExtra1());
                // Get AdminId
                Integer adminId = ((Administrator)(request.getSession().getAttribute("admin"))).getAdminId();
                examService.setAccept(examId, adminId);
                borrowService.addTimelimits(borrowId, days);
            } else if(exam.getExamType().equals("申请还书")) {
                // TODO 还书
                // Get Borrow Id
                Integer borrowId = Integer.valueOf(exam.getExamExtra());
                // Get Days
                Integer days = Integer.valueOf(exam.getExamExtra1());
                // Get AdminId
                Integer adminId = ((Administrator)(request.getSession().getAttribute("admin"))).getAdminId();
                examService.setAccept(examId, adminId);
                borrowService.addTimelimits(borrowId, days);

            } else if(exam.getExamType().equals("申请借书")) {
                // TODO 借书
            }

            jsonObject.put("status", "success");
        } catch (Exception e) {
            jsonObject.put("status", "error");
        }
        return jsonObject.toJSONString();
    }

    /**
     * 同意审核
     * @param map
     * @return
     */
    @GetMapping("/reject")
    @ResponseBody
    public String reject(@RequestBody Map map) {
        //TODO 拒绝
        return "1";
    }

}
