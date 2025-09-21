package ki306.robur.lab3;

import java.io.IOException;
/**
 * Клас ScannerDriver є точкою входу в програму та демонструє роботу зі сканером,
 * використовуючи різні методи класу Scanner.
 */
public class CopyingMachineDriver {
    /**
     * Точка входу в програму. Демонструє роботу з телевізором шляхом виклику різних методів.
     *
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        try {
            CopyingMachine copier = new CopyingMachine();

            copier.makeCopy("Документ1");
            copier.adjustContrast(30);
            copier.adjustBrightness(44);

            System.out.println(copier.getStatus());
            System.out.println("Контраст: " + copier.getContrastLevel());
            System.out.println("Яскравість: " + copier.getBrightnessLevel());

            copier.closeLogger();
        } catch (IOException e) {
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}
