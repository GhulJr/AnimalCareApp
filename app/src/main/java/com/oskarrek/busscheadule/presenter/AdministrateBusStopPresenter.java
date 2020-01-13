package com.oskarrek.busscheadule.presenter;

import com.oskarrek.busscheadule.interfaces.AdministrateBusStopMVP;
import com.oskarrek.busscheadule.model.BusStop;
import com.oskarrek.busscheadule.model.Schedule;
import com.oskarrek.busscheadule.model.TimeTable;
import com.oskarrek.busscheadule.repository.DatabaseRepository;

import java.util.List;

public class AdministrateBusStopPresenter implements AdministrateBusStopMVP.Presenter {

    private AdministrateBusStopMVP.View view;
    private BusStop busStop;
    private DatabaseRepository repository;
    private boolean isModified;


    public AdministrateBusStopPresenter(AdministrateBusStopMVP.View view) {
        this.view = view;
        this.repository = DatabaseRepository.getInstance();
        this.busStop = new BusStop();
        this.isModified = false;
    }


    public AdministrateBusStopPresenter(AdministrateBusStopMVP.View view, int busStopId) {
        this.view = view;
        this.repository = DatabaseRepository.getInstance();
        this.busStop = repository.getBusStop(busStopId);
        view.showBusStop(busStop);
        this.isModified = false;
    }

    @Override
    public void setBusStopAddress(String address) {
        this.isModified = true;
        busStop.setAddress(address);
    }

    @Override
    public void addTimeTable(TimeTable timeTable) {
        this.isModified = true;
        busStop.addTimeTable(timeTable);
    }

    @Override
    public void deleteTimeTable(TimeTable timeTable) {
        this.isModified = true;
        busStop.getTimeTables().remove(timeTable);
    }

    @Override
    public void setTimeTableLine(int timeTableId, int busLineId) {
        this.isModified = true;
        for(TimeTable timeTable : busStop.getTimeTables()) {
            if(timeTable.getId() == timeTableId) {
                timeTable.setBusLineId(busLineId);
                break;
            }
        }
    }

    @Override
    public void addSchedule(int timeTableId, Schedule schedule) {
        this.isModified = true;
        for(TimeTable timeTable : busStop.getTimeTables()) {
            if(timeTable.getId() == timeTableId) {
                timeTable.addSchedule(schedule);
                break;
            }
        }
    }

    @Override
    public void setScheduleName(int timeTableId, int scheduleId, String name) {
        this.isModified = true;
        for(TimeTable timeTable : busStop.getTimeTables()) {
            if(timeTable.getId() == timeTableId) {
                for(Schedule schedule : timeTable.getSchedules()) {
                    if(schedule.getId() == scheduleId) {
                        schedule.setName(name);
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void deleteSchedule(int timeTableId, int scheduleId) {
        this.isModified = true;
        for(TimeTable timeTable : busStop.getTimeTables()) {
            if(timeTable.getId() == timeTableId) {
                for(Schedule schedule : timeTable.getSchedules()) {
                    if(schedule.getId() == scheduleId) {
                        timeTable.getSchedules().remove(schedule);
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void putRowToSchedule(int timeTableId, int scheduleId, int hour, List<Integer> minutes) {
        this.isModified = true;
        for(TimeTable timeTable : busStop.getTimeTables()) {
            if(timeTable.getId() == timeTableId) {
                for(Schedule schedule : timeTable.getSchedules()) {
                    if(schedule.getId() == scheduleId) {
                        schedule.putRow(hour, minutes);
                        return;
                    }
                }
            }
        }
    }

    @Override
    public boolean isModified() {
        return isModified;
    }

    @Override
    public boolean isEmpty() {
        return busStop.getAddress().isEmpty() || busStop.getTimeTables().isEmpty();
    }

    @Override
    public void createBusStop() {
        if(isEmpty()) {
            view.showError("Cannot add bus stop due to missing data.");
            return;
        }

        if(!repository.addBusStop(busStop)) {
            view.showError("Unable to add bus stop to database.");
        }
    }

    @Override
    public void modifyBusStop() {
        if(isEmpty()) {
            view.showError("Cannot modify bus stop due to missing data.");
            return;
        }

        if(!repository.modifyBusStop(busStop)) {
            view.showError("Unable to modify bus stop in database.");
        }
    }

    @Override
    public void deleteBusStop() {
        if(!repository.deleteBusStop(busStop)) {
            view.showError("Unable to delete bus stop from.");
        }
    }
}
