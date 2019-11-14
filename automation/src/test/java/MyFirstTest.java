import com.sun.xml.internal.txw2.output.DumpSerializer;
import org.checkerframework.checker.signature.qual.ClassGetName;
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
    public void setUp() {
        WebDriver = new ChromeDriver();
        wait = new WebDriverWait(WebDriver, 30, 500);
        WebDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebDriver.manage().window().maximize();

        WebDriver.get("https://training.by/#!/Home");
        WebDriver.manage().deleteAllCookies();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.location-selector__globe/*:after")));

        WebElement appearsMainPage = WebDriver.findElement(By.xpath("//div[@class='hero-banner__content']"));
        Assert.assertTrue("Page is not appear", appearsMainPage.isDisplayed());

        WebElement changeLanguage = WebDriver.findElement(By.cssSelector("div.location-selector__globe/*:after"));
        changeLanguage.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[a[contains(text(),'English')]]")));

        WebElement chooseEnglish = WebDriver.findElement(By.xpath("//a[contains(text(),'English')]"));
        chooseEnglish.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='main-nav__item'][contains(text(),'Training list')]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='header-auth__signin']")));

        WebElement signInUpperRightButton = WebDriver.findElement(By.xpath("//p[@class='header-auth__signin']"));
        signInUpperRightButton.click();

        WebElement signInModalWindow = WebDriver.findElement(By.xpath("//div[@class='popup-wrapper']"));
        Assert.assertTrue("'Sign In' modal window is not displayed", signInModalWindow.isDisplayed());
    }

    @Test
    public void verifyLogIn() {
        WebElement SearchEmailInput = WebDriver.findElement(By.xpath("//input[@id='signInEmail']"));
        SearchEmailInput.sendKeys("swiatikdusko@gmail.com");

        WebElement SearchPasswordInput = WebDriver.findElement(By.xpath("//input[@id='signInPassword']"));
        SearchPasswordInput.sendKeys("kom87lans12");

        WebElement signInButton = WebDriver.findElement(By.xpath("//input[@class='popup-reg-sign-in-form__sign-in']"));
        signInButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal-body']")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dropdown user-info-desktop']//div[@class='user-info__name'][contains(text(),'Sviatoslav-Petro Dusko')]")));

        String userName = WebDriver.findElement(By.xpath("//div[@class='dropdown user-info-desktop']//div[@class='user-info__name']")).getText();
        Assert.assertTrue("Invalid Login", userName.contains("Sviatoslav-Petro Dusko"));
    }

    @Test
    public void notVerifyLogIn() {
        WebElement SearchEmailInput = WebDriver.findElement(By.xpath("//input[@id='signInEmail']"));
        SearchEmailInput.sendKeys("swiatikdusko@gmail.com");

        WebElement SearchPasswordInput = WebDriver.findElement(By.xpath("//input[@id='signInPassword']"));
        SearchPasswordInput.sendKeys("kom87lans2");

        WebElement signInButton = WebDriver.findElement(By.xpath("//input[@class='popup-reg-sign-in-form__sign-in']"));
        signInButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal-body']")));

        String failedLogIn = WebDriver.findElement(By.xpath("//div[@class='popup__error-message ng-binding']")).getText();
        Assert.assertTrue("Error message not displays", failedLogIn.contains("Login failed. Please try again."));
    }

    @Test
    public void trainingSearchSkills() {
        WebElement SearchEmailInput = WebDriver.findElement(By.xpath("//input[@id='signInEmail']"));
        SearchEmailInput.sendKeys("swiatikdusko@gmail.com");

        WebElement SearchPasswordInput = WebDriver.findElement(By.xpath("//input[@id='signInPassword']"));
        SearchPasswordInput.sendKeys("kom87lans12");

        WebElement signInButton = WebDriver.findElement(By.xpath("//input[@class='popup-reg-sign-in-form__sign-in']"));
        signInButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal-body']")));

        String userName = WebDriver.findElement(By.xpath("//div[@class='dropdown user-info-desktop']//div[@class='user-info__name']")).getText();
        Assert.assertTrue("Invalid Login", userName.contains("Sviatoslav-Petro Dusko"));

        WebElement trainingListButton = WebDriver.findElement(By.xpath("//div[@class='links-row']//a[contains(text(),'Training list')]"));
        trainingListButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='main-nav__list']//a[@class='topNavItem training click hover activeItem']")));

        WebElement activeTrainingListButton = WebDriver.findElement(By.xpath("//ul[@class='main-nav__list']//a[@class='topNavItem training click hover activeItem']"));
        Assert.assertTrue("'Training List' page is not opened", activeTrainingListButton.isDisplayed());

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'OUR SKILLS')]")));

        WebElement openCloseSearchListWithCheckbox = WebDriver.findElement(By.xpath("//div[@class='filter-toggle__arrow-icon']"));
        openCloseSearchListWithCheckbox.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='navigation-item ng-binding']")));

        WebElement bySkillsButton = WebDriver.findElement(By.xpath("//div[@class='navigation-item ng-binding']"));
        bySkillsButton.click();

        WebElement dropDownBySkillsBlock = WebDriver.findElement(By.xpath("//div[@class='navigation-item ng-binding active']"));
        Assert.assertTrue("Search 'By skills' is not displayed", dropDownBySkillsBlock.getText().contains("By skills"));

        WebElement searchBySkillInput = WebDriver.findElement(By.xpath("//input[@placeholder='Search by skills']"));
        searchBySkillInput.clear();
        searchBySkillInput.sendKeys("Java");

        List<WebElement> checkBoxesContainsJavaWordList = WebDriver.findElements(By.xpath("//div[@class='filter-toggle']//label"));
        for (WebElement option : checkBoxesContainsJavaWordList) {
            if (option.getText().equals("Java")){
                option.click();
            }
        }

        openCloseSearchListWithCheckbox.click();

        List<WebElement> skillsContainsJavaWordList = WebDriver.findElements(By.xpath("//div[@class='training-list__container training-list__desktop']//a[@class='training-item__title-link ng-binding'][contains(text(),'Java')]"));
        skillsContainsJavaWordList.add(WebDriver.findElement(By.xpath("//div[@class='training-list__container training-list__desktop']//a[@class='training-item__title-link ng-binding'][contains(text(),'JAVA')]")));
        for (WebElement option : skillsContainsJavaWordList) {
            Assert.assertTrue("Search element by skills 'Java' contains not 'Java' word", option.getText().toLowerCase().contains("java"));
        }

        openCloseSearchListWithCheckbox.click();
        List<WebElement> activeSkillsList = WebDriver.findElements(By.xpath("//label[@class='location__not-active-label ng-binding location__location-active-label']"));
        for (WebElement option : activeSkillsList) {
                option.click();
        }
        openCloseSearchListWithCheckbox.click();

        searchBySkillInput.clear();
        searchBySkillInput.click();
        searchBySkillInput.sendKeys("DATA");

        List<WebElement> checkBoxesContainsDataWordList = WebDriver.findElements(By.xpath("//div[@class='filter-toggle']//label"));
        for (WebElement option : checkBoxesContainsDataWordList) {
            if (option.getText().contains("Data")) {
                option.click();
            }
        }

        openCloseSearchListWithCheckbox.click();

        List<WebElement> skillsContainsDataWordList = WebDriver.findElements(By.xpath("//div[@class='training-list__container training-list__desktop']//a[@class='training-item__title-link ng-binding'][contains(text(),'Data')]"));
        for (WebElement option : skillsContainsDataWordList) {
            Assert.assertTrue("Search element by skills 'DATA' contains not 'DATA' word", option.getText().toLowerCase().contains("data"));
        }

        openCloseSearchListWithCheckbox.click();
        List<WebElement> activeSkillsList2 = WebDriver.findElements(By.xpath("//label[@class='location__not-active-label ng-binding location__location-active-label']"));
        for (WebElement option : activeSkillsList2) {
            option.click();
        }
        openCloseSearchListWithCheckbox.click();

        searchBySkillInput.clear();
        searchBySkillInput.click();
        searchBySkillInput.sendKeys("pascal");

        List<WebElement> skillList = WebDriver.findElements(By.xpath("//li[@class='cities ng-scope']"));
        Assert.assertTrue("Search result invalid", skillList.size() == 0);
    }

    @Test
    public void verifyNewsPage() {
        WebElement SearchEmailInput = WebDriver.findElement(By.xpath("//input[@id='signInEmail']"));
        SearchEmailInput.sendKeys("swiatikdusko@gmail.com");

        WebElement SearchPasswordInput = WebDriver.findElement(By.xpath("//input[@id='signInPassword']"));
        SearchPasswordInput.sendKeys("kom87lans12");

        WebElement signInButton = WebDriver.findElement(By.xpath("//input[@class='popup-reg-sign-in-form__sign-in']"));
        signInButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal-body']")));

        String userName = WebDriver.findElement(By.xpath("//div[@class='dropdown user-info-desktop']//div[@class='user-info__name']")).getText();
        Assert.assertTrue("Invalid Login", userName.contains("Sviatoslav-Petro Dusko"));

        WebElement newsButton = WebDriver.findElement(By.xpath("//div[@class='links-row']//li//*[contains(text(),'News')]"));
        newsButton.click();

        WebElement newsPageIsOpened = WebDriver.findElement(By.xpath("//ul[@class='main-nav__list']//a[@class='topNavItem news click hover activeItem'][contains(text(),'News')]"));
        WebElement pageIsOpened = WebDriver.findElement(By.xpath("//ul[@class='main-nav__list']//a[@class='topNavItem news click hover activeItem']"));
        Assert.assertTrue("", newsPageIsOpened.getClass() == pageIsOpened.getClass());

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='news-page-list__all-news']")));

        WebElement materialsButton = WebDriver.findElement(By.xpath("//news-categories[@class='ng-isolate-scope']//div//span[contains(text(),'Materials')]"));

        JavascriptExecutor executor = (JavascriptExecutor) WebDriver;
        executor.executeScript("arguments[0].click()", materialsButton);

        WebElement materialsButtonIsActive = WebDriver.findElement(By.xpath("//div[@class='tab-nav__item ng-scope active']//span[contains(text(),'Materials')]"));
        WebElement newsActivePage = WebDriver.findElement(By.xpath("//div[@class='tab-nav__item ng-scope active']"));

        Assert.assertTrue("Materials page is not active", newsActivePage.getClass() == materialsButtonIsActive.getClass());
    }

    @Test
    public void trainingSearchLocations() {
        WebElement SearchEmailInput = WebDriver.findElement(By.xpath("//input[@id='signInEmail']"));
        SearchEmailInput.sendKeys("swiatikdusko@gmail.com");

        WebElement SearchPasswordInput = WebDriver.findElement(By.xpath("//input[@id='signInPassword']"));
        SearchPasswordInput.sendKeys("kom87lans12");

        WebElement signInButton = WebDriver.findElement(By.xpath("//input[@class='popup-reg-sign-in-form__sign-in']"));
        signInButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal-body']")));

        String userName = WebDriver.findElement(By.xpath("//div[@class='dropdown user-info-desktop']//div[@class='user-info__name']")).getText();
        Assert.assertTrue("Invalid Login", userName.contains("Sviatoslav-Petro Dusko"));

        WebElement trainingListButton = WebDriver.findElement(By.xpath("//div[@class='links-row']//li//*[contains(text(),'Training list')]"));
        trainingListButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'OUR SKILLS')]")));

        WebElement activeTrainingListButton = WebDriver.findElement(By.xpath("//ul[@class='main-nav__list']//a[@class='topNavItem training click hover activeItem']"));
        Assert.assertTrue("'Training List' page is not opened", activeTrainingListButton.isDisplayed());

        WebElement openCloseSearchListWithCheckbox = WebDriver.findElement(By.xpath("//div[@class='filter-toggle__arrow-icon']"));
        openCloseSearchListWithCheckbox.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='navigation-item ng-binding']")));

        WebElement dropDownWithCountries = WebDriver.findElement(By.xpath("//div[@class='drop-down drop-down-choose drop-down-visibility']"));
        Assert.assertTrue("Drop down with Countries is not displayed", dropDownWithCountries.isDisplayed());

        WebElement chooseUkraine = WebDriver.findElement(By.xpath("//div[@class='location__not-active-label city-name ng-binding'][contains(text(),'Ukraine')]"));
        chooseUkraine.click();

        List<WebElement> citiesCheckBoxesList = WebDriver.findElements(By.xpath("//ul[@class='location__cities-list-cities ng-scope']//label[@class='location__not-active-label ng-binding']"));
        for (WebElement option : citiesCheckBoxesList) {
            if (option.getText().contains("Lviv")) {
                if (!option.isSelected()) {
                    option.click();
                }
            }
        }

        openCloseSearchListWithCheckbox.click();

        List<WebElement> cityContainsLvivWordList = WebDriver.findElements(By.xpath("//div[@class='training-list__container training-list__desktop']//div[@class='training-item__location ng-binding']"));
        for (WebElement option : cityContainsLvivWordList) {
            Assert.assertTrue("Search element location is not 'Lviv'", option.getText().contains("Lviv"));
        }
    }

    @After
    public void tearDown() {
        if (WebDriver != null) {
            WebDriver.quit();
        }
    }
}
