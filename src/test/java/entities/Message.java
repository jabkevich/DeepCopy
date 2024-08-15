package entities;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

/**
 * @author jabkevich
 */
public class Message {

    private final String text;
    private final OffsetDateTime timestamp;
    private final Person author;
    private Set<Person> likes;
    private Map<Person, Instant> views;

    public Message(String text, OffsetDateTime timestamp, Person author) {
        this.text = text;
        this.timestamp = timestamp;
        this.author = author;
    }

    public void setLikes(Set<Person> likes) {
        this.likes = likes;
    }

    public void setViews(Map<Person, Instant> views) {
        this.views = views;
    }

    public String getText() {
        return text;
    }

    public Set<Person> getLikes() {
        return likes;
    }

    public Map<Person, Instant> getViews() {
        return views;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public Person getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (text != null ? !text.equals(message.text) : message.text != null) return false;
        if (timestamp != null ? !timestamp.equals(message.timestamp) : message.timestamp != null) return false;
        if (author != null ? !author.equals(message.author) : message.author != null) return false;
        if (likes != null ? !likes.equals(message.likes) : message.likes != null) return false;
        return views != null ? views.equals(message.views) : message.views == null;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (likes != null ? likes.hashCode() : 0);
        result = 31 * result + (views != null ? views.hashCode() : 0);
        return result;
    }
}
