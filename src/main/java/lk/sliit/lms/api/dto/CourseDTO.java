package lk.sliit.lms.api.dto;

/**
 * Created by Jonathan on 10/28/2017.
 */
public class CourseDTO {
    private Long cId;

    private String name;
    private String description;
    private String title;

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
