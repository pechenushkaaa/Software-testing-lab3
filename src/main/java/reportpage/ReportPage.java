package reportpage;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class ReportPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"name-fld\"]")
    private WebElement nameField;

    @FindBy(xpath = "//*[@id=\"email-fld\"]")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"text-fld\"]")
    private WebElement textField;

    @FindBy(xpath = "//*[@id=\"subj-group\"]/div/p/span")
    private WebElement subjectsGroup;

    @FindBy(xpath = "//*[@id=\"subj-group\"]/div/div/ul/li[4]/label")
    private WebElement subject;

    @FindBy(xpath = "//*[@id=\"fTerms-label\"]/span")
    private WebElement confirmCheckBox;

    @FindBy(xpath = "//*[@id=\"submit-fld\"]")
    private WebElement submitBtn;

    public ReportPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
