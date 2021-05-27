package startpage;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class StartPage{
    private static final String URL = "http://www.ucoz.ru/";
    private WebDriver driver;

    @FindBy(xpath = "//section[1]//div[@class=\"card uKit-card\"]/div[3]/a[1]")
    private WebElement uKitRegistrationLink;

    @FindBy(xpath = "//section[1]//div[@class=\"card uCoz-card\"]/div[3]/a[1]")
    private WebElement uCozRegistrationLink;

    @FindBy(xpath = "//section[1]//div[@class=\"card uCoz-card\"]/div[3]/a[2]")
    private WebElement uCozEnterLink;


    @FindBy(xpath = "//section[2]//a[@class=\"button create-site \"]")
    private WebElement uCozCreateSiteLink;

    @FindBy(xpath = "//section[3]//a[@class=\"button uKit create-site\"]")
    private WebElement uKitStartWorkLink;

    @FindBy(xpath = "//section[4]//a[@class=\"button create-shop\"]")
    private WebElement uShopCreateShopLink;

    @FindBy(xpath = "//section[5]//a[@class=\"button create-calc\"]")
    private WebElement uCalcCreateCalcLink;

    @FindBy(xpath = "//section[6]//a[@class=\"button create-site\"]")
    private WebElement divlyCreateSiteLink;

    @FindBy(xpath = "//section[7]//a[@class=\"uscl-button\"]")
    private WebElement uSocialCreateSetLink;

    @FindBy(xpath = "//section[8]//a[@class=\"button buy-template\"]")
    private WebElement uTemplateBuyTemplateLink;

    @FindBy(xpath = "//section[9]//a[@class=\"button create-landing\"]")
    private WebElement uLandingCreateLandingLink;


    @FindBy(xpath = "//*[@id=\"super-footer\"]//div[1]/div[2]/ul/li[4]/a")
    private WebElement feedbackLink;

    @FindBy(xpath = "//*[@id=\"super-footer\"]//div[1]/div[4]/ul/li[2]/a")
    private WebElement reportLink;

    @FindBy(xpath = "//*[@id=\"super-footer\"]//div[1]/div[5]/ul/li[2]/a")
    private WebElement blogLink;

    @FindBy(xpath = "//*[@id=\"super-footer\"]//div[1]/div[5]/ul/li[3]/a")
    private WebElement forumLink;

    public StartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static String getUrl(){
        return URL;
    }
}
