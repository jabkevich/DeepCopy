package list;

import java.util.AbstractList;
import java.util.Arrays;

/**
 * @author jabkevich
 */
public class CustomList<E> extends AbstractList<E> {

    private Object[] elements; // Хранилище для элементов списка
    private int size = 0;      // Текущий размер списка

    // Конструктор с начальной ёмкостью
    public CustomList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Initial capacity cannot be negative: " + initialCapacity);
        }
        elements = new Object[initialCapacity];
    }

    // Конструктор по умолчанию
    public CustomList() {
        this(10); // Вызываем конструктор с начальной ёмкостью 10
    }

    // Метод добавления элемента в список
    @Override
    public boolean add(E e) {
        ensureCapacity(size + 1); // Увеличиваем размер массива, если нужно
        elements[size++] = e;     // Добавляем элемент и увеличиваем размер
        return true;
    }

    // Метод получения элемента по индексу
    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    // Метод установки элемента по индексу
    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E oldValue = (E) elements[index];
        elements[index] = element;
        return oldValue;
    }

    // Метод возвращает текущий размер списка
    @Override
    public int size() {
        return size;
    }

    // Внутренний метод проверки индекса
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Метод для увеличения ёмкости при необходимости
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2; // Удваиваем ёмкость
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    // Метод удаления элемента по индексу
    @Override
    public E remove(int index) {
        checkIndex(index);
        E oldValue = (E) elements[index];

        // Сдвигаем элементы влево
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // Уменьшаем размер и удаляем последний элемент

        return oldValue;
    }


}
