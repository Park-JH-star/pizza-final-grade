package pizza;

public class GradeCanceled extends AbstractEvent {

    private Long id;
    private String orderId;
    private Long score;
    private String gradestatus;

    public GradeCanceled(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
    public String getGradestatus() {
        return gradestatus;
    }

    public void setGradestatus(String gradestatus) {
        this.gradestatus = gradestatus;
    }
}
