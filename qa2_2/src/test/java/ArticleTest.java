import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ArticleTest {
    private final String URL = "https://www.delfi.lv";
    private final By TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");
    private final By COMMENT = By.xpath(".//a[contains(@class, 'text-red-ribbon')]");
    private final By COMMENT_PAGE_TITLE = By.xpath(".//h1[@class='article-title']/a");

    private WebDriver driver;
    @Test
    public void articleTitleCheck() {
        //0. set driver path
        System.setProperty("webdriver.chrome.driver", "D:/projects/chromedriver.exe");
        //1. Open browser
        driver = new ChromeDriver();
        //2. Max full screen
        driver.manage().window().maximize();
        //3. Open Home page
        driver.get(URL);
        //4. Find first article title
        WebElement homePageTile = driver.findElement(TITLE);
        //5. Save Article title
        String txtHomePageTitle = homePageTile.getText();
        //6. Click on article
        homePageTile.click();
        //7. Find title
        WebElement articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE);
        //8. save to string
        String txtArticlePageTitle = articlePageTitle.getText();
        //9. assert article title
        Assertions.assertEquals(txtHomePageTitle, txtArticlePageTitle, "Article Title is wrong");
        //10. Find comment count
        WebElement lnkComment = driver.findElement(COMMENT);
        //11. click on comment count
        lnkComment.click();
        //12. Find title
        WebElement commentPageTile = driver.findElement(COMMENT_PAGE_TITLE);
        //13. save to string
        String txtCommentPageTitle = commentPageTile.getText();
        //14. assert article title
        Assertions.assertEquals(txtHomePageTitle, txtCommentPageTitle, "Comment Page Article Title is wrong");


    }

    @AfterEach
    public void browserClose(){
        //15. close browser
        driver.close();
    }
}
