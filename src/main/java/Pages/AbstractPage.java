package Pages;

import Driver.Driver;
import com.sun.org.apache.bcel.internal.Constants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


class AbstractPage  {
    private static WebDriverWait wait = new WebDriverWait(Driver.getWebDriver(), 30, 500);

    WebElement getElement(By locator) {
        return (Driver.getWebDriver().findElement(locator));
    }

    List<WebElement> getElements(By locator) {
        return (Driver.getWebDriver().findElements(locator));
    }

    void waitBy(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        isElementDisplayed(locator);
    }

    void sendKey(String key, By locator) {
        getElement(locator).sendKeys(key);
    }

    boolean isElementDisplayed(By locator) {
        try {
            Driver.getWebDriver().findElement(locator).isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    void clickOnCheckBoxWithKey(String key, By locator) {
        List<WebElement> checkBoxes = getElements(locator);
        for (WebElement option : checkBoxes) {
            if (option.getText().toLowerCase().equals(key.toLowerCase())) {
                option.click();
                break;
            }
        }
    }

    void clickOnCheckBoxesWithKey(String key, By locator) {
        List<WebElement> checkBoxes = getElements(locator);
        for (WebElement option : checkBoxes) {
            if (option.getText().toLowerCase().contains(key.toLowerCase())) {
                option.click();
            }
        }
    }

    void clickOnActiveCheckBoxes(By locator) {
        List<WebElement> checkBoxesActiveList = getElements(locator);
        for (WebElement option : checkBoxesActiveList) {
            option.click();
        }
    }

    void chooseCountryOnTrainingList(String country, By locator) {
        List<WebElement> countries = getElements(locator);
        for (WebElement option : countries) {
            if (option.getText().toLowerCase().contains(country.toLowerCase())) {
                option.click();
                break;
            }
        }
    }
}
