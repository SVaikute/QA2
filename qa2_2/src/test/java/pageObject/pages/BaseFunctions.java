package pageObject.pages;

import cucumber.api.java.en.Given;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BaseFunctions {
    private WebDriver driver;

    public BaseFunctions() {
        // Create object of ChromeOption class
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "D:/projects/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    public void goToUrl(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public void closeBrowser() {
        Assertions.assertNotNull(driver, "There are no opened browser!");
        driver.close();
    }


    public List<WebElement> getListOfWebElements(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        List<WebElement> elements = driver.findElements(locator);
        Assertions.assertNotNull(elements.size(), "List of elements is empty");
        return elements;
    }

    public WebElement getElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        List<WebElement> elements = getListOfWebElements(locator);
        return elements.get(0);

    }

    public void clickOnElementByIndex(By locator, int index) {

        List<WebElement> elements = getListOfWebElements(locator);
        elements.get(index).click();
    }

    public void clickOnElement(By locator) {
        List<WebElement> elements = getListOfWebElements(locator);
        elements.get(0).click();

    }

    public void reloadScreen() {
        driver.navigate().refresh();
    }
}
