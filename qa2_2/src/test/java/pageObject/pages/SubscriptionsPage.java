package pageObject.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class SubscriptionsPage {
    public final By CHANNEL_TITLE = By.xpath(".//ytd-channel-renderer//h3/span[@class='style-scope ytd-channel-renderer']");
    public final By BTN_UNSUBSCRIBE = By.xpath(".//paper-button[contains(@aria-label, 'Unsubscribe')]/yt-formatted-string");
public final By UNSUBSCRIBE_POP_UP = By.xpath(".//yt-button-renderer[@id= 'confirm-button']//paper-button");
    private BaseFunctions baseFunctions;


    public SubscriptionsPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void verifySubscription(List<String> subscriptions) {

        List<WebElement> elements = baseFunctions.getListOfWebElements(CHANNEL_TITLE);
        String[] act = new String[elements.size()];
        int i = 0;
        for (WebElement element : elements) {
            act[i++] = element.getText();
        }
        List<String> actual = Arrays.asList(act);
        Assertions.assertTrue(actual.containsAll(subscriptions), "Subscription is not found" + subscriptions + "In list");
    }

    public void removeSubsriptions() {
        List<WebElement> elements = baseFunctions.getListOfWebElements(BTN_UNSUBSCRIBE);
        if (elements.size() > 0) {
            for (WebElement element : elements) {
                element.click();
                baseFunctions.clickOnElement(UNSUBSCRIBE_POP_UP);
            }
        } else {
            System.out.println("No subscriptions");
        }
    }
}
