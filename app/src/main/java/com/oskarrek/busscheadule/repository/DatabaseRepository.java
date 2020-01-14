package com.oskarrek.busscheadule.repository;

import com.oskarrek.busscheadule.model.BusLine;
import com.oskarrek.busscheadule.model.BusStop;

import java.util.ArrayList;
import java.util.List;

public class DatabaseRepository {

    private List<BusLine> busLines;
    private List<BusStop> busStops;
    private static DatabaseRepository instance;

    private DatabaseRepository() {
        busLines = new ArrayList<>();
        busStops = new ArrayList<>();
    }

    public static DatabaseRepository getInstance() {
        if(instance == null) {
            instance = new DatabaseRepository();
        }
        return instance;
    }

    public void setBusLines(List<BusLine> list) {
        this.busLines = list;
    }

    public List<BusLine> getBusLines() {
        return busLines;
    }

    public void setBusStops(List<BusStop> busStops) {
        this.busStops = busStops;
    }

    public List<BusStop> getBusStops() {
        return busStops;
    }

    public BusLine getBusLine(int busLineId) {
        for(BusLine busLine : busLines) {
            if(busLine.getId() == busLineId)
                return busLine;
        }
        return null;
    }

    public boolean addBusLine(BusLine busLine) {
        if(busLine == null)
            return false;
        busLines.add(busLine);
        return true;
    }

    public boolean modifyBusLine(BusLine busLine) {
        return true;
    }

    public boolean deleteBusLine(BusLine busLine) {
        return true;
    }

    public BusStop getBusStop(int busStopId) {
        for(BusStop busStop : busStops) {
            if(busStop.getId() == busStopId)
                return busStop;
        }
        return null;
    }

    public boolean addBusStop(BusStop busStop) {
        if(busStop == null)
            return false;
        busStops.add(busStop);
        return true;
    }

    public boolean modifyBusStop(BusStop busStop) {
        return true;
    }

    public boolean deleteBusStop(BusStop busStop) {
        return true;
    }
}
