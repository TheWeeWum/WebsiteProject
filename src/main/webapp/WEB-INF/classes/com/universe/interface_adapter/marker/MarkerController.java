package com.universe.interface_adapter.marker;

import com.universe.use_case.display_markers.MarkerInputBoundary;

public class MarkerController {
    MarkerInputBoundary interactor;
    public MarkerController(MarkerInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute() {
        System.out.println("MarkerController");
        interactor.execute();
    }
}
