package seedu.address.ui.person;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import seedu.address.model.person.ReadOnlyPerson;
import seedu.address.ui.PropertyLabel;
import seedu.address.ui.UiPart;

//@@author yunpengn
/**
 * The panel on the right side of {@link PersonListPanel}. Used to show the details (including photo and all
 * properties) of a specific person (selected on the {@link PersonListPanel}).
 */
public class PersonDetailsPanel extends UiPart<Region> {
    private static final String FXML = "person/PersonDetailsPanel.fxml";

    private ReadOnlyPerson person;

    @FXML
    private Label name;
    @FXML
    private ImageView avatar;
    @FXML
    private ListView<Label> propertyListKeys;
    @FXML
    private ListView<Label> propertyListValues;

    public PersonDetailsPanel(ReadOnlyPerson person) {
        super(FXML);
        this.person = person;
        name.textProperty().bind(Bindings.convert(person.nameProperty()));
        person.avatarProperty().addListener((observable, oldValue, newValue) -> setAvatar());
        setAvatar();
        person.properties().addListener((observable, oldValue, newValue) -> bindProperties());
        bindProperties();
    }

    /**
     * Binds all properties of this person to a {@link ListView} of key-value pairs.
     */
    private void bindProperties() {
        List<Label> keys = new ArrayList<>();
        List<Label> values = new ArrayList<>();

        person.getSortedProperties().forEach(property -> {
            Label newPropertyKey = new PropertyLabel(property.getFullName() + ":", "details-property-key");
            Label newPropertyValue = new PropertyLabel(property.getValue(), "details-property-value");

            keys.add(newPropertyKey);
            values.add(newPropertyValue);
        });

        propertyListKeys.setItems(FXCollections.observableList(keys));
        propertyListValues.setItems(FXCollections.observableList(values));
    }

    /**
     * Displays the avatar of the person if the {@code avatar} has been set before.
     */
    private void setAvatar() {
        if (person.getAvatar() != null) {
            Platform.runLater(() -> avatar.setImage(new Image(person.getAvatar().getUri(), 200, 200, false, true)));
        }
    }
}
