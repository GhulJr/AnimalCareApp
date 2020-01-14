package com.oskarrek.busscheadule;

import com.oskarrek.busscheadule.interfaces.UserBusStopMVP;
import com.oskarrek.busscheadule.model.BusLine;
import com.oskarrek.busscheadule.model.BusStop;
import com.oskarrek.busscheadule.presenter.BusStopPresenter;
import com.oskarrek.busscheadule.repository.DatabaseRepository;

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
public class BusStopPresenterMockTest {

    @Injectable
    UserBusStopMVP.View view = new ViewPlaceholder();

    @Injectable
    String address1, address2, address3, address4, address5;

    @Injectable
    BusStop busStop1, busStop2, busStop3, busStop4, busStop5;

    @Injectable
    DatabaseRepository repository;

    @Tested
    BusStopPresenter presenter = new BusStopPresenter(view);


    @Test
    public void searchBusStopByAddressTest() {

        // Addresses.
        address1 = "plac grunwaldzki";
        address2 = "Plac Grunwaldzki";
        address3 = "PLAC GRUNWALDZKI";
        address4 = "Most Grunwaldzki";
        address5 = "";

        repository = DatabaseRepository.getInstance();

        final List<BusStop> busStops = Arrays.asList(busStop1, busStop2, busStop3, busStop4);
        final List<BusStop> expectedResult = Arrays.asList(busStop2, busStop3);

        new Expectations(repository) {{
            repository.getBusStops(); result = busStops;
            busStop1.getAddress(); result = anyString;
            busStop2.getAddress(); result = address2;
            busStop3.getAddress(); result = address3;
            busStop4.getAddress(); result = address4;
        }};

        List<BusStop> result1 = presenter.searchBusStops(address3);
        List<BusStop> result2 = presenter.searchBusStops(address5);

        Assert.assertEquals(expectedResult, result1);
        Assert.assertNull(result2);

        new VerificationsInOrder() {{
            busStop1.getAddress(); times = 1;
            busStop2.getAddress(); times = 1;
            busStop3.getAddress(); times = 1;
            busStop4.getAddress(); times = 1;
        }};

    }

    @Test
    public void setFavoriteBusStopTest() {

        repository = DatabaseRepository.getInstance();
        final List<BusStop> busStops = Arrays.asList(busStop1, busStop2, busStop3, busStop4);

        new Expectations(repository) {{
            repository.getBusStops(); result = busStops;
            busStop1.getId(); result = 0;
            busStop2.getId(); result = 1;
            busStop3.getId(); result = 2;
        }};


        presenter.setFavorite(2, true);
        presenter.setFavorite(1, true);

        new Verifications() {{
            busStop1.getId(); maxTimes = 2;
            busStop2.getId(); maxTimes = 2;
            busStop3.getId(); times = 1;
            busStop4.getId(); times = 0;
        }};
    }

}
 /* // Bus stops.
        busStop1 = new BusStop();
        busStop2 = new BusStop();
        busStop2.setAddress(address2);
        busStop3 = new BusStop();
        busStop3.setAddress(address3);
        busStop4 = new BusStop();
        busStop4.setAddress(address4);*/