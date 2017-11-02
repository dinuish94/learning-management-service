package lk.sliit.lms.api.dto;

/**
 * Created by nuwani on 10/28/2017.
 */
public class DepartmentCourseDTO {
    private Long dId;
    private Long cId;

    public Long getdId() {
        return dId;
    }

    public void setdId(Long dId){
        this.dId = dId;
    }

    public Long getcId(){
        return cId;
    }

    public void setcId(Long cId){
        this.cId = cId;
    }

}
