package com.universe.app;

import com.universe.data_access.EventDataAccessObject;
import com.universe.entity.event.EventBuilder;
import com.universe.interface_adapter.event.BuildingEventsController;
import com.universe.interface_adapter.event.BuildingEventsPresenter;
import com.universe.use_case.building_events.BuildingEventsDataAccessInterface;
import com.universe.use_case.building_events.BuildingEventsInputBoundary;
import com.universe.use_case.building_events.BuildingEventsInteractor;
import com.universe.use_case.building_events.BuildingEventsOutputBoundary;
import com.universe.view.Events.BuildingEventsServlet;

public class BuildingEventsSetup {
    public static BuildingEventsController setup(BuildingEventsServlet buildingsEventsServlet) {
        BuildingEventsOutputBoundary presenter = new BuildingEventsPresenter(buildingsEventsServlet);

        BuildingEventsDataAccessInterface dataAccess = DataAccessBuilder.getEventDataAccessObject();

        BuildingEventsInputBoundary interactor = new BuildingEventsInteractor(presenter, dataAccess);
        return new BuildingEventsController(interactor);
    }
}
