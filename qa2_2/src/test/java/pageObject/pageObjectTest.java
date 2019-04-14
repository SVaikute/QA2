package pageObject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pageObject.pages.BaseFunctions;
import pageObject.pages.HomePage;

public class pageObjectTest {
    private final String URL = "delfi.lv";
    private BaseFunctions baseFunctions;

    @Test
    public void delfiTest() {
        baseFunctions.goToUrl(URL);
        HomePage homePage = new HomePage(baseFunctions);
        homePage.openArticleByIndex(5);
    }

    @AfterEach
    public void closeBrowser() {
        baseFunctions.closeBrowser();
    }
}
