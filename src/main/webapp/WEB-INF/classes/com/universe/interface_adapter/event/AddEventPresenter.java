package com.universe.interface_adapter.event;

import com.universe.use_case.add_event.AddEventOutputBoundary;
import com.universe.use_case.add_event.AddEventOutputData;
import com.universe.use_case.building_events.BuildingEventsOutputBoundary;
import com.universe.use_case.building_events.BuildingEventsOutputData;
import com.universe.view.Events.AddEventServlet;
import com.universe.view.Events.BuildingEventsServlet;

public class AddEventPresenter implements AddEventOutputBoundary {
    AddEventServlet servlet;

    public AddEventPresenter(AddEventServlet servlet) {
        this.servlet = servlet;
    }

    @Override
    public void execute(AddEventOutputData outputData) {
        servlet.successView(outputData);
    }
}
