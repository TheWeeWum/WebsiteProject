package com.universe.interface_adapter.building_reviews;

import com.universe.use_case.building_reviews.BuildingReviewsOutputBoundary;
import com.universe.use_case.building_reviews.BuildingReviewsOutputData;
import com.universe.view.Events.BuildingEventsServlet;
import com.universe.view.Reviews.BuildingReviewsServlet;

public class BuildingReviewsPresenter implements BuildingReviewsOutputBoundary {
    BuildingReviewsServlet buildingReviewsServlet;

    public BuildingReviewsPresenter(BuildingReviewsServlet buildingReviewsServlet) {
        this.buildingReviewsServlet = buildingReviewsServlet;
    }

    @Override
    public void prepareSuccessView(BuildingReviewsOutputData buildingReviewsOutputData) {
        buildingReviewsServlet.displayReviews(buildingReviewsOutputData);
    }
}
