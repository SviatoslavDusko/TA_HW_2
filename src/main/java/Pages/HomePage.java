package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends AbstractPage {
    private By changeLanguageButton = By.cssSelector("div.location-selector__globe/*:after");
    private By chooseEnglishLanguage = By.xpath("//div//a[contains(text(),'English')]");
    private By chooseRussianLanguage = By.xpath("//div//a[contains(text(),'Русский')]");
    private By chooseUkrainianLanguage = By.xpath("//div//a[contains(text(),'Українська')]");
    private By languageActiveButton = By.xpath("//div[@class='location-selector__item']//a[@class='active']");

    private By homePageWait = By.cssSelector("div.location-selector__globe/*:after");
    private By dropDownChangeLanguageWait = By.xpath("//div//a[contains(text(),'English')]");
    private By rightUpperSignInButtonWait = By.xpath("//a[@class='main-nav__item'][contains(text(),'Training list')]");

    private By mainPageAppears = By.xpath("//div[@class='hero-banner__content']");

    public void openChangeLanguageButtonClick() {
        waitBy(homePageWait);
        getElement(changeLanguageButton).click();
    }

    public void closeChangeLanguageButtonClick() {
        getElement(changeLanguageButton).click();
    }

    public void chooseLanguage(String language) {
        waitBy(dropDownChangeLanguageWait);
        if (language.toLowerCase().equals(getElement(chooseEnglishLanguage).getText().toLowerCase())) {
            getElement(chooseEnglishLanguage).click();
        } else if (language.toLowerCase().equals(getElement(chooseRussianLanguage).getText().toLowerCase())) {
            getElement(chooseRussianLanguage);
        }else if (language.toLowerCase().equals(getElement(chooseUkrainianLanguage).getText().toLowerCase())) {
            getElement(chooseUkrainianLanguage);
        }
        waitBy(rightUpperSignInButtonWait);
    }

    public WebElement getLanguage() {
        waitBy(mainPageAppears);
        waitBy(dropDownChangeLanguageWait);
        return getElement(languageActiveButton);
    }

    public boolean isMainPageDisplayed() {
        waitBy(mainPageAppears);
        return isElementDisplayed(mainPageAppears);
    }
}
