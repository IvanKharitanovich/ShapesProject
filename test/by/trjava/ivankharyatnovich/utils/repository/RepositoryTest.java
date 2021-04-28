package by.trjava.ivankharyatnovich.utils.repository;

import by.trjava.ivankharyatnovich.exception.EntityException;
import by.trjava.ivankharyatnovich.model.entity.Triangle;
import by.trjava.ivankharyatnovich.model.entity.factory.EntityFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RepositoryTest {
    EntityFactory entityFactory;

    @BeforeClass
    public void setUp() {
        entityFactory = EntityFactory.getInstance();
    }

    @Test
    public void addTest() throws EntityException {
        TriangleRepository repository = new TriangleRepository();
        Triangle triangle = entityFactory.getTriangle();
        triangle.setSides(12, 12, 12);
        triangle.setId(2000l);

        repository.add(triangle);

        String actual = repository.print();
        String expected = "[Triangle 2000 have sides: 12.0 12.0 12.0 ]";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void removeTest() throws EntityException {
        TriangleRepository repository = new TriangleRepository();
        Triangle triangle = entityFactory.getTriangle();
        triangle.setSides(12, 12, 12);
        triangle.setId(2000l);

        repository.add(triangle);
        repository.remove(triangle);

        String actual = repository.print();
        String expected = "[]";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void queryTest() throws EntityException {
        TriangleRepository repository = new TriangleRepository();
        Triangle triangleA = entityFactory.getTriangle();
        Triangle triangleB = entityFactory.getTriangle();
        Triangle triangleC = entityFactory.getTriangle();
        triangleA.setSides(12, 23, 11);
        triangleA.setId(192l);

        triangleB.setSides(42, 42, 22);
        triangleB.setId(10l);

        triangleC.setSides(12, 33, 17);
        triangleC.setId(2l);

        repository.add(triangleA);
        repository.add(triangleB);
        repository.add(triangleC);

        IdSpecification idSpecification = new IdSpecification(10l);

        List<Triangle> actual = repository.query(idSpecification);
        List<Triangle> expected = new ArrayList<>();
        expected.add(triangleB);

        Assert.assertEquals(actual, expected);
    }

    @AfterClass
    public void tierDown() {
        entityFactory = null;
    }
}
