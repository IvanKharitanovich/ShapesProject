package by.trjava.ivankharyatnovich.utils.parser;

import by.trjava.ivankharyatnovich.exception.DaoException;
import by.trjava.ivankharyatnovich.exception.EntityException;
import by.trjava.ivankharyatnovich.model.entity.Point;
import by.trjava.ivankharyatnovich.model.entity.Triangle;
import by.trjava.ivankharyatnovich.model.entity.factory.EntityFactory;
import by.trjava.ivankharyatnovich.validation.DaoValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class StringParser {
    final static Logger logger = LogManager.getLogger();
    final String SPLITTER = " ";

    public Triangle getTriangleFromString(String data) throws DaoException {
        if (DaoValidation.isTriangleInCorrect(data)) {
            logger.error("INCORRECT DATA: " + data);
            throw new DaoException("INCORRECT DATA");
        }
        EntityFactory entityFactory = EntityFactory.getInstance();
        Triangle triangle = entityFactory.getTriangle();

        String[] strings = data.split(SPLITTER);

        triangle.setId(Long.parseLong(strings[0]));
        try {
            triangle.setSides(Double.parseDouble(strings[1]), Double.parseDouble(strings[2]), Double.parseDouble(strings[3]));
        } catch (EntityException e) {
            logger.error("INCORRECT VALUE");
            throw new DaoException("INCORRECT VALUE");
        }
        return triangle;
    }

    public List<Triangle> getTrianglesFromStrings(List<String> data) {
        List<Triangle> triangleList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            try {
                triangleList.add(getTriangleFromString(data.get(i)));
            } catch (DaoException e) {
                continue;
            }
        }
        return triangleList;
    }

    public Point getPointFromString(String data) throws DaoException {
        if (DaoValidation.isPointInCorrect(data)) {
            logger.error("INCORRECT DATA: " + data);
            throw new DaoException("INCORRECT DATA");
        }
        EntityFactory entityFactory = EntityFactory.getInstance();
        Point point = entityFactory.getPoint();

        String[] strings = data.split(" ");

        point.setX(Double.parseDouble(strings[0]));
        point.setY(Double.parseDouble(strings[1]));

        return point;
    }

    public List<Point> getPointsFromStrings(List<String> data) {
        List<Point> pointArrayList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            try {
                pointArrayList.add(getPointFromString(data.get(i)));
            } catch (DaoException e) {
                continue;
            }
        }
        return pointArrayList;
    }
}
