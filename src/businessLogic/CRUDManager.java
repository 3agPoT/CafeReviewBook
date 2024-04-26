package businessLogic;

import java.util.HashMap;

/**
 * Клас, що надає основні операції створення, зчитування, оновлення та видалення (CRUD) елементів у колекції з використанням HashMap.
 *
 * @param <T> тип значення, що зберігається у колекції
 */
public class CRUDManager<T> {
    private HashMap<String, T> dataStore;

    /**
     * Конструктор за замовчуванням, що ініціалізує пусту колекцію HashMap.
     */
    public CRUDManager() {
        this.dataStore = new HashMap<>();
    }

    /**
     * Додає новий запис до колекції з вказаним ключем та значенням.
     *
     * @param key   ключ для нового запису
     * @param value значення для нового запису
     */
    public void create(String key, T value) {
        dataStore.put(key, value);
    }

    /**
     * Повертає значення з колекції за вказаним ключем.
     *
     * @param key ключ, за яким потрібно отримати значення
     * @return значення, що відповідає вказаному ключу
     */
    public T read(String key) {
        return dataStore.get(key);
    }

    /**
     * Оновлює запис у колекції за вказаним ключем з новим значенням.
     *
     * @param key   ключ запису, який потрібно оновити
     * @param value нове значення для оновлення запису
     */
    public void update(String key, T value) {
        if (dataStore.containsKey(key)) {
            dataStore.put(key, value);
        } else {
            System.out.println("Запис з ключем " + key + " не існує.");
        }
    }

    /**
     * Видаляє запис з колекції за вказаним ключем.
     *
     * @param key ключ запису, який потрібно видалити
     */
    public void delete(String key) {
        dataStore.remove(key);
    }
}
