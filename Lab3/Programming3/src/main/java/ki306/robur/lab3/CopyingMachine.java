package ki306.robur.lab3;

import java.io.IOException;

/**
 * Клас CopyingMachine представляє копіювальний апарат, який розширює функціонал класу Scanner
 * та реалізує операції, визначені інтерфейсом {@link Copyable}.
 *
 * <p>Клас дозволяє виконувати такі операції, як копіювання документів, регулювання контрасту
 * та яскравості, а також сканування з можливістю збереження результату. Всі операції
 * супроводжуються логуванням.
 */
public class CopyingMachine extends Scanner implements Copyable {
    private int contrastLevel;
    private int brightnessLevel;

    /**
     * Конструктор класу CopyingMachine. Ініціалізує базовий клас Scanner і налаштовує
     * початкові параметри контрасту та яскравості.
     *
     * @throws IOException якщо виникає помилка під час створення лог-файлу
     */
    public CopyingMachine() throws IOException {
        super();
        this.contrastLevel = 50;
        this.brightnessLevel = 50;
        logger.log("Копіювальний апарат створено.");
        System.out.println("Копіювальний апарат створено.");
    }

    /**
     * Починає процес сканування документа.
     *
     * @param documentName назва документа для сканування
     * @throws IOException якщо виникає помилка під час сканування
     */
    @Override
    public void startScan(String documentName) throws IOException {
        this.isScanning = true;
        this.currentDocument = documentName;
        logger.log(String.format("Початок сканування документа: %s", documentName));
        System.out.println(String.format("Початок сканування документа: %s", documentName));
    }

    /**
     * Завершує процес сканування документа.
     *
     * @throws IOException якщо виникає помилка під час завершення сканування
     */
    @Override
    public void finishScan() throws IOException {
        if (isScanning) {
            this.isScanning = false;
            String scannedImage = imageProcessor.processImage(opticalSystem.captureImage());
            memoryUnit.saveImage(currentDocument, scannedImage);
            logger.log(String.format("Завершення сканування: %s", currentDocument));
            System.out.println(String.format("Завершення сканування: %s", currentDocument));
            this.currentDocument = "";
        }
    }

    /**
     * Створює копію документа, спочатку скануючи його, а потім завершуючи процес сканування.
     *
     * @param documentName назва документа для копіювання
     * @throws IOException якщо виникає помилка під час копіювання
     */
    @Override
    public void makeCopy(String documentName) throws IOException {
        startScan(documentName);
        finishScan();
        logger.log(String.format("Створено копію документа: %s", documentName));
        System.out.println(String.format("Створено копію документа: %s", documentName));
    }

    /**
     * Налаштовує рівень контрасту для копіювального апарату.
     *
     * @param level рівень контрасту (від 0 до 100)
     * @throws IOException якщо рівень контрасту недійсний або виникає помилка при налаштуванні
     */
    @Override
    public void adjustContrast(int level) throws IOException {
        if (level >= 0 && level <= 100) {
            this.contrastLevel = level;
            logger.log(String.format("Контраст налаштовано на рівень: %d", level));
            System.out.println(String.format("Контраст налаштовано на рівень: %d", level));
        } else {
            logger.log("Помилка: Недійсний рівень контрасту");
            System.out.println("Помилка: Недійсний рівень контрасту");
        }
    }

    /**
     * Налаштовує рівень яскравості для копіювального апарату.
     *
     * @param level рівень яскравості (від 0 до 100)
     * @throws IOException якщо рівень яскравості недійсний або виникає помилка при налаштуванні
     */
    @Override
    public void adjustBrightness(int level) throws IOException {
        if (level >= 0 && level <= 100) {
            this.brightnessLevel = level;
            logger.log(String.format("Яскравість налаштовано на рівень: %d", level));
            System.out.println(String.format("Яскравість налаштовано на рівень: %d", level));
        } else {
            logger.log("Помилка: Недійсний рівень яскравості");
            System.out.println("Помилка: Недійсний рівень яскравості");
        }
    }

    /**
     * Метод для отримання поточного рівня контрасту.
     *
     * @return поточний рівень контрасту
     */
    public int getContrastLevel() {
        return contrastLevel;
    }

    /**
     * Метод для отримання поточного рівня яскравості.
     *
     * @return поточний рівень яскравості
     */
    public int getBrightnessLevel() {
        return brightnessLevel;
    }

    /**
     * Повертає статус копіювального апарату, включаючи поточний стан сканера, рівень контрасту та яскравості.
     *
     * @return рядок, що представляє поточний статус пристрою
     * @throws IOException якщо виникає помилка при отриманні статусу
     */
    @Override
    public String getStatus() throws IOException {
        String status = super.getStatus() + String.format(", Контраст: %d, Яскравість: %d", contrastLevel, brightnessLevel);
        System.out.println(status);
        return status;
    }
}
