package lk.sliit.lms.api.models;

/**
 * Created by Jonathan on 9/26/2017.
 */
public class Enrollment {

    private Long cId;
    private Long sId;

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }
}