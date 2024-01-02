package com.universe.app;

import com.universe.data_access.BuildingDataAccessObject;
import com.universe.data_access.BuildingReviewDataAccessObject;
import com.universe.data_access.FileUserDataAccessObject;
import com.universe.entity.building.BuildingBuilder;
import com.universe.entity.event.EventBuilder;
import com.universe.entity.review.ReviewBuilder;
import com.universe.interface_adapter.open_buildings_list.OpenBuildingsListController;
import com.universe.interface_adapter.open_buildings_list.OpenBuildingsListPresenter;
import com.universe.use_case.building_reviews.BuildingReviewsDataAccessInterface;
import com.universe.use_case.open_buildings_list.OpenBuildingsListDataAccessInterface;
import com.universe.use_case.open_buildings_list.OpenBuildingsListInputBoundary;
import com.universe.use_case.open_buildings_list.OpenBuildingsListInteractor;
import com.universe.use_case.open_buildings_list.OpenBuildingsListOutputBoundary;
import com.universe.view.Buildings.BuildingsListServlet;

public class BuildingListSetup {
    public static OpenBuildingsListController setup(BuildingsListServlet buildingsListServlet) {
        OpenBuildingsListOutputBoundary presenter = new OpenBuildingsListPresenter(buildingsListServlet);

        OpenBuildingsListDataAccessInterface dataAccess = DataAccessBuilder.getBuildingDataAccessObject();

        OpenBuildingsListInputBoundary interactor = new OpenBuildingsListInteractor(dataAccess, presenter);
        return new OpenBuildingsListController(interactor);
    }
}
