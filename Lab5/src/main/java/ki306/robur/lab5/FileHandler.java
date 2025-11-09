package ki306.robur.lab5;

import java.io.*;

/**
 * Клас для читання і запису результатів у текстовому та двійковому форматах.
 */
public class FileHandler {

    /**
     * Запис результату у текстовий файл.
     *
     * @param result результат для запису
     * @param filePath шлях до файлу
     * @throws IOException якщо виникає помилка при записі
     */
    public void writeText(double result, String filePath) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("Результат обчислення: " + result);
        }
    }

    /**
     * Зчитування результату з текстового файлу.
     *
     * @param filePath шлях до файлу
     * @return зчитане значення результату
     * @throws IOException якщо виникає помилка при читанні
     */
    public double readText(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line != null && line.contains(":")) {
                String valuePart = line.split(":")[1].trim();
                return Double.parseDouble(valuePart);
            } else {
                throw new IOException("Некоректний формат файлу.");
            }
        }
    }

    /**
     * Запис результату у двійковий файл.
     *
     * @param result результат для запису
     * @param filePath шлях до файлу
     * @throws IOException якщо виникає помилка при записі
     */
    public void writeBinary(double result, String filePath) throws IOException {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(filePath))) {
            out.writeDouble(result);
        }
    }

    /**
     * Зчитування результату з двійкового файлу.
     *
     * @param filePath шлях до файлу
     * @return зчитане значення результату
     * @throws IOException якщо виникає помилка при читанні
     */
    public double readBinary(String filePath) throws IOException {
        try (DataInputStream in = new DataInputStream(new FileInputStream(filePath))) {
            return in.readDouble();
        }
    }
}
