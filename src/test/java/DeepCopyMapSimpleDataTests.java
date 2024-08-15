import com.example.DeepCopy;
import org.junit.jupiter.api.Test;

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
public class DeepCopyMapSimpleDataTests {
    @Test
    public void testHashMap() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        HashMap<String, String> copy = (HashMap<String, String>) DeepCopy.deepCopy(map);
        assertNotSame(map, copy);
        assertEquals(map, copy);
    }

    @Test
    public void testLinkedHashMap() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        HashMap<String, String> copy = (HashMap<String, String>) DeepCopy.deepCopy(map);
        assertNotSame(map, copy);
        assertEquals(map, copy);
    }

    @Test
    public void testEnumMap() throws Exception {
        TreeMap<DayOfWeek, String> map = new TreeMap<>();
        map.put(DayOfWeek.MONDAY, "1");
        map.put(DayOfWeek.TUESDAY, "2");
        map.put(DayOfWeek.WEDNESDAY, "3");
        TreeMap<DayOfWeek, String> copy = (TreeMap<DayOfWeek, String>) DeepCopy.deepCopy(map);
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
        AbstractMap<String, String> map = new IdentityHashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        AbstractMap<String, String> copy = (AbstractMap<String, String>) DeepCopy.deepCopy(map);
        assertNotSame(map, copy);
        assertEquals(map, copy);
    }

    @Test
    public void testSingletonMap() throws Exception {
        AbstractMap<String, String> map = new HashMap<>();
        map.put("a", "1");
        AbstractMap<String, String> copy = (AbstractMap<String, String>) DeepCopy.deepCopy(map);
        assertNotSame(map, copy);
        assertEquals(map, copy);
    }

    @Test
    public void testEmptyMap() throws Exception {
        AbstractMap<String, String> map = new HashMap<>();
        AbstractMap<String, String> copy = (AbstractMap<String, String>) DeepCopy.deepCopy(map);
        assertNotSame(map, copy);
        assertEquals(map, copy);
    }

    @Test
    public void testMapOf() throws Exception {
        AbstractMap<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        AbstractMap<String, String> copy = (AbstractMap<String, String>) DeepCopy.deepCopy(map);
        assertNotSame(map, copy);
        assertEquals(map, copy);
    }

    @Test
    public void testMapOfEntries() throws Exception {
        AbstractMap<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        AbstractMap<String, String> copy = (AbstractMap<String, String>) DeepCopy.deepCopy(map);
        assertNotSame(map, copy);
        assertEquals(map, copy);
    }


    @Test
    public void testTreeMap() throws Exception {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        TreeMap<String, String> copy = (TreeMap<String, String>) DeepCopy.deepCopy(map);
        assertNotSame(map, copy);
        assertEquals(map, copy);
    }


    @Test
    public void testAbstractMapSimpleEntry() throws Exception {
        AbstractMap.SimpleEntry<String, String> entry = new AbstractMap.SimpleEntry<>("a", "1");
        AbstractMap.SimpleEntry<String, String> copy = (AbstractMap.SimpleEntry<String, String>) DeepCopy.deepCopy(entry);
        assertNotSame(entry, copy);
        assertEquals(entry, copy);
    }


    @Test
    public void testAbstractMapSimpleImmutableEntry() throws Exception {
        AbstractMap.SimpleImmutableEntry<String, String> entry = new AbstractMap.SimpleImmutableEntry<>("a", "1");
        AbstractMap.SimpleImmutableEntry<String, String> copy = (AbstractMap.SimpleImmutableEntry<String, String>) DeepCopy.deepCopy(entry);
        assertNotSame(entry, copy);
        assertEquals(entry, copy);
    }


}
