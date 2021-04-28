package by.trjava.ivankharyatnovich.utils.repository;

import by.trjava.ivankharyatnovich.model.entity.Triangle;

public class SidesSpecification implements Specification {
    private double[] triangleSides = new double[3];

    public SidesSpecification(double sideA, double sideB, double sideC) {
        triangleSides[0] = sideA;
        triangleSides[1] = sideB;
        triangleSides[2] = sideC;
    }

    @Override
    public boolean test(Triangle triangle) {
        boolean status = true;
        for (int i = 0; i < this.triangleSides.length;i++){
            if(triangleSides[i] != triangle.getSides()[i]){
                status = false;
                break;
            }
        }
            return true;
    }
}
