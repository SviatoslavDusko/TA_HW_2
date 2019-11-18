package Pages;

import Driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class AbstractPage {
    private static WebDriverWait wait =  new WebDriverWait(Driver.getWebDriver(), 30, 500);

    WebElement getElement(By locator){
        return (Driver.getWebDriver().findElement(locator));
    }

    List<WebElement> getElements (By locator){
        return (Driver.getWebDriver().findElements(locator));
    }

    public void waitBy (By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        isElementDisplayed(locator);
    }

    public void sendKey(String key,By locator){
        getElement(locator).sendKeys(key);
    }

    public boolean isElementDisplayed(By locator) {
        try {
            Driver.getWebDriver().findElement(locator).isDisplayed();
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void clickOnCheckBoxWithKey(String key, By locator){
        List<WebElement> checkBoxes = getElements(locator);
        for (WebElement option : checkBoxes) {
            if (option.getText().toLowerCase().equals(key.toLowerCase())){
                option.click();
                break;
            }
        }
    }

    public void clickOnCheckBoxesWithKey(String key, By locator){
        List<WebElement> checkBoxes = getElements(locator);
        for (WebElement option : checkBoxes) {
            if (option.getText().toLowerCase().contains(key.toLowerCase())){
                option.click();
            }
        }
    }

    public void clickOnActiveCheckBoxes(By locator){
        List<WebElement> checkBoxesActiveList = getElements(locator);
        for (WebElement option : checkBoxesActiveList) {
            option.click();
        }
    }

    public void chooseCountryOnTrainingList(String country, By locator){
        List<WebElement> countries = getElements(locator);
        for (WebElement option : countries){
            if (option.getText().toLowerCase().contains(country.toLowerCase())){
                option.click();
                break;
            }
        }
    }


}
