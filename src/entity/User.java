package entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Представляє користувача системи з автентифікацією за допомогою ім'я користувача та хешованого паролю.
 */
public class User {
    private String username;     // Ім'я користувача
    private String passwordHash; // Хеш паролю користувача

    /**
     * Конструктор для створення нового користувача з вказаним ім'ям та паролем.
     *
     * @param username ім'я користувача
     * @param password пароль користувача
     */
    public User(String username, String password) {
        this.username = username;
        this.passwordHash = hashPassword(password);
    }

    /**
     * Повертає ім'я користувача.
     *
     * @return ім'я користувача
     */
    public String getUsername() {
        return username;
    }

    /**
     * Перевіряє, чи співпадає вказаний пароль з паролем користувача.
     *
     * @param password пароль для перевірки
     * @return true, якщо пароль співпадає з паролем користувача; false - в іншому випадку
     */
    public boolean checkPassword(String password) {
        return hashPassword(password).equals(passwordHash);
    }

    /**
     * Хешує вказаний пароль за допомогою алгоритму SHA-256.
     *
     * @param password пароль для хешування
     * @return хеш паролю у вигляді рядка шістнадцяткового представлення
     */
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
