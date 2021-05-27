package blogpage;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class BlogPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[1]/div/div[2]/form/div[1]/input")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/table[1]/tbody/tr/td/div[1]/a")
    private WebElement toSelectTopic;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div")
    private WebElement resultStatus;

    @FindBy(xpath = "//*[@id=\"content\"]/div[4]/label/select")
    private WebElement filter;

    @FindBy(xpath = "/html/body/div[2]/div[4]/label/select/option[2]")
    private WebElement newestFirst;


    public BlogPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
