package stepDefinitions;

import io.cucumber.java.en.When;
import pages.SearchStorePage;
import utilities.BasePage;

public class SearchStoreStep extends BasePage {
    private SearchStorePage searchStorePage;

    public SearchStoreStep() {
        searchStorePage = new SearchStorePage();
    }

    @When("I search store with keyword is {string}")
    public void iSearchStoreWithKeywordIs(String keyword) {
        searchStorePage.inputKeyword(keyword);
        searchStorePage.clickHighLandsShop();
    }

}
