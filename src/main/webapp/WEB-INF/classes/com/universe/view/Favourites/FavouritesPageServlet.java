package com.universe.view.Favourites;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FavouritesPageServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        int id;
        try {
            id = Integer.parseInt(session.getAttribute("id").toString());
        } catch (NullPointerException e) {
            System.out.println("user not signed in");
            response.sendRedirect("index.jsp");
            return;
        }

        session.setAttribute("id", id);

        response.sendRedirect("favourites.jsp");
    }
}
