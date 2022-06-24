package stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = { "stepDefinitions" },
        plugin = {"pretty"
                , "html:target/cucumber"
                , "summary"
                , "json:target/cucumber.json"},
        tags = "not @ignore")

/*@CucumberOptions(
        features = "src/test/resources/features",
        glue = { "stepDefinitions" },
        plugin = {"pretty"
                , "html:target/cucumber"
                , "summary"
                , "de.monochromata.cucumber.report.PrettyReports:target/cucumber-reports"},
        tags = "not @ignore")*/

public class TestRunner {
    //System.out.println("XXX");
}