import com.example.DeepCopy;

import entities.Person;
import org.junit.jupiter.api.Test;
import utils.PersonUtils;

import java.lang.reflect.InvocationTargetException;
import java.time.DayOfWeek;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jabkevich
 */
public class DeepCopyCollectionHardDataTests {


    @Test
    public void testLinkedList() throws Exception {
        // given
        LinkedList<Person> list = new LinkedList<>();
        list.add(PersonUtils.getTestPerson());
        list.add(PersonUtils.getTestPerson());

        // when
        LinkedList<Person> copy = (LinkedList<Person>) DeepCopy.deepCopy(list);

        // then
        assertNotSame(list, copy);
        assertEquals(list, copy);


    }

    @Test
    public void testArrayList() throws Exception {
        // given
        ArrayList<Person> list = new ArrayList<>();
        list.add(PersonUtils.getTestPerson());
        list.add(PersonUtils.getTestPerson());

        // when
        ArrayList<Person> copy = (ArrayList<Person>) DeepCopy.deepCopy(list);

        // then
        assertNotSame(list, copy);
        assertEquals(list, copy);

    }

    @Test
    public void testAsList() throws Exception {
        // given
        List<Person> list = Arrays.asList(PersonUtils.getTestPerson(), PersonUtils.getTestPerson());

        // when
        List<Person> copy = (List<Person>) DeepCopy.deepCopy(list);

        // then

        assertNotSame(list, copy);
        assertEquals(list, copy);
    }

    @Test
    public void testNCopies() throws Exception {
        // given
        List<Person> list = Collections.nCopies(2, PersonUtils.getTestPerson());

        // when
        List<Person> copy = (List<Person>) DeepCopy.deepCopy(list);

        // then
        assertNotSame(list, copy);
        assertEquals(list, copy);
    }

    @Test
    public void testSingletonList() throws Exception {
        // given
        List<Person> list = Collections.singletonList(PersonUtils.getTestPerson());

        // when
        List<Person> copy = (List<Person>) DeepCopy.deepCopy(list);

        // then
        assertNotSame(list, copy);
        assertEquals(list, copy);
    }

    @Test
    public void testEmptyList() throws Exception {
        // given
        List<Person> list = Collections.emptyList();

        // when
        List<Person> copy = (List<Person>) DeepCopy.deepCopy(list);

        // then
        assertNotSame(list, copy);
        assertEquals(list, copy);
    }

    @Test
    public void testEmptySet() throws Exception {
        // given
        Set<Person> set = Collections.emptySet();

        // when
        Set<Person> copy = (Set<Person>) DeepCopy.deepCopy(set);

        // then
        assertNotSame(set, copy);
        assertEquals(set, copy);
    }

    @Test
    public void testSetOf() throws Exception {
        // given
        Set<Person> set = Set.of(PersonUtils.getTestPerson(), PersonUtils.getTestPerson());

        // when
        Set<Person> copy = (Set<Person>) DeepCopy.deepCopy(set);

        // then
        assertNotSame(set, copy);
        assertEquals(set, copy);
    }

    @Test
    public void testListOf() throws Exception {
        // given
        List<Person> list = List.of(PersonUtils.getTestPerson(), PersonUtils.getTestPerson());

        // when
        List<Person> copy = (List<Person>) DeepCopy.deepCopy(list);

        // then
        assertNotSame(list, copy);


    }

    @Test
    public void testHashSet() throws Exception {
        // given
        HashSet<Person> set = new HashSet<>();
        set.add(new Person(25, "Alice"));
        set.add(new Person(30, "Bob"));

        // when
        HashSet<Person> copy = (HashSet<Person>) DeepCopy.deepCopy(set);

        // then
        assertNotSame(set, copy);
        assertEquals(set, copy);
    }

    @Test
    public void testSingleton() throws Exception {
        // given
        Set<Person> set = Collections.singleton(new Person(25, "Alice"));

        // when
        Set<Person> copy = (Set<Person>) DeepCopy.deepCopy(set);

        // then
        assertNotSame(set, copy);
        assertEquals(set, copy);
    }

    @Test
    public void testEnumSet() throws Exception {
        // given
        EnumSet<DayOfWeek> set = EnumSet.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY);

        // when
        EnumSet<DayOfWeek> copy = (EnumSet<DayOfWeek>) DeepCopy.deepCopy(set);

        // then
        assertNotSame(set, copy);
        assertEquals(set, copy);
    }

    @Test

    public void testLinkedHashSet() throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        // given
        LinkedHashSet<Person> set = new LinkedHashSet<>();
        set.add(new Person(25, "Alice"));
        set.add(new Person(30, "Bob"));

        // when
        LinkedHashSet<Person> copy = (LinkedHashSet<Person>) DeepCopy.deepCopy(set);

        // then
        assertNotSame(set, copy);

        assertNotSame(set.getFirst(), copy.getFirst());
        assertEquals(set.getFirst().getAge(), copy.getFirst().getAge());
        assertEquals(set.getFirst().getName(), copy.getFirst().getName());

        assertNotSame(set.getLast(), copy.getLast());
        assertEquals(set.getLast().getAge(), copy.getLast().getAge());
        assertEquals(set.getLast().getName(), copy.getLast().getName());

    }

    @Test
    public void testTreeSet() throws Exception {
        // given
        TreeSet<Person> set = new TreeSet<>();
        set.add(new Person(25, "Alice"));
        set.add(new Person(30, "Bob"));

        // when
        TreeSet<Person> copy = (TreeSet<Person>) DeepCopy.deepCopy(set);

        // then
        assertNotSame(set, copy);
        assertEquals(set, copy);
    }

    @Test
    public void testArrayDeque() throws Exception {
        // given
        ArrayDeque<Person> deque = new ArrayDeque<>();
        deque.add(PersonUtils.getTestPerson());
//        deque.add(PersonUtils.getTestPerson());

        // when
        ArrayDeque<Person> copy = (ArrayDeque<Person>) DeepCopy.deepCopy(deque);

        // then
        assertNotSame(deque, copy);
        assertEquals(deque.getFirst(), copy.getFirst());
        assertEquals(deque.getLast(), copy.getLast());

    }

    @Test
    public void testPriorityQueue() throws Exception {
        // given
        PriorityQueue<Person> queue = new PriorityQueue<>();
        queue.add(PersonUtils.getTestPerson());
        queue.add(PersonUtils.getTestPerson());

        // when
        PriorityQueue<Person> copy = (PriorityQueue<Person>) DeepCopy.deepCopy(queue);

        // then
        assertNotSame(queue, copy);
        assertNotSame(queue.peek(), copy.peek());
        assertEquals(queue.peek(), copy.peek());
    }


    @Test
    public void testArray() throws Exception {
        // given
        Person[] array = new Person[]{new Person(25, "Alice"), new Person(30, "Bob")};

        // when
        Person[] copy = (Person[]) DeepCopy.deepCopy(array);

        // then
        assertNotSame(array, copy);
        assertArrayEquals(array, copy);
    }
}
