package com.universe.entity.building;

import com.universe.entity.event.Event;
import com.universe.entity.review.Review;
import com.universe.entity.room.Room;

import java.util.List;

public class BuildingBuilder {
    private Building building;

    public void createBuilding(String code, String name, String shortname, String campus, Address address, List<Room> rooms, List<String> floor, Location location, List<Review> reviews) {
        this.building = new Building(code, name, shortname, campus, address, rooms, floor, location, reviews);
    }

    public void setEvents(List<Event> events) {
        building.setEvents(events);
    }

    public void setReviews(List<Review> reviews) {
        building.setReviews(reviews);
    }

    public Building getBuilding() {
        return building;
    }
}
