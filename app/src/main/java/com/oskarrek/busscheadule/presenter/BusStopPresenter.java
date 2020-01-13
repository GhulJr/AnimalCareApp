package com.oskarrek.busscheadule.presenter;

import com.oskarrek.busscheadule.interfaces.UserBusStopMVP;
import com.oskarrek.busscheadule.model.BusLine;
import com.oskarrek.busscheadule.model.BusStop;
import com.oskarrek.busscheadule.model.TimeTable;
import com.oskarrek.busscheadule.repository.DatabaseRepository;

import java.util.ArrayList;
import java.util.List;

public class BusStopPresenter implements UserBusStopMVP.Presenter {
    private UserBusStopMVP.View view;
    private DatabaseRepository repository;

    public BusStopPresenter(UserBusStopMVP.View view) {
        this.view = view;
        repository = DatabaseRepository.getInstance();
    }

    @Override
    public List<BusStop> searchBusStops(int busLineId) {
        List<BusStop> allStops = repository.getBusStops();

        List<BusStop> searchedStops = new ArrayList<>();
        for (BusStop busStop : allStops) {
            for (TimeTable timeTable: busStop.getTimeTables())
                if (timeTable.getBusLineId() == busLineId) {
                    searchedStops.add(busStop);
                    break;
                }
        }

        if (searchedStops.isEmpty()) {
            view.showNoBusStopsFound();
        } else {
            view.showBusStopsList(searchedStops);
        }

        return searchedStops;
    }

    @Override
    public List<BusStop> searchBusStops(String stopAddress) {
        List<BusStop> allStops = repository.getBusStops();

        List<BusStop> searchedLines = new ArrayList<>();
        for (BusStop busStop : allStops) {
            if (busStop.getAddress().contains(stopAddress.toLowerCase())) {
                searchedLines.add(busStop);
                break;
            }
        }

        if (searchedLines.isEmpty()) {
            view.showNoBusStopsFound();
        } else {
            view.showBusStopsList(searchedLines);
        }

        return searchedLines;
    }

    @Override
    public List<BusStop> getBusStops() {
        List<BusStop> allStops = repository.getBusStops();
        view.showBusStopsList(allStops);
        return allStops;
    }

    @Override
    public BusStop getBusStopDetails(int busStopId) {
        List<BusStop> allStops = repository.getBusStops();

        for (BusStop busStop : allStops) {
            if (busStop.getId() == busStopId) {
                view.showDetails(busStop);
                return busStop;
            }
        }
        view.showNoBusStopsFound();
        return null;
    }

    @Override
    public List<BusStop> getFavoriteStops() {
        List<BusStop> allStops = repository.getBusStops();

        List<BusStop> favoriteStops = new ArrayList<>();

        for(BusStop busLine : allStops) {
            if(busLine.isFavorite()) {
                favoriteStops.add(busLine);
            }
        }
        view.showFavoriteStops(favoriteStops);
        return favoriteStops;
    }

    @Override
    public void setFavorite(int busStopId, Boolean isFavorite) {
        List<BusStop> allStops = repository.getBusStops();

        for (BusStop busStop : allStops) {
            if (busStop.getId() == busStopId) {
                busStop.setFavorite(isFavorite);
                view.showIsFavorite(busStop);
                break;
            }
        }
    }

}
