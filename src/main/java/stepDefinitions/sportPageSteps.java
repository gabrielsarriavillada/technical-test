package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjectModel.Betslip;
import pageObjectModel.EventPage;
import pageObjectModel.Header;
import utils.ScenarioContext;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by gabriels on 26/04/2017.
 */
public class sportPageSteps {

    private EventPage event = new EventPage();
    private Betslip betslip = new Betslip();
    private Header header = new Header();

    /**
     * This step adds first actibe selection in the page to the betslip
     * @throws Throwable
     */
    @When("^user adds first active selection to betslip$")
    public void userAddsFirstActiveSelectionToBetslip() throws Throwable {
        event.firstActiveSelectionIsSelected();
    }

    @And("^user places a '(.*)' bet$")
    public void userPlacesABet(BigDecimal stake) throws Throwable {
        ScenarioContext.saveBalance(header.getAccountBalance());
        ScenarioContext.saveStake(stake);
        betslip.stakeIsIntroduced(stake);
        betslip.placeBet();
    }

    @Then("^user balance is updated$")
    public void userBalanceIsUpdated() throws Throwable {
        BigDecimal previousBalance = ScenarioContext.getSavedBalance();
        BigDecimal stake = ScenarioContext.getSavedStake();

        BigDecimal expectedBalance = previousBalance.subtract(stake);

        BigDecimal currentBalance = header.getAccountBalance();

        assertThat(currentBalance.equals(expectedBalance)).isTrue();
    }
}
