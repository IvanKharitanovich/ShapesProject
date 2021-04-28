package by.trjava.ivankharyatnovich.utils.repository;

import by.trjava.ivankharyatnovich.model.entity.Triangle;

import java.util.function.Predicate;

@FunctionalInterface
public interface Specification extends Predicate<Triangle> {
}
