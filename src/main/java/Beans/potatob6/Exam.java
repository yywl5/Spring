package Beans.potatob6;

import java.sql.Timestamp;

public class Exam {
    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getExamUserId() {
        return examUserId;
    }

    public void setExamUserId(String examUserId) {
        this.examUserId = examUserId;
    }

    public Timestamp getExamCreateTime() {
        return examCreateTime;
    }

    public void setExamCreateTime(Timestamp examCreateTime) {
        this.examCreateTime = examCreateTime;
    }

    public String getExamExtra() {
        return examExtra;
    }

    public void setExamExtra(String examExtra) {
        this.examExtra = examExtra;
    }

    public String getExamHandleTime() {
        return examHandleTime;
    }

    public void setExamHandleTime(String examHandleTime) {
        this.examHandleTime = examHandleTime;
    }

    public String getExamHandleStatus() {
        return examHandleStatus;
    }

    public void setExamHandleStatus(String examHandleStatus) {
        this.examHandleStatus = examHandleStatus;
    }

    public Integer getExamHandleAdminId() {
        return examHandleAdminId;
    }

    public void setExamHandleAdminId(Integer examHandleAdminId) {
        this.examHandleAdminId = examHandleAdminId;
    }

    public String getExamComment() {
        return examComment;
    }

    public void setExamComment(String examComment) {
        this.examComment = examComment;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", examType='" + examType + '\'' +
                ", examUserId='" + examUserId + '\'' +
                ", examCreateTime=" + examCreateTime +
                ", examExtra='" + examExtra + '\'' +
                ", examHandleTime='" + examHandleTime + '\'' +
                ", examHandleStatus='" + examHandleStatus + '\'' +
                ", examHandleAdminId=" + examHandleAdminId +
                ", examComment='" + examComment + '\'' +
                '}';
    }

    private Integer examId;
    private String examType;
    private String examUserId;
    private Timestamp examCreateTime;
    private String examExtra;
    private String examHandleTime;
    private String examHandleStatus;
    private Integer examHandleAdminId;
    private String examComment;
}
