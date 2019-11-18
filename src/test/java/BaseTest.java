import Driver.Driver;
import Pages.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BaseTest extends Driver {
    @Before
    public void setUp() {
        initDriver();
        getWebDriver().manage().window().maximize();
        getWebDriver().get("https://training.by/#!/Home");

        WebElement appearsMainPage = getWebDriver().findElement(By.xpath("//div[@class='hero-banner__content']"));
        Assert.assertTrue("Page is not appear", appearsMainPage.isDisplayed());
    }

    @After
    public void tearDown() {
        if (getWebDriver() != null) {
            quitDriver();
        }
    }
}
