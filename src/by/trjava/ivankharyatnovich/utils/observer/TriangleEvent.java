package by.trjava.ivankharyatnovich.utils.observer;

import by.trjava.ivankharyatnovich.model.entity.Triangle;

import java.util.EventObject;

public class TriangleEvent extends EventObject {
    public TriangleEvent(Object source) {
        super(source);
    }

    @Override
    public Triangle getSource() {
        return (Triangle) super.getSource();
    }
}
