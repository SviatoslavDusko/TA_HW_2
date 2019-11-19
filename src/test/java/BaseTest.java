import Driver.Driver;

import org.junit.After;
import org.junit.Before;

public class BaseTest extends Driver implements Constants{
    @Before
    public void setUp() {
        initDriver();
        getWebDriver().manage().window().maximize();
        getWebDriver().get(EPAMTRAINING);
    }

    @After
    public void tearDown() {
        if (getWebDriver() != null) {
            quitDriver();
        }
    }
}
