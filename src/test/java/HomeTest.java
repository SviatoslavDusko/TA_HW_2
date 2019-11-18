import Pages.BO.HomeBO;
import org.junit.Test;

public class HomeTest extends BaseTest {
    @Test
    public void changeLanguageVerify() {
        new HomeBO()
                .isMainPageAppears()
                .openChangeLanguageButtonClick()
                .chooseLanguage("english")
                .openChangeLanguageButtonClick()
                .verifyLanguageChange("english")
                .closeChangeLanguageButtonClick();

    }
}
