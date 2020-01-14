package com.oskarrek.busscheadule;

import com.oskarrek.busscheadule.model.Route;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.experimental.categories.Category;

import java.util.ArrayList;

@Category({TestEntity.class})
public class RouteTest {

    @Test
    public void addBusStopIdTest() {
        Route route = new Route(0, new ArrayList<Integer>());
        ArrayList<Integer> busStopIds = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            busStopIds.add(i);
            route.addBusStopId(i);
            assertEquals(route.getBusStopsIds(), busStopIds);
        }

        route.addBusStopId(1);

        busStopIds.clear();
        busStopIds.add(0);
        busStopIds.add(2);
        busStopIds.add(3);
        busStopIds.add(1);

        assertEquals(route.getBusStopsIds(), busStopIds);
    }
}
