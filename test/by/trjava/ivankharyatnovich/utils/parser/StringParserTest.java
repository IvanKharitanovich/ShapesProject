package by.trjava.ivankharyatnovich.utils.parser;

import by.trjava.ivankharyatnovich.exception.DaoException;
import by.trjava.ivankharyatnovich.exception.EntityException;
import by.trjava.ivankharyatnovich.model.entity.Point;
import by.trjava.ivankharyatnovich.model.entity.Triangle;
import by.trjava.ivankharyatnovich.model.entity.factory.EntityFactory;
import by.trjava.ivankharyatnovich.utils.reader.FileReader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class StringParserTest {
    StringParser parserFromString;
    EntityFactory entityFactory;
    FileReader readerFromFile;

    @BeforeClass
    public void setUp() {
        parserFromString = new StringParser();
        entityFactory = EntityFactory.getInstance();
        readerFromFile = new FileReader();
    }

    @Test
    public void getTriangleFromStringTest() throws DaoException, EntityException {
        String data = "0003 12.1 10 73";

        Triangle actual = parserFromString.getTriangleFromString(data);
        Triangle expected = entityFactory.getTriangle();
        expected.setId(0003l);
        expected.setSides(12.1, 10, 73);

        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = DaoException.class)
    public void getTriangleFromStringTestException() throws DaoException, EntityException {
        String data = "0003s 12 10 73";

        Triangle actual = parserFromString.getTriangleFromString(data);
        Triangle expected = entityFactory.getTriangle();
        expected.setId(0003l);
        expected.setSides(12, 10, 73);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getTrianglesFromStringTest() throws DaoException {
        List<String> list = readerFromFile.readShapesFromFile();

        List<Triangle> actual = parserFromString.getTrianglesFromStrings(list);

        List<Triangle> expected = new ArrayList<>();
        expected.add(parserFromString.getTriangleFromString("1 12 12 22"));
        expected.add(parserFromString.getTriangleFromString("0332 11 4 7"));
        expected.add(parserFromString.getTriangleFromString("1000 12 12 31"));

        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = DaoException.class)
    public void getTrianglesFromStringTestException() throws DaoException {
        List<String> list = readerFromFile.readShapesFromFile();

        List<Triangle> actual = parserFromString.getTrianglesFromStrings(list);

        List<Triangle> expected = new ArrayList<>();
        expected.add(parserFromString.getTriangleFromString("1 -12 12 22"));
        expected.add(parserFromString.getTriangleFromString("0332 11 4 7"));
        expected.add(parserFromString.getTriangleFromString("1000 12 12 31"));

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getPointFromStringTest() throws DaoException {
        String data = "112.2 12";

        Point actual = parserFromString.getPointFromString(data);
        Point expected = entityFactory.getPoint();
        expected.setX(112.2);
        expected.setY(12);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getPointsFromStringTest() throws DaoException {
        List<String> list = readerFromFile.readPointsFromFile();

        List<Point> actual = parserFromString.getPointsFromStrings(list);

        List<Point> expected = new ArrayList<>();
        expected.add(parserFromString.getPointFromString("12.2 12"));
        expected.add(parserFromString.getPointFromString("0.1 90"));
        expected.add(parserFromString.getPointFromString("12 13"));
        expected.add(parserFromString.getPointFromString("0.4 9.1"));


        Assert.assertEquals(actual, expected);
    }

    @AfterClass
    public void tierDown() {
        parserFromString = null;
        entityFactory = null;
        readerFromFile = null;
    }
}
