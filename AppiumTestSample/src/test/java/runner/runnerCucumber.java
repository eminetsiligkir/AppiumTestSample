package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        glue = {"stepDefinitions", "util"},
        features = {"src/test/java/features"},
        tags = "@Login",
        plugin = {
                "summary",
                "pretty",
               // "html:Reports/CucumberReport/Reports.html",
              // "json:Reports/CucumberReport/Report",
               // "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        dryRun = false
)
public class runnerCucumber extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() { return super.scenarios();}
}
