package com.oskarrek.busscheadule.model;

import java.util.ArrayList;
import java.util.List;

public class BusStop {
    private int id;
    private String address;
    private List<TimeTable> timeTables;
    private boolean isFavorite;

    public BusStop() {
        this.timeTables = new ArrayList<>();
        this.isFavorite = false;
    }

    public BusStop(String address, List<TimeTable> timeTables) {
        this.address = address;
        this.timeTables = timeTables;
        this.isFavorite = false;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<TimeTable> getTimeTables() {
        return timeTables;
    }

    public void setTimeTables(List<TimeTable> timeTables) {
        this.timeTables = timeTables;
    }

    public void addTimeTable(TimeTable timeTable) {
        this.timeTables.add(timeTable);
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}



// - display all timetables
// - display specific timetable