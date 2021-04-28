package by.trjava.ivankharyatnovich.utils.repository;

import by.trjava.ivankharyatnovich.model.entity.Triangle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleRepository {
    private List<Triangle> triangles = new ArrayList<>();

    public boolean add(Triangle triangle) {
        return triangles.add(triangle);
    }

    public boolean remove(Object o) {
        return triangles.remove(o);
    }

    public void sort(Comparator<? super Triangle> comparator) {
        triangles.sort(comparator);
    }

    public List<Triangle> query(Specification specification) {
        List<Triangle> list = triangles.stream().filter(specification).collect(Collectors.toList());
        return list;
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(triangles);
        return stringBuilder.toString();
    }
}
