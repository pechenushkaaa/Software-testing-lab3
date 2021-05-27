package forumpage;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class ForumPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"wrap\"]/div[3]/ul/li[1]/a")
    private WebElement newMessages;

    @FindBy(xpath = "//div[1]/div[4]/div/div/div[1]/div/table//tr[4]/td[3]/a")
    private WebElement toSelectMessage;

    @FindBy(xpath = "//div[1]/div[4]/div/div/div[1]/div/table//tr[3]/td/div/div[2]/div[3]/div[5]/div/div[2]/div/div[2]")
    private WebElement rateBnt;

    @FindBy(xpath = "//table//tr[3]/td/div/div[2]/div[3]/div[5]/div/div[2]/div/div[@class=\"uscl-uLikeButton-counter\"]")
    private WebElement rateCounter;

    public ForumPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
