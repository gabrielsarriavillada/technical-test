package pageObjectModel;

import org.openqa.selenium.By;
import utils.Navigation;
import utils.Credentials;

import java.math.BigDecimal;

/**
 * Created by gabriels on 26/04/2017.
 */
public class Header extends Navigation{

    private final By LOGIN_TAB = By.id("accountTabButton");
    private final By USERNAME_INPUT = By.id("loginUsernameInput");
    private final By PASSWORD_INPUT = By.id("loginPasswordInput");
    private final By LOGIN_BUTTON = By.id("loginButton");
    private final By ACCOUNT_BALANCE = By.id("userBalance");

    public void introduceCorrectCredentials(){
        performClick(LOGIN_TAB);
        stringIsIntroducedInInputField(USERNAME_INPUT, Credentials.VALID_USERNAME);
        stringIsIntroducedInInputField(PASSWORD_INPUT, Credentials.VALID_PASSWORD);

    }

    public void clickOnLogin() {
        performClick(LOGIN_BUTTON);
    }

    public BigDecimal getAccountBalance() {
        String balanceString = getTextNav(ACCOUNT_BALANCE).substring(1);
        BigDecimal balanceDecimal = new BigDecimal(balanceString);
        return balanceDecimal;
    }
}
