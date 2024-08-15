package utils;

import entities.*;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.*;

/**
 * @author jabkevich
 */
public class PersonUtils {

    public static int getRandomAge() {
        return new Random().nextInt(100);
    }


    public static SortedMap<Person, Instant> getViewers() {
        Person viewer1 = new Person(getRandomAge(), "Dima");
        Person viewer2 = new Person(getRandomAge(), "Bob");
        SortedMap<Person, Instant> views = new TreeMap<>();
        views.put(viewer1, Instant.now());
        views.put(viewer2, Instant.now());

        return views;
    }

    public static Queue<Notification> getNotifications() {
        Queue<Notification> friends = new LinkedList<>();
        friends.add(new Notification("random age: " + getRandomAge()));
        friends.add(new Notification("random age: " + getRandomAge()));

        return friends;
    }

    public static SortedSet<Person> getSubscribers() {
        Person subscriber1 = new Person(getRandomAge(), "Lisa");
        Person subscriber2 = new Person(getRandomAge(), "John");
        SortedSet<Person> subscribers = new TreeSet<>();
        subscribers.add(subscriber1);
        subscribers.add(subscriber2);

        return subscribers;
    }

    public static List<Message> getMessages() {
        Person author = new Person(getRandomAge(), "Bob");
        Person viewer = new Person(getRandomAge(), "Dima");
        Message message = new Message("Hello", OffsetDateTime.now(), author);
        message.setViews(Map.of(viewer, Instant.now()));
        message.setLikes(Set.of(author));
        Message message2 = new Message("Hello2", OffsetDateTime.now(), author);
        message2.setViews(Map.of(viewer, Instant.now()));
        message2.setLikes(Set.of(author));

        return List.of(message, message2);
    }

    public static Contact[] getContacts() {
        Contact[] contacts = new Contact[2];
        contacts[0] = new Contact("email1", ContactType.EMAIL);
        contacts[1] = new Contact("phone1", ContactType.PHONE);

        return contacts;
    }

    public static Person getTestPerson() {
        Person person = new Person(getRandomAge(), "Alice");
        person.setViews(getViewers());
        person.setNotifications(getNotifications());
        person.setSubscribers(getSubscribers());
        person.setMessages(getMessages());
        person.setContacts(getContacts());

        return person;
    }
}
