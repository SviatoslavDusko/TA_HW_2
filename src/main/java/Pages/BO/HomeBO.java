package Pages.BO;

import Pages.HomePage;
import org.junit.Assert;

public class HomeBO {
    private HomePage homePage;

    public HomeBO() {
        homePage = new HomePage();
    }

    public HomeBO openChangeLanguageButtonClick() {
        homePage.openChangeLanguageButtonClick();
        return this;
    }

    public void closeChangeLanguageButtonClick() {
        homePage.closeChangeLanguageButtonClick();
    }

    public HomeBO chooseLanguage(String language) {
        homePage.chooseLanguage(language);
        return this;
    }

    public HomeBO verifyLanguageChange(String language) {
        Assert.assertEquals(homePage.getLanguage().getText().toLowerCase(), language.toLowerCase());
        return this;
    }


    public HomeBO verifyMainPageAppears() {
        Assert.assertTrue("Main page is not appears", homePage.isMainPageDisplayed());
        return this;
    }
}
