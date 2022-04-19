package Mappers.potatob6;

import Beans.potatob6.Exam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamMapper {

    // 获取待处理清单的数量
    Integer    getNumberOfAllNotHandledExams();

    // 获取一页的待处理清单
    List<Exam> getAPageOfNotHandledExams(@Param("startIndex") Integer startIndex, @Param("pageCount") Integer pageCount);

    // 获取全部的待处理清单
    List<Exam> getAllNotHandledExams();

    // 获取全部已经完成的一页待处理清单
    List<Exam> getAllPageOfHandledExams(@Param("startIndex") Integer startIndex, @Param("pageCount") Integer pageCount);

    // 获取全部由自己处理的一页清单
    List<Exam> getAllHandledPageOfExamsBySelf(@Param("startIndex") Integer startIndex, @Param("pageCount") Integer pageCount, @Param("adminId") Integer adminId);

}
