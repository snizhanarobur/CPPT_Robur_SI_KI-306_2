package ki306.robur.lab3;

import java.io.IOException;
import java.util.List;

/**
 * Клас представляє сканер, який здійснює сканування документів,
 * обробку зображень та управління пам'яттю для збережених зображень.
 */
public abstract class Scanner {
    protected OpticalSystem opticalSystem;
    protected ImageProcessor imageProcessor;
    protected MemoryUnit memoryUnit;
    protected Logger logger;
    protected boolean isScanning;
    protected String currentDocument;

    /**
     * Конструктор за замовчуванням, який ініціалізує всі необхідні підсистеми сканера.
     * @throws IOException якщо виникає помилка під час створення лог-файлу
     */
    public Scanner() throws IOException {
        this.opticalSystem = new OpticalSystem();
        this.imageProcessor = new ImageProcessor();
        this.memoryUnit = new MemoryUnit();
        this.isScanning = false;
        this.currentDocument = "";

        this.logger = new Logger("scanner_log.txt");
        logger.log(String.format("Сканер %s створено.", this.toString()));
    }

    /**
     * Конструктор для створення сканера з заданими підсистемами.
     * @param opticalSystem система для захоплення зображень
     * @param imageProcessor процесор для обробки зображень
     * @param memoryUnit блок пам'яті для збереження зображень
     * @throws IOException якщо виникає помилка під час створення лог-файлу
     */
    public Scanner(OpticalSystem opticalSystem, ImageProcessor imageProcessor, MemoryUnit memoryUnit) throws IOException {
        this.opticalSystem = opticalSystem;
        this.imageProcessor = imageProcessor;
        this.memoryUnit = memoryUnit;
        this.isScanning = false;
        this.currentDocument = "";

        this.logger = new Logger("scanner_log.txt");
        logger.log(String.format("Сканер %s створено.", this.toString()));
    }

    /**
     * Абстрактний метод для початку сканування документа.
     * @param documentName назва документа для сканування
     * @throws IOException якщо виникає помилка під час логування
     */
    public abstract void startScan(String documentName) throws IOException;

    /**
     * Абстрактний метод для завершення сканування.
     * @throws IOException якщо виникає помилка під час обробки або збереження зображення
     */
    public abstract void finishScan() throws IOException;

    /**
     * Метод для скасування сканування.
     * @throws IOException якщо виникає помилка під час логування
     */
    public void cancelScan() throws IOException {
        if (isScanning) {
            this.isScanning = false;

            logger.log(String.format("Скасування сканування: %s", currentDocument));
            System.out.printf("Скасування сканування: %s\n", currentDocument);

            this.currentDocument = "";
        }
    }

    /**
     * Метод для зміни роздільної здатності сканера.
     * @param resolution нове значення роздільної здатності
     * @throws IOException якщо виникає помилка під час логування
     */
    public void changeResolution(int resolution) throws IOException {
        opticalSystem.setResolution(resolution);

        logger.log(String.format("Зміна роздільної здатності на: %s", resolution));
        System.out.printf("Зміна роздільної здатності на: %s\n", resolution);
    }

    /**
     * Метод для зміни швидкості обробки зображень.
     * @param speed нове значення швидкості обробки
     * @throws IOException якщо виникає помилка під час логування
     */
    public void changeProcessingSpeed(int speed) throws IOException {
        imageProcessor.setProcessingSpeed(speed);

        logger.log(String.format("Зміна швидкості обробки на: %s", speed));
        System.out.printf("Зміна швидкості обробки на: %s\n", speed);
    }

    /**
     * Метод для видалення зображення з пам'яті.
     * @param imageName назва зображення
     * @throws IOException якщо виникає помилка під час видалення або логування
     */
    public void deleteImage(String imageName) throws IOException {
        if (memoryUnit.deleteImage(imageName)) {
            logger.log(String.format("Видалено зображення: %s", imageName));
            System.out.printf("Видалено зображення: %s\n", imageName);
        } else {
            logger.log(String.format("Не вдалося видалити зображення: %s", imageName));
            System.out.printf("Не вдалося видалити зображення: %s\n", imageName);
        }
    }

    /**
     * Метод для отримання списку всіх збережених зображень.
     * @return список зображень
     * @throws IOException якщо виникає помилка під час логування
     */
    public List<String> getSavedImages() throws IOException {
        logger.log("Запит списку збережених зображень");
        System.out.println("Запит списку збережених зображень");
        return memoryUnit.getImageList();
    }

    /**
     * Метод для перевірки стану сканування.
     * @return true, якщо сканування в процесі, інакше false
     * @throws IOException якщо виникає помилка під час логування
     */
    public boolean isScanning() throws IOException {
        logger.log(String.format("Відбувається сканування %s", isScanning));
        System.out.printf("Відбувається сканування %s\n", isScanning);
        return isScanning;
    }

    /**
     * Метод для отримання інформації про поточний стан сканера.
     * @return рядок з інформацією про стан сканера
     * @throws IOException якщо виникає помилка під час логування
     */
    public String getStatus() throws IOException {
        String status = String.format("Стан сканера: %s, Роздільна здатність: %d, Швидкість обробки: %d, Вільна пам'ять: %d",
                (isScanning ? "Сканування" : "Очікування"),
                opticalSystem.getResolution(),
                imageProcessor.getProcessingSpeed(),
                memoryUnit.getFreeSpace());

        logger.log("Запит стану сканера");
        System.out.println("Запит стану сканера");
        return status;
    }

    /**
     * Метод для очищення всієї пам'яті сканера.
     * @throws IOException якщо виникає помилка під час очищення пам'яті або логування
     */
    public void clearMemory() throws IOException {
        memoryUnit.clearAll();

        logger.log("Очищення всієї пам'яті сканера.");
        System.out.println("Очищення всієї пам'яті сканера.");
    }

    /**
     * Закриває логер для збереження даних у файл.
     * @throws IOException якщо виникає помилка під час закриття логера
     */
    public void closeLogger() throws IOException {
        logger.close();
    }
}
