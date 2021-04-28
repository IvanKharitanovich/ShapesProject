package by.trjava.ivankharyatnovich.validation;

public class EntityValidation {

    public static boolean isInCorrect(double sideA, double sideB, double sideC) {
        boolean status = false;
        if ((sideA <= 0) || (sideB <= 0) || (sideC <= 0)) {
            status = true;
        }
        return status;
    }
}
