package ki306.robur.lab2;

import java.io.IOException;
/**
 * Клас ScannerDriver є точкою входу в програму та демонструє роботу зі сканером,
 * використовуючи різні методи класу Scanner.
 */
public class ScannerDriver {
    /**
     * Точка входу в програму. Демонструє роботу з телевізором шляхом виклику різних методів.
     *
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(
                    new OpticalSystem(250),
                    new ImageProcessor(3),
                    new MemoryUnit(1000)
            );
            scanner.startScan("Документ1");
            scanner.finishScan();
            scanner.startScan("Документ2");
            scanner.finishScan();
            scanner.cancelScan();
            scanner.changeResolution(25);
            scanner.changeProcessingSpeed(7);
            scanner.deleteImage("Документ1");
            scanner.getSavedImages();
            scanner.isScanning();
            scanner.getStatus();
            scanner.clearMemory();

            scanner.closeLogger();
        } catch (IOException e) {
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}
