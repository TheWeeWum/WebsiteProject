package com.universe.use_case.building_reviews;

import com.universe.entity.review.Review;

import java.util.List;

public interface BuildingReviewsDataAccessInterface {
    public List<Review> getReviews(String buildingCode);

    void saveReview(Review review, String buildingCode);
}
