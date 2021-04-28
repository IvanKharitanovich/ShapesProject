package by.trjava.ivankharyatnovich.model.entity;

import by.trjava.ivankharyatnovich.model.service.TriangleAction;

import java.util.Objects;

public class TriangleCalculations {
    private final TriangleAction triangleAction = new TriangleAction();
    private double triangleHypotenuse;
    private double trianglePerimeter;
    private double triangleArea;
    private boolean isTriangleRight;
    private boolean isTriangleIsosceles;
    private boolean isTriangleEquilateral;
    private boolean isTriangleSharp;
    private boolean isTriangleObtuse;

    public TriangleCalculations() {
    }

    public TriangleCalculations(Triangle triangle) {
        this.triangleHypotenuse = triangleAction.calculateHypotenuse(triangle);
        this.trianglePerimeter = triangleAction.calculatePerimeter(triangle);
        this.triangleArea = triangleAction.calculateArea(triangle);
        this.isTriangleRight = triangleAction.isTriangleRight(triangle);
        this.isTriangleIsosceles = triangleAction.isTriangleIsosceles(triangle);
        this.isTriangleEquilateral = triangleAction.isTriangleEquilateral(triangle);
        this.isTriangleSharp = triangleAction.isTriangleSharp(triangle);
        this.isTriangleObtuse = triangleAction.isTriangleObtuse(triangle);
    }

    public double getTriangleHypotenuse() {
        return triangleHypotenuse;
    }

    public double getTrianglePerimeter() {
        return trianglePerimeter;
    }

    public double getTriangleArea() {
        return triangleArea;
    }

    public boolean isTriangleRight() {
        return isTriangleRight;
    }

    public boolean isTriangleIsosceles() {
        return isTriangleIsosceles;
    }

    public boolean isTriangleEquilateral() {
        return isTriangleEquilateral;
    }

    public boolean isTriangleSharp() {
        return isTriangleSharp;
    }

    public boolean isTriangleObtuse() {
        return isTriangleObtuse;
    }

    public void setTriangleHypotenuse(double triangleHypotenuse) {
        this.triangleHypotenuse = triangleHypotenuse;
    }

    public void setTrianglePerimeter(double trianglePerimeter) {
        this.trianglePerimeter = trianglePerimeter;
    }

    public void setTriangleArea(double triangleArea) {
        this.triangleArea = triangleArea;
    }

    public void setTriangleRight(boolean triangleRight) {
        isTriangleRight = triangleRight;
    }

    public void setTriangleIsosceles(boolean triangleIsosceles) {
        isTriangleIsosceles = triangleIsosceles;
    }

    public void setTriangleEquilateral(boolean triangleEquilateral) {
        isTriangleEquilateral = triangleEquilateral;
    }

    public void setTriangleSharp(boolean triangleSharp) {
        isTriangleSharp = triangleSharp;
    }

    public void setTriangleObtuse(boolean triangleObtuse) {
        isTriangleObtuse = triangleObtuse;
    }

    public void updateCalculations(Triangle triangle){
        this.triangleHypotenuse = triangleAction.calculateHypotenuse(triangle);
        this.trianglePerimeter = triangleAction.calculatePerimeter(triangle);
        this.triangleArea = triangleAction.calculateArea(triangle);
        this.isTriangleRight = triangleAction.isTriangleRight(triangle);
        this.isTriangleIsosceles = triangleAction.isTriangleIsosceles(triangle);
        this.isTriangleEquilateral = triangleAction.isTriangleEquilateral(triangle);
        this.isTriangleSharp = triangleAction.isTriangleSharp(triangle);
        this.isTriangleObtuse = triangleAction.isTriangleObtuse(triangle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TriangleCalculations that = (TriangleCalculations) o;
        return Double.compare(that.triangleHypotenuse, triangleHypotenuse) == 0 &&
                Double.compare(that.trianglePerimeter, trianglePerimeter) == 0 &&
                Double.compare(that.triangleArea, triangleArea) == 0 &&
                isTriangleRight == that.isTriangleRight &&
                isTriangleIsosceles == that.isTriangleIsosceles &&
                isTriangleEquilateral == that.isTriangleEquilateral &&
                isTriangleSharp == that.isTriangleSharp &&
                isTriangleObtuse == that.isTriangleObtuse;
    }

    @Override
    public int hashCode() {
        return Objects.hash(triangleHypotenuse, trianglePerimeter, triangleArea, isTriangleRight, isTriangleIsosceles, isTriangleEquilateral, isTriangleSharp, isTriangleObtuse);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("calculationsHypotenuse: [");
        stringBuilder.append(triangleHypotenuse);
        stringBuilder.append("] trianglePerimeter: [");
        stringBuilder.append(trianglePerimeter);
        stringBuilder.append("] triangleArea: [");
        stringBuilder.append(triangleArea);
        stringBuilder.append("] isTriangleRight: [");
        stringBuilder.append(isTriangleRight);
        stringBuilder.append("] isTriangleIsosceles: [");
        stringBuilder.append(isTriangleIsosceles);
        stringBuilder.append("] isTriangleEquilateral: [");
        stringBuilder.append(isTriangleEquilateral);
        stringBuilder.append("] isTriangleSharp: [");
        stringBuilder.append(isTriangleSharp);
        stringBuilder.append("] isTriangleObtuse: [");
        stringBuilder.append(isTriangleObtuse);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
