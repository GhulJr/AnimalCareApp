package com.oskarrek.busscheadule.interfaces;

import com.oskarrek.busscheadule.model.BusLine;
import com.oskarrek.busscheadule.model.BusStop;
import com.oskarrek.busscheadule.model.Route;
import com.oskarrek.busscheadule.model.Schedule;
import com.oskarrek.busscheadule.model.TimeTable;

import java.util.List;

public interface AdministrateBusStopMVP {
    interface View {
        void showBusStop(BusStop busStop);
        void showTimeTable(TimeTable timeTable);
        void acceptChanges();
        void discardChanges();
        void updateChanges(BusStop busStop);
        void showError(String errorMessage);
    }

    interface Presenter {
        void setBusStopAddress(String address);
        void addTimeTable(TimeTable timeTable);
        void deleteTimeTable(TimeTable timeTable);
        void setTimeTableLine(int timeTableId, int busLineId);
        void addSchedule(int timeTableId, Schedule schedule);
        void setScheduleName(int timeTableId, int scheduleId, String name);
        void deleteSchedule(int timeTableId, int scheduleId);
        void putRowToSchedule(int timeTableId, int scheduleId, int hour, List<Integer> minutes);
        boolean isModified();
        boolean isEmpty();
        void createBusStop();
        void modifyBusStop();
        void deleteBusStop();
    }
}
