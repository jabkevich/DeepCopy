package entities;

import java.time.Instant;
import java.util.*;

/**
 * @author jabkevich
 */
public class PersonWithoutConstructors implements Comparable<PersonWithoutConstructors> {
    private int age;
    private String name;

    private Contact[] contacts;
    private List<Message> messages;
    private SortedSet<Person> subscribers;
    private SortedMap<Person, Instant> views;
    private Queue<Notification> notifications;


    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setViews(SortedMap<Person, Instant> views) {
        this.views = views;
    }

    public void setNotifications(Queue<Notification> notifications) {
        this.notifications = notifications;
    }

    public void setSubscribers(SortedSet<Person> subscribers) {
        this.subscribers = subscribers;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void setContacts(Contact[] emails) {
        this.contacts = emails;
    }

    public Contact[] getContacts() {
        return contacts;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public SortedSet<Person> getSubscribers() {
        return subscribers;
    }

    public SortedMap<Person, Instant> getViews() {
        return views;
    }

    public Queue<Notification> getNotifications() {
        return notifications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonWithoutConstructors person = (PersonWithoutConstructors) o;

        if (age != person.age) return false;
        if (!name.equals(person.name)) return false;
        // check for null
        if (contacts != null ? !Arrays.equals(contacts, person.contacts) : person.contacts != null) return false;
        if (!Objects.equals(messages, person.messages)) return false;
        if (!Objects.equals(subscribers, person.subscribers)) return false;
        if (!Objects.equals(views, person.views)) return false;
        if (!Objects.equals(notifications, person.notifications)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public int compareTo(PersonWithoutConstructors o) {
        return Integer.compare(age, o.age);
    }
}
