package com.universe.use_case.display_markers;

import com.universe.entity.building.Building;

import java.util.List;

public class MarkerOutputData {
    private final List<Building> buildings;
    public MarkerOutputData(List<Building> buildings) {
        this.buildings = buildings;
    }

    public List<Building> getBuildings() {
        return buildings;
    }
}
