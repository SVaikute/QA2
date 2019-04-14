package pageObject.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseFunctions {
    private WebDriver driver;

    public BaseFunctions() {
        System.setProperty("webdriver.chrome.driver", "D:/projects/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void goToUrl(String url) {
        if(!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public void closeBrowser() {
        Assertions.assertNotNull(driver, "There are no opened browser!");
        driver.close();
    }

    public List<WebElement> getListOfWebElements(By locator) {
        return driver.findElements(locator);
    }
}
