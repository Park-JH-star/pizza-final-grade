package pizza;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Grade_table")
public class Grade {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private Long score;
    private String gradeStatus;


    @PrePersist
    public void onPrePersist(){
        try {
            Thread.currentThread().sleep((long) (400 + Math.random() * 350));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        GradeCanceled gradeCanceled = new GradeCanceled();
        BeanUtils.copyProperties(this, gradeCanceled);
        gradeCanceled.publishAfterCommit();


        Graded graded = new Graded();
        BeanUtils.copyProperties(this, graded);
        graded.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
    public String getGradeStatus() {
        return gradeStatus;
    }

    public void setGradeStatus(String gradeStatus) {
        this.gradeStatus = gradeStatus;
    }




}
