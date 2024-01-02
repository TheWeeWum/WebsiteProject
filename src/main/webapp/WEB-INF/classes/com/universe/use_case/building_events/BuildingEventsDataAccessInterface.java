package com.universe.use_case.building_events;

import com.universe.entity.event.Event;

import java.util.List;

public interface BuildingEventsDataAccessInterface {
    public List<Event> getEvents(String buildingCode);
}
