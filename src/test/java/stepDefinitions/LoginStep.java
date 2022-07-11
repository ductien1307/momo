package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utilities.BasePage;

public class LoginStep extends BasePage {
    private LoginPage loginPage;

    public LoginStep() {
        loginPage = new LoginPage();
    }

    @When("I provide phone number is {string}")
    public void iProvidePhoneNumberIs(String phoneNumber) {
        loginPage.inputPhoneNumber(phoneNumber);
        loginPage.clickLogin();
    }


    @When("I provide password is {string}")
    public void iProvidePasswordIs(String password) {
        loginPage.inputPassword(password);
    }


    @Then("I see error text is {string}")
    public void iSeeErrorText(String errorText) {
        Assert.assertEquals(errorText, loginPage.getErrorText());
    }


    @Given("I click explore now button")
    public void iClickExploreButton() throws InterruptedException {
        loginPage.clickExploreButton();
    }


    @Given("I touch skip button")
    public void i_touch_skip_button() {
        loginPage.clickExploreButton();
    }



}
