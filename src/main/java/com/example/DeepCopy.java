package com.example;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author jabkevich
 */
public class DeepCopy {

    public static Object deepCopy(Object original) throws
            IllegalAccessException,
            InstantiationException,
            InvocationTargetException,
            NoSuchMethodException
    {
        Map<Object, Object> copiedObjects = new IdentityHashMap<>();
        return deepCopyRecursive(original, copiedObjects);
    }

    private static Object deepCopyRecursive(Object original, Map<Object, Object> copiedObjects) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        if (original == null) {
            return null;
        }

        if (copiedObjects.containsKey(original)) {
            return copiedObjects.get(original);
        }

        Class<?> clazz = original.getClass();

        if (AbstractMap.SimpleEntry.class.isAssignableFrom(clazz)) {
            AbstractMap.SimpleEntry<?, ?> originalEntry = (AbstractMap.SimpleEntry<?, ?>) original;
            Object keyCopy = deepCopyRecursive(originalEntry.getKey(), copiedObjects);
            Object valueCopy = deepCopyRecursive(originalEntry.getValue(), copiedObjects);
            AbstractMap.SimpleEntry<Object, Object> copy = new AbstractMap.SimpleEntry<>(keyCopy, valueCopy);
            copiedObjects.put(original, copy);
            return copy;
        }

        if (AbstractMap.SimpleImmutableEntry.class.isAssignableFrom(clazz)) {
            AbstractMap.SimpleImmutableEntry<?, ?> originalEntry = (AbstractMap.SimpleImmutableEntry<?, ?>) original;
            Object keyCopy = deepCopyRecursive(originalEntry.getKey(), copiedObjects);
            Object valueCopy = deepCopyRecursive(originalEntry.getValue(), copiedObjects);
            AbstractMap.SimpleImmutableEntry<Object, Object> copy = new AbstractMap.SimpleImmutableEntry<>(keyCopy, valueCopy);
            copiedObjects.put(original, copy);
            return copy;
        }

        if (clazz.isArray()) {
            int length = Array.getLength(original);
            Object arrayCopy = Array.newInstance(clazz.getComponentType(), length);
            copiedObjects.put(original, arrayCopy);

            for (int i = 0; i < length; i++) {
                Array.set(arrayCopy, i, deepCopyRecursive(Array.get(original, i), copiedObjects));
            }
            return arrayCopy;
        }

        if (EnumSet.class.isAssignableFrom(clazz)) {
            EnumSet<?> originalEnumSet = (EnumSet<?>) original;
            EnumSet<?> copyEnumSet = EnumSet.copyOf(originalEnumSet);
            copiedObjects.put(original, copyEnumSet);
            return copyEnumSet;
        }

        if (Collection.class.isAssignableFrom(clazz)) {
            Collection<?> originalCollection = (Collection<?>) original;
            Collection<Object> copyCollection = createCollectionInstance(clazz, originalCollection.size());
            copiedObjects.put(original, copyCollection);

            for (Object item : originalCollection) {
                copyCollection.add(deepCopyRecursive(item, copiedObjects));
            }
            return copyCollection;
        }

        if (Map.class.isAssignableFrom(clazz)) {
            Map<?, ?> originalMap = (Map<?, ?>) original;
            Map<Object, Object> copyMap = createMapInstance(clazz);
            copiedObjects.put(original, copyMap);

            for (Map.Entry<?, ?> entry : originalMap.entrySet()) {
                Object keyCopy = deepCopyRecursive(entry.getKey(), copiedObjects);
                Object valueCopy = deepCopyRecursive(entry.getValue(), copiedObjects);
                copyMap.put(keyCopy, valueCopy);
            }
            return copyMap;
        }

        if (clazz.isPrimitive() || clazz == String.class || clazz.isEnum() ||
                Number.class.isAssignableFrom(clazz) || Boolean.class.isAssignableFrom(clazz) ||
                Character.class.isAssignableFrom(clazz) || Date.class.isAssignableFrom(clazz) ||
                clazz.getPackage().getName().startsWith("java.")) {
            return original;
        }

        Object copy;
        try {
            copy = clazz.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException e) {
            copy = createInstanceWithParams(clazz, original);
        }

        copiedObjects.put(original, copy);

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object fieldValue = field.get(original);
            Object fieldCopy = deepCopyRecursive(fieldValue, copiedObjects);
            field.set(copy, fieldCopy);
        }

        return copy;
    }

    private static Collection<Object> createCollectionInstance(Class<?> collectionClass, int size) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (ArrayDeque.class.isAssignableFrom(collectionClass)) {
            return new ArrayDeque<>(size);
        } else if (PriorityQueue.class.isAssignableFrom(collectionClass)) {
            return new PriorityQueue<>(size);
        } else if (LinkedHashSet.class.isAssignableFrom(collectionClass)) {
            return new LinkedHashSet<>(size);
        } else if (Queue.class.isAssignableFrom(collectionClass)) {
            return new LinkedList<>();
        } else if (SortedSet.class.isAssignableFrom(collectionClass)) {
            return new TreeSet<>();
        } else if (Set.class.isAssignableFrom(collectionClass)) {
            return new HashSet<>(size);
        } else if (List.class.isAssignableFrom(collectionClass)) {
            return new ArrayList<>(size);
        } else if (Collection.class.isAssignableFrom(collectionClass)) {
            return (Collection<Object>) collectionClass.getDeclaredConstructor().newInstance();
        } else {
            throw new IllegalArgumentException("Unknown Collection type: " + collectionClass);
        }
    }

    private static Map<Object, Object> createMapInstance(Class<?> mapClass) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (SortedMap.class.isAssignableFrom(mapClass)) {
            return new TreeMap<>();
        } else if (Map.class.isAssignableFrom(mapClass)) {
            return new HashMap<>();
        } else {
            throw new IllegalArgumentException("Unknown Map type: " + mapClass);
        }
    }

    private static Object getDefaultValue(Class<?> clazz) {
        if (clazz.isPrimitive()) {
            if (clazz == boolean.class) {
                return false;
            } else if (clazz == byte.class) {
                return (byte) 0;
            } else if (clazz == short.class) {
                return (short) 0;
            } else if (clazz == int.class) {
                return 0;
            } else if (clazz == long.class) {
                return 0L;
            } else if (clazz == float.class) {
                return 0.0f;
            } else if (clazz == double.class) {
                return 0.0;
            } else if (clazz == char.class) {
                return '\u0000';
            }
        }
        return null;
    }

    private static Object createInstanceWithParams(Class<?> clazz, Object original) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            constructor.setAccessible(true);
            Class<?>[] paramTypes = constructor.getParameterTypes();
            Object[] params = new Object[paramTypes.length];

            for (int i = 0; i < paramTypes.length; i++) {
                params[i] = getDefaultValue(paramTypes[i]);
            }

            return constructor.newInstance(params);
        }
        throw new IllegalArgumentException("No suitable constructor found for class: " + clazz.getName());
    }

}
