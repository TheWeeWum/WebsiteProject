package com.universe.app;

import com.universe.data_access.*;
import com.universe.entity.building.BuildingBuilder;
import com.universe.entity.event.EventBuilder;
import com.universe.entity.review.ReviewBuilder;
import com.universe.interface_adapter.open_profile.ProfileController;
import com.universe.interface_adapter.open_profile.ProfilePresenter;
import com.universe.use_case.building_reviews.BuildingReviewsDataAccessInterface;
import com.universe.use_case.open_profile.ProfileInputBoundary;
import com.universe.use_case.open_profile.ProfileInteractor;
import com.universe.use_case.open_profile.ProfileOutputBoundary;
import com.universe.use_case.open_profile.ProfileUserDataAccessInterface;
import com.universe.view.User.UserProfileServlet;

public class ProfileSetup {

    public static ProfileController setup(UserProfileServlet userProfileServlet) {
        ProfileOutputBoundary presenter = new ProfilePresenter(userProfileServlet);

        ProfileUserDataAccessInterface dataAccess = DataAccessBuilder.getProfileDataAccessObject();

        ProfileInputBoundary interactor = new ProfileInteractor(dataAccess, presenter, DataAccessBuilder.getFileUserDataAccessObject());
        return new ProfileController(interactor);
    }
}
