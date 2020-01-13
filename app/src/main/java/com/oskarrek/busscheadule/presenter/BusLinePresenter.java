package com.oskarrek.busscheadule.presenter;

import com.oskarrek.busscheadule.interfaces.UserBusLineMVP;
import com.oskarrek.busscheadule.model.BusLine;
import com.oskarrek.busscheadule.model.Route;
import com.oskarrek.busscheadule.repository.DatabaseRepository;

import java.util.ArrayList;
import java.util.List;

public class BusLinePresenter implements UserBusLineMVP.Presenter {

    private UserBusLineMVP.View view;
    private DatabaseRepository repository;

    public BusLinePresenter(UserBusLineMVP.View view) {
        this.view = view;
        repository = DatabaseRepository.getInstance();
    }

    @Override
    public List<BusLine> searchBusLines(int busStopId) {
        List<BusLine> allLines = repository.getBusLines();

        List<BusLine> searchedLines = new ArrayList<>();
        for (BusLine busLine : allLines) {
            for (Route route : busLine.getRoutes())
                if (route.getBusStopsIds().contains(busStopId)) {
                    searchedLines.add(busLine);
                    break;
                }
        }

        if (searchedLines.isEmpty()) {
            view.showNoBusLinesFound();
        } else {
            view.showBusLinesList(searchedLines);
        }

        return searchedLines;
    }

    @Override
    public List<BusLine> searchBusLines(String lineName) {
        List<BusLine> allLines = repository.getBusLines();

        List<BusLine> searchedLines = new ArrayList<>();
        for (BusLine busLine : allLines) {
            if (busLine.getName().contains(lineName.toLowerCase())) {
                searchedLines.add(busLine);
                break;
            }
        }

        if (searchedLines.isEmpty()) {
            view.showNoBusLinesFound();
        } else {
            view.showBusLinesList(searchedLines);
        }

        return searchedLines;
    }

    @Override
    public List<BusLine> getBusLines() {
        List<BusLine> busLines = repository.getBusLines();
        view.showBusLinesList(busLines);
        return busLines;
    }

    @Override
    public BusLine getBusLineDetails(int busLineId) {
        List<BusLine> allLines = repository.getBusLines();

        for (BusLine busLine : allLines) {
            if (busLine.getId() == busLineId) {
                view.showDetails(busLine);
                return busLine;
            }
        }
        view.showNoBusLinesFound();
        return null;
    }

    @Override
    public List<BusLine> getFavoriteLines() {
        List<BusLine> allLines = repository.getBusLines();

        List<BusLine> favoriteLines = new ArrayList<>();

        for(BusLine busLine : allLines) {
            if(busLine.isFavorite()) {
                favoriteLines.add(busLine);
            }
        }
        view.showFavoriteLines(favoriteLines);
        return favoriteLines;
    }

    @Override
    public void setFavorite(int busLineId, Boolean isFavorite) {
        List<BusLine> allLines = repository.getBusLines();

        for (BusLine busLine : allLines) {
            if (busLine.getId() == busLineId) {
                busLine.setFavorite(isFavorite);
                view.showIsFavorite(busLine);
                break;
            }
        }
    }

}