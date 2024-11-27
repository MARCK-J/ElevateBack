package ucb.edu.bo.Elevate.DTO;

public class FavoritesDTO {
    private Long studentUserId;
    private Long courseId;

    public FavoritesDTO() {
    }

    public FavoritesDTO(Long studentUserId, Long courseId) {
        this.studentUserId = studentUserId;
        this.courseId = courseId;
    }

    public Long getStudentUserId() {
        return studentUserId;
    }

    public void setStudentUserId(Long studentUserId) {
        this.studentUserId = studentUserId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}