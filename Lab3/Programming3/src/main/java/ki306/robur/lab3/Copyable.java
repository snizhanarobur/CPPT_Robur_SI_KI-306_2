package ki306.robur.lab3;

import java.io.IOException;

/**
 * Інтерфейс Copyable визначає набір операцій для копіювального апарату.
 *
 * <p>До основних операцій належать створення копії документа, регулювання контрастності
 * та яскравості під час копіювання. Кожен метод може викликати {@link IOException} у разі виникнення помилок.
 */
public interface Copyable {

    /**
     * Створює копію документа.
     *
     * @param documentName назва документа для копіювання
     * @throws IOException якщо виникає помилка під час копіювання
     */
    void makeCopy(String documentName) throws IOException;

    /**
     * Регулює контрастність копії.
     *
     * @param level рівень контрастності (від 1 до 10)
     * @throws IOException якщо виникає помилка при регулюванні
     */
    void adjustContrast(int level) throws IOException;

    /**
     * Регулює яскравість копії.
     *
     * @param level рівень яскравості (від 1 до 10)
     * @throws IOException якщо виникає помилка при регулюванні
     */
    void adjustBrightness(int level) throws IOException;
}
