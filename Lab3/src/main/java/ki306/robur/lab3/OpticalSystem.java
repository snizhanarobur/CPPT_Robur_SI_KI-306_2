package ki306.robur.lab3;

/**
 * Клас OpticalSystem представляє оптичну систему сканера, яка відповідає за захоплення зображень
 * з заданою роздільною здатністю.
 */
public class OpticalSystem {
    private int resolution;

    /**
     * Конструктор за замовчуванням, який ініціалізує оптичну систему з роздільною здатністю 300 DPI.
     */
    public OpticalSystem() {
        this.resolution = 300;
    }

    /**
     * Конструктор, який дозволяє задавати користувацьку роздільну здатність.
     * @param resolution початкова роздільна здатність в DPI
     */
    public OpticalSystem(int resolution) {
        this.resolution = resolution;
    }

    /**
     * Встановлює нову роздільну здатність для оптичної системи.
     * @param resolution нова роздільна здатність в DPI
     */
    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    /**
     * Повертає поточну роздільну здатність оптичної системи.
     * @return поточна роздільна здатність в DPI
     */
    public int getResolution() {
        return resolution;
    }

    /**
     * Захоплює зображення з використанням поточної роздільної здатності.
     * @return рядок з інформацією про захоплене зображення та роздільну здатність
     */
    public String captureImage() {
        return "Captured image at " + resolution + " DPI";
    }
}
