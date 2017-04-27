package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by gabriels on 26/04/2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
//        plugin = {"pretty", "html:target/cucumber-html-report"},
        glue = {"stepDefinitions"}
)

public class testRunner {
}
