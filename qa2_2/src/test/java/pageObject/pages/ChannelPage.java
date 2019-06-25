package pageObject.pages;

import model.Channel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChannelPage {

    private BaseFunctions baseFunctions;
    public final By BTN_SUBSCRIBE = By.xpath(".//paper-button[contains(@aria-label, 'Subscribe')]");
    public final By TITLE = By.id("title");
    public final By CHANNEL_CONTAINER = By.id("channel-header-container");
    public ChannelPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public String getChannelTitle(Channel channel) {
        return channel.getTitle();
    }

    public Channel subscribeToChannel() {
        WebElement channel =  baseFunctions.getElement(CHANNEL_CONTAINER);
        Channel currChannel = new Channel();
        currChannel.setTitle(channel.findElement(TITLE).getText());
        currChannel.setSubscribe(channel.findElement(BTN_SUBSCRIBE));
        currChannel.getSubscribe().click();

        return currChannel;
    }
}
