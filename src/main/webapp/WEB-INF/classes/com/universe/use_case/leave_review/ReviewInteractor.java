package com.universe.use_case.leave_review;

import com.universe.entity.review.Review;
import com.universe.entity.review.ReviewBuilder;
import com.universe.entity.user.Guest;
import com.universe.entity.user.LoggedInUser;
import com.universe.use_case.building_reviews.BuildingReviewsDataAccessInterface;

public class ReviewInteractor implements ReviewInputBoundary{
    final ReviewOutputBoundary presenter;
    final ReviewDataAccessInterface userDataAccessObject;
    final BuildingReviewsDataAccessInterface buildingReviewsDataAccessObject;
    public ReviewInteractor(ReviewOutputBoundary presenter, ReviewDataAccessInterface userDataAccessObject, BuildingReviewsDataAccessInterface buildingReviewsDataAccessObject) {
        this.presenter = presenter;
        this.userDataAccessObject = userDataAccessObject;
        this.buildingReviewsDataAccessObject = buildingReviewsDataAccessObject;
    }

    @Override
    public void execute(ReviewInputData reviewInputData) {
        ReviewBuilder reviewFactory = new ReviewBuilder();

        if (reviewInputData.getUserId() == -1) {
             Guest guest = new Guest();
             Review review = reviewFactory.create(guest.getId(), guest.getUsername(), reviewInputData.getDateTime(), reviewInputData.getTitle(),
                     reviewInputData.getReviewContent(), reviewInputData.getRating());
             buildingReviewsDataAccessObject.saveReview(review, reviewInputData.getBuildingCode());
        }
        else
        {
            // If we are here, that means that the user is logged in, and the review will for sure be entered into the json file.
            LoggedInUser user = userDataAccessObject.findUser(reviewInputData.getUserId());

            Review review = reviewFactory.create(user.getId(), user.getUsername(), reviewInputData.getDateTime(), reviewInputData.getTitle(),
                    reviewInputData.getReviewContent(), reviewInputData.getRating());
            userDataAccessObject.saveReview(review);
            buildingReviewsDataAccessObject.saveReview(review, reviewInputData.getBuildingCode());
        }

        ReviewOutputData outputData = new ReviewOutputData("The review has been saved.");
        presenter.prepareSuccessView(outputData);
    }
}
