package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.loginPage;
import util.driverFactory;

public class login {
    loginPage loginPages = new loginPage((RemoteWebDriver) driverFactory.getDriver());
    @Given("user is on login page")
    public void userIsOnLoginPage() {
        loginPages.accountButton();


    }
    @When("user fill the username address on login page")
    public void userFillTheUsernameAddressOnLoginPage() {
        loginPages.loginButton();
        loginPages.fillEmailAddress();
    }


    @When("user click to giris button on login email page")
    public void userClickToGirisButtonOnLoginEmailPage() {

    }

    @Then("successfully addressed to password page on login page")
    public void successfullyAddressedToPasswordPageOnLoginPage() {
    }

    @When("user fill the wrong password on login page")
    public void userFillTheWrongPasswordOnLoginPage() {
        loginPages.wrongPassword();
    }

    @Then("giris button is available on login page")
    public void girisButtonIsAvailableOnLoginPage() {
    }

    @When("user click to giris button on password page")
    public void userClickToGirisButtonOnPasswordPage() {
        loginPages.tabLoginBtnLoginPage();
    }

    @Then("Error message will disappear")
    public void errorMessageWillDisappear() {
        loginPages.errorMessage();
    }

    @When("user fill the wrong username address on login page")
    public void userFillTheWrongUsernameAddressOnLoginPage() {
    }

    @When("user fill the correct username address on login page")
    public void userFillTheCorrectUsernameAddressOnLoginPage() {
    }

    @When("user fill the password on login page")
    public void userFillThePasswordOnLoginPage() {
    }

    @When("user click to giris button on login page")
    public void userClickToGirisButtonOnLoginPage() {

    }

    @Then("login is successfully")
    public void loginIsSuccessfully() {
    }

    @Then("Error message will disappear on Screen")
    public void errorMessageWillDisappearOnScreen() {
    }
}
