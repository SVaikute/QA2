package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AutomationPracticeHomePage {
    private BaseFunctions baseFunctions;
    private final By MENU = By.xpath(".//ul[contains(@class, 'sf-menu')]/li/a");

public AutomationPracticeHomePage(BaseFunctions baseFunctions) {this.baseFunctions = baseFunctions;}

public void selectMenuItem(String menuItemName){

    List<WebElement> menuItems = baseFunctions.getListOfWebElements(MENU);
    for (int i = 0; i < menuItems.size(); i++) {
        if (menuItems.get(i).getText().equals(menuItemName)) {
            menuItems.get(i).click();
            break;
        }

    }

}


}
