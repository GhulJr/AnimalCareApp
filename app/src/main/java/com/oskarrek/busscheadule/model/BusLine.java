package com.oskarrek.busscheadule.model;

import java.util.ArrayList;
import java.util.List;

public class BusLine {
    private int id;
    private String name;
    private List<Route> routes;
    private Boolean favorite;

    public BusLine() {
        this.name = "";
        this.favorite = false;
        this.routes = new ArrayList<>();
    }

    public BusLine(String name, List<Route> routes) {
        this.name = name;
        this.favorite = false;

        if (routes == null) {
            this.routes = new ArrayList<>();
        } else {
            this.routes = routes;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public Boolean isFavorite() {
        return favorite;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addRoute(Route route) {
        routes.add(route);
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public void deleteRoute(int routeId) {
        for (Route route : routes) {
            if (route.getId() == routeId) {
                routes.remove(route);
                break;
            }
        }
    }
}


