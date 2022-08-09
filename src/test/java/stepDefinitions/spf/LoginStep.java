package stepDefinitions.spf;

import io.cucumber.java.en.When;
import pages.spf.LoginPage;
import pages.spf.MenuPage;
import utilities.BasePage;

public class LoginStep extends BasePage {
    private LoginPage loginPage;
    private MenuPage menuPage;

    public LoginStep() {
        loginPage = new LoginPage();
        menuPage = new MenuPage();
    }

    @When("I login with {string} and {string}")
    public void iLoginWith(String phoneNumber, String password) throws InterruptedException {
        sleep(5);
        menuPage.gotoMenu("Me");
        loginPage.login(phoneNumber, password);
    }


}
