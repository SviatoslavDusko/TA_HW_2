package Pages.BO;

import Pages.HomePage;
import org.junit.Assert;

public class HomeBO {
    private HomePage homePage;

    public HomeBO() {
        homePage = new HomePage();
    }

    public HomeBO openChangeLanguageButtonClick() {
        homePage
                .openChangeLanguageButtonClick();
        return this;
    }

    public HomeBO closeChangeLanguageButtonClick() {
        homePage
                .closeChangeLanguageButtonClick();
        return this;
    }

    public HomeBO chooseLanguage(String language) {
        homePage
                .chooseLanguage(language);
        return this;
    }

    public HomeBO verifyLanguageChange(String language) {
        Assert.assertTrue("Language is not changed", homePage.getLanguage().getText().toLowerCase().equals(language.toLowerCase()));
        return this;
    }


    public HomeBO isMainPageAppears() {
        Assert.assertTrue("Main page is not appears", homePage.isMainPageDisplayed());
        return this;
    }
}
