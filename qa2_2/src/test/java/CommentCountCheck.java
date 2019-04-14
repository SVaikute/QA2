import model.Article;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
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
    private final By BTN_READ_COMMENTS = By.className("input-read");
    private final By COMMENT_PAGE_TITLE = By.xpath(".//h1[@class='article-title']/a");
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
    public void commentCountCheck() {

        Integer index = 3;

        List<WebElement> articles = driver.findElements(ARTICLE);
        Article article = getArticle(articles, index);
        String articleTitle = article.getTitle();
        Integer articleCommentCount = article.getCommentCount();
        articles.get(index).click();

        List<WebElement> articlesOnArticlePage = driver.findElements(ARTICLE);
        Article articleOnArticlePage = getArticle(articlesOnArticlePage, 0);
        String articleTitleOnArticlePage = articleOnArticlePage.getTitle();
        Integer articleCommentCountOnArticlePage = articleOnArticlePage.getCommentCount();

        Assertions.assertEquals(articleTitle, articleTitleOnArticlePage, "Article Title on Home page is different in comparison to Article Title on Article Page!");
        Assertions.assertEquals(articleCommentCount, articleCommentCountOnArticlePage, "Article Comment count on Home page is different in comparison to Article Comment count on Article Page!");

        WebElement btnReadComments = driver.findElement(BTN_READ_COMMENTS);
        btnReadComments.click();

        WebElement commentPageTile = driver.findElement(COMMENT_PAGE_TITLE);
        String txtCommentPageTitle = commentPageTile.getText();

        Assertions.assertEquals(articleTitle, txtCommentPageTitle, "Comment Page Article Title is different in comparison to Article Title on Home Page!");

        Integer txtComments = calculateCommentsOnCommentPage(COMMENT_COUNT_COMMENT_PAGE);
        Assertions.assertEquals(articleCommentCount, txtComments, "Comment count on Comments Page is different in comparison to Comment Count on Home Page!");
    }


    private Integer calculateCommentsOnCommentPage(By commentLocator) {

        Integer commentsSum = 0;

        List<WebElement> counts = driver.findElements(commentLocator);
        for (WebElement list : counts) {
            String s = list.getText().substring(1, list.getText().length() - 1);
            commentsSum = commentsSum + Integer.valueOf(s);
        }
        return commentsSum;
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



    @AfterEach
    public void browserClose() {

        driver.close();
    }
}
