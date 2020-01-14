package com.oskarrek.busscheadule;

import com.oskarrek.busscheadule.model.BusLine;
import com.oskarrek.busscheadule.model.Route;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Category({TestEntity.class})
@RunWith(Parameterized.class)
public class BusLineTest {
    BusLine busLine;

    @Parameterized.Parameter(value = 0)
    public String name;
    @Parameterized.Parameter(value = 1)
    public ArrayList<Route> routes;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{"", null}, {"A", null}, {"B", new ArrayList<Route>()}});
    }

    @Before
    public void SetUp() {
        busLine = new BusLine();
    }

    @Test
    public void constructorTest() {
        busLine = new BusLine(name, routes);
        assertEquals(busLine.getName(), name);
        assertFalse(busLine.isFavorite());
        assertNotNull(busLine.getRoutes());
    }

    @Test
    public void isFavoriteTest() {
        busLine.setFavorite(true);
        assertTrue(busLine.isFavorite());
        busLine.setFavorite(false);
        assertFalse(busLine.isFavorite());
    }
}
