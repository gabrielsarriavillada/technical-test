package utils;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;

/**
 * Created by gabriels on 26/04/2017.
 */
public class Navigation {

    private static final By HIDDEN_OVERLAY = By.cssSelector("#wh-global-overlay.wh-hide");
    protected static WebDriver driver;

    protected void navigateToUrl(String url){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    protected void stringIsIntroducedInInputField(By cssElement, String string){
        waitForLoadingMask();
        waitForElementToBeDisplayed(cssElement,10);
        driver.findElement(cssElement).sendKeys(string);
    }

    private void waitForElementToBeDisplayed(By cssElement, int waitingTime) {
        (new WebDriverWait(driver, waitingTime)).until(ExpectedConditions.presenceOfElementLocated(cssElement));
    }

    protected void performClick(By cssElement) {
        waitForLoadingMask();
        waitForElementToBeClickable(cssElement,10);
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        driver.findElement(cssElement).click();
    }

    private void waitForElementToBeClickable(By cssElement, int waitingTime){
        (new WebDriverWait(driver, waitingTime)).until(ExpectedConditions.elementToBeClickable(cssElement));
    }

    private void waitForLoadingMask() {
        waitForElementToBeDisplayed(HIDDEN_OVERLAY,10);
    }

    public String getTextNav(By cssElement) {
        return driver.findElement(cssElement).getAttribute("text");
    }

}
