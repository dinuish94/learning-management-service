package lk.sliit.lms.api.dto;

import java.util.Arrays;

/**
 * Created by kashifroshen on 10/21/17.
 */
public class QuizMarkDTO {

    long marks;
    long quiz;
    long student;
    long correctQuestions[];

    public long getMarks() {
        return marks;
    }

    public void setMarks(long marks) {
        this.marks = marks;
    }

    public long getQuiz() {
        return quiz;
    }

    public void setQuiz(long quiz) {
        this.quiz = quiz;
    }

    public long getStudent() {
        return student;
    }

    public void setStudent(long student) {
        this.student = student;
    }

    public long[] getCorrectQuestions() {
        return correctQuestions;
    }

    public void setCorrectQuestions(long[] correctQuestions) {
        this.correctQuestions = correctQuestions;
    }

    @Override
    public String toString() {
        return "QuizMarkDTO{" +
                "marks=" + marks +
                ", quiz=" + quiz +
                ", student=" + student +
                ", correctQuestions=" + Arrays.toString(correctQuestions) +
                '}';
    }
}
