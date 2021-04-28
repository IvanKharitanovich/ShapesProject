package by.trjava.ivankharyatnovich.utils.comparator;

import by.trjava.ivankharyatnovich.model.entity.Triangle;
import by.trjava.ivankharyatnovich.model.service.TriangleAction;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Triangle> {
    TriangleAction triangleAction = new TriangleAction();

    @Override
    public int compare(Triangle o1, Triangle o2) {
        return Double.compare(triangleAction.calculatePerimeter(o1), triangleAction.calculatePerimeter(o2));
    }
}
