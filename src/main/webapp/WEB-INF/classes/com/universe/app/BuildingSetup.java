package com.universe.app;

import com.universe.data_access.BuildingDataAccessObject;
import com.universe.data_access.BuildingReviewDataAccessObject;
import com.universe.data_access.FileUserDataAccessObject;
import com.universe.entity.building.BuildingBuilder;
import com.universe.entity.event.EventBuilder;
import com.universe.entity.review.ReviewBuilder;
import com.universe.interface_adapter.open_building.OpenBuildingController;
import com.universe.interface_adapter.open_building.OpenBuildingPresenter;
import com.universe.use_case.building_reviews.BuildingReviewsDataAccessInterface;
import com.universe.use_case.open_building.OpenBuildingDataAccessInterface;
import com.universe.use_case.open_building.OpenBuildingInputBoundary;
import com.universe.use_case.open_building.OpenBuildingInteractor;
import com.universe.use_case.open_building.OpenBuildingOutputBoundary;
import com.universe.view.Building.BuildingInfoServlet;

public class BuildingSetup {
    public static OpenBuildingController setup(BuildingInfoServlet buildingInfoServlet) {
        OpenBuildingOutputBoundary presenter = new OpenBuildingPresenter(buildingInfoServlet);

        OpenBuildingDataAccessInterface dataAccess = DataAccessBuilder.getBuildingDataAccessObject();

        OpenBuildingInputBoundary interactor = new OpenBuildingInteractor(dataAccess, presenter);
        return new OpenBuildingController(interactor);
    }
}
