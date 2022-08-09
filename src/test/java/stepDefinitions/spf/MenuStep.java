package stepDefinitions.spf;

import io.cucumber.java.en.When;
import pages.spf.MenuPage;
import utilities.BasePage;

public class MenuStep extends BasePage {
    private MenuPage menuPage;

    public MenuStep() {
        menuPage = new MenuPage();
    }

    @When("I go to menu {string}")
    public void iGotoMenu(String menuName) throws InterruptedException {
        sleep(2);
        menuPage.gotoMenu(menuName);
        enterKey();
    }

}
