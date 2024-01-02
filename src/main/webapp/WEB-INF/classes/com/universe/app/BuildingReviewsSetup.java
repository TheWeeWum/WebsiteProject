package com.universe.app;


import com.universe.data_access.BuildingReviewDataAccessObject;
import com.universe.data_access.FileUserDataAccessObject;
import com.universe.entity.review.ReviewBuilder;
import com.universe.interface_adapter.building_reviews.BuildingReviewsController;
import com.universe.interface_adapter.building_reviews.BuildingReviewsPresenter;
import com.universe.use_case.building_reviews.BuildingReviewsDataAccessInterface;
import com.universe.use_case.building_reviews.BuildingReviewsInputBoundary;
import com.universe.use_case.building_reviews.BuildingReviewsInteractor;
import com.universe.use_case.building_reviews.BuildingReviewsOutputBoundary;
import com.universe.view.Reviews.BuildingReviewsServlet;

public class BuildingReviewsSetup {
    public static BuildingReviewsController setup(BuildingReviewsServlet buildingsReviewsServlet) {
        BuildingReviewsOutputBoundary presenter = new BuildingReviewsPresenter(buildingsReviewsServlet);

        BuildingReviewsDataAccessInterface dataAccess = DataAccessBuilder.getBuildingReviewDataAccessObject();

        BuildingReviewsInputBoundary interactor = new BuildingReviewsInteractor(presenter, dataAccess);
        return new BuildingReviewsController(interactor);
    }
}
