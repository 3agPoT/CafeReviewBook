package entity;

/**
 * Представляє відгук користувача на об'єкт або послугу.
 */
class Review {
    private String user;    // Користувач, що залишив відгук
    private String content; // Вміст відгуку

    /**
     * Конструктор для створення нового об'єкта відгуку з вказаними даними.
     *
     * @param user    ім'я користувача, який залишив відгук
     * @param content текст відгуку
     */
    public Review(String user, String content) {
        this.user = user;
        this.content = content;
    }

    /**
     * Повертає ім'я користувача, який залишив відгук.
     *
     * @return ім'я користувача
     */
    public String getUser() {
        return user;
    }

    /**
     * Повертає вміст відгуку.
     *
     * @return вміст відгуку
     */
    public String getContent() {
        return content;
    }
}
