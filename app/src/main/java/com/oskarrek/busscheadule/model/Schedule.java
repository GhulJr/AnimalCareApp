package com.oskarrek.busscheadule.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schedule {
    private int id;
    private int timeTableId;
    private String name;
    private Map<Integer, List<Integer>> rows; //<Hour, Minutes>


    public Schedule(String name, Map<Integer, List<Integer>> rows) {
        this.name = name;
        this.rows = rows;
    }

    public int getId() {
        return id;
    }

    public int getTimeTableId() {
        return timeTableId;
    }

    public void setTimeTableId(int timeTableId) {
        this.timeTableId = timeTableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, List<Integer>> getRows() {
        return rows;
    }

    public void setRows(Map<Integer, List<Integer>> rows) {
        this.rows = rows;
    }

    public List<Integer> getRow(int hour) {
        return rows.get(hour);
    }

    public void putRow(int hour, List<Integer> minutes) {
        rows.put(hour, minutes);
    }
}