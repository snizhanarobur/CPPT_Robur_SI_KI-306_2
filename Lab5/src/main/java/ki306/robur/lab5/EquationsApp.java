package ki306.robur.lab5;

import java.io.IOException;
import java.util.Scanner;

/**
 * Драйвер програми: обчислення виразу, запис/читання у різних форматах.
 * Головний клас застосунку для обчислення виразів.
 */
public class EquationsApp {

    /**
     * Точка входу в програму.
     * @param args аргументи командного рядка
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpressionCalculator calculator = new ExpressionCalculator();
        FileHandler fileHandler = new FileHandler();

        try {
            System.out.print("Введіть значення x: ");
            double x = scanner.nextDouble();

            double result = calculator.calculate(x);
            System.out.println("Результат обчислення: " + result);

            String textFile = "result.txt";
            fileHandler.writeText(result, textFile);
            System.out.println("Текстовий файл записано.");

            double textRead = fileHandler.readText(textFile);
            System.out.println("Зчитано з текстового файлу: " + textRead);

            String binaryFile = "result.dat";
            fileHandler.writeBinary(result, binaryFile);
            System.out.println("Двійковий файл записано.");

            double binaryRead = fileHandler.readBinary(binaryFile);
            System.out.println("Зчитано з двійкового файлу: " + binaryRead);

        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Помилка роботи з файлом: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
