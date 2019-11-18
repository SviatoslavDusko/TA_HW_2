package Pages;

import Driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {
    private By signInUpperRightButton = By.xpath("//p[@class='header-auth__signin']");
    private By signInButton = By.xpath("//input[@class='popup-reg-sign-in-form__sign-in']");

    private By emailInput = By.xpath("//input[@id='signInEmail']");
    private By passwordInput = By.xpath("//input[@id='signInPassword']");

    private By textWithInvalidSignIn = By.xpath("//div[@class='popup__error-message ng-binding']");
    private By userName = By.xpath("//div[@class='dropdown user-info-desktop']//div[@class='user-info__name']");

    private By leftUpperTrainingListButtonWait = By.xpath("//a[@class='main-nav__item'][contains(text(),'Training list')]");
    private By rightUpperSignInButtonWait = By.xpath("//a[@class='main-nav__item'][contains(text(),'Training list')]");
    private By inputEmailWait = By.id("signInEmail");
    private By modalBodyWait = By.xpath("//div[@class='modal-body']");
    private By modalSignInWindow = By.xpath("//div[@class='popup-wrapper']");
    private By rightUpperUserNameWait = By.xpath("//div[@class='dropdown user-info-desktop']//div[@class='user-info__name'][contains(text(),'Sviatoslav-Petro Dusko')]");

    public LoginPage openSignInModalWindow() {
//        waitBy(leftUpperTrainingListButtonWait);
        waitBy(rightUpperSignInButtonWait);
        getElement(signInUpperRightButton).click();
        return this;
    }

    public LoginPage enterUserData(String email, String password) {
        waitBy(inputEmailWait);
        getElement(emailInput).sendKeys(email);
        getElement(passwordInput).sendKeys(password);
        return this;
    }


    public void signInClick() {
        getElement(signInButton).click();
//            waitBy(modalBodyWait);
//        }
    }

    public Boolean isFailedSignInMessageDisplayed() {
        waitBy(textWithInvalidSignIn);
        if (isElementDisplayed(textWithInvalidSignIn)) {
            return true;
        } else {
            return false;
        }
    }

    public String getUserName() {
        waitBy(rightUpperUserNameWait);
        return getElement(userName).getText();
    }

    public Boolean isLogInModalWindowDisplayed() {
        waitBy(modalSignInWindow);
        if (isElementDisplayed(modalSignInWindow)) {
            return true;
        } else
            return false;
    }
}
