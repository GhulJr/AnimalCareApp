package com.oskarrek.busscheadule.interfaces;

import com.oskarrek.busscheadule.model.BusLine;

import java.util.List;

public interface UserBusLineMVP {
    interface View {
        void showDetails(BusLine busLine);
        void showBusLinesList(List<BusLine> searchedLines);
        void showNoBusLinesFound();
        void showIsFavorite(BusLine busLine);
        void showFavoriteLines(List<BusLine> favoriteLines);
    }

    interface Presenter {
        List<BusLine> searchBusLines(int BusLineId);
        List<BusLine> searchBusLines(String lineName);
        List<BusLine> getBusLines();
        BusLine getBusLineDetails(int busLineId);
        List<BusLine> getFavoriteLines();
        void setFavorite(int busLineId, Boolean isFavorite);
    }
}
