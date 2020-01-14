package com.oskarrek.busscheadule;

import com.oskarrek.busscheadule.model.BusLine;
import com.oskarrek.busscheadule.presenter.BusLinePresenter;
import com.oskarrek.busscheadule.repository.DatabaseRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@Category({TestControl.class, TestEntity.class})
@RunWith(Parameterized.class)
public class BusLinePresenterTest {
    static BusLinePresenter presenter;
    static DatabaseRepository repository;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Parameterized.Parameter
    public String busLineName;

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[]{"a", "b", "c", null});
    }

    @BeforeClass
    public static void SetUp() {
        repository = DatabaseRepository.getInstance();
        presenter = new BusLinePresenter(new ViewPlaceholder());

        BusLine busLine1 = new BusLine("a",  null);
        busLine1.setFavorite(true);

        repository.addBusLine(busLine1);
        repository.addBusLine(new BusLine("b",  null));
        repository.addBusLine(new BusLine("c",  null));


    }

    @Test
    public void searchBusLinesTest() {
        List<BusLine> found;
        if (busLineName == null) {
            exception.expect(NullPointerException.class);
            found = presenter.searchBusLines(busLineName);
        }
        else {
            found = presenter.searchBusLines(busLineName);
            assertEquals(found.get(0).getName(), busLineName);
        }
    }

    @Test
    public void getFavoritesLinesTest() {
        List<BusLine> result = presenter.getFavoriteLines();
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("a", result.get(0).getName());
    }
}
