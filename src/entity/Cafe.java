package entity;

/**
 * Представляє кафе з вказаним ім'ям, адресою і категорією.
 */
public class Cafe {
    private String name;
    private String address;
    private String category;

    /**
     * Конструктор для створення нового об'єкта кафе з вказаними даними.
     *
     * @param name     ім'я кафе
     * @param address  адреса кафе
     * @param category категорія кафе (наприклад, кав'ярня, ресторан і т.д.)
     */
    public Cafe(String name, String address, String category) {
        this.name = name;
        this.address = address;
        this.category = category;
    }

    /**
     * Повертає ім'я кафе.
     *
     * @return ім'я кафе
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає адресу кафе.
     *
     * @return адреса кафе
     */
    public String getAddress() {
        return address;
    }

    /**
     * Повертає категорію кафе.
     *
     * @return категорія кафе
     */
    public String getCategory() {
        return category;
    }
}
