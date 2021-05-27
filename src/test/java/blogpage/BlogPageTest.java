package blogpage;

import forumpage.ForumPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import startpage.StartPage;

import java.util.concurrent.TimeUnit;

import static helpers.TimeoutHelper.waitTime;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BlogPageTest {
    private static WebDriver driver;
    private static StartPage startPage;
    private static BlogPage blogPage;
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
    @Order(2)
    public void searchTopicsAndSortComments() throws InterruptedException {
        driver.navigate().back();
        waitTime(2);
        blogPage.getSearchField().clear();
        blogPage.getSearchField().sendKeys("сайты" + Keys.ENTER);
        blogPage.getToSelectTopic().click();
        blogPage.getFilter().click();
        waitTime(1);
        blogPage.getNewestFirst().click();

        Assertions.assertFalse(driver.findElement(By.xpath("//*[text()=\"03 Ноября 2015,\"]")) == null);
    }

    @Test
    @Order(1)
    public void searchTopics_getNotFoundStatus() throws InterruptedException {
        startPage.getBlogLink().click();

        handles = new String[driver.getWindowHandles().size()];
        driver.getWindowHandles().toArray(handles);
        driver.switchTo().window(handles[1]);

        blogPage = new BlogPage(driver);

        waitTime(2);
        blogPage.getSearchField().clear();
        blogPage.getSearchField().sendKeys("dwqdqwdqsqdqdw" + Keys.ENTER);

        Assertions.assertTrue(blogPage.getResultStatus().getText().contains("По запросу ничего не найдено"));
    }
}
