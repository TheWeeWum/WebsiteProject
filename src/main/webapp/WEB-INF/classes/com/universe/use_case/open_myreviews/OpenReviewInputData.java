package com.universe.use_case.open_myreviews;

import com.universe.entity.review.Review;

public class OpenReviewInputData {

    private final int userID;

    public OpenReviewInputData(int userID) {this.userID = userID;}

    public int getUserID() {return userID;}

}
