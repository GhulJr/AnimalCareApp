package com.oskarrek.busscheadule;

import com.oskarrek.busscheadule.interfaces.AdministrateBusLineMVP;
import com.oskarrek.busscheadule.interfaces.AdministrateBusStopMVP;
import com.oskarrek.busscheadule.interfaces.UserBusLineMVP;
import com.oskarrek.busscheadule.interfaces.UserBusStopMVP;
import com.oskarrek.busscheadule.model.BusLine;
import com.oskarrek.busscheadule.model.BusStop;
import com.oskarrek.busscheadule.model.TimeTable;

import java.util.List;

public class ViewPlaceholder implements UserBusLineMVP.View, UserBusStopMVP.View,
        AdministrateBusStopMVP.View, AdministrateBusLineMVP.View {
    @Override
    public void showDetails(BusLine busLine) {

    }

    @Override
    public void showBusLinesList(List<BusLine> searchedLines) {

    }

    @Override
    public void showNoBusLinesFound() {

    }

    @Override
    public void showIsFavorite(BusLine busLine) {

    }

    @Override
    public void showFavoriteLines(List<BusLine> favoriteLines) {

    }

    @Override
    public void showBusLine(BusLine busLine) {

    }

    @Override
    public void updateChanges(BusLine busLine) {

    }

    @Override
    public void showBusStop(BusStop busStop) {

    }

    @Override
    public void showTimeTable(TimeTable timeTable) {

    }

    @Override
    public void acceptChanges() {

    }

    @Override
    public void discardChanges() {

    }

    @Override
    public void updateChanges(BusStop busStop) {

    }

    @Override
    public void showError(String errorMessage) {

    }

    @Override
    public void showDetails(BusStop busStop) {

    }

    @Override
    public void showBusStopsList(List<BusStop> searchedStops) {

    }

    @Override
    public void showNoBusStopsFound() {

    }

    @Override
    public void showIsFavorite(BusStop busStop) {

    }

    @Override
    public void showFavoriteStops(List<BusStop> favoriteStops) {

    }
}
