package com.oskarrek.busscheadule;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

@Categories.SuiteClasses({BusLineTest.class, RouteTest.class, ScheduleTest.class, BusLinePresenterTest.class})
@RunWith(Categories.class)
@Categories.IncludeCategory(TestControl.class)
public class TestControlSuite {

}