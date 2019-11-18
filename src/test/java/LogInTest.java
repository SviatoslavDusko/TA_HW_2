import Pages.BO.HomeBO;
import Pages.BO.LoginBO;
import Pages.HomePage;
import org.junit.Test;

public class LogInTest extends BaseTest {
    @Test
    public void verifyLogIn() {
        new HomeBO()
                .isMainPageAppears()
                .changeLanguage("english");
        new LoginBO()
                .openSignInWindow()
                .isModalLogInWindowDisplayed()
                .LogIn("swiatikdusko@gmail.com", "kom87lans12")
                .isDisplayedUserName("Sviatoslav-Petro Dusko");
    }

    @Test
    public void notVerifyLogIn() {
        new HomeBO()
                .isMainPageAppears()
                .changeLanguage("english");
        new LoginBO()
                .openSignInWindow()
                .isModalLogInWindowDisplayed()
                .LogIn("swiatikdusko@gmail.com", "kom87lans1")
                .isDisplayedFailedLoginErrorMessage();
    }

}
