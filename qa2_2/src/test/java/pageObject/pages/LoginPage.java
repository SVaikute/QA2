package pageObject.pages;
import org.openqa.selenium.By;


public class LoginPage {
    private  BaseFunctions baseFunctions;
    private final By EMAIL = By.xpath(".//input[@type='email']");
    private final By PWD = By.name("password");
    private final By BTN_NEXT = By.xpath(".//span[contains(text(),'Next')]");

    public LoginPage(BaseFunctions baseFunctions) { this.baseFunctions = baseFunctions;}


    public void logIn(String user, String pwd) throws InterruptedException {
        baseFunctions.getElement(EMAIL).sendKeys(user);
        baseFunctions.clickOnElement(BTN_NEXT);

        baseFunctions.getElement(PWD).sendKeys(pwd);
        baseFunctions.clickOnElement(BTN_NEXT);

    }
}
