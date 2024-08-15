package entities;

/**
 * @author jabkevich
 */
public class Contact {
    private final String value;
    private final ContactType type;

    public Contact(String value, ContactType type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public ContactType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (value != null ? !value.equals(contact.value) : contact.value != null) return false;
        return type == contact.type;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
