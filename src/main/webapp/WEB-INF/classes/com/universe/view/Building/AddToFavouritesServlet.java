package com.universe.view.Building;

import com.universe.app.AddToFavouritesSetup;
import com.universe.app.BuildingSetup;
import com.universe.interface_adapter.add_to_favourites.AddToFavouritesController;
import com.universe.interface_adapter.open_building.OpenBuildingController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddToFavouritesServlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId;
        String buildingCode;
        try {
            userId = Integer.parseInt(session.getAttribute("id").toString());
            buildingCode = session.getAttribute("buildingCode").toString();
        } catch (NullPointerException e) {
            System.out.println("user not signed in");
            response.sendRedirect("universe/index.jsp");
            return;
        }

        // save the request and response for use later in
        this.request = request;
        this.response = response;
        // Initialize the loop for the use_case
        AddToFavouritesController controller = AddToFavouritesSetup.setup(this);

        // call the controller passing it the inputs
        controller.execute(userId, buildingCode);
    }
}
