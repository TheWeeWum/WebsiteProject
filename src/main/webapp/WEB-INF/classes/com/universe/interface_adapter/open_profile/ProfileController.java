package com.universe.interface_adapter.open_profile;

import com.universe.use_case.open_profile.ProfileInputBoundary;

public class ProfileController {

    final ProfileInputBoundary openProfileUseCaseInteractor;

    public ProfileController(ProfileInputBoundary openProfileUseCaseInteractor) {
        this.openProfileUseCaseInteractor = openProfileUseCaseInteractor;
    }


    public void execute(int userId) {
        System.out.println("ProfileController");
        openProfileUseCaseInteractor.execute(userId);
    }
}
