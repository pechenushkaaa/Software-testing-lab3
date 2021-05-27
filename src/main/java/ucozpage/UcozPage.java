package ucozpage;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class UcozPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"sbt47\"]")
    private WebElement createSiteBtn;

    @FindBy(xpath = "//*[@id=\"addr\"]")
    private WebElement siteAddressField;

    @FindBy(xpath = "//section/div[2]//form/div[2]/label/span")
    private WebElement confirmCheckBox;

    @FindBy(xpath = "//*[@id=\"faddr-status\"]")
    private WebElement errorMessage;

    public UcozPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
