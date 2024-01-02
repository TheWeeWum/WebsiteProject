package com.universe.app;

import com.universe.data_access.EventDataAccessObject;
import com.universe.interface_adapter.event.AddEventController;
import com.universe.interface_adapter.event.AddEventPresenter;
import com.universe.use_case.add_event.AddEventDataAccessInterface;
import com.universe.use_case.add_event.AddEventInputBoundary;
import com.universe.use_case.add_event.AddEventInteractor;
import com.universe.use_case.add_event.AddEventOutputBoundary;
import com.universe.view.Events.AddEventServlet;

public class AddEventSetup {
    public static AddEventController setup(AddEventServlet servlet) {
        AddEventOutputBoundary presenter = new AddEventPresenter(servlet);

        AddEventDataAccessInterface dataAccess = DataAccessBuilder.getEventDataAccessObject();

        AddEventInputBoundary interactor = new AddEventInteractor(presenter, dataAccess);
        return new AddEventController(interactor);
    }
}
