import com.example.DeepCopy;

import entities.Person;
import entities.PersonWithoutConstructors;
import org.junit.jupiter.api.Test;
import utils.PersonUtils;

import java.time.DayOfWeek;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

/**
 * @author jabkevich
 */
public class DeepCopyMapHardDataTests {

    @Test
    public void testHashMap() throws Exception {
        HashMap<String, Person> map = new HashMap<>();
        map.put("a", PersonUtils.getTestPerson());
        map.put("b", PersonUtils.getTestPerson());
        HashMap<String, Person> copy = (HashMap<String, Person>) DeepCopy.deepCopy(map);
        assertNotSame(map, copy);
        assertEquals(map, copy);
    }

    @Test
    public void testLinkedHashMap() throws Exception {
        HashMap<String, Person> map = new HashMap<>();

        map.put("a", PersonUtils.getTestPerson());
        map.put("b", PersonUtils.getTestPerson());

        HashMap<String, Person> copy = (HashMap<String, Person>) DeepCopy.deepCopy(map);

        assertNotSame(map, copy);
        assertEquals(map, copy);

    }

    @Test
    public void testEnumMap() throws Exception {
        TreeMap<DayOfWeek, Person> map = new TreeMap<>();
        map.put(DayOfWeek.MONDAY, PersonUtils.getTestPerson());
        map.put(DayOfWeek.TUESDAY, PersonUtils.getTestPerson());
        map.put(DayOfWeek.WEDNESDAY, PersonUtils.getTestPerson());
        TreeMap<DayOfWeek, Person> copy = (TreeMap<DayOfWeek, Person>) DeepCopy.deepCopy(map);
        assertNotSame(map, copy);
        assertEquals(map, copy);
    }


    /**
     * IdentityHashMap
     * singletonMap
     * emptyMap
     * Map.of
     * Map.ofEntries
     *
     * TreeMap
     *
     * AbstractMap.SimpleEntry
     * AbstractMap.SimpleImmutableEntry
     * Map.entry
     */

    @Test
    public void testIdentityHashMap() throws Exception {
        AbstractMap<String, Person> map = new IdentityHashMap<>();
        map.put("a", PersonUtils.getTestPerson());
        map.put("b", PersonUtils.getTestPerson());
        map.put("c", PersonUtils.getTestPerson());
        AbstractMap<String, Person> copy = (AbstractMap<String, Person>) DeepCopy.deepCopy(map);
        assertNotSame(map, copy);
        assertEquals(map.get("a"), copy.get("a"));
        assertNotSame(map.get("a"), copy.get("a"));
        assertEquals(map.get("b"), copy.get("b"));
        assertNotSame(map.get("b"), copy.get("b"));
        assertEquals(map.get("c"), copy.get("c"));
        assertNotSame(map.get("c"), copy.get("c"));
    }

    @Test
    public void testSingletonMap() throws Exception {
        AbstractMap<String, Person> map = new HashMap<>();
        map.put("a", PersonUtils.getTestPerson());
        AbstractMap<String, Person> copy = (AbstractMap<String, Person>) DeepCopy.deepCopy(map);
        assertNotSame(map, copy);
        assertEquals(map, copy);
    }

    @Test
    public void testEmptyMap() throws Exception {
        AbstractMap<String, Person> map = new HashMap<>();
        AbstractMap<String, Person> copy = (AbstractMap<String, Person>) DeepCopy.deepCopy(map);
        assertNotSame(map, copy);
        assertEquals(map, copy);
    }

    @Test
    public void testMapOf() throws Exception {
        AbstractMap<String, Person> map = new HashMap<>();
        map.put("a", PersonUtils.getTestPerson());
        map.put("b", PersonUtils.getTestPerson());
        map.put("c", PersonUtils.getTestPerson());
        AbstractMap<String, Person> copy = (AbstractMap<String, Person>) DeepCopy.deepCopy(map);
        assertNotSame(map, copy);
        assertEquals(map, copy);
    }

    @Test
    public void testMapOfEntries() throws Exception {
        AbstractMap<String, Person> map = new HashMap<>();
        map.put("a", PersonUtils.getTestPerson());
        map.put("b", PersonUtils.getTestPerson());
        map.put("c", PersonUtils.getTestPerson());
        AbstractMap<String, Person> copy = (AbstractMap<String, Person>) DeepCopy.deepCopy(map);
        assertNotSame(map, copy);
        assertEquals(map, copy);
    }


    @Test
    public void testTreeMap() throws Exception {
        TreeMap<String, Person> map = new TreeMap<>();
        map.put("a", PersonUtils.getTestPerson());
        map.put("b", PersonUtils.getTestPerson());
        map.put("c", PersonUtils.getTestPerson());
        TreeMap<String, Person> copy = (TreeMap<String, Person>) DeepCopy.deepCopy(map);
        assertNotSame(map, copy);
        assertEquals(map, copy);
    }


    @Test
    public void testAbstractMapSimpleEntry() throws Exception {
        AbstractMap.SimpleEntry<String, Person> entry = new AbstractMap.SimpleEntry<>("a", PersonUtils.getTestPerson());
        AbstractMap.SimpleEntry<String, Person> copy = (AbstractMap.SimpleEntry<String, Person>) DeepCopy.deepCopy(entry);
        assertNotSame(entry, copy);
        assertEquals(entry, copy);
    }


    @Test
    public void testAbstractMapSimpleImmutableEntry() throws Exception {
        AbstractMap.SimpleImmutableEntry<String, Person> entry = new AbstractMap.SimpleImmutableEntry<>("a", PersonUtils.getTestPerson());
        AbstractMap.SimpleImmutableEntry<String, Person> copy = (AbstractMap.SimpleImmutableEntry<String, Person>) DeepCopy.deepCopy(entry);
        assertNotSame(entry, copy);
        assertEquals(entry, copy);
    }

    @Test
    public void testTest() throws Exception {
        AbstractMap.SimpleImmutableEntry<String, PersonWithoutConstructors> entry = new AbstractMap.SimpleImmutableEntry<>("a", PersonUtils.getTestPersonWithoutContructors());
        AbstractMap.SimpleImmutableEntry<String, PersonWithoutConstructors> copy = (AbstractMap.SimpleImmutableEntry<String, PersonWithoutConstructors>) DeepCopy.deepCopy(entry);
        assertNotSame(entry, copy);
        assertEquals(entry, copy);
    }
}
