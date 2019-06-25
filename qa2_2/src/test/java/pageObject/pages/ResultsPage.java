package pageObject.pages;

import model.Channel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultsPage {

    public final By CHANNEL = By.xpath(".//ytd-channel-renderer[@class= 'style-scope ytd-item-section-renderer']");
    public final By CHANNEL_TITLE = By.id("channel-title");
    public final By BTN_SUBSCRIBE = By.xpath(".//paper-button[contains(@aria-label, 'Subscribe')]");

    public final By VIDEO = By.xpath(".//ytd-video-renderer[@class= 'style-scope ytd-item-section-renderer']//a");
    private BaseFunctions baseFunctions;

    public ResultsPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;

    }

    public String getChannelTitle(Channel channel) {
        return channel.getTitle();
    }

    public Channel subscribeToChannelByIndex(int index) {
        List<WebElement> elements = baseFunctions.getListOfWebElements(CHANNEL);
        WebElement channel = elements.get(index);
        Channel currChannel = new Channel();
        currChannel.setTitle(channel.findElement(CHANNEL_TITLE).getText());
        currChannel.setSubscribe(channel.findElement(BTN_SUBSCRIBE));
        currChannel.getSubscribe().click();

        return currChannel;
    }

    public void clickOnVideoByIndex(int index) {
        List<WebElement> elements = baseFunctions.getListOfWebElements(VIDEO);
        elements.get(index).click();
    }

}
