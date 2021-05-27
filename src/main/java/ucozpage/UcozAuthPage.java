package ucozpage;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class UcozAuthPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"regform\"]/div/div[1]/a")
    private WebElement enterLink;

    @FindBy(xpath = "//*[@id=\"uid_email\"]")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"uid_password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"uid-form-submit\"]")
    private WebElement submitBtn;

    @FindBy(xpath = "//*[@id=\"form-error\"]")
    private WebElement errorMessage;

    public UcozAuthPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
