package ki306.robur.lab3;

/**
 * Клас ImageProcessor представляє систему для обробки зображень,
 * яка має налаштовувану швидкість обробки.
 */
public class ImageProcessor {
    private int processingSpeed;

    /**
     * Конструктор за замовчуванням, який ініціалізує систему обробки зображень зі швидкістю 5.
     */
    public ImageProcessor() {
        this.processingSpeed = 5;
    }

    /**
     * Конструктор, який дозволяє задавати початкову швидкість обробки.
     * @param processingSpeed початкова швидкість обробки зображень
     */
    public ImageProcessor(int processingSpeed) {
        this.processingSpeed = processingSpeed;
    }

    /**
     * Встановлює нову швидкість обробки зображень.
     * @param speed нова швидкість обробки
     */
    public void setProcessingSpeed(int speed) {
        this.processingSpeed = speed;
    }

    /**
     * Повертає поточну швидкість обробки зображень.
     * @return поточна швидкість обробки
     */
    public int getProcessingSpeed() {
        return processingSpeed;
    }

    /**
     * Обробляє зображення з використанням поточної швидкості обробки.
     * @param rawImage необроблене зображення
     * @return рядок, що представляє процес обробки з зазначенням швидкості
     */
    public String processImage(String rawImage) {
        return "Процес: " + rawImage + " з швидкістю " + processingSpeed;
    }
}
