package com.universe.use_case.open_profile;

import com.universe.entity.Reviewable;
import com.universe.entity.building.Building;
import com.universe.entity.review.Review;
import com.universe.entity.room.Room;
import com.universe.entity.user.LoggedInUser;
import com.universe.entity.user.User;

import java.util.List;

public class ProfileOutputData {
     final  LoggedInUser user;
     final List<Review> reviews;
     final List<Reviewable> favourites;
     final List<Building> favouriteBuildings;
     final List<Room> favouriteRooms;

    public ProfileOutputData(LoggedInUser user) {
        this.user = user;
        this.reviews = user.getReviews();
        this.favouriteBuildings = user.getFavouriteBuildings();
        this.favouriteRooms = user.getFavouriteRooms();
        this.favourites = user.getFavourites(this.favouriteBuildings, this.favouriteRooms);
    }
    public LoggedInUser getUser() {return user;}

    public List<Review> getReviews() {return reviews;};
    public List<Reviewable> getFavourites() {return favourites;};
    public List<Building> getFavouriteBuildings() {return favouriteBuildings;};
    public List<Room> getFavouriteRooms(){return favouriteRooms;}
}