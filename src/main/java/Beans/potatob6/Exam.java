package Beans.potatob6;

import Beans.czt.BorrowWithBook;

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

    public User getExamUser() {
        return examUser;
    }

    public void setExamUser(User examUser) {
        this.examUser = examUser;
    }

    public Administrator getExamAdmin() {
        return examAdmin;
    }

    public void setExamAdmin(Administrator examAdmin) {
        this.examAdmin = examAdmin;
    }

    public String getExamExtra1() {
        return examExtra1;
    }

    public void setExamExtra1(String examExtra1) {
        this.examExtra1 = examExtra1;
    }

    public Book getExamBook() {
        return examBook;
    }

    public void setExamBook(Book examBook) {
        this.examBook = examBook;
    }

    public BorrowWithBook getExamBorrowWithBook() {
        return examBorrowWithBook;
    }

    public void setExamBorrowWithBook(BorrowWithBook examBorrowWithBook) {
        this.examBorrowWithBook = examBorrowWithBook;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", examType='" + examType + '\'' +
                ", examUserId='" + examUserId + '\'' +
                ", examCreateTime=" + examCreateTime +
                ", examExtra='" + examExtra + '\'' +
                ", examExtra1='" + examExtra1 + '\'' +
                ", examHandleTime='" + examHandleTime + '\'' +
                ", examHandleStatus='" + examHandleStatus + '\'' +
                ", examHandleAdminId=" + examHandleAdminId +
                ", examComment='" + examComment + '\'' +
                ", examUser=" + examUser +
                ", examAdmin=" + examAdmin +
                ", examBook=" + examBook +
                ", examBorrowWithBook=" + examBorrowWithBook +
                '}';
    }

    private Integer examId;
    private String examType;
    private String examUserId;
    private Timestamp examCreateTime;
    private String examExtra;
    private String examExtra1;
    private String examHandleTime;
    private String examHandleStatus;
    private Integer examHandleAdminId;
    private String examComment;
    private User examUser;
    private Administrator examAdmin;
    private Book examBook;
    private BorrowWithBook examBorrowWithBook;
}
