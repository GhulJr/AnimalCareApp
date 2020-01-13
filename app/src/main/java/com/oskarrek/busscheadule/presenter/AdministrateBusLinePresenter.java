package com.oskarrek.busscheadule.presenter;

import android.provider.ContactsContract;

import com.oskarrek.busscheadule.interfaces.AdministrateBusLineMVP;
import com.oskarrek.busscheadule.model.BusLine;
import com.oskarrek.busscheadule.model.Route;
import com.oskarrek.busscheadule.repository.DatabaseRepository;

public class AdministrateBusLinePresenter implements AdministrateBusLineMVP.Presenter {

    private AdministrateBusLineMVP.View view;
    private BusLine busLine;
    private DatabaseRepository repository;
    private boolean isModified;

    public AdministrateBusLinePresenter(AdministrateBusLineMVP.View view) {
        this.view = view;
        this.repository = DatabaseRepository.getInstance();
        this.busLine = new BusLine();
        this.isModified = false;
    }


    public AdministrateBusLinePresenter(AdministrateBusLineMVP.View view, int busLineId) {
        this.view = view;
        this.repository = DatabaseRepository.getInstance();
        this.busLine = repository.getBusLine(busLineId);
        view.showBusLine(busLine);
        this.isModified = false;
    }

    @Override
    public void setBusLineName(String name) {
        busLine.setName(name);
        view.updateChanges(busLine);
    }

    @Override
    public void addRoute(Route route) {
        this.isModified = true;
        busLine.addRoute(route);
        view.updateChanges(busLine);
    }

    @Override
    public void deleteRoute(int routeId) {
        this.isModified = true;
        busLine.deleteRoute(routeId);
        view.updateChanges(busLine);
    }

    @Override
    public void addStopToRoute(int routeId, int busStopId) {
        this.isModified = true;
        for(Route route : busLine.getRoutes()){
            if(route.getId() == routeId) {
                route.addBusStopId(busStopId);
                view.updateChanges(busLine);
                break;
            }
        }
    }

    @Override
    public void putStopToRoute(int routeId, int busStopId, int position) {
        this.isModified = true;
        for(Route route : busLine.getRoutes()){
            if(route.getId() == routeId) {
                route.putBusStopId(busStopId, position);
                view.updateChanges(busLine);
                break;
            }
        }
    }

    @Override
    public void deleteStopToRoute(int routeId, int busStopId) {
        this.isModified = true;
        for(Route route : busLine.getRoutes()){
            if(route.getId() == routeId) {
                route.getBusStopsIds().remove(busStopId);
                view.updateChanges(busLine);
                break;
            }
        }
    }

    @Override
    public boolean isModified() {
        return isModified;
    }

    @Override
    public boolean isEmpty() {
        return busLine.getRoutes().isEmpty() || busLine.getName().isEmpty();
    }

    @Override
    public void createBusLine() {
        if(isEmpty()) {
            view.showError("Cannot add bus line due to missing data.");
            return;
        }

        if(!repository.addBusLine(busLine)) {
            view.showError("Unable to add bus line to database.");
        }
    }


    @Override
    public void modifyBusLine() {
        if(isEmpty()) {
            view.showError("Cannot modify bus line due to missing data.");
            return;
        }

        if(!repository.modifyBusLine(busLine)) {
            view.showError("Unable to update bus line in database.");
        }
    }

    @Override
    public void deleteBusLine() {
        if(!repository.modifyBusLine(busLine)) {
            view.showError("Unable to delete bus line.");
        }
    }
}
