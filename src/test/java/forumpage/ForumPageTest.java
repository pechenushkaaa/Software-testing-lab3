package forumpage;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import reportpage.FeedbackPage;
import reportpage.ReportPage;
import startpage.StartPage;

import java.util.concurrent.TimeUnit;

import static helpers.TimeoutHelper.waitTime;

public class ForumPageTest {
    private static WebDriver driver;
    private static StartPage startPage;
    private ForumPage forumPage;
    String[] handles;

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
    public void makeRate_newRateIsGreaterThanOld() throws InterruptedException {
        startPage.getForumLink().click();

        handles = new String[driver.getWindowHandles().size()];
        driver.getWindowHandles().toArray(handles);
        driver.switchTo().window(handles[1]);

        forumPage = new ForumPage(driver);
        forumPage.getNewMessages().click();
        waitTime(1);
        forumPage.getToSelectMessage().click();
        waitTime(1);

        int oldRate = Integer.parseInt(forumPage.getRateCounter().getText());
        forumPage.getRateBnt().click();
        int newRate = Integer.parseInt(forumPage.getRateCounter().getText());

        Assertions.assertTrue(oldRate < newRate);
    }
}
