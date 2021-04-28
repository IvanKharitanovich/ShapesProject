package by.trjava.ivankharyatnovich.model.entity.factory;

import by.trjava.ivankharyatnovich.model.entity.Point;
import by.trjava.ivankharyatnovich.model.entity.Triangle;
import by.trjava.ivankharyatnovich.model.entity.TriangleCalculations;

public class EntityFactory {
    private static final EntityFactory INSTANCE = new EntityFactory();

    private EntityFactory() {
    }

    public static EntityFactory getInstance() {
        return INSTANCE;
    }

    public Point getPoint() {
        return new Point();
    }

    public Triangle getTriangle() {
        return new Triangle();
    }

    public TriangleCalculations getTriangleCalculations() {
        return new TriangleCalculations();
    }
}
