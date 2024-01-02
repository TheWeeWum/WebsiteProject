package com.universe.use_case.open_favourites;

import com.universe.use_case.open_buildings_list.OpenBuildingsListOutputData;

public interface OpenFavouritesOutputBoundary {
    void execute(OpenFavouritesOutputData favouriteBuildings);

}
