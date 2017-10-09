package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.exceptions.IllegalValueException;

/**
 * A generic class that represents a property of a person. All properties of a person (including name, email, phone
 * and address) should inherit from this class.
 */
public class Property {
    /**
     * Why do we only store three fields as instance variables in this class?<br>
     *
     * {@link #shortName} is used as the identifier for the property, {@link #fullName} is used stored because we may
     * need to access it frequently (it will be a bad design decision if we have to perform HashMap access operation
     * whenever we need to get the full name of a property), and {@link #value} must be stored here apparently.
     */
    private final String shortName;
    private final String fullName;
    private String value;

    /**
     * Creates a property via its name in short form and its input value.
     *
     * @param shortName is the short name (identifier) of this property.
     */
    public Property(String shortName, String value) throws IllegalValueException {
        this.shortName = shortName;

        requireNonNull(value);
        if (!isValid(value)) {
            throw new IllegalValueException(PropertyManager.getPropertyConstraintMessage(shortName));
        }
        this.value = value;
        this.fullName = PropertyManager.getPropertyFullName(shortName);
    }

    /**
     * Returns if a given string is a valid value for this property.
     */
    public boolean isValid(String test) {
        return test.matches(PropertyManager.getPropertyValidationRegex(shortName));
    }

    public String getShortName() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Property // instanceof handles nulls
                    && this.shortName.equals(((Property) (other)).getShortName())); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
