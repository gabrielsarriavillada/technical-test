package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pageObjectModel.Header;
import pageObjectModel.Homepage;

/**
 * Created by gabriels on 26/04/2017.
 */
public class homepageSteps {

    private Homepage homepage = new Homepage();
    private Header header = new Header();

    /**
     * This step navigates to Homepage
     * @throws Throwable
     */
    @Given("^user goes to homepage$")
    public void userGoesToHomepage() throws Throwable {
        homepage.navigateToHomepage();
    }

    /**
     * This step logs user with correct credentials
     * @throws Throwable
     */
    @And("^user logs in$")
    public void userLogsIn() throws Throwable {
        header.introduceCorrectCredentials();
        header.clickOnLogin();
    }

    /**
     * This step sends user to the first event of a certain sport
     * @param sportName
     * @throws Throwable
     */
    @And("^user navigates to a (football|tennis) event$")
    public void userNavigatesToASportEvent(String sportName) throws Throwable {
        homepage.navigateToEvent(sportName);
    }
}
