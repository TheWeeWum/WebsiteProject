package com.universe.interface_adapter.open_buildings_list;

import com.universe.use_case.open_buildings_list.OpenBuildingsListOutputBoundary;
import com.universe.use_case.open_buildings_list.OpenBuildingsListOutputData;
import com.universe.view.Buildings.BuildingsListServlet;

public class OpenBuildingsListPresenter implements OpenBuildingsListOutputBoundary {
    BuildingsListServlet buildingsListServlet;

    public OpenBuildingsListPresenter(BuildingsListServlet buildingsListServlet) {
        this.buildingsListServlet = buildingsListServlet;
    }

    @Override
    public void prepareSuccessView(OpenBuildingsListOutputData openBuildingsListOutputData) {
        buildingsListServlet.writeBuildings(openBuildingsListOutputData);
    }
}
