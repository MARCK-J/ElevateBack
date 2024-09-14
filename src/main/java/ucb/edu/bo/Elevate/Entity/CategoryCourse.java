package ucb.edu.bo.Elevate.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "category_course")
public class CategoryCourse {

    /*
    -- Table: Category_course
    CREATE TABLE Category_course (
        id int  NOT NULL,
        name_category varchar(50)  NOT NULL,
        CONSTRAINT Category_course_pk PRIMARY KEY (id)
    );
    */

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name_category", nullable = false)
    private String nameCategory;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    // toString
    @Override
    public String toString() {
        return "CategoryCourse{" +
                "id=" + id +
                ", nameCategory='" + nameCategory + '\'' +
                '}';
    }
}
