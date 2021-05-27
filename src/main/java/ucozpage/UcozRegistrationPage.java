package ucozpage;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class UcozRegistrationPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"fEmail\"]")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"fPassword\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"fEmail-status\"]")
    private WebElement emailStatus;

    @FindBy(xpath = "//*[@id=\"fPassword-status\"]")
    private WebElement passwordStatus;

    @FindBy(xpath = "//*[@id=\"sbt47\"]")
    private WebElement submitBtn;


    public UcozRegistrationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
