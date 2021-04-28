package by.trjava.ivankharyatnovich.utils.comparator;

import by.trjava.ivankharyatnovich.model.entity.Shape;

import java.util.Comparator;

public class IdShapesComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        return Long.compare(o1.getId(), o2.getId());
    }
}
