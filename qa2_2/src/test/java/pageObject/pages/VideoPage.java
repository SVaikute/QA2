package pageObject.pages;

import model.Channel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class VideoPage {

    public final By BTN_SBSCRIBE_VIDEO = By.xpath(".//div[@id='top-row']//paper-button[contains(@aria-label, 'Subscribe')]");
    public final By LNK_VIDEO = By.xpath(".//a[@class='yt-simple-endpoint style-scope yt-formatted-string']");
    public final By VIDEO_CONTAINER = By.xpath(".//div[@id='top-row']/ytd-video-owner-renderer");
    private BaseFunctions baseFunctions;

    public VideoPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public String getChannelTitle(Channel channel) {
        return channel.getTitle();
    }

    public Channel subscribeToChannel() {
        WebElement channel =  baseFunctions.getElement(VIDEO_CONTAINER);
        Channel currChannel = new Channel();
        currChannel.setTitle(channel.findElement(LNK_VIDEO).getText());
        currChannel.setSubscribe(baseFunctions.getElement(BTN_SBSCRIBE_VIDEO));
        currChannel.getSubscribe().click();

        return currChannel;
    }
}
