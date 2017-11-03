package lk.sliit.lms.api.dto;

/**
 * Created by dinukshakandasamanage on 11/3/17.
 */
public class SubmissionDTO {

    private long studentId;
    private String file;
    private String studentName;
    private long marks;
    private String feedback;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public long getMarks() {
        return marks;
    }

    public void setMarks(long marks) {
        this.marks = marks;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "SubmissionDTO{" +
                "studentId=" + studentId +
                ", file='" + file + '\'' +
                ", studentName='" + studentName + '\'' +
                ", marks=" + marks +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
