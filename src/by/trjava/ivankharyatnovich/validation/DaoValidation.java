package by.trjava.ivankharyatnovich.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DaoValidation {
    static final Logger logger = LogManager.getLogger();
    private final static String SHAPE_FORMAT_STRUCTURE = "^\\d+\\s+[0-9]{1,5}(?:[.,][0-9]{1,5})?\\s+[0-9]{1,5}(?:[.,][0-9]{1,5})?\\s+[0-9]{1,5}(?:[.,][0-9]{1,5})?$";
    private final static String POINT_FORMAT_STRUCTURE = "^[0-9]{1,5}(?:[.,][0-9]{1,5})?\\s+[0-9]{1,5}(?:[.,][0-9]{1,5})?$";

    public static boolean isEmpty(Path path) {
        boolean status = false;
        try {
            if (Files.size(path) < 1) {
                status = true;
            }
        } catch (IOException e) {
            logger.error("FILE NOT FOUND" + path.toString());
            status = true;
        }
        return status;
    }

    public static boolean isTriangleInCorrect(String data) {
        boolean status = false;
        Pattern pattern = Pattern.compile(SHAPE_FORMAT_STRUCTURE);
        Matcher matcher = pattern.matcher(data);
        if (!matcher.matches()) {
            status = true;
        }
        return status;
    }

    public static boolean isPointInCorrect(String data) {
        boolean status = false;
        Pattern pattern = Pattern.compile(POINT_FORMAT_STRUCTURE);
        Matcher matcher = pattern.matcher(data);
        if (!matcher.matches()) {
            status = true;
        }
        return status;
    }
}


