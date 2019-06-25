package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainMenuHelper {

    public final By SECTION = By.xpath(".//ytd-guide-section-renderer//span[@class= 'title style-scope ytd-guide-entry-renderer']");
    private BaseFunctions baseFunctions;

    public MainMenuHelper(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void selectSectionByName(String sectionName) {
        List<WebElement> sectionItems = baseFunctions.getListOfWebElements(SECTION);
        for (int i = 0; i < sectionItems.size(); i++) {
            if (sectionItems.get(i).getText().equals(sectionName)) {
                sectionItems.get(i).click();
                break;
            }

        }
    }
}
