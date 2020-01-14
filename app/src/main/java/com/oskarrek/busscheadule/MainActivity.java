package com.oskarrek.busscheadule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.oskarrek.busscheadule.interfaces.UserBusLineMVP;
import com.oskarrek.busscheadule.model.BusLine;

import java.util.List;

public class MainActivity extends AppCompatActivity
implements UserBusLineMVP.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

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
}
