package reportpage;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class FeedbackPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"submit-fld\"]")
    private WebElement submitBtn;

    @FindBy(xpath = "//*[@id=\"name-fld\"]")
    private WebElement nameField;

    @FindBy(xpath = "//*[@id=\"email-fld\"]")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"nsite-fld\"]")
    private WebElement siteAddressField;

    @FindBy(xpath = "//*[@id=\"subj-fld\"]")
    private WebElement subjectField;

    @FindBy(xpath = "//*[@id=\"text-fld\"]")
    private WebElement textField;

    @FindBy(xpath = "//*[@id=\"fTerms-label\"]/span")
    private WebElement confirmCheckBox;

    public FeedbackPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
