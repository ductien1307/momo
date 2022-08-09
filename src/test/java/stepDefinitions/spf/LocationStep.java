package stepDefinitions.spf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.spf.LocationPage;
import utilities.BasePage;

public class LocationStep extends BasePage {
    private LocationPage locationPage;

    public LocationStep() {
        locationPage = new LocationPage();
    }

    @When("I set location is {string}")
    public void iSetLocationIs(String location) throws InterruptedException {
        locationPage.setLocation(location);
    }

    @Then("I see page is {string}")
    public void iSeePageIs(String expected) throws InterruptedException {
        Thread.sleep(5000);

    }

}
