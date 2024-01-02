package com.universe.interface_adapter.user_reviews;

import com.universe.use_case.building_reviews.BuildingReviewsOutputData;
import com.universe.use_case.open_myreviews.OpenReviewOutputBoundary;
import com.universe.use_case.open_myreviews.OpenReviewOutputData;
import com.universe.view.Reviews.BuildingReviewsServlet;
import com.universe.view.Reviews.UserReviewServlet;

public class UserReviewsPresenter implements OpenReviewOutputBoundary {
    UserReviewServlet userReviewsServlet;

    public UserReviewsPresenter(UserReviewServlet userReviewsServlet) {
        this.userReviewsServlet = userReviewsServlet;
    }

    @Override
    public void prepareSuccessView(OpenReviewOutputData openReviewOutputData) {
        System.out.println("URP");
        userReviewsServlet.displayReviews(openReviewOutputData);
    }
}
