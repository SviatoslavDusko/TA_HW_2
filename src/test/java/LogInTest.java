import Pages.BO.HomeBO;
import Pages.BO.LoginBO;
import org.junit.Test;

public class LogInTest extends BaseTest {
    @Test
    public void verifyLogIn() {
        new HomeBO()
                .verifyMainPageAppears()
                .openChangeLanguageButtonClick()
                .chooseLanguage(ENGLISH);
        new LoginBO()
                .openSignInWindow()
                .verifyModalLogInWindowDisplayed()
                .LogIn(VALID_EMAIL, VALID_PASSWORD)
                .verifyDisplayedUserName(USER_NAME);
    }

    @Test
    public void notVerifyLogIn() {
        new HomeBO()
                .verifyMainPageAppears()
                .openChangeLanguageButtonClick()
                .chooseLanguage(ENGLISH);
        new LoginBO()
                .openSignInWindow()
                .verifyModalLogInWindowDisplayed()
                .LogIn(VALID_EMAIL, NOT_VALID_PASSWORD)
                .verifyDisplayedFailedLoginErrorMessage();
    }

}
