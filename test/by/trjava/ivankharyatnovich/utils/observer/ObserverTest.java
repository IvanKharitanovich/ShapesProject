package by.trjava.ivankharyatnovich.utils.observer;

import by.trjava.ivankharyatnovich.exception.EntityException;
import by.trjava.ivankharyatnovich.model.entity.Triangle;
import by.trjava.ivankharyatnovich.model.entity.TriangleCalculations;
import by.trjava.ivankharyatnovich.model.entity.factory.EntityFactory;
import by.trjava.ivankharyatnovich.warehouse.TriangleWareHouse;
import by.trjava.ivankharyatnovich.warehouse.WareHouseObserver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ObserverTest {
    EntityFactory entityFactory;
    TriangleWareHouse triangleWareHouse;

    @BeforeClass
    public void setUp() {
        entityFactory = EntityFactory.getInstance();
        triangleWareHouse = TriangleWareHouse.getInstance();
    }

    @Test
    public void wareHouseObserverTest() throws EntityException {
        Triangle triangle = entityFactory.getTriangle();
        TriangleCalculations triangleCalculations = entityFactory.getTriangleCalculations();

        triangle.setSides(13, 14, 15);
        triangle.setId(1l);

        triangleCalculations.updateCalculations(triangle);
        triangleWareHouse.addTriangleCalculations(triangle.getId(), triangleCalculations);

        triangle.addObserver(new WareHouseObserver());
        triangle.setSides(14, 15, 16);

        TriangleCalculations actual = triangleWareHouse.getTriangleCalculations(1l);
        TriangleCalculations expected = new TriangleCalculations(triangle);

        Assert.assertEquals(actual, expected);
    }

    @AfterClass
    public void tierDown() {
        entityFactory = null;
        triangleWareHouse = null;
    }
}
