package com.universe.app;

import com.universe.data_access.FileUserDataAccessObject;
import com.universe.data_access.UserReviewDataAccessObject;
import com.universe.entity.review.ReviewBuilder;
import com.universe.interface_adapter.user_reviews.UserReviewsController;
import com.universe.interface_adapter.user_reviews.UserReviewsPresenter;
import com.universe.use_case.open_myreviews.OpenReviewDataAccessInterface;
import com.universe.use_case.open_myreviews.OpenReviewInputBoundary;
import com.universe.use_case.open_myreviews.OpenReviewInteractor;
import com.universe.use_case.open_myreviews.OpenReviewOutputBoundary;
import com.universe.view.Reviews.UserReviewServlet;

public class UserReviewSetup {
    public static UserReviewsController setup(UserReviewServlet userReviewServlet) {
        OpenReviewOutputBoundary presenter = new UserReviewsPresenter(userReviewServlet);

        OpenReviewDataAccessInterface dataAccess = DataAccessBuilder.getUserReviewDataAccessObject();

        OpenReviewInputBoundary interactor = new OpenReviewInteractor(dataAccess, presenter);
        return new UserReviewsController(interactor);
    }
}
