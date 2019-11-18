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

    public HomePage openChangeLanguageButtonClick() {
        waitBy(homePageWait);
        getElement(changeLanguageButton).click();
        return this;
    }

    public HomePage closeChangeLanguageButtonClick() {
        getElement(changeLanguageButton).click();
        return this;
    }

    public HomePage chooseLanguage(String language) {
        waitBy(dropDownChangeLanguageWait);
        if (language.toLowerCase().equals("english")) {
            getElement(chooseEnglishLanguage).click();
        } else if (language.toLowerCase().equals("русский")) {
            getElement(chooseRussianLanguage);
        }
        if (language.toLowerCase().equals("українська")) {
            getElement(chooseUkrainianLanguage);
        }
        waitBy(rightUpperSignInButtonWait);
        return this;
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
