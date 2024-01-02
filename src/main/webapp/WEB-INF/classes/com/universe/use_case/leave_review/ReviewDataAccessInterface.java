package com.universe.use_case.leave_review;

import com.universe.entity.review.Review;
import com.universe.entity.user.LoggedInUser;
import com.universe.entity.user.User;

public interface ReviewDataAccessInterface {
    void saveReview(Review reviewInputData);
    LoggedInUser findUser(int userId);
}
