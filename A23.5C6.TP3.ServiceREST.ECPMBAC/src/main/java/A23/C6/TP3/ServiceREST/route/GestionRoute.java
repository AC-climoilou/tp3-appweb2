package A23.C6.TP3.ServiceREST.ECPMBAC.A23.C6.TP3.ServiceREST.ECPMBAC.route;

import A23.C6.TP3.ServiceREST.route.TP3Route;

import java.util.ArrayList;
import java.util.List;

public class GestionRoute {
    private List<TP3Route> TP3RouteList = new ArrayList<>();

    public static void main(String[] args) {

    }

    public GestionRoute() {

    }

    public TP3Route getRoute() {
        return TP3RouteList.get(0);
    }

    public void replaceRoute(TP3Route TP3Route) {
        TP3RouteList.clear();
        TP3RouteList.add(TP3Route);
    }


}
