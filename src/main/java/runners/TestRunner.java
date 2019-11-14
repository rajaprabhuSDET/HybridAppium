package runners;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src/main/java/features", glue = {"stepDefinition"},
    plugin = {"pretty:target/cucumber-pretty.txt", "html:target/cucumber-html-report",
        "json:target/cucumber.json", "rerun:target/rerun.txt"}, // to generate different types of
                                                                // reporting
    monochrome = true, // display the console output in a proper readable format
    strict = true, // it will check if any step is not defined in step definition file
    dryRun = false // to check the mapping is proper between feature file and step definition file
)

public class TestRunner extends AbstractTestNGCucumberTests {
  private TestNGCucumberRunner testNGCucumberRunner;

  @BeforeClass(alwaysRun = true)
  public void setUpClass() {
    System.out.println(this.getClass().getName());
    testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
  }

  @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "myFeatures")
  public void runScenario(PickleWrapper cucumberFeature, FeatureWrapper featureWrapper)
      throws Throwable {

    testNGCucumberRunner.runScenario(cucumberFeature.getPickle());
  }

  @DataProvider(name = "myFeatures")
  public Object[][] scenarios() {
    System.out.println("inside DP");
    return testNGCucumberRunner.provideScenarios();
  }

  @AfterClass(alwaysRun = true)
  public void tearDownClass() {
    testNGCucumberRunner.finish();
  }
}
