package com.oskarrek.busscheadule;

import com.oskarrek.busscheadule.interfaces.AdministrateBusLineMVP;
import com.oskarrek.busscheadule.model.BusLine;
import com.oskarrek.busscheadule.model.BusStop;
import com.oskarrek.busscheadule.model.Route;
import com.oskarrek.busscheadule.presenter.AdministrateBusLinePresenter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import mockit.Verifications;
import mockit.VerificationsInOrder;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class AdministrateBusLinePresenterTest {

    @Injectable
    AdministrateBusLineMVP.View view = new ViewPlaceholder();

    @Mocked
    BusLine busLine;

    @Injectable
    Route route1, route2, route3, route4;

    @Injectable
    List<Integer> stopsIds1 = new ArrayList<>(Arrays.asList(1,25,34,56,79));
    List<Integer> stopsIds2 = new ArrayList<>(Arrays.asList(1,2,25,5,7));
    List<Integer> stopsResult1 = new ArrayList<>( Arrays.asList(1,25,56,79));
    List<Integer> stopsResult2 = new ArrayList<>( Arrays.asList(2,5,7));

    @Tested
    AdministrateBusLinePresenter presenter;

    @Test
    public void removeBusLineToRoute() {
        final List<Route> routes = Arrays.asList(route1, route2, route3, route4);
        //final List<Intege> expectedResult = Arrays.asList(route2, route3);


        new Expectations() {{
                busLine.getRoutes(); result = routes;
                route1.getId(); result = 0;
                route1.getBusStopsIds(); result = stopsIds1;
                route2.getId(); result = 1;
                route2.getBusStopsIds(); result = stopsIds2;

            }};

        presenter.deleteStopToRoute(0, 34);
        presenter.deleteStopToRoute(1, 1);
        presenter.deleteStopToRoute(1, 25);

        Assert.assertEquals(stopsResult1, busLine.getRoutes().get(0).getBusStopsIds());
        Assert.assertEquals(stopsResult2, busLine.getRoutes().get(1).getBusStopsIds());

        new VerificationsInOrder() {{
            busLine.getRoutes(); times = 1;
            route1.getId(); times = 1;
            route1.getBusStopsIds(); times = 1;
            route2.getId(); times = 1;
            route2.getBusStopsIds(); times = 1;
        }};

    }

}
