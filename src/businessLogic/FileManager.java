package businessLogic;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

/**
 * Клас для роботи з файлами, що надає методи для читання та запису даних з/у файл.
 */
class FileManager {
    /**
     * Читає вміст файлу з вказаного шляху і повертає його у вигляді рядка.
     *
     * @param filePath шлях до файлу, який потрібно прочитати
     * @return рядок, що містить вміст файлу
     */
    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try {
            FileReader reader = new FileReader(filePath);
            int character;
            while ((character = reader.read()) != -1) {
                content.append((char) character);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Помилка при читанні файлу: " + e.getMessage());
        }
        return content.toString();
    }

    /**
     * Записує вміст у файл за вказаним шляхом.
     *
     * @param filePath шлях до файлу, у який потрібно записати вміст
     * @param content  рядок, який потрібно записати у файл
     */
    public static void writeFile(String filePath, String content) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(content);
            writer.close();
            System.out.println("Файл успішно записано.");
        } catch (IOException e) {
            System.err.println("Помилка при записі у файл: " + e.getMessage());
        }
    }
}
