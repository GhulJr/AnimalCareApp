package com.oskarrek.busscheadule.interfaces;

import com.oskarrek.busscheadule.model.BusLine;
import com.oskarrek.busscheadule.model.BusStop;
import com.oskarrek.busscheadule.model.Route;
import com.oskarrek.busscheadule.repository.DatabaseRepository;

import java.util.ArrayList;
import java.util.List;

public interface AdministrateBusLineMVP {

    interface View {
        void showBusLine(BusLine busLine);
        void acceptChanges();
        void discardChanges();
        void updateChanges(BusLine busLine);
        void showError(String errorMessage);
    }

    interface Presenter {
        void setBusLineName(String name);
        void addRoute(Route route);
        void deleteRoute(int routeId);
        void addStopToRoute(int routeId, int busStopId);
        void putStopToRoute(int routeId, int busStopId, int position);
        void deleteStopToRoute(int routeId, int busStopId);
        boolean isModified();
        boolean isEmpty();
        void createBusLine();
        void modifyBusLine();
        void deleteBusLine();
    }
}
