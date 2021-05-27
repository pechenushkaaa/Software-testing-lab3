package ucozpage;

import helpers.AuthConfigsHolder;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import startpage.StartPage;
import ucozpage.UcozRegistrationPage;

import java.util.concurrent.TimeUnit;

import static helpers.TimeoutHelper.waitTime;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UcozRegistrationPageTest {
    private static WebDriver driver;
    private static StartPage startPage;
    private static UcozRegistrationPage uCozRegistrationPage;

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
    public void uCozRegistration_forwardToSecondRegistrationStep() throws InterruptedException {
        uCozRegistrationPage.getEmailField().sendKeys("testEmail@mail.ru");
        uCozRegistrationPage.getPasswordField().sendKeys(AuthConfigsHolder.getPASSWORD());
        waitTime(2);

        uCozRegistrationPage.getSubmitBtn().click();

        Assertions.assertTrue(driver.getCurrentUrl().equals("https://www.ucoz.ru/register2"));
    }

    @Test
    @Order(1)
    public void uCozRegistration_whenEmptyInput_thenShowErrorMessage() throws InterruptedException {
        startPage.getUCozRegistrationLink().click();
        uCozRegistrationPage = new UcozRegistrationPage(driver);

        uCozRegistrationPage.getSubmitBtn().click();

        waitTime(2);

        Assertions.assertTrue(uCozRegistrationPage.getEmailStatus().getText().contains("E-mail указан неправильно"));
        Assertions.assertTrue(uCozRegistrationPage.getPasswordStatus().getText().contains("Минимальная длина пароля 6 символов"));

        waitTime(1);

    }
}
