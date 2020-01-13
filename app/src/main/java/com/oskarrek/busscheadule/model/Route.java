package com.oskarrek.busscheadule.model;

import android.app.PendingIntent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Route {
    private int id;
    private int busLineId;
    private List<Integer> busStopsIds; // <BusStopId, Order>

    public Route(int busLineId, List<Integer> busStopsIds) {
        this.getBusLineId();
        this.busStopsIds = busStopsIds;
    }

    public void setBusStopsIds(List<Integer> busStopsIds) {
        this.busStopsIds = busStopsIds;
    }

    public List<Integer> getBusStopsIds() {
        return busStopsIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBusLineId() {
        return busLineId;
    }

    public void setBusLineId(int busLineId) {
        this.busLineId = busLineId;
    }

    public void addBusStopId(int id) {
        if(busStopsIds.contains(id)) {
            busStopsIds.remove(id);
        }
        busStopsIds.add(id);
    }
    public void putBusStopId(int id, int position) {
        if(busStopsIds.contains(id)) {
            busStopsIds.remove(id);
        }
        busStopsIds.add(id, position);
    }
}
