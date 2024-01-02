package com.universe.interface_adapter.event;

import com.universe.use_case.building_events.BuildingEventsOutputBoundary;
import com.universe.use_case.building_events.BuildingEventsOutputData;
import com.universe.view.Events.BuildingEventsServlet;

public class BuildingEventsPresenter implements BuildingEventsOutputBoundary {
    BuildingEventsServlet buildingEventsServlet;

    public BuildingEventsPresenter(BuildingEventsServlet buildingEventsServlet) {
        this.buildingEventsServlet = buildingEventsServlet;
    }

    @Override
    public void execute(BuildingEventsOutputData outputData) {
        buildingEventsServlet.displayEvents(outputData);
    }
}
