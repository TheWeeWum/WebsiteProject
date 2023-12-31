package com.universe.app;

import com.universe.data_access.*;
import com.universe.entity.building.BuildingBuilder;
import com.universe.entity.event.EventBuilder;
import com.universe.entity.review.ReviewBuilder;
import com.universe.entity.user.CommonUserFactory;

public class DataAccessBuilder {
    private static String buildingReviewsPath = Path.path + "external-data/buildingreviews.json";
    private static String buildings = Path.path + "external-data/buildings.json";
    private static String events = Path.path + "external-data/events.json";
    private static String testBase = Path.path + "external-data/testBase.json";
    private static String userDataBase = Path.path + "external-data/UserDataBase.json";
    public static AddToFavouritesDataAccessObject getAddToFavouritesDataAccessObject() {
        return new AddToFavouritesDataAccessObject(buildings, new BuildingBuilder(), userDataBase, new CommonUserFactory());
    }

    public static BuildingDataAccessObject getBuildingDataAccessObject() {
        BuildingReviewDataAccessObject buidingReviewDAO = getBuildingReviewDataAccessObject();
        return new BuildingDataAccessObject(buildings, events, new BuildingBuilder(), new EventBuilder(), buidingReviewDAO);
    }

    private static BuildingDataAccessObject getBuildingDataAccessObjectNoReview() {
        return new BuildingDataAccessObject(buildings, events, new BuildingBuilder(), new EventBuilder());
    }

    public static BuildingReviewDataAccessObject getBuildingReviewDataAccessObject() {
        return new BuildingReviewDataAccessObject(buildingReviewsPath, new ReviewBuilder(), getFileUserDataAccessObject());
    }

    public static EventDataAccessObject getEventDataAccessObject() {
        return new EventDataAccessObject(events, new EventBuilder());
    }

    public static FileUserDataAccessObject getFileUserDataAccessObject() {
        return new FileUserDataAccessObject(userDataBase, getBuildingDataAccessObjectNoReview());
    }

    public static ProfileDataAccessObject getProfileDataAccessObject() {
        return new ProfileDataAccessObject(userDataBase, getFileUserDataAccessObject(), new ReviewBuilder(), getBuildingDataAccessObject());
    }

    public static UserReviewDataAccessObject getUserReviewDataAccessObject() {
        return new UserReviewDataAccessObject(userDataBase, new ReviewBuilder(), getFileUserDataAccessObject());
    }
}
