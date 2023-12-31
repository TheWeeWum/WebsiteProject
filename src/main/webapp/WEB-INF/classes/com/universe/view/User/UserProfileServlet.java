package com.universe.view.User;

import com.universe.app.ProfileSetup;
import com.universe.entity.Reviewable;
import com.universe.entity.building.Building;
import com.universe.entity.review.Review;
import com.universe.entity.room.Room;
import com.universe.entity.user.LoggedInUser;
import com.universe.entity.user.User;
import com.universe.interface_adapter.open_profile.ProfileController;
import com.universe.use_case.open_profile.ProfileInteractor;
import com.universe.use_case.open_profile.ProfileOutputData;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserProfileServlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Perform data retrieval or processing here
        HttpSession session = request.getSession();
        this.request = request;
        this.response = response;

        int id;
        try {
            id = Integer.parseInt(session.getAttribute("id").toString());
        } catch (NullPointerException e) {
            System.out.println("user not signed in");
            response.sendRedirect("index.jsp");
            return;
        }

        ProfileController controller = ProfileSetup.setup(this);
        controller.execute(id);
    }


    public void writeProfile(ProfileOutputData profileOutputData) {
        LoggedInUser user = profileOutputData.getUser();
        // Prepare JSON for reviews
        StringBuilder reviewsJson = new StringBuilder("[");

        for (Review review : profileOutputData.getReviews()) {
            String title = review.getTitle();
            String content = review.getContent();
            float rating = review.getRating();
            String date = review.getDate().toString();

            reviewsJson.append(String.format("{\"username\": \"%s\", " + "\"title\": \"%s\", " + "\"content\": \"%s\", \"date\": \"%s\", " + "\"rating\": %f " + "},",
                    user.getUsername(), title, content, date, rating));
        }
        if (!profileOutputData.getReviews().isEmpty()) {
            // delete comma at the end
            reviewsJson.delete(reviewsJson.length() - 1, reviewsJson.length());
        }
        reviewsJson.append("]");

        // Prepare JSON for favorites
        StringBuilder favoritesJson = new StringBuilder("[");

        for (Reviewable favorite : profileOutputData.getFavourites()) {
            if (favorite instanceof Building) {
                Building building = (Building) favorite;
                String name = building.getName();
                String code = building.getCode();

                favoritesJson.append(String.format("{ " + "\"name\": \"%s\", " + "\"code\": \"%s\" " + "},", name, code));
            } else if (favorite instanceof Room) {
                Room room = (Room) favorite;
                String roomNumber = room.getRoomNumber();
                String code = room.getFloor();

                favoritesJson.append(String.format("{ " + "\"name\": \"%s\", " + "\"code\": \"%s\" " + "},", roomNumber, code));
            }
            // Add more conditions for other types if necessary
        }
        if (!profileOutputData.getFavourites().isEmpty()) {
            // delete comma at the end
            favoritesJson.delete(favoritesJson.length() - 1, favoritesJson.length());
        }
        favoritesJson.append("]");

        // Print or write JSON for reviews and favorites as needed
        System.out.println("Reviews JSON: " + reviewsJson);
        System.out.println("Favorites JSON: " + favoritesJson);;

        String username = profileOutputData.getUser().getUsername();

//        LoggedInUser user = profileOutputData.getUser();
//        String userProfileJson = user.getJsonRepresentation();
//
//        System.out.println("got json representation");
//        System.out.println(userProfileJson);

        try {
            // Set content type and write JSON response
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print("{\"username\": \"" + username + "\", \"reviews\": " + reviewsJson + ", \"favorites\": " + favoritesJson + "}");
//            out.print(userProfileJson);
            out.flush();
        } catch (IOException e) {
            System.out.println("Could not write profile data");
        }
    }
}
