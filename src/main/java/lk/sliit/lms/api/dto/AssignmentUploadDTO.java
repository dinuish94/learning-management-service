package lk.sliit.lms.api.dto;

/**
 * Created by Jonathan on 10/23/2017.
 */
public class AssignmentUploadDTO {

    private Long assignId;
    private Long sId;
    private String file;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Long getAssignId() {
        return assignId;
    }

    public void setAssignId(Long assignId) {
        this.assignId = assignId;
    }

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    @Override
    public String toString() {
        return "AssignmentUploadDTO{" +
                "assignId=" + assignId +
                ", sId=" + sId +
                ", file='" + file + '\'' +
                '}';
    }
}