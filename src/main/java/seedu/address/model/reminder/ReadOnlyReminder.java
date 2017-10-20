package seedu.address.model.reminder;
import javafx.beans.property.ObjectProperty;
import seedu.address.model.property.DateTime;

/**
 * A read-only immutable interface for a Reminder in the addressBook.
 * Implementations should guarantee: details are present and not null, field values are validated.
 */
public interface ReadOnlyReminder {

    ObjectProperty<DateTime> dateTimeProperty();
    DateTime getTime();
    ObjectProperty<String> messageProperty();
    String getMessage();

    /**
     * Returns true if both have the same state. (interfaces cannot override .equals)
     *
     * TODO: Should we include comparision of {@code getProperties} here?
     */
    default boolean isSameStateAs(ReadOnlyReminder other) {
        return other == this // short circuit if same object
                || (other != null // this is first to avoid NPE below
                && other.getTime().equals(this.getTime()) // state checks here onwards
                && other.getMessage().equals(this.getMessage()));
    }

    /**
     * Formats the reminder as text, showing all contact details.
     */
    default String getAsText() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getTime())
                .append(" Message: ")
                .append(getMessage());
        return builder.toString();
    }

}
