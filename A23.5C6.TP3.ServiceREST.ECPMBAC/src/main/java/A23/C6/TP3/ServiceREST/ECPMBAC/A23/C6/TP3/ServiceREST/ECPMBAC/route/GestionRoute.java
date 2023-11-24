package A23.C6.TP3.ServiceREST.ECPMBAC.A23.C6.TP3.ServiceREST.ECPMBAC.route;

import java.util.ArrayList;
import java.util.List;

public class GestionRoute {
    private List<Route> routeList = new ArrayList<>();

    public static void main(String[] args) {

    }

    public GestionRoute() {

    }

    public Route getRoute() {
        return routeList.get(0);
    }

    public void replaceRoute(Route route) {
        routeList.clear();
        routeList.add(route);
    }


}
