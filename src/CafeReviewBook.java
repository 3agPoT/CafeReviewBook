import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

/**
 * Клас, що керує системою обробки відгуків про кафе.
 */
public class CafeReviewBook {
    private static final String REVIEWS_TXT_FILE_PATH = "reviews.txt";
    private static final String REVIEWS_JSON_FILE_PATH = "reviews.json";
    private static HashMap<String, String> users = new HashMap<>();
    private static HashMap<String, String> reviews = new HashMap<>();
    private static String currentUser = null;
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Запускає головний цикл програми для обробки вибору користувачів.
     */
    public void run() {
        loadReviewsFromTxt();
        loadReviewsFromJson();
        while (true) {
            System.out.println("1. Реєстрація");
            System.out.println("2. Логін");
            System.out.println("3. Залишити відгук");
            System.out.println("4. Переглянути відгуки");
            System.out.println("5. Вийти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    leaveReview();
                    break;
                case 4:
                    viewReviews();
                    break;
                case 5:
                    saveReviews();
                    System.out.println("Дякую за використання нашої книги відгуків! До побачення!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }

    /**
     * Реєстрація нового користувача в системі.
     */
    private static void register() {
        System.out.println("Введіть ім'я користувача:");
        String username = scanner.nextLine();
        System.out.println("Введіть пароль:");
        String password = scanner.nextLine();
        users.put(username, password);
        System.out.println("Реєстрація успішна!");
    }

    /**
     * Авторизація користувача в системі.
     */
    private static void login() {
        System.out.println("Введіть ім'я користувача:");
        String username = scanner.nextLine();
        System.out.println("Введіть пароль:");
        String password = scanner.nextLine();
        if (users.containsKey(username) && users.get(username).equals(password)) {
            currentUser = username;
            System.out.println("Ви увійшли як " + currentUser);
        } else {
            System.out.println("Невірний ім'я користувача або пароль.");
        }
    }

    /**
     * Залишення відгуку про кафе поточним користувачем.
     */
    private static void leaveReview() {
        if (currentUser == null) {
            System.out.println("Будь ласка, увійдіть в систему, щоб залишити відгук.");
            return;
        }
        System.out.println("Введіть ваш відгук:");
        String review = scanner.nextLine();
        reviews.put(currentUser, review);
        System.out.println("Відгук успішно додано!");
    }

    /**
     * Виведення всіх наявних відгуків про кафе.
     */
    private static void viewReviews() {
        if (reviews.isEmpty()) {
            System.out.println("Наразі немає відгуків.");
            return;
        }
        System.out.println("Відгуки:");
        for (String user : reviews.keySet()) {
            System.out.println(user + ": " + reviews.get(user));
        }
    }

    /**
     * Збереження всіх відгуків до файлів у форматах txt та json.
     */
    private static void saveReviews() {
        saveReviewsAsTxt();
        saveReviewsAsJson();
    }

    /**
     * Збереження відгуків до текстового файлу.
     */
    private static void saveReviewsAsTxt() {
        try {
            FileWriter writer = new FileWriter(REVIEWS_TXT_FILE_PATH);
            for (String user : reviews.keySet()) {
                writer.write(user + ":" + reviews.get(user) + "\n");
            }
            writer.close();
            System.out.println("Відгуки успішно збережено у текстовому файлі.");
        } catch (IOException e) {
            System.out.println("Помилка при збереженні відгуків у текстовому файлі.");
        }
    }

    /**
     * Збереження відгуків до файлу у форматі json.
     */
    private static void saveReviewsAsJson() {
        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter(REVIEWS_JSON_FILE_PATH);
            gson.toJson(reviews, writer);
            writer.close();
            System.out.println("Відгуки успішно збережено у JSON файлі.");
        } catch (IOException e) {
            System.out.println("Помилка при збереженні відгуків у JSON файлі.");
        }
    }

    /**
     * Завантаження відгуків з текстового файлу при запуску програми.
     */
    private static void loadReviewsFromTxt() {
        try {
            File file = new File(REVIEWS_TXT_FILE_PATH);
            if (file.exists()) {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split(":");
                    reviews.put(parts[0], parts[1]);
                }
                fileScanner.close();
            }
        } catch (IOException e) {
            System.out.println("Помилка при завантаженні відгуків з текстового файлу.");
        }
    }

    /**
     * Завантаження відгуків з файлу у форматі json при запуску програми.
     */
    private static void loadReviewsFromJson() {
        try {
            File file = new File(REVIEWS_JSON_FILE_PATH);
            if (file.exists()) {
                Gson gson = new Gson();
                Type type = new TypeToken<HashMap<String, String>>(){}.getType();
                reviews = gson.fromJson(new FileReader(file), type);
            }
        } catch (IOException e) {
            System.out.println("Помилка при завантаженні відгуків з JSON файлу.");
        }
    }
}
