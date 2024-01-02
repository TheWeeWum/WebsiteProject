package com.universe.view.User;

import com.universe.app.ProfileSetup;
import com.universe.entity.Reviewable;
import com.universe.entity.building.Building;
import com.universe.entity.review.Review;
import com.universe.entity.room.Room;
import com.universe.entity.user.LoggedInUser;
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

public class UserProfilePageServlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Perform data retrieval or processing here
        HttpSession session = request.getSession();
        this.request = request;
        this.response = response;

        if (session.getAttribute("loggedIn") == null) {
            // If the user is not logged in, set a default message
            session.setAttribute("username", "You are not signed in");
        } else if (session.getAttribute("loggedIn").equals(false)) {
            // If the user is not logged in, set a default message
            session.setAttribute("username", "You are not signed in");
        }

        // Redirect to the profile.jsp page
        response.sendRedirect("profile.jsp");
    }
}
