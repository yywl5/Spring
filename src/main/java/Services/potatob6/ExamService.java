package Services.potatob6;

import Beans.potatob6.Exam;
import Mappers.potatob6.ExamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    // Exam DAO
    @Autowired
    private ExamMapper examDAO;

    // 一页的条目数量
    public static Integer numberOfPages = 10;

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
