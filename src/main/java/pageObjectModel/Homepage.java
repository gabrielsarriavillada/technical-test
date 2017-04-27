package pageObjectModel;

import org.openqa.selenium.By;
import utils.Navigation;

/**
 * Created by gabriels on 26/04/2017.
 */
public class Homepage extends Navigation {

    public void navigateToHomepage() {
        navigateToUrl("http://sports.williamhill.com/sr-admin-set-white-list-cookie.html");
    }

    public void navigateToEvent(String sportName) {
        By eventLink = By.cssSelector("a[href^='/betting/en-gb/" + sportName + "/OB_EV']");
        performClick(eventLink);
    }

}
