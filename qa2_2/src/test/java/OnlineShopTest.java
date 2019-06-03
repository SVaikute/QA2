
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObject.pages.AutomationPracticeHomePage;
import pageObject.pages.BaseFunctions;

import java.util.List;

public class OnlineShopTest  {
    private BaseFunctions baseFunctions;
    private WebDriver driver;
    private final String URL = "http://automationpractice.com";
    private final Logger LOGGER = LogManager.getLogger(OnlineShopTest.class);
    private final By MENU = By.xpath(".//ul[contains(@class, 'sf-menu')]/li/a");
    private final By MENU_SUBCATEGORY = By.xpath(".//a[@class='subcategory-name']");

    @BeforeEach
    public void openHomePage() {
        baseFunctions = new BaseFunctions();
        baseFunctions.goToUrl(URL);
    }

    @Test
    public void articleTitleCheck() throws InterruptedException {

        AutomationPracticeHomePage homePage = new AutomationPracticeHomePage(baseFunctions);
        homePage.selectMenuItem("DRESSES");
//        LOGGER.info(" Create list with menu items");
//        List<WebElement> menuItems = driver.findElements(MENU);
//        LOGGER.info(" Select category Dresses");
//        for (int i = 0; i < menuItems.size(); i++) {
//            if (menuItems.get(i).getText().equals("DRESSES")) {
//                menuItems.get(i).click();
//                break;
//            }
//
//        }


//        LOGGER.info(" Select sub-category Evening dresses");
//        List<WebElement> menuSubItems = driver.findElements(MENU_SUBCATEGORY);
//
//        for (int i = 0; i < menuSubItems.size(); i++) {
//            if (menuSubItems.get(i).getText().equals("Evening Dresses") ) {
//                menuSubItems.get(i).click();
//                break;
//            }
//
//        }


    }

    @AfterEach
    public void browserClose() {

        driver.close();
    }
}