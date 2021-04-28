package by.trjava.ivankharyatnovich.model.entity;

import by.trjava.ivankharyatnovich.exception.EntityException;
import by.trjava.ivankharyatnovich.utils.observer.Observed;
import by.trjava.ivankharyatnovich.utils.observer.Observer;
import by.trjava.ivankharyatnovich.utils.observer.TriangleEvent;
import by.trjava.ivankharyatnovich.validation.EntityValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.Arrays;


public class Triangle extends Shape implements Serializable, Observed {
    final static Logger logger = LogManager.getLogger();
    private double[] sides = new double[3];
    private Observer observer;

    public Triangle() {
    }

    public double[] getSides() {
        return sides.clone();
    }

    public void setSides(double sideA, double sideB, double sideC) throws EntityException {
        if (EntityValidation.isInCorrect(sideA, sideB, sideC)) {
            logger.error("INCORRECT VALUE: " + sides.toString());
            throw new EntityException("INCORRECT VALUE");
        }
        sides[0] = sideA;
        sides[1] = sideB;
        sides[2] = sideC;
        notifyObserver();
    }

    @Override
    public void addObserver(Observer observer) {
        this.observer = observer;
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observer = null;
    }

    @Override
    public void notifyObserver() {
        if (observer != null) {
            observer.handleEvent(new TriangleEvent(this));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Triangle triangle = (Triangle) o;
        return Arrays.equals(sides, triangle.sides);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(sides);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Triangle ");
        stringBuilder.append(this.getId());
        stringBuilder.append(" have sides: ");
        for (int i = 0; i < sides.length; i++) {
            stringBuilder.append(sides[i]);
            stringBuilder.append(" ");
        }
        String result = stringBuilder.toString();
        return result;
    }

}
