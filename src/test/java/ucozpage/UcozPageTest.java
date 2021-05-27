package ucozpage;

import helpers.AuthConfigsHolder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import startpage.StartPage;

import java.util.concurrent.TimeUnit;

import static helpers.TimeoutHelper.waitTime;

public class UcozPageTest {
    private static WebDriver driver;
    private static UcozPage uCozPage;
    private static UcozAuthPage uCozAuthPage;
    private String[] handles;

    @BeforeAll
    public static void setup(){
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(StartPage.getUrl() + "login");

        uCozAuthPage = new UcozAuthPage(driver);
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        waitTime(2);
        driver.quit();
    }

    @Test
    public void tryToCreateSite_ShowErrorMessage() throws InterruptedException {
        doAuthorization();
        driver.switchTo().window(handles[0]);
        uCozPage = new UcozPage(driver);

        uCozPage.getSiteAddressField().sendKeys("ILoveTesting");
        waitTime(1);
        uCozPage.getConfirmCheckBox().click();
        waitTime(1);
        uCozPage.getCreateSiteBtn().click();

        Assertions.assertTrue(uCozPage.getErrorMessage().getText().contains("Для получения возможности создавать больше сайтов,\n" + "подтвердите ваш номер телефона"));
    }

    private void doAuthorization() throws InterruptedException {
        uCozAuthPage.getEnterLink().click();

        handles = new String[driver.getWindowHandles().size()];
        driver.getWindowHandles().toArray(handles);
        driver.switchTo().window(handles[1]);

        uCozAuthPage.getEmailField().sendKeys(AuthConfigsHolder.getEMAIL());
        uCozAuthPage.getPasswordField().sendKeys(AuthConfigsHolder.getPASSWORD());
        waitTime(2);
        uCozAuthPage.getSubmitBtn().click();

    }
}
