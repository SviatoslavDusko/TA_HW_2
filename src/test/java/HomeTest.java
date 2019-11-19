import Pages.BO.HomeBO;
import org.junit.Test;

public class HomeTest extends BaseTest {
    @Test
    public void changeLanguageVerify() {
        new HomeBO()
                .verifyMainPageAppears()
                .openChangeLanguageButtonClick()
                .chooseLanguage(ENGLISH)
                .openChangeLanguageButtonClick()
                .verifyLanguageChange(ENGLISH)
                .closeChangeLanguageButtonClick();

    }
}
