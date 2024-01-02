package com.universe.app;

import com.universe.data_access.BuildingDataAccessObject;
import com.universe.data_access.BuildingReviewDataAccessObject;
import com.universe.data_access.FileUserDataAccessObject;
import com.universe.entity.building.BuildingBuilder;
import com.universe.entity.event.EventBuilder;
import com.universe.entity.review.ReviewBuilder;
import com.universe.interface_adapter.marker.MarkerController;
import com.universe.interface_adapter.marker.MarkerPresenter;
import com.universe.use_case.building_reviews.BuildingReviewsDataAccessInterface;
import com.universe.use_case.display_markers.BuildingMarkerDataAccessInterface;
import com.universe.use_case.display_markers.MarkerInputBoundary;
import com.universe.use_case.display_markers.MarkerInteractor;
import com.universe.use_case.display_markers.MarkerOutputBoundary;
import com.universe.view.MainMap.MarkerServlet;

public class MarkerSetup {
    public static MarkerController setup(MarkerServlet markerServlet) {
        MarkerOutputBoundary presenter = new MarkerPresenter(markerServlet);

        BuildingMarkerDataAccessInterface dataAccess = DataAccessBuilder.getBuildingDataAccessObject();

        MarkerInputBoundary interactor = new MarkerInteractor(presenter, dataAccess);
        return new MarkerController(interactor);
    }
}
