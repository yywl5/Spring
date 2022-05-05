package Services.potatob6;

import Beans.potatob6.Exam;
import Mappers.potatob6.ExamMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PBAdminExamService")
public class ExamService {

    // Exam DAO
    @Autowired
    @Qualifier("PBAdminExamDAO")
    private ExamMapper examDAO;

    // 一页的条目数量
    public static Integer numberOfPages = 10;

    // 处理同意
    public Integer setAccept(Integer examId, Integer adminId) {
        return examDAO.setAccept(examId, adminId);
    }

    // 处理拒绝
    public Integer setReject(Integer examId, Integer adminId) {
        return examDAO.setReject(examId, adminId);
    }

    // 通过Id获取Exam
    public Exam getExamById(Integer examId) {
        return examDAO.getExamById(examId);
    }

    // 获取待处理清单的数量
    public Integer getNumberOfAllNotHandledExams() {
        return examDAO.getNumberOfAllNotHandledExams();
    }

    // 获取一页的待处理清单
    public List<Exam> getAPageOfNotHandledExams(Integer page) {
        return examDAO.getAPageOfNotHandledExams(numberOfPages*(page-1), numberOfPages);
    }

    // 获取全部的待处理清单
    public List<Exam> getAllNotHandledExams() {
        return examDAO.getAllNotHandledExams();
    }

    // 获取全部已经完成的一页清单
    public List<Exam> getAllPageOfHandledExams(Integer page) {
        return examDAO.getAllPageOfHandledExams(numberOfPages*(page-1), numberOfPages);
    }

    // 获取全部由自己处理的一页清单
    public List<Exam> getAllHandledPageOfExamsBySelf(Integer page, Integer adminId) {
        return examDAO.getAllHandledPageOfExamsBySelf(numberOfPages*(page-1), numberOfPages, adminId);
    }

    // 获取全部的一页清单
    public List<Exam> getAllPageExam(Integer page) {
        return examDAO.getAllPageExam(numberOfPages*(page-1), numberOfPages);
    }
}
