package com.universe.use_case.open_favourites;

import com.universe.entity.building.Building;

import java.util.List;

public interface OpenFavouritesDataAccessInterface {
    List<Building> getFavouriteBuildings(int userId);

}
