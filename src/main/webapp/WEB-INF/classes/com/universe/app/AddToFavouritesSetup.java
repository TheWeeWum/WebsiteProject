package com.universe.app;

import com.universe.data_access.AddToFavouritesDataAccessObject;
import com.universe.entity.building.BuildingBuilder;
import com.universe.entity.user.CommonUserFactory;
import com.universe.entity.user.UserFactory;
import com.universe.interface_adapter.add_to_favourites.AddToFavouritesController;

import com.universe.use_case.add_to_favourites.AddToFavouritesDataAccessInterface;
import com.universe.use_case.add_to_favourites.AddToFavouritesInputBoundary;
import com.universe.use_case.add_to_favourites.AddToFavouritesInteractor;

import com.universe.view.Building.AddToFavouritesServlet;

public class AddToFavouritesSetup {

    public static AddToFavouritesController setup(AddToFavouritesServlet buildingPageServlet) {
        AddToFavouritesDataAccessInterface dataAccess = DataAccessBuilder.getAddToFavouritesDataAccessObject();

        AddToFavouritesInputBoundary interactor = new AddToFavouritesInteractor(dataAccess);
        return new AddToFavouritesController(interactor);
    }
}
