package by.trjava.ivankharyatnovich.model.service;

import by.trjava.ivankharyatnovich.model.entity.Point;
import by.trjava.ivankharyatnovich.model.entity.Triangle;

public class TriangleAction {

    public double calculateHypotenuse(Triangle triangle) {
        double hypotenuse = 0;
        for (int i = 0; i < triangle.getSides().length; i++) {
            if (hypotenuse <= triangle.getSides()[i]) {
                hypotenuse = triangle.getSides()[i];
            }
        }
        return hypotenuse;
    }

    public double calculatePerimeter(Triangle triangle) {
        double result = 0;
        for (int i = 0; i < triangle.getSides().length; i++) {
            result += triangle.getSides()[i];
        }
        return result;
    }

    public double calculateArea(Triangle triangle) {
        double result = 0;
        double halfPerimeter = calculatePerimeter(triangle) / 2.0;
        result = Math.sqrt(halfPerimeter * (halfPerimeter - triangle.getSides()[0])
                * (halfPerimeter - triangle.getSides()[1]) * (halfPerimeter - triangle.getSides()[2]));
        return result;
    }

    public boolean isPointsMakeTriangle(Point pointA, Point pointB, Point pointC) {
        boolean status = true;
        if ((((pointC.getX() - pointA.getX()) / (pointB.getX() - pointA.getX()))
                == ((pointC.getY() - pointA.getY()) / (pointB.getY() - pointA.getY())))) {
            status = false;
        }
        return status;
    }

    public boolean isTriangleRight(Triangle triangle) {
        boolean status = false;
        double hypotenuse = calculateHypotenuse(triangle);
        double otherSides = calculatePerimeter(triangle) - hypotenuse;
        if (Math.pow(hypotenuse, 2.0) == Math.pow(otherSides, 2)) {
            status = true;
        }
        return status;
    }

    public boolean isTriangleIsosceles(Triangle triangle) {
        boolean status = false;
        double sideA = triangle.getSides()[0];
        double sideB = triangle.getSides()[1];
        double sideC = triangle.getSides()[2];
        if ((sideA == sideB) || (sideA == sideC) || (sideB == sideC)) {
            status = true;
        }
        return status;
    }

    public boolean isTriangleEquilateral(Triangle triangle) {
        boolean status = false;
        double sideA = triangle.getSides()[0];
        double sideB = triangle.getSides()[1];
        double sideC = triangle.getSides()[2];
        if ((sideA == sideB) && (sideB == sideC)) {
            status = true;
        }
        return status;
    }

    public boolean isTriangleSharp(Triangle triangle) {
        boolean status = false;
        double hypotenuse = calculateHypotenuse(triangle);
        double otherSides = calculatePerimeter(triangle) - hypotenuse;
        if (Math.pow(hypotenuse, 2.0) < Math.pow(otherSides, 2.0)) {
            status = true;
        }
        return status;
    }

    public boolean isTriangleObtuse(Triangle triangle) {
        boolean status = false;
        double hypotenuse = calculateHypotenuse(triangle);
        double otherSides = calculatePerimeter(triangle) - hypotenuse;
        if (Math.pow(hypotenuse, 2.0) > Math.pow(otherSides, 2.0)) {
            status = true;
        }
        return status;
    }


}
