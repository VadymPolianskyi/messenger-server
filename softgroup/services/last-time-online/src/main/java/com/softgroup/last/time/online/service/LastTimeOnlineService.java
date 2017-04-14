package com.softgroup.last.time.online.service;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: vadym_polyanski
 * Date: 14.04.17
 * Time: 13:27
 */
@Component
public class LastTimeOnlineService {

    private Map<String, Long> lastTimeOnlineMap = new HashMap<>();

    public void putLastTimeOnline(String profileId) {

        lastTimeOnlineMap.put(profileId, System.currentTimeMillis());
    }

    public Long getLastTimeOnline(String profileId) {
        return lastTimeOnlineMap.get(profileId);
    }

    public List<Long> getLastTimeOnline(List<String> profileIds) {
        List<Long> lastTimesOnlineList = new ArrayList<>();

        for (String profileId : profileIds) {
            lastTimesOnlineList.add(lastTimeOnlineMap.get(profileId));
        }

        return lastTimesOnlineList;
    }
}
