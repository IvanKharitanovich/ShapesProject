package by.trjava.ivankharyatnovich.utils.comparator;

import by.trjava.ivankharyatnovich.exception.EntityException;
import by.trjava.ivankharyatnovich.model.entity.Triangle;
import by.trjava.ivankharyatnovich.model.entity.factory.EntityFactory;
import by.trjava.ivankharyatnovich.utils.parser.StringParser;
import by.trjava.ivankharyatnovich.utils.reader.FileReader;
import by.trjava.ivankharyatnovich.utils.repository.TriangleRepository;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ComparatorTest {
    EntityFactory entityFactory;

    @BeforeClass
    public void setUp() {
        entityFactory = EntityFactory.getInstance();
    }

    @Test
    public void idShapesComparatorTest() {
        TriangleRepository repository = new TriangleRepository();
        Triangle triangleA = entityFactory.getTriangle();
        Triangle triangleB = entityFactory.getTriangle();
        Triangle triangleC = entityFactory.getTriangle();

        triangleA.setId(23l);
        triangleB.setId(1l);
        triangleC.setId(1933l);

        repository.add(triangleA);
        repository.add(triangleB);
        repository.add(triangleC);

        repository.sort(new IdShapesComparator());

        String actual = repository.print();
        String expected = "[Triangle 1 have sides: 0.0 0.0 0.0 , Triangle 23 have sides: 0.0 0.0 0.0 , Triangle 1933 have sides: 0.0 0.0 0.0 ]";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void perimeterTriangleComparatorTest() throws EntityException {
        TriangleRepository repository = new TriangleRepository();
        Triangle triangleA = entityFactory.getTriangle();
        Triangle triangleB = entityFactory.getTriangle();
        Triangle triangleC = entityFactory.getTriangle();

        triangleA.setSides(12, 12, 12);
        triangleB.setSides(13, 255, 13);
        triangleC.setSides(132, 1, 1);

        repository.add(triangleA);
        repository.add(triangleB);
        repository.add(triangleC);

        repository.sort(new PerimeterComparator());

        String actual = repository.print();
        String expected = "[Triangle null have sides: 12.0 12.0 12.0 , Triangle null have sides: 132.0 1.0 1.0 , Triangle null have sides: 13.0 255.0 13.0 ]";
        Assert.assertEquals(actual, expected);
    }

    @AfterClass
    public void tierDown() {
        entityFactory = null;
    }
}
