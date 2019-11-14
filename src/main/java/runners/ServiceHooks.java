package runners;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ServiceHooks {
  @Before
  public void initializeTest() {
    // Code to setup initial configurations
  }

  @After
  public void embedScreenshot(Scenario scenario) {
    if (scenario.isFailed()) {
      try {
        // Code to capture and embed images in test reports (if scenario fails)
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
