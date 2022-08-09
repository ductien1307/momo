package stepDefinitions.spf;

import io.cucumber.java.en.When;
import pages.spf.MenuPage;
import pages.spf.SearchStorePage;
import utilities.BasePage;

public class SearchStoreStep extends BasePage {
    private SearchStorePage searchStorePage;
    private MenuPage menuPage;

    public SearchStoreStep() {
        menuPage = new MenuPage();
        searchStorePage = new SearchStorePage();
    }

    @When("I search store with keyword is {string}")
    public void iSearchStoreWithKeywordIs(String keyword) throws InterruptedException {
        searchStorePage.inputKeyword(keyword);
    }

    @When("I go to most order")
    public void iGotoMostOrder() throws InterruptedException {
        menuPage.gotoMenu("Likes");
        searchStorePage.mostOrder();
    }
}
