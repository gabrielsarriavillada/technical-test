package pageObjectModel;

import org.openqa.selenium.By;
import utils.Navigation;

/**
 * Created by gabriels on 26/04/2017.
 */
public class EventPage extends Navigation{

    /**
     * This method clicks on first selection available
     */
    public void firstActiveSelectionIsSelected() {
        By selectionButton = By.cssSelector("button[id^='OB_OU']");
        performClick(selectionButton);
    }
}
