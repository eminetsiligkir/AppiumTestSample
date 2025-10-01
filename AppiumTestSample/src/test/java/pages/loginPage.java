package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.elementHelper;
public class loginPage {
    elementHelper helper;
    public loginPage(RemoteWebDriver driver) {
        this.helper = new elementHelper(driver);
    }

    By accountButton = By.id("com.pozitron.hepsiburada:id/menuItemAccountFakeView");
    By loginButton = By.id("//android.view.ViewGroup[@content-desc=\"account_menu_button_1\"]");
    By emailAddress = By.id("emailInput");
    By loginButtonLoginPage = By.xpath("//android.view.ViewGroup[@content-desc=\"account_menu_button_1\"]/android.view.ViewGroup/android.widget.Button");
    By passwordTextbox = By.id("passwordInput");
    By loginButtonPasswordPage = By.id("loginButton");
    By errorMessage = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.TextView[1]");

    public void accountButton(){
        helper.click(accountButton);
    }
    public void loginButton(){
        helper.click(loginButton);
    }
    public void fillEmailAddress(){
        helper.click(emailAddress);
        helper.sendKey(emailAddress,"emine.cilingir@hotmail.com");
    }
    public void tabLoginBtnLoginPage(){
        helper.click(loginButtonLoginPage);
    }
    public void enterPassword(){
        helper.click(passwordTextbox);
        helper.sendKey(passwordTextbox,"Deneme123.");
    }
    public void tabLoginButton(){
        helper.click(loginButtonPasswordPage);
    }

    public void wrongPassword(){
        helper.click(passwordTextbox);
        helper.sendKey(passwordTextbox,"aAaaAAa2568,");
    }
    public void wrongEmailAddress(){
        helper.click(emailAddress);
        helper.sendKey(emailAddress,"emine.cilingkiresa@hotmail.com");
    }
    public void errorMessage(){
        helper.checkElementPresence(errorMessage);
    }


}

