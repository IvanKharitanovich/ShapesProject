package by.trjava.ivankharyatnovich.utils.repository;

import by.trjava.ivankharyatnovich.model.entity.Triangle;

public class IdSpecification implements Specification {
    private long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean test(Triangle triangle) {
        return id == triangle.getId();
    }
}
