package startpage;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import startpage.StartPage;

import java.util.concurrent.TimeUnit;

import static helpers.TimeoutHelper.waitTime;

public class StartPageTest {
    private static WebDriver driver;
    private static StartPage startPage;
    private String[] handles;

    @BeforeAll
    public static void setup(){
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(StartPage.getUrl());

        startPage = new StartPage(driver);
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        waitTime(2);
        driver.quit();
    }

    @Test
    public void internalUrlsCheck() throws InterruptedException {
        startPage.getUCozCreateSiteLink().click();
        waitTime(2);

        startPage.getUKitStartWorkLink().click();
        waitTime(2);

        startPage.getUShopCreateShopLink().click();
        waitTime(2);

        startPage.getUCalcCreateCalcLink().click();
        waitTime(2);

        startPage.getDivlyCreateSiteLink().click();
        waitTime(2);

        startPage.getUSocialCreateSetLink().click();
        waitTime(2);

        startPage.getUTemplateBuyTemplateLink().click();
        waitTime(2);

        startPage.getULandingCreateLandingLink().click();
        waitTime(2);

        handles = new String[driver.getWindowHandles().size()];
        driver.getWindowHandles().toArray(handles);

        Assertions.assertTrue(driver.switchTo().window(handles[0]).getCurrentUrl().contains("ucoz.ru"));
        Assertions.assertTrue(driver.switchTo().window(handles[1]).getCurrentUrl().contains("ulanding.io"));
        Assertions.assertTrue(driver.switchTo().window(handles[2]).getCurrentUrl().contains("utemplate.pro"));
        Assertions.assertTrue(driver.switchTo().window(handles[3]).getCurrentUrl().contains("usocial.pro"));
        Assertions.assertTrue(driver.switchTo().window(handles[4]).getCurrentUrl().contains("divly.ru"));
        Assertions.assertTrue(driver.switchTo().window(handles[5]).getCurrentUrl().contains("ucalc.pro"));
        Assertions.assertTrue(driver.switchTo().window(handles[6]).getCurrentUrl().contains("ucoz.ru"));
        Assertions.assertTrue(driver.switchTo().window(handles[7]).getCurrentUrl().contains("ukit.com"));
        Assertions.assertTrue(driver.switchTo().window(handles[8]).getCurrentUrl().contains("ucoz.ru"));
    }

}
