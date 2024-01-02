package com.universe.interface_adapter.user_reviews;

import com.universe.use_case.building_reviews.BuildingReviewsInputBoundary;
import com.universe.use_case.building_reviews.BuildingReviewsInputData;
import com.universe.use_case.open_myreviews.OpenReviewInputBoundary;
import com.universe.use_case.open_myreviews.OpenReviewInputData;
import com.universe.view.Reviews.UserReviewServlet;

public class UserReviewsController {
    OpenReviewInputBoundary userReviewsInteractor;
    public UserReviewsController(OpenReviewInputBoundary userReviewsInteractor) {
        this.userReviewsInteractor = userReviewsInteractor;
    }


    public void execute(int userID) {
        System.out.println("URC");
        OpenReviewInputData openReviewInputData = new OpenReviewInputData(userID);
        userReviewsInteractor.execute(openReviewInputData);
    }
}
