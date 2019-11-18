import Driver.Driver;

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
    }

    @After
    public void tearDown() {
        if (getWebDriver() != null) {
            quitDriver();
        }
    }
}
