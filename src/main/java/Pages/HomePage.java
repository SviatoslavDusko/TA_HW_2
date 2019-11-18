package Pages;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage extends AbstractPage{
    private By changeLanguageButton = By.cssSelector("div.location-selector__globe/*:after");
    private By chooseEnglishLanguage = By.xpath("//div//a[contains(text(),'English')]");
    private By chooseRussianLanguage = By.xpath("//div//a[contains(text(),'Русский')]");
    private By chooseUkrainianLanguage = By.xpath("//div//a[contains(text(),'Українська')]");

    private By homePageWait = By.cssSelector("div.location-selector__globe/*:after");
    private By dropDownChangeLanguageWait = By.xpath("//div//a[contains(text(),'English')]");

    private By mainPageAppears = By.xpath("//div[@class='hero-banner__content']");

    public HomePage changeLanguageButtonClick(){
        waitBy(homePageWait);
        getElement(changeLanguageButton).click();
        return this;
    }

    public LoginPage chooseLanguage(String language){
        waitBy(dropDownChangeLanguageWait);
        if (language.toLowerCase().equals("english")) {
            getElement(chooseEnglishLanguage).click();
        }else if (language.toLowerCase().equals("русский")){
            getElement(chooseRussianLanguage);
        }if (language.toLowerCase().equals("українська")){
            getElement(chooseUkrainianLanguage);
        }
        return new LoginPage();
    }

    public boolean isMainPageDisplayed(){
        if (isElementDisplayed(mainPageAppears)){
            return true;
        }else {
            return false;
        }
    }
}
