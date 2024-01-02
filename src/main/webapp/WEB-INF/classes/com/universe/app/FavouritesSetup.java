package com.universe.app;

import com.universe.data_access.BuildingDataAccessObject;
import com.universe.entity.building.BuildingBuilder;
import com.universe.entity.event.EventBuilder;
import com.universe.interface_adapter.open_favourites.OpenFavouritesController;
import com.universe.interface_adapter.open_favourites.OpenFavouritesPresenter;
import com.universe.use_case.open_favourites.OpenFavouritesDataAccessInterface;
import com.universe.use_case.open_favourites.OpenFavouritesInputBoundary;
import com.universe.use_case.open_favourites.OpenFavouritesInteractor;
import com.universe.use_case.open_favourites.OpenFavouritesOutputBoundary;
import com.universe.view.Favourites.FavouritesInfoServlet;

public class FavouritesSetup {
    public static OpenFavouritesController setup(FavouritesInfoServlet favouritesInfoServlet) {
        OpenFavouritesOutputBoundary presenter = new OpenFavouritesPresenter(favouritesInfoServlet);

        OpenFavouritesDataAccessInterface dataAccess = DataAccessBuilder.getFileUserDataAccessObject();

        OpenFavouritesInputBoundary interactor = new OpenFavouritesInteractor(dataAccess, presenter);
        return new OpenFavouritesController(interactor);
    }
}
