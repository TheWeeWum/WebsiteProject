package com.universe.interface_adapter.open_building;

import com.universe.use_case.open_building.OpenBuildingOutputBoundary;
import com.universe.use_case.open_building.OpenBuildingOutputData;
import com.universe.view.Building.BuildingInfoServlet;

public class OpenBuildingPresenter implements OpenBuildingOutputBoundary {

    BuildingInfoServlet buildingInfoServlet;

    public OpenBuildingPresenter(BuildingInfoServlet buildingInfoServlet) {
        this.buildingInfoServlet = buildingInfoServlet;
    }

    @Override
    public void prepareSuccessView(OpenBuildingOutputData openBuildingOutputData) {
        buildingInfoServlet.writeBuilding(openBuildingOutputData);
    }
}
