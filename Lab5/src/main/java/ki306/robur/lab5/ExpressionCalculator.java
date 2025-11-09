package ki306.robur.lab5;

/**
 * Клас для обчислення виразу y = tg(x)/(sin(4x)-2cos(x)).
 */
public class ExpressionCalculator {

    /**
     * Обчислює вираз y = tg(x)/(sin(4x)-2cos(x)).
     *
     * @param x значення змінної x
     * @return результат обчислення виразу
     * @throws IllegalArgumentException якщо x = 0, оскільки вираз не визначений
     */
    public double calculate(double x) throws IllegalArgumentException {
        if (x == 0) {
            throw new IllegalArgumentException("Значення x не може бути 0, оскільки вираз не визначений.");
        }

        return Math.tan(x) / Math.abs(Math.sin(4 * x) - 2 * Math.cos(x));

    }
}