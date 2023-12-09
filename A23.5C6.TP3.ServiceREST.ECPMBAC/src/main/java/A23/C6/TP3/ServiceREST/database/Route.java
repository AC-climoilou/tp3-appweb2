package A23.C6.TP3.ServiceREST.database;
import java.io.Serializable;

public class Route implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String route;

    public Route() {

    }

    public Route(String route) {
        this.route = route;
    }

    public Long getId() {
        return id;
    }

    public String getRoute() {
        return route;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}

