package by.trjava.ivankharyatnovich.warehouse;

import by.trjava.ivankharyatnovich.model.entity.TriangleCalculations;

import java.util.HashMap;
import java.util.Map;

public class TriangleWareHouse {
    private static final TriangleWareHouse INSTANCE = new TriangleWareHouse();
    private Map<Long, TriangleCalculations> calculationsWareHouse = new HashMap<>();

    private TriangleWareHouse() {
    }

    public static TriangleWareHouse getInstance() {
        return INSTANCE;
    }

    public boolean isContains(long id) {
        return calculationsWareHouse.containsKey(id);
    }

    public boolean addTriangleCalculations(long id, TriangleCalculations calculations) {
        calculationsWareHouse.put(id, calculations);
        return true;
    }

    public TriangleCalculations getTriangleCalculations(long id) {
        return calculationsWareHouse.get(id);
    }

    public String printContainment(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(calculationsWareHouse);
        return stringBuilder.toString();
    }
}
