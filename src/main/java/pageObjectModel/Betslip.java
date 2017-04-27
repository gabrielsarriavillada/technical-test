package pageObjectModel;

import org.openqa.selenium.By;
import utils.Navigation;

import java.math.BigDecimal;

/**
 * Created by gabriels on 26/04/2017.
 */
public class Betslip extends Navigation{

    private final By STAKE_INPUT = By.cssSelector("input[id^='stake-input']");
    private final By PLACE_BET_BUTTON = By.id("place-bet-button");

    /**
     * This method enters certain stake in the first stake input field
     * @param stake
     */
    public void stakeIsIntroduced(BigDecimal stake) {
        String stakeString = String.valueOf(stake);
        stringIsIntroducedInInputField(STAKE_INPUT, stakeString);
    }

    /**
     * This method clicks the Place Bet button
     */
    public void placeBet() {
        performClick(PLACE_BET_BUTTON);
    }
}
