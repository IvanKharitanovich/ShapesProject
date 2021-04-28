package by.trjava.ivankharyatnovich.model.service;

import by.trjava.ivankharyatnovich.exception.EntityException;
import by.trjava.ivankharyatnovich.model.entity.Point;
import by.trjava.ivankharyatnovich.model.entity.Triangle;
import by.trjava.ivankharyatnovich.model.entity.factory.EntityFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TriangleActionTest {
    TriangleAction triangleAction;
    EntityFactory entityFactory;

    @BeforeClass
    public void setUp() {
        triangleAction = new TriangleAction();
        entityFactory = EntityFactory.getInstance();
    }

    @Test
    public void getPerimeterTest() throws EntityException {
        Triangle triangle = entityFactory.getTriangle();
        triangle.setSides(10, 10, 14.1);

        double actual = triangleAction.calculatePerimeter(triangle);
        double expected = 34.1;

        Assert.assertEquals(actual, expected, 0.001);
    }

    @Test(expectedExceptions = EntityException.class)
    public void getPerimeterTestException() throws EntityException {
        Triangle triangle = entityFactory.getTriangle();
        triangle.setSides(10, -10, 14.1);

        double actual = triangleAction.calculatePerimeter(triangle);
        double expected = 34.1;

        Assert.assertEquals(actual, expected, 0.001);
    }

    @Test
    public void isPointsMakeTriangleTest() {
        Point pointA = entityFactory.getPoint();
        Point pointB = entityFactory.getPoint();
        Point pointC = entityFactory.getPoint();
        pointA.setX(10);
        pointB.setX(3);
        pointC.setX(5);
        pointA.setY(4);
        pointB.setY(-1);
        pointC.setY(25);

        Boolean actual = triangleAction.isPointsMakeTriangle(pointA, pointB, pointC);
        Boolean expected = true;

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void isPointsMakeTriangleTestZeroPoints() {
        Point pointA = entityFactory.getPoint();
        Point pointB = entityFactory.getPoint();
        Point pointC = entityFactory.getPoint();
        pointA.setX(0);
        pointB.setX(1);
        pointC.setX(0);
        pointA.setY(1);
        pointB.setY(0);
        pointC.setY(1);

        Boolean actual = triangleAction.isPointsMakeTriangle(pointA, pointB, pointC);
        Boolean expected = false;

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void isTriangleRightTest() throws EntityException {
        Triangle triangle = entityFactory.getTriangle();
        triangle.setSides(10, 10, 14.1);

        Boolean actual = triangleAction.isTriangleRight(triangle);
        Boolean expected = false;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void isTriangleIsoscelesTest() throws EntityException {
        Triangle triangle = entityFactory.getTriangle();
        triangle.setSides(10, 10, 14.1);

        Boolean actual = triangleAction.isTriangleIsosceles(triangle);
        Boolean expected = true;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void isTriangleEquilateralTest() throws EntityException {
        Triangle triangle = entityFactory.getTriangle();
        triangle.setSides(10, 10, 14.1);

        Boolean actual = triangleAction.isTriangleEquilateral(triangle);
        Boolean expected = false;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void isTriangleSharpTest() throws EntityException {
        Triangle triangle = entityFactory.getTriangle();
        triangle.setSides(10, 10, 14.1);

        Boolean actual = triangleAction.isTriangleSharp(triangle);
        Boolean expected = true;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void isTriangleObtuseTest() throws EntityException {
        Triangle triangle = entityFactory.getTriangle();
        triangle.setSides(10, 10, 14.1);

        Boolean actual = triangleAction.isTriangleObtuse(triangle);
        Boolean expected = false;

        Assert.assertEquals(actual, expected);
    }

    @AfterClass
    public void tierDown() {
        triangleAction = null;
        entityFactory = null;
    }
}
