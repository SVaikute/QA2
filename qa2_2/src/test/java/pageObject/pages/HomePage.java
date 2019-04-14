package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    private final By TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private BaseFunctions baseFunctions;

    public HomePage(BaseFunctions baseFunctions) { this.baseFunctions = baseFunctions;}

    public void  openArticleByIndex (int index) {
        List<WebElement> articles = baseFunctions.getListOfWebElements(TITLE);
        articles.get(index).click();
    }
}
