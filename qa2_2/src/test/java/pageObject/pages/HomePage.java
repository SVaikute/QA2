package pageObject.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class HomePage {

    public final By BTN_SIGN_IN = By.xpath(".//ytd-button-renderer[@id='sign-in-button']");
    public final By TXT_NAME = By.id("search");
    public final By LNK_SUBSCRIPTIONS = By.xpath(".//a[@title='Subscriptions']");
    public final By LNK_HOME = By.id("logo-icon-container");
    public final By MANAGE = By.xpath(".//paper-button[@aria-label='Manage']");
    public final By SUBSCRIPTION_ON_MAIN = By.xpath(".//ytd-guide-section-renderer//span[contains(@class, 'title style-scope ytd-guide-entry-renderer')]");
    public final By BTN_SEARCH = By.id("search-icon-legacy");
    private BaseFunctions baseFunctions;

    public HomePage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void clickOnButton(By locator) {
        baseFunctions.clickOnElement(locator);
    }

    public void searchForVideo(String videoName) {

        WebElement element = baseFunctions.getElement(TXT_NAME);
        element.click();
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(videoName);
        baseFunctions.getElement(BTN_SEARCH).click();


    }

    public void verifySubscription(List<String> subscriptions) {

        List<WebElement> elements = baseFunctions.getListOfWebElements(SUBSCRIPTION_ON_MAIN);
        String[] act = new String[elements.size()];
        int i = 0;
        for (WebElement element : elements) {
            act[i++] = element.getText();
        }
        List<String> actual = Arrays.asList(act);
        Assertions.assertTrue(actual.containsAll(subscriptions), "Subscription is not found" + subscriptions + "In list");
    }

    public void navigateToSubscriptions() {
        clickOnButton(LNK_HOME);
        clickOnButton(LNK_SUBSCRIPTIONS);
        clickOnButton(MANAGE);
    }

}
