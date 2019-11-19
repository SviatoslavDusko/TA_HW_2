package Pages;

import org.openqa.selenium.By;

public class LoginPage extends AbstractPage {
    private By signInUpperRightButton = By.xpath("//p[@class='header-auth__signin']");
    private By signInButton = By.xpath("//input[@class='popup-reg-sign-in-form__sign-in']");

    private By emailInput = By.xpath("//input[@id='signInEmail']");
    private By passwordInput = By.xpath("//input[@id='signInPassword']");

    private By textWithInvalidSignIn = By.xpath("//div[@class='popup__error-message ng-binding']");
    private By userName = By.xpath("//div[@class='dropdown user-info-desktop']//div[@class='user-info__name']");

    private By rightUpperSignInButtonWait = By.xpath("//a[@class='main-nav__item'][contains(text(),'Training list')]");
    private By inputEmailWait = By.id("signInEmail");
    private By modalSignInWindow = By.xpath("//div[@class='popup-wrapper']");
    private By rightUpperUserNameWait = By.xpath("//div[@class='dropdown user-info-desktop']//div[@class='user-info__name'][contains(text(),'Sviatoslav-Petro Dusko')]");

    public void openSignInModalWindow() {
        waitBy(rightUpperSignInButtonWait);
        getElement(signInUpperRightButton).click();
    }

    public LoginPage enterUserData(String email, String password) {
        waitBy(inputEmailWait);
        getElement(emailInput).sendKeys(email);
        getElement(passwordInput).sendKeys(password);
        return this;
    }


    public void signInClick() {
        getElement(signInButton).click();
    }

    public boolean isFailedSignInMessageDisplayed() {
        waitBy(textWithInvalidSignIn);
        return isElementDisplayed(textWithInvalidSignIn);
    }

    public String getUserName() {
        waitBy(rightUpperUserNameWait);
        return getElement(userName).getText();
    }

    public boolean isLogInModalWindowDisplayed() {
        waitBy(modalSignInWindow);
        return isElementDisplayed(modalSignInWindow);
    }
}
