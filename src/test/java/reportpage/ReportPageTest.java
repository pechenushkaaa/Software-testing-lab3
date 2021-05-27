package reportpage;

import helpers.TimeoutHelper;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import startpage.StartPage;

import java.util.concurrent.TimeUnit;

import static helpers.TimeoutHelper.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReportPageTest {
    private static WebDriver driver;
    private static StartPage startPage;
    private ReportPage reportPage;
    private FeedbackPage feedbackPage;

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
    @Order(2)
    public void tryToMakeReport() throws InterruptedException {
        driver.navigate().back();
        startPage.getReportLink().click();

        reportPage = new ReportPage(driver);
        reportPage.getNameField().sendKeys("Sheggi");
        reportPage.getEmailField().sendKeys("test@mail.ru");
        reportPage.getSubjectsGroup().click();
        waitTime(2);
        reportPage.getSubject().click();
        waitTime(2);
        reportPage.getTextField().sendKeys("УБЕРИТЕ КАПЧУ!!!");
        waitTime(2);
        reportPage.getConfirmCheckBox().click();
        waitTime(1);
        reportPage.getSubmitBtn().click();
    }

    @Test
    @Order(1)
    public void tryToMakeFeedback() throws InterruptedException {
        startPage.getFeedbackLink().click();

        feedbackPage = new FeedbackPage(driver);
        feedbackPage.getEmailField().sendKeys("test@mail.ru");
        feedbackPage.getNameField().sendKeys("Sheggi");
        feedbackPage.getSiteAddressField().sendKeys("itmo.ru");
        feedbackPage.getSubjectField().sendKeys("Признание в любви");
        feedbackPage.getTextField().sendKeys("Я Очень сильно люблю функциональное тестирование. Особенно сайты с капчей!!! :)))");
        waitTime(2);
        feedbackPage.getConfirmCheckBox().click();
        waitTime(1);
        feedbackPage.getSubmitBtn().click();
        waitTime(2);
    }
}
