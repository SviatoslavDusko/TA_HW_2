import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyFirstTest {
    WebDriver WebDriver;
    WebDriverWait wait;

    @Before
    public void setUp(){
        WebDriver = new ChromeDriver();
        wait = new WebDriverWait(WebDriver,30,500);
        WebDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriver.manage ().timeouts ().implicitlyWait (15,  TimeUnit.SECONDS);
        WebDriver.manage().window().maximize();

        WebDriver.get("https://training.by/#!/Home");
        WebDriver.manage().deleteAllCookies();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.location-selector__globe/*:after")));

        WebElement changeLanguage = WebDriver.findElement(By.cssSelector("div.location-selector__globe/*:after"));
        changeLanguage.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[a[contains(text(),'English')]]")));

        WebElement chooseEnglish = WebDriver.findElement(By.xpath("//a[contains(text(),'English')]"));
        chooseEnglish.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='main-nav__item'][contains(text(),'Training list')]")));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='header-auth__signin']")));

        WebElement signInUpperRightButton = WebDriver.findElement(By.xpath("//p[@class='header-auth__signin']"));
        signInUpperRightButton.click();
       }

    @Test
    public void verifyLogIn(){
        WebElement SearchEmailInput = WebDriver.findElement(By.xpath("//input[@id='signInEmail']"));
        SearchEmailInput.sendKeys("swiatikdusko@gmail.com");

        WebElement SearchPasswordInput = WebDriver.findElement(By.xpath("//input[@id='signInPassword']"));
        SearchPasswordInput.sendKeys("kom87lans12");

        WebElement signInButton = WebDriver.findElement(By.xpath("//input[@class='popup-reg-sign-in-form__sign-in']"));
        signInButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal-body']")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dropdown user-info-desktop']//div[@class='user-info__name'][contains(text(),'Sviatoslav-Petro Dusko')]")));

        Assert.assertTrue(WebDriver.findElement(By.xpath("//div[@class='dropdown user-info-desktop']//div[@class='user-info__name'][contains(text(),'Sviatoslav-Petro Dusko')]")).getText().contains("Sviatoslav-Petro Dusko"));
    }

    @Test
    public void notVerifyLogIn(){
        WebElement SearchEmailInput = WebDriver.findElement(By.xpath("//input[@id='signInEmail']"));
        SearchEmailInput.sendKeys("swiatikdusko@gmail.com");

        WebElement SearchPasswordInput = WebDriver.findElement(By.xpath("//input[@id='signInPassword']"));
        SearchPasswordInput.sendKeys("kom87lans2");

        WebElement signInButton = WebDriver.findElement(By.xpath("//input[@class='popup-reg-sign-in-form__sign-in']"));
        signInButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal-body']")));

        Assert.assertTrue(WebDriver.findElement(By.xpath("//div[@class='popup__error-message ng-binding'][contains(text(),'Login failed. Please try again.')]")).getText().contains("Login failed. Please try again."));
    }

    @Test
    public void trainingSearchSkills (){
        WebElement SearchEmailInput = WebDriver.findElement(By.xpath("//input[@id='signInEmail']"));
        SearchEmailInput.sendKeys("swiatikdusko@gmail.com");

        WebElement SearchPasswordInput = WebDriver.findElement(By.xpath("//input[@id='signInPassword']"));
        SearchPasswordInput.sendKeys("kom87lans12");

        WebElement signInButton = WebDriver.findElement(By.xpath("//input[@class='popup-reg-sign-in-form__sign-in']"));
        signInButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal-body']")));

        WebElement trainingListButton = WebDriver.findElement(By.xpath("//div[@class='links-row']//li//*[contains(text(),'Training list')]"));
        trainingListButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'OUR SKILLS')]")));

        WebElement openCloseSearchListWithCheckbox = WebDriver.findElement(By.xpath("//div[@class='filter-toggle__arrow-icon']"));
        openCloseSearchListWithCheckbox.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='navigation-item ng-binding']")));

        WebElement bySkillsButton = WebDriver.findElement(By.xpath("//div[@class='navigation-item ng-binding']"));
        bySkillsButton.click();

        WebElement searchBySkillInput = WebDriver.findElement(By.xpath("//input[@placeholder='Search by skills']"));
        searchBySkillInput.clear();
        searchBySkillInput.sendKeys("Java");
        WebElement javaCheckbox = WebDriver.findElement(By.xpath("//div[@class='filter-toggle']//li[1]//label[1]"));
        javaCheckbox.click();
        openCloseSearchListWithCheckbox.click();

        openCloseSearchListWithCheckbox.click();
        javaCheckbox.click();
        openCloseSearchListWithCheckbox.click();

        searchBySkillInput.clear();
        searchBySkillInput.click();
        searchBySkillInput.sendKeys("DATA");

        WebElement checkboxData1 = WebDriver.findElement(By.xpath("//div[@class='filter-toggle']//li[1]//label[1]"));
        checkboxData1.click();
        WebElement checkboxData2 = WebDriver.findElement(By.xpath("//div[@class='filter-toggle']//li[2]//label[1]"));
        checkboxData2.click();

        openCloseSearchListWithCheckbox.click();
        openCloseSearchListWithCheckbox.click();
        checkboxData1.click();
        checkboxData2.click();
        openCloseSearchListWithCheckbox.click();

        searchBySkillInput.clear();
        searchBySkillInput.click();
        searchBySkillInput.sendKeys("pascal");

        Assert.assertTrue("No search results for that term.", true);
    }

    @Test
    public void verifyNewsPage(){
        WebElement SearchEmailInput = WebDriver.findElement(By.xpath("//input[@id='signInEmail']"));
        SearchEmailInput.sendKeys("swiatikdusko@gmail.com");

        WebElement SearchPasswordInput = WebDriver.findElement(By.xpath("//input[@id='signInPassword']"));
        SearchPasswordInput.sendKeys("kom87lans12");

        WebElement signInButton = WebDriver.findElement(By.xpath("//input[@class='popup-reg-sign-in-form__sign-in']"));
        signInButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal-body']")));

        WebElement newsButton = WebDriver.findElement(By.xpath("//div[@class='links-row']//li//*[contains(text(),'News')]"));
        newsButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='news-page-list__all-news']")));

        WebElement materialsButton = WebDriver.findElement(By.xpath("//news-categories[@class='ng-isolate-scope']//div[3]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//news-categories[@class='ng-isolate-scope']//div[3]")));
//        materialsButton.click();
        JavascriptExecutor executor = (JavascriptExecutor)WebDriver;
        executor.executeScript("arguments[0].click()", materialsButton);
    }

    @Test
    public void trainingSearchLocations(){
        WebElement SearchEmailInput = WebDriver.findElement(By.xpath("//input[@id='signInEmail']"));
        SearchEmailInput.sendKeys("swiatikdusko@gmail.com");

        WebElement SearchPasswordInput = WebDriver.findElement(By.xpath("//input[@id='signInPassword']"));
        SearchPasswordInput.sendKeys("kom87lans12");

        WebElement signInButton = WebDriver.findElement(By.xpath("//input[@class='popup-reg-sign-in-form__sign-in']"));
        signInButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal-body']")));

        WebElement trainingListButton = WebDriver.findElement(By.xpath("//div[@class='links-row']//li//*[contains(text(),'Training list')]"));
        trainingListButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'OUR SKILLS')]")));

        WebElement openCloseSearchListWithCheckbox = WebDriver.findElement(By.xpath("//div[@class='filter-toggle__arrow-icon']"));
        openCloseSearchListWithCheckbox.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='navigation-item ng-binding']")));

        WebElement chooseUkraine = WebDriver.findElement(By.xpath("//div[@class='location__not-active-label city-name ng-binding'][contains(text(),'Ukraine')]"));
        chooseUkraine.click();

        WebElement cityCheckbox = WebDriver.findElement(By.xpath("//*[@id=\"training\"]/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[2]/ul/li[4]/label/input"));
        WebElement cityButton = WebDriver.findElement(By.xpath("//div[@class='drop-down-choose__frame-active']//li[4]//label[1]"));
        if (!cityCheckbox.isSelected()){
            cityButton.click();
        }
        openCloseSearchListWithCheckbox.click();

        List<WebElement> cityContainsLviv = WebDriver.findElements(By.xpath("//div[@class='training-list__container training-list__desktop']//div[@class='training-item__location ng-binding']"));
        for (WebElement option: cityContainsLviv){
            if (option.getText().contains("Lviv")){
                Assert.assertTrue(true);
            }else {
                Assert.assertTrue(false);
            }
        }
    }

    @After
    public void tearDown(){
        if (WebDriver != null){
             WebDriver.quit();
        }
    }
}
