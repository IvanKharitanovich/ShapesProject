package by.trjava.ivankharyatnovich.utils.reader;

import by.trjava.ivankharyatnovich.exception.DaoException;
import by.trjava.ivankharyatnovich.validation.DaoValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private static Logger logger = LogManager.getLogger();

    public List<String> readShapesFromFile() throws DaoException {
        List<String> list = new ArrayList<>();
        String defaultDirName = "data";
        String defaultFileName = "shapesData.txt";
        Path path = FileSystems.getDefault().getPath(defaultDirName, defaultFileName);
        try {
            if (DaoValidation.isEmpty(path)) {
                logger.error("EMPTY FILE: " + path.toString());
                throw new DaoException("EMPTY FILE");
            }
            list = Files.readAllLines(path);
        } catch (IOException e) {
            logger.error("FILE NOT FOUND");
            throw new DaoException("FILE NOT FOUND");
        }
        return list;
    }

    public List<String> readPointsFromFile() throws DaoException {
        List<String> list = new ArrayList<>();
        String defaultDirName = "data";
        String defaultFileName = "pointsData.txt";
        Path path = FileSystems.getDefault().getPath(defaultDirName, defaultFileName);
        try {
            if (DaoValidation.isEmpty(path)) {
                logger.error("EMPTY FILE");
                throw new DaoException("EMPTY FILE");
            }
            list = Files.readAllLines(path);
        } catch (IOException e) {
            logger.error("FILE NOT FOUND" + path.toString());
            throw new DaoException("FILE NOT FOUND");
        }
        return list;
    }
}
