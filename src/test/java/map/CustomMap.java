package map;

import java.util.AbstractMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

/**
 * @author jabkevich
 */

public class CustomMap<K, V> extends AbstractMap<K, V> {

    private Set<Map.Entry<K, V>> entrySet = new HashSet<>();

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return entrySet;
    }

    @Override
    public V put(K key, V value) {
        for (Map.Entry<K, V> entry : entrySet) {
            if (Objects.equals(entry.getKey(), key)) {
                V oldValue = entry.getValue();
                entrySet.remove(entry); // Удаляем старую запись
                entrySet.add(new SimpleEntry<>(key, value)); // Добавляем обновленную запись
                return oldValue;
            }
        }
        entrySet.add(new SimpleEntry<>(key, value));
        return null;
    }

    @Override
    public V get(Object key) {
        for (Map.Entry<K, V> entry : entrySet) {
            if (Objects.equals(entry.getKey(), key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        for (Map.Entry<K, V> entry : entrySet) {
            if (Objects.equals(entry.getKey(), key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V remove(Object key) {
        for (Map.Entry<K, V> entry : entrySet) {
            if (Objects.equals(entry.getKey(), key)) {
                V value = entry.getValue();
                entrySet.remove(entry);
                return value;
            }
        }
        return null;
    }

    // Для удобства добавим метод, чтобы получить размер карты
    @Override
    public int size() {
        return entrySet.size();
    }
}
