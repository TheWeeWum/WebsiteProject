package com.universe.view.Building;

import com.universe.app.ReviewSetup;
import com.universe.interface_adapter.leave_review.ReviewController;

import com.universe.app.AddEventSetup;
import com.universe.app.AddToFavouritesSetup;
import com.universe.interface_adapter.add_to_favourites.AddToFavouritesController;
import com.universe.interface_adapter.event.AddEventController;
import com.universe.use_case.add_event.AddEventOutputData;
import com.universe.use_case.add_to_favourites.AddToFavouritesOutputData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BuildingPageServlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        String buildingCode = request.getParameter("buildingCode");

        session.setAttribute("buildingCode", buildingCode);

        response.sendRedirect("building.jsp");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.request = request;
        this.response = response;
        try {
            request.setAttribute("buildingCode", session.getAttribute("buildingCode"));
            request.setAttribute("id", session.getAttribute("id"));
        } catch (NullPointerException e) {
            System.out.println("user not signed in or refreshed");
            response.sendRedirect("index.jsp");
            return;
        }

        ReviewController controller = ReviewSetup.setup(this);
        controller.execute(request);
    }

    public void updateAfterReview(String message) throws IOException, ServletException {
        request.setAttribute("ReviewMessage", message);
        try {
            request.getRequestDispatcher("building.jsp").forward(request, response);
        } catch (NullPointerException e) {
            System.out.println("getRequestDispatcher was null, test case worked!");
        }
    }
}
