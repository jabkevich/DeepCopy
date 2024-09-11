package entities;

import list.CustomList;
import list.CustomQueue;
import map.CustomMap;

import java.time.Instant;
import java.util.*;

/**
 * @author jabkevich
 */
public class Person implements Comparable<Person> {


    private TestRecord testRecord;

    private CustomQueue<Notification> customQueue;
    private CustomList<Person> customList;
    private SortedMap<Person, Instant> views;
    private CustomMap<String, Person> customMap;
    private final int age;
    private final String name;

    private Contact[] contacts;
    private List<Message> messages;
    private SortedSet<Person> subscribers;
    private Queue<Notification> notifications;





    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void setTestRecord(TestRecord testRecord) {
        this.testRecord = testRecord;
    }

    public CustomMap<String, Person> getCustomMap() {
        return customMap;
    }

    public CustomQueue<Notification> getCustomQueue() {
        return customQueue;
    }

    public void setCustomQueue(CustomQueue<Notification> customQueue) {
        this.customQueue = customQueue;
    }

    public CustomList<Person> getCustomList() {
        return customList;
    }

    public void setCustomList(CustomList<Person> customList) {
        this.customList = customList;
    }

    public void setCustomMap(CustomMap<String, Person> customMap) {
        this.customMap = customMap;
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
        Person person = (Person) o;

        if (age != person.age) return false;
        if (!name.equals(person.name)) return false;
        // check for null
        if (contacts != null ? !Arrays.equals(contacts, person.contacts) : person.contacts != null) return false;
        if (!Objects.equals(messages, person.messages)) return false;
        if (!Objects.equals(subscribers, person.subscribers)) return false;
        if (!Objects.equals(views, person.views)) return false;
        if (!Objects.equals(notifications, person.notifications)) return false;
        if (!Objects.equals(customMap, person.customMap)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(age, o.age);
    }
}
