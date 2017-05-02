package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.Navigation;

/**
 * Created by gabriels on 26/04/2017.
 */
public class beforeAndAfter extends Navigation{

    @Before
    public void beforeScenario() {

    }

    @After
    public void afterScenario() {
        driver.close();
    }

}
