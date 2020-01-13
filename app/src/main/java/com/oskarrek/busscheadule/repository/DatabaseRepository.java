package com.oskarrek.busscheadule.repository;

import android.provider.ContactsContract;

import com.oskarrek.busscheadule.model.BusLine;
import com.oskarrek.busscheadule.model.BusStop;

import java.util.List;

public class DatabaseRepository {

    private Database database;
    private static DatabaseRepository instance;

    private DatabaseRepository() {
        database = new Database();
    }

    public static DatabaseRepository getInstance() {
        if(instance == null) {
            instance = new DatabaseRepository();
        }
        return instance;
    }

    public List<BusLine> getBusLines() {
    }

    public List<BusStop> getBusStops() {
    }

    public BusLine getBusLine(int busLineId) {
    }

    public boolean addBusLine(BusLine busLine) {
    }

    public boolean modifyBusLine(BusLine busLine) {
    }

    public boolean deleteBusLine(BusLine busLine) {
    }

    public BusStop getBusStop(int busStopId) {
    }

    public boolean addBusStop(BusStop busStop) {
    }

    public boolean modifyBusStop(BusStop busStop) {
    }

    public boolean deleteBusStop(BusStop busStop) {
    }
}
