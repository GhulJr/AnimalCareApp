package com.oskarrek.busscheadule.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeTable {
    private int id;
    private int busStopId;
    private int busLineId;
    private List<Schedule> schedules;


    private TimeTable(int busStopId, int busLineId, List<Schedule> schedules) {
        this.busStopId = busStopId;
        this.busLineId = busLineId;
        if (schedules == null) {
            this.schedules = new ArrayList<>();
        } else {
            this.schedules = schedules;
        }
    }


    public int getId() {
        return id;
    }

    public int getBusStopId() {
        return busStopId;
    }

    public void setBusStopId(int busStopId) {
        this.busStopId = busStopId;
    }

    public int getBusLineId() {
        return busLineId;
    }

    public void setBusLineId(int busLineId) {
        this.busLineId = busLineId;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }
}
