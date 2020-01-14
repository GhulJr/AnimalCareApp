package com.oskarrek.busscheadule;
import com.oskarrek.busscheadule.model.Schedule;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.experimental.categories.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Category({TestEntity.class})
public class ScheduleTest {
    @Test
    public void putRowTest() {
        Schedule schedule = new Schedule("", new HashMap<Integer, List<Integer>>());
        HashMap<Integer, List<Integer>> rows = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            ArrayList<Integer> row = new ArrayList();

            for (int j = 0; j < 5; j++)
                row.add(j);

            schedule.putRow(i, row);
            rows.put(i, row);

            assertEquals(schedule.getRows(), rows);
        }
    }
}