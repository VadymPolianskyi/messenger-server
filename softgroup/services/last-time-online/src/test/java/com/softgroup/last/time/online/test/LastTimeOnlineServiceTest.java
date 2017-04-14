package com.softgroup.last.time.online.test;

import com.softgroup.last.time.online.service.LastTimeOnlineService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: vadym_polyanski
 * Date: 14.04.17
 * Time: 13:42
 */
@RunWith(MockitoJUnitRunner.class)
public class LastTimeOnlineServiceTest {

    @InjectMocks
    private LastTimeOnlineService lastTimeOnlineService;

    @Spy
    private HashMap<String, Long> lastTimeOnlineMap;

    @Before
    public void init() {
        lastTimeOnlineMap.put("firstId", 00000001L);
        lastTimeOnlineMap.put("secondId", 00000002L);
    }

    @Test
    public void testPutLastTimeOnline() {
        lastTimeOnlineService.putLastTimeOnline("thirdId");
    }

    @Test
    public void testPutNullLastTimeOnline() {
        lastTimeOnlineService.putLastTimeOnline(null);
    }

    @Test
    public void testGetLastTimeOnline() {
        assertThat(lastTimeOnlineService.getLastTimeOnline("firstId"),
                        is(00000001L));
    }

    @Test
    public void testGetNullLastTimeOnline() {
        assertThat(lastTimeOnlineService.getLastTimeOnline(""), nullValue());
    }

    @Test
    public void testGetLastTimesOnline() {
        assertThat(lastTimeOnlineService.getLastTimeOnline(Arrays.asList("firstId", "secondId")),
                        is(Arrays.asList(00000001L, 00000002L)));
    }

    @Test
    public void testGetNullLastTimesOnline() {
        assertThat(lastTimeOnlineService.getLastTimeOnline(Arrays.asList(null, null)),
                is(Arrays.asList(null, null)));
    }
}
