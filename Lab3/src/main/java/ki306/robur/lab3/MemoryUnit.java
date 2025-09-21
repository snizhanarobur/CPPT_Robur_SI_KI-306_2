package ki306.robur.lab3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Клас MemoryUnit представляє модуль пам'яті для зберігання зображень,
 * захоплених сканером. Він дозволяє зберігати, видаляти та отримувати список збережених зображень.
 */
public class MemoryUnit {
    private int capacity;
    private Map<String, String> savedImages;

    /**
     * Конструктор за замовчуванням, який ініціалізує модуль пам'яті з місткістю 1000 одиниць.
     */
    public MemoryUnit() {
        this.capacity = 1000;
        this.savedImages = new HashMap<>();
    }

    /**
     * Конструктор, який дозволяє задавати початкову місткість модуля пам'яті.
     * @param capacity початкова місткість
     */
    public MemoryUnit(int capacity) {
        this.capacity = capacity;
        this.savedImages = new HashMap<>();
    }

    /**
     * Зберігає зображення в пам'ять під зазначеним іменем.
     * @param name ім'я зображення
     * @param image зображення у вигляді рядка
     */
    public void saveImage(String name, String image) {
        savedImages.put(name, image);
    }

    /**
     * Видаляє зображення з пам'яті за вказаним ім'ям.
     * @param name ім'я зображення
     * @return true, якщо зображення було видалено, інакше false
     */
    public boolean deleteImage(String name) {
        return savedImages.remove(name) != null;
    }

    /**
     * Повертає список імен всіх збережених зображень.
     * @return список імен збережених зображень
     */
    public List<String> getImageList() {
        return new ArrayList<>(savedImages.keySet());
    }

    /**
     * Повертає кількість вільного місця в пам'яті.
     * @return кількість вільного місця
     */
    public int getFreeSpace() {
        return capacity - savedImages.size();
    }

    /**
     * Очищає всю пам'ять, видаляючи всі збережені зображення.
     */
    public void clearAll() {
        savedImages.clear();
    }
}
