package com.universe.use_case.open_buildings_list;

import com.universe.entity.building.Building;

import java.util.List;

public class OpenBuildingsListOutputData {
    private final List<Building> buildings;

    public OpenBuildingsListOutputData(List<Building> buildings) {
        this.buildings = buildings;
    }
    public List<Building> getBuildings() {
        return buildings;
    }
}
