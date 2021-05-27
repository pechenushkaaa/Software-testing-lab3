package ucozpage;

import helpers.AuthConfigsHolder;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import startpage.StartPage;

import java.util.concurrent.TimeUnit;

import static helpers.TimeoutHelper.waitTime;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UcozAuthPageTest {
    private static WebDriver driver;
    private static StartPage startPage;
    private static UcozAuthPage uCozAuthPage;
    private static String[] handles;

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
    public void uCozAuth() throws InterruptedException {
        uCozAuthPage.getEmailField().sendKeys(AuthConfigsHolder.getEMAIL());
        uCozAuthPage.getPasswordField().sendKeys(AuthConfigsHolder.getPASSWORD());
        waitTime(2);

        uCozAuthPage.getSubmitBtn().click();
        waitTime(2);

        driver.switchTo().window(handles[0]);
        Assertions.assertTrue(driver.getCurrentUrl().equals("https://www.ucoz.ru/createsite"));
    }

    @Test
    @Order(1)
    public void uCozAuth_whenEmptyInput_thenShowErrorMessage() throws InterruptedException {
        startPage.getUCozEnterLink().click();

        uCozAuthPage = new UcozAuthPage(driver);
        uCozAuthPage.getEnterLink().click();

        handles = new String[driver.getWindowHandles().size()];
        driver.getWindowHandles().toArray(handles);
        driver.switchTo().window(handles[1]);
        uCozAuthPage.getSubmitBtn().click();

        waitTime(2);

        Assertions.assertTrue(uCozAuthPage.getErrorMessage().getText().contains("Некорректный e-mail или номер телефона") || uCozAuthPage.getErrorMessage().getText().contains("Invalid e-mail or phone"));

        waitTime(1);
    }
}
