package guitests.guihandles;

import guitests.guihandles.person.PersonListPanelHandle;
import javafx.stage.Stage;

/**
 * Provides a handle for {@code MainWindow}.
 */
public class MainWindowHandle extends StageHandle {
    private final MainMenuHandle mainMenu;
    private final CommandBoxHandle commandBox;
    private final ResultDisplayHandle resultDisplay;

    private final PersonListPanelHandle personListPanel;

    private final StatusBarFooterHandle statusBarFooter;

    public MainWindowHandle(Stage stage) {
        super(stage);

        personListPanel = new PersonListPanelHandle(getChildNode(PersonListPanelHandle.PERSON_LIST_VIEW_ID));
        resultDisplay = new ResultDisplayHandle(getChildNode(ResultDisplayHandle.RESULT_DISPLAY_ID));
        commandBox = new CommandBoxHandle(getChildNode(CommandBoxHandle.COMMAND_INPUT_FIELD_ID));
        statusBarFooter = new StatusBarFooterHandle(getChildNode(StatusBarFooterHandle.STATUS_BAR_PLACEHOLDER));
        mainMenu = new MainMenuHandle(getChildNode(MainMenuHandle.MENU_BAR_ID));
    }

    public PersonListPanelHandle getPersonListPanel() {
        return personListPanel;
    }

    public ResultDisplayHandle getResultDisplay() {
        return resultDisplay;
    }

    public CommandBoxHandle getCommandBox() {
        return commandBox;
    }

    public StatusBarFooterHandle getStatusBarFooter() {
        return statusBarFooter;
    }

    public MainMenuHandle getMainMenu() {
        return mainMenu;
    }
}
