package com.oskarrek.busscheadule.interfaces;

import com.oskarrek.busscheadule.model.BusLine;
import com.oskarrek.busscheadule.model.BusStop;

import java.util.List;

public interface UserBusStopMVP {
    interface View {
        void showDetails(BusStop busStop);
        void showBusStopsList(List<BusStop> searchedStops);
        void showNoBusStopsFound();
        void showIsFavorite(BusStop busStop);
        void showFavoriteStops(List<BusStop> favoriteStops);
    }

    interface Presenter {
        List<BusStop> searchBusStops(int busLineId);
        List<BusStop> searchBusStops(String stopName);
        List<BusStop> getBusStops();
        BusStop getBusStopDetails(int busStopId);
        List<BusStop> getFavoriteStops();
        void setFavorite(int busStopId, Boolean isFavorite);
    }
}
