package Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Driver {
    private static WebDriver webDriver;
    protected void initDriver(){
        webDriver = new ChromeDriver();
    }

    public static WebDriver getWebDriver(){
        return webDriver;
    }

    public void quitDriver(){
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
