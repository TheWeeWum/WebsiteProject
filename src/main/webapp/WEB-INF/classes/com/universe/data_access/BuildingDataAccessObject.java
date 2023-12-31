package com.universe.data_access;

import com.universe.entity.building.Address;
import com.universe.entity.building.Building;
import com.universe.entity.building.BuildingBuilder;
import com.universe.entity.building.Location;
import com.universe.entity.event.Event;
import com.universe.entity.event.EventBuilder;
import com.universe.entity.review.Review;
import com.google.gson.*;
import com.universe.use_case.building_reviews.BuildingReviewsDataAccessInterface;
import com.universe.use_case.display_markers.BuildingMarkerDataAccessInterface;
import com.universe.use_case.open_building.OpenBuildingDataAccessInterface;
import com.universe.use_case.open_buildings_list.OpenBuildingsListDataAccessInterface;
import com.universe.use_case.open_favourites.OpenFavouritesDataAccessInterface;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BuildingDataAccessObject implements BuildingMarkerDataAccessInterface, OpenBuildingsListDataAccessInterface, OpenBuildingDataAccessInterface, OpenFavouritesDataAccessInterface {
    private BuildingBuilder buildingBuilder = null;
    private EventBuilder eventBuilder = null;

    private final String buildingPath;
    private final String eventPath;
    private BuildingReviewsDataAccessInterface reviewDataAccessObject = null;

    private String userPath;

    private List<Building> buildings;

    public BuildingDataAccessObject(String buildingPath, String eventPath, BuildingBuilder buildingBuilder, EventBuilder eventBuilder, BuildingReviewsDataAccessInterface reviewDataAccessObject) {
        this.buildingBuilder = buildingBuilder;
        this.eventBuilder = eventBuilder;

        this.reviewDataAccessObject = reviewDataAccessObject;

        this.buildingPath = buildingPath;
        this.eventPath = eventPath;

        this.buildings = new ArrayList<>();
    }

    public BuildingDataAccessObject(String buildingPath, String eventPath, BuildingBuilder buildingBuilder, EventBuilder eventBuilder) {
        this.buildingBuilder = buildingBuilder;
        this.eventBuilder = eventBuilder;

        this.buildingPath = buildingPath;
        this.eventPath = eventPath;

        this.buildings = new ArrayList<>();
    }

    private void getBuildingsHelper() {
        try {
            JsonObject baseJsonObj1 = JsonParser.parseReader(new FileReader(buildingPath)).getAsJsonObject();
            JsonArray buildingArr = baseJsonObj1.getAsJsonArray("buildings");

            JsonObject jsonEvents = JsonParser.parseReader(new FileReader(eventPath)).getAsJsonObject();

            for (JsonElement temp : buildingArr) {
                JsonObject b = temp.getAsJsonObject();

                // get base information
                String code = b.get("code").getAsString();
                String name = b.get("name").getAsString();
                String shortName = b.get("short_name").getAsString();
                String campus = b.get("campus").getAsString();

                // get location information
                float lat = b.get("lat").getAsFloat();
                float lon = b.get("lng").getAsFloat();;
                // TODO: turn into a location builder call
                Location location = new Location(lat, lon);

                // get address information
                JsonObject jo = b.get("address").getAsJsonObject();
                String street = jo.get("street").getAsString();
                String city = jo.get("city").getAsString();
                String province = jo.get("province").getAsString();
                String country = jo.get("country").getAsString();
                String postal = jo.get("postal").getAsString();
                // TODO: turn into builder call
                Address address = new Address(street, city, province, country, postal);
                buildingBuilder.createBuilding(code, name, shortName, campus, address, new ArrayList<>(), new ArrayList<>(), location, new ArrayList<>());

                // get events information
                List<Event> events = new ArrayList<>();
                try {
                    JsonArray eventsInBuilding = jsonEvents.get(code).getAsJsonObject().get("events").getAsJsonArray();
                    for (JsonElement eventElement : eventsInBuilding) {
                        JsonObject eo = eventElement.getAsJsonObject();
                        String ename = eo.get("name").getAsString();
                        String organizer = eo.get("organizer").getAsString();
                        String dateStr = eo.get("date").getAsString();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        Date date = sdf.parse(dateStr);
                        eventBuilder.createEvent(ename, organizer, date);
                        eventBuilder.setLocation(buildingBuilder.getBuilding());
                        events.add(eventBuilder.getEvent());
                    }
                } catch (NullPointerException e) {
                    // event list was hopefully empty
                }

                if (reviewDataAccessObject != null) {
                    List<Review> reviews = reviewDataAccessObject.getReviews(code);
                    buildingBuilder.setReviews(reviews);
                } else {
                    buildingBuilder.setReviews(new ArrayList<>());
                }
                buildingBuilder.setEvents(events);
                Building building = buildingBuilder.getBuilding();

                // add finished building to list
                buildings.add(building);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public List<Building> getBuildings() {
        // Note: The reason its in a helper was because an old version of this code
        // could return either a list of buildings or a list of markers (removed).
        // So the helper allowed the duplicate code of both to be combined.
        // But then we realized that the code was just the same and the building
        // class contained everything we needed anyways.
        getBuildingsHelper();
        return buildings;
    }

    // adding to get individual buildings for profile class
    public Building getBuilding(String buildingCode) {
        List<Building> buildings = getBuildings();

        // Find the building with the specified code
        for (Building building : buildings) {
            if (building.getCode().equals(buildingCode)) {
                return building;
            }
        }

        // Return null if the building with the given code is not found
        return null;
    }

    @Override
    public List<Building> getFavouriteBuildings(int userId) {
        List<Building> favouriteBuildings = new ArrayList<>();

        try {
            JsonObject jsonUser = JsonParser.parseReader(new FileReader(userPath)).getAsJsonObject().get(String.format("%d", userId)).getAsJsonObject();
            JsonArray favouriteBuildingsJsonArray = jsonUser.get("favouriteBuildings").getAsJsonArray();

            for (JsonElement temp : favouriteBuildingsJsonArray) {
                String b = temp.toString();
                b = b.substring(1, b.length()-1);

                Building currBuilding = getBuilding(b);
                favouriteBuildings.add(currBuilding);

                System.out.println(currBuilding);

                System.out.println(favouriteBuildings);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not find file in BuildingDAO getFavouriteBuildings");
        }
        return favouriteBuildings;
    }
}
