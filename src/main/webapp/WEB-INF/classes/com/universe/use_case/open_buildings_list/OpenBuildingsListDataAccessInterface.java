package com.universe.use_case.open_buildings_list;
import com.universe.entity.building.Building;

import java.util.List;

public interface OpenBuildingsListDataAccessInterface {
    List<Building> getBuildings();
}
