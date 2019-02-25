import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DelfiFirstTest {
    @Test
    public void delfiFirstTitleTest() {
        System.setProperty("webdriver.chrome.driver", "D:/projects/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.delfi.lv");
    }
}
