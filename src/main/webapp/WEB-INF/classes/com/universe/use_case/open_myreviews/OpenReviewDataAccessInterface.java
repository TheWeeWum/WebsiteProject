package com.universe.use_case.open_myreviews;

import com.universe.entity.review.Review;

import java.util.List;

public interface OpenReviewDataAccessInterface {
    public List<Review> getReviews(int userID);

}
