package Pages.BO;

import Pages.HomePage;
import Pages.LoginPage;
import org.junit.Assert;

public class LoginBO {
    private LoginPage loginPage;

    public LoginBO(){
        loginPage = new LoginPage();
    }

    public LoginBO openSignInWindow(){
        loginPage.openSignInModalWindow();
        return this;
    }
    public LoginBO LogIn(String email,String password){
        loginPage.enterUserData(email, password)
                .signInClick();
        return this;
    }

    public void isDisplayedFailedLoginErrorMessage(){
        Assert.assertTrue("LogIn failed is not displayed",loginPage.isFailedSignInMessageDisplayed());
    }

    public void isDisplayedUserName(String userName){
        Assert.assertEquals(userName, loginPage.getUserName());
    }

    public  LoginBO isModalLogInWindowDisplayed(){
        Assert.assertTrue("'Log in' modal window is not displayed'",loginPage.isLogInModalWindowDisplayed());
        return this;
    }
}
