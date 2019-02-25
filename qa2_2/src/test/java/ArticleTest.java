
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ArticleTest {
    private final String URL = "https://www.delfi.lv";
    private final By TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");
    private final By COMMENT_ARTICLE_PAGE = By.xpath(".//a[contains(@class, 'text-red-ribbon')]");
    private final By COMMENT_PAGE_TITLE = By.xpath(".//h1[@class='article-title']/a");
    private final By COMMENT_COUNT_HOME_PAGE = By.xpath(".//a[contains(@class, 'comment-count')]");
    private final By COMMENT_COUNT_COMMENT_PAGE = By.xpath(".//span[@class='type-cnt']");

    private WebDriver driver;

    @BeforeEach
    public void openHomePage() {

        System.setProperty("webdriver.chrome.driver", "D:/projects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test
    public void articleTitleCheck() {

        WebElement homePageTile = driver.findElement(TITLE);
        String txtHomePageTitle = homePageTile.getText();

        homePageTile.click();

        WebElement articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE);
        String txtArticlePageTitle = articlePageTitle.getText();

        Assertions.assertEquals(txtHomePageTitle, txtArticlePageTitle, "Article Title is wrong");

        WebElement lnkComment = driver.findElement(COMMENT_ARTICLE_PAGE);

        lnkComment.click();

        WebElement commentPageTile = driver.findElement(COMMENT_PAGE_TITLE);
        String txtCommentPageTitle = commentPageTile.getText();

        Assertions.assertEquals(txtHomePageTitle, txtCommentPageTitle, "Comment Page Article Title is wrong");

    }

    @Test
    public void articleCommentCountCheck() {

        WebElement commentCount = driver.findElement(COMMENT_COUNT_HOME_PAGE);

        String txtCommentCount = commentCount.getText();
        txtCommentCount = removeBrackets(txtCommentCount);

        WebElement homePageTitle = driver.findElement(TITLE);
        homePageTitle.click();

        WebElement articleCommentCount = driver.findElement(COMMENT_ARTICLE_PAGE);

        String txtArticleCommentCount = articleCommentCount.getText();
        txtArticleCommentCount = removeBrackets(txtArticleCommentCount);

        Assertions.assertEquals(txtCommentCount, txtArticleCommentCount, "Wrong Comment count!");

        articleCommentCount.click();

        List<WebElement> counts = driver.findElements(COMMENT_COUNT_COMMENT_PAGE);
        int commentsSum = 0;
        for (WebElement list : counts) {
            System.out.println(list.getText());
            String s = list.getText().replace("(", "");
            commentsSum = commentsSum + Integer.parseInt(s.replace(")", ""));
        }

        System.out.println(commentsSum);
        String txtComments = Integer.toString(commentsSum);
        Assertions.assertEquals(txtCommentCount, txtComments, "Wrong Comment count!");

    }

    private String removeBrackets(String txtCommentCountWithBrackets) {
        txtCommentCountWithBrackets = txtCommentCountWithBrackets.replace("(", "");
        txtCommentCountWithBrackets = txtCommentCountWithBrackets.replace(")", "");
        System.out.println(txtCommentCountWithBrackets);
        return txtCommentCountWithBrackets;

    }

    @AfterEach
    public void browserClose() {

        driver.close();
    }
}
