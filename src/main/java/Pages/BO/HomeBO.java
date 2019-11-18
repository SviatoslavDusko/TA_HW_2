package Pages.BO;

import Pages.HomePage;
import org.junit.Assert;

public class HomeBO {
    private HomePage homePage;

    public HomeBO(){
        homePage = new HomePage();
    }

    public void changeLanguage(String language){
        homePage
                .changeLanguageButtonClick()
                .chooseLanguage(language);
    }


    public HomeBO isMainPageAppears(){
        Assert.assertTrue("Main page is not appears",homePage.isMainPageDisplayed());
        return this;
    }
}
