package com.universe.interface_adapter.marker;

import com.universe.use_case.display_markers.MarkerOutputBoundary;
import com.universe.use_case.display_markers.MarkerOutputData;
import com.universe.view.MainMap.MarkerServlet;

public class MarkerPresenter implements MarkerOutputBoundary {
    MarkerServlet markerServlet;

    public MarkerPresenter(MarkerServlet markerServlet) {
        this.markerServlet = markerServlet;
    }

    @Override
    public void execute(MarkerOutputData outputData) {
        System.out.println("MarkerPresenter");
        markerServlet.writeMarkers(outputData);
    }
}
