package model;


import org.openqa.selenium.WebElement;

public class Article {
    private String title;
    private Integer commentCount;
    private WebElement element;

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public void setCommentCount(String commentCount) {
        commentCount = commentCount.substring(1, commentCount.length() - 1);
        this.commentCount = Integer.valueOf(commentCount);
    }

    public WebElement getElement() {
        return element;
    }

    public void setElement(WebElement element) {
        this.element = element;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
