package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;

public class LoginStep {
    private LoginPage loginPage;

    public LoginStep() {
        loginPage = new LoginPage();
    }

    @Given("I provide phone number is {string}")
    public void iProvidePhoneNumberIs(String phoneNumber) {
        loginPage.inputPhoneNumber(phoneNumber);
        loginPage.clickLogin();
    }

    @Given("I provide password is {string}")
    public void iProvidePasswordIs(String password) {
        loginPage.inputPassword(password);
    }

    @When("I see error text is {string}")
    public void iSeeErrorText(String errorText) {
        Assert.assertEquals(errorText, loginPage.getErrorText());
    }

    @When("I click explore now button")
    public void iClickExploreButton() {
        loginPage.clickExploreButton();
    }

}
