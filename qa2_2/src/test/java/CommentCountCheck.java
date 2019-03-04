import model.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CommentCountCheck {

    private final String URL = "http://rus.delfi.lv";
    private final By ARTICLE = By.tagName("article");
    private final By ARTICLE_TITLE = By.tagName("h1");
    private final By COMMENT_COUNTER = By.xpath(".//a[contains(@class, 'text-red')]");
    private WebDriver driver;

    @BeforeEach
    public void openHomePage() {

        System.setProperty("webdriver.chrome.driver", "D:/projects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test
    public void commentCountCheck() {

        List<WebElement> articles = driver.findElements(ARTICLE);
        Article article = getArticle(articles, 5);
    }


    private Article getArticle(List<WebElement> elements, int i) {
        WebElement article = elements.get(i);

        Article currArticle = new Article();
        currArticle.setTitle(article.findElement(ARTICLE_TITLE).getText());

        List<WebElement> commentCounters = article.findElements(COMMENT_COUNTER);
        if (commentCounters.isEmpty()) {
            currArticle.setCommentCount(0);
        } else {
            currArticle.setCommentCount(commentCounters.get(0).getText());
        }

        return currArticle;
    }
}
