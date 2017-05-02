package utils;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by gabriels on 26/04/2017.
 */
public class Navigation {

//    This is the mask that appears when page is being loaded
    private static final By HIDDEN_OVERLAY = By.cssSelector("#wh-global-overlay.wh-hide");

    protected static WebDriver driver;

    /**
     * This method creates an Chrome driver instance, it changes the browser window dimension to 1500x1000,
     * and it navigates to the specified URL
     * @param url
     */
    protected void navigateToUrl(String url){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1500,1000));
        driver.get(url);
    }

    /**
     * This method introduces a string in a specified input field
     * @param cssElement
     * @param string
     */
    protected void stringIsIntroducedInInputField(By cssElement, String string){
        waitForLoadingMask();
        waitForElementToBeDisplayed(cssElement,10);
        driver.findElement(cssElement).sendKeys(string);
    }

    /**
     * This method waits certain time for an element to be available
     * @param cssElement
     * @param waitingTime
     */
    private void waitForElementToBeDisplayed(By cssElement, int waitingTime) {
        (new WebDriverWait(driver, waitingTime)).until(ExpectedConditions.presenceOfElementLocated(cssElement));
    }

    /**
     * This method performs a click on a specified element
     * @param cssElement
     */
    protected void performClick(By cssElement) {
        waitForLoadingMask();
        waitForElementToBeClickable(cssElement,10);

        driver.findElement(cssElement).click();
    }

    /**
     * This method waits certain time for an element to be clickable
     * @param cssElement
     * @param waitingTime
     */
    private void waitForElementToBeClickable(By cssElement, int waitingTime){
        (new WebDriverWait(driver, waitingTime)).until(ExpectedConditions.elementToBeClickable(cssElement));
    }

    /**
     * This method wait for the loading mask to be hidden
     */
    private void waitForLoadingMask() {
        waitForElementToBeDisplayed(HIDDEN_OVERLAY,10);
    }

    /**
     * This method returns the vaule of the attribute text for a specified element
     * @param cssElement
     * @return
     */
    protected String getTextNav(By cssElement) {
        return driver.findElement(cssElement).getAttribute("text");
    }

}
