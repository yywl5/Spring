package Mappers.potatob6;

import Beans.czt.BorrowWithBook;
import Beans.potatob6.Administrator;
import Beans.potatob6.Exam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamMapper {

    // 处理同意
    Integer setAccept(@Param("examId") Integer examId, @Param("adminId") Integer adminId);

    // 处理拒绝
    Integer setReject(@Param("examId") Integer examId, @Param("adminId") Integer adminId);

    // 通过Id获取Exam
    Exam getExamById(@Param("examId") Integer examId);

    // 获取待处理清单的数量
    Integer    getNumberOfAllNotHandledExams();

    // 获取一页的待处理清单
    List<Exam> getAPageOfNotHandledExams(@Param("startIndex") Integer startIndex, @Param("pageCount") Integer pageCount);

    // 获取全部的待处理清单
    List<Exam> getAllNotHandledExams();

    // 获取全部已经完成的一页清单
    List<Exam> getAllPageOfHandledExams(@Param("startIndex") Integer startIndex, @Param("pageCount") Integer pageCount);

    // 获取全部由自己处理的一页清单
    List<Exam> getAllHandledPageOfExamsBySelf(@Param("startIndex") Integer startIndex, @Param("pageCount") Integer pageCount, @Param("adminId") Integer adminId);

    // 获取全部的一页清单
    List<Exam> getAllPageExam(@Param("startIndex") Integer startIndex, @Param("pageCount") Integer pageCount);

    //从特定Id获取管理员
    Administrator getAdminById(@Param("adminId") Integer adminId);

    // 获取borrow的book
    BorrowWithBook getBookInBorrow(@Param("bookId") Integer bookId);
}
