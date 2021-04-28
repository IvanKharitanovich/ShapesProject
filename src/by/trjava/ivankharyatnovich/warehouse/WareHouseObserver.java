package by.trjava.ivankharyatnovich.warehouse;

import by.trjava.ivankharyatnovich.model.entity.Triangle;
import by.trjava.ivankharyatnovich.model.entity.TriangleCalculations;
import by.trjava.ivankharyatnovich.utils.observer.Observer;
import by.trjava.ivankharyatnovich.utils.observer.TriangleEvent;

public class WareHouseObserver implements Observer {
    @Override
    public void handleEvent(TriangleEvent triangleEvent) {
        Triangle triangle = triangleEvent.getSource();

        TriangleCalculations triangleCalculations = new TriangleCalculations();
        triangleCalculations.updateCalculations(triangle);

        TriangleWareHouse triangleWareHouse = TriangleWareHouse.getInstance();
        triangleWareHouse.addTriangleCalculations(triangle.getId(), triangleCalculations);
    }
}
