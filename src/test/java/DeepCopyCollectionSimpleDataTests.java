import com.example.DeepCopy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.time.DayOfWeek;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jabkevich
 */
public class DeepCopyCollectionSimpleDataTests {


    @Test
    public void testLinkedList() throws Exception {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        LinkedList<String> copy = (LinkedList<String>) DeepCopy.deepCopy(list);
        assertNotSame(list, copy);
        assertEquals(list, copy);
    }

    @Test
    public void testArrayList() throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        ArrayList<String> copy = (ArrayList<String>) DeepCopy.deepCopy(list);
        assertNotSame(list, copy);
        assertEquals(list, copy);
    }

    @Test
    public void testAsList() throws Exception {
        List<String> list = Arrays.asList("a", "b", "c");
        List<String> copy = (List<String>) DeepCopy.deepCopy(list);
        assertNotSame(list, copy);
        assertEquals(list, copy);
    }

    @Test
    public void testNCopies() throws Exception {
        List<String> list = Collections.nCopies(3, "a");
        List<String> copy = (List<String>) DeepCopy.deepCopy(list);
        assertNotSame(list, copy);
        assertEquals(list, copy);
    }

    @Test
    public void testSingletonList() throws Exception {
        List<String> list = Collections.singletonList("a");
        List<String> copy = (List<String>) DeepCopy.deepCopy(list);
        assertNotSame(list, copy);
        assertEquals(list, copy);
    }

    @Test
    public void testEmptyList() throws Exception {
        List<String> list = Collections.emptyList();
        List<String> copy = (List<String>) DeepCopy.deepCopy(list);
        assertNotSame(list, copy);
        assertEquals(list, copy);
    }
    @Test
    public void testEmptySet() throws Exception {
        Set<String> set = Collections.emptySet();
        Set<String> copy = (Set<String>) DeepCopy.deepCopy(set);
        assertNotSame(set, copy);
        assertEquals(set, copy);
    }
    @Test
    public void testSetOf() throws Exception {
        Set<String> set = Set.of("a", "b", "c");
        Set<String> copy = (Set<String>) DeepCopy.deepCopy(set);
        assertNotSame(set, copy);
        assertEquals(set, copy);
    }
    @Test
    public void testListOf() throws Exception {
        List<String> list = List.of("a", "b", "c");
        List<String> copy = (List<String>) DeepCopy.deepCopy(list);
        assertNotSame(list, copy);
        assertEquals(list, copy);
    }

    @Test
    public void testHashSet() throws Exception {
        HashSet<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        HashSet<String> copy = (HashSet<String>) DeepCopy.deepCopy(set);
        assertNotSame(set, copy);
        assertEquals(set, copy);
    }

    @Test
    public void testSingleton() throws Exception {
        Set<String> set = Collections.singleton("a");
        Set<String> copy = (Set<String>) DeepCopy.deepCopy(set);
        assertNotSame(set, copy);
        assertEquals(set, copy);
    }

    @Test
    public void testEnumSet() throws Exception {
        EnumSet<DayOfWeek> set = EnumSet.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY);
        EnumSet<DayOfWeek> copy = (EnumSet<DayOfWeek>) DeepCopy.deepCopy(set);
        assertNotSame(set, copy);
        assertEquals(set, copy);
    }

    @Test

    public void testLinkedHashSet() throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        LinkedHashSet<String> copy = (LinkedHashSet<String>) DeepCopy.deepCopy(set);
        assertNotSame(set, copy);
        assertEquals(set, copy);
    }

    @Test
    public void testTreeSet() throws Exception {
        TreeSet<String> set = new TreeSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        TreeSet<String> copy = (TreeSet<String>) DeepCopy.deepCopy(set);
        assertNotSame(set, copy);
        assertEquals(set, copy);
    }

    @Test
    public void testArrayDeque() throws Exception {
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.add("a");
        deque.add("b");
        deque.add("c");
        ArrayDeque<String> copy = (ArrayDeque<String>) DeepCopy.deepCopy(deque);
        assertNotSame(deque, copy);
        for (int i = 0; i < deque.size(); i++) {
            assertEquals(deque.poll(), copy.poll());
        }
    }

    @Test
    public void testPriorityQueue() throws Exception {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        PriorityQueue<String> copy = (PriorityQueue<String>) DeepCopy.deepCopy(queue);
        assertNotSame(queue, copy);
        for (int i = 0; i < queue.size(); i++) {
            assertEquals(queue.poll(), copy.poll());
        }
    }


    @Test
    public void testArray() throws Exception {
        String[] array = new String[] {"a", "b", "c"};
        String[] copy = (String[]) DeepCopy.deepCopy(array);
        assertNotSame(array, copy);
        assertArrayEquals(array, copy);
    }
}
