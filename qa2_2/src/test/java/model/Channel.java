package model;

import org.openqa.selenium.WebElement;

public class Channel {
    private String title;
    private WebElement subscribe;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public WebElement getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(WebElement subscribe) {
        this.subscribe = subscribe;
    }
}
