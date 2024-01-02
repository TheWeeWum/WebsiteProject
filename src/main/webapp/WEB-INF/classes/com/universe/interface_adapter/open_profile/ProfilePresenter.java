package com.universe.interface_adapter.open_profile;

import com.universe.use_case.open_profile.ProfileOutputBoundary;
import com.universe.use_case.open_profile.ProfileOutputData;
import com.universe.view.User.UserProfileServlet;


public class ProfilePresenter implements ProfileOutputBoundary {
    UserProfileServlet userProfileServlet;

    public ProfilePresenter(UserProfileServlet userProfileServlet) {

        this.userProfileServlet = userProfileServlet;
    }


    @Override
    public void prepareSuccessView(ProfileOutputData userOutputData) {
        System.out.println("ProfilePresenter");
        userProfileServlet.writeProfile(userOutputData);
    }

}
