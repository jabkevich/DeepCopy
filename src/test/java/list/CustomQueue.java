package list;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author jabkevich
 */
public class CustomQueue<E> extends AbstractQueue<E> {

    private Object[] elements;
    private int head = 0;   // Указывает на первый элемент
    private int tail = 0;   // Указывает на следующий свободный индекс
    private int size = 0;   // Текущий размер очереди

    public CustomQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        elements = new Object[capacity];
    }

    public CustomQueue() {
        this(10);
    }

    @Override
    public boolean offer(E e) {
        if (size == elements.length) {
            return false; // Очередь заполнена
        }
        elements[tail] = e;
        tail = (tail + 1) % elements.length; // Циклически увеличиваем tail
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (size == 0) {
            return null; // Очередь пуста
        }
        E element = (E) elements[head];
        elements[head] = null; // Удаляем элемент
        head = (head + 1) % elements.length; // Циклически увеличиваем head
        size--;
        return element;
    }

    @Override
    public E peek() {
        if (size == 0) {
            return null; // Очередь пуста
        }
        return (E) elements[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = head;
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E element = (E) elements[index];
                index = (index + 1) % elements.length;
                count++;
                return element;
            }
        };
    }
}
