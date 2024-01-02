package com.universe.use_case.open_profile;
import com.universe.entity.Reviewable;
import com.universe.entity.building.Building;
import com.universe.entity.room.Room;
import com.universe.entity.user.LoggedInUser;
import com.universe.entity.user.User;

import java.util.List;


public interface ProfileUserDataAccessInterface {
    LoggedInUser getUser(int userID);

    String getUsername(int userID);
    List<Reviewable> getFavourites(int userID);

    List<Building> getFavouriteBuildings(int userID);

    List<Room> getFavouriteRooms(int userID);
}
