
package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step {

  @Given("^I am on the \"([^\"]*)\" page on URL \"([^\"]*)\"$")
  public void i_am_on_the_page_on_URL(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions

  }

  @When("^I fill in \"([^\"]*)\" with \"([^\"]*)\"$")
  public void i_fill_in_with(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions

  }

  @When("^I click on the \"([^\"]*)\" button$")
  public void i_click_on_the_button(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions

  }

  @Then("^I should see \"([^\"]*)\" message$")
  public void i_should_see_message(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions

  }

  @Then("^I should see the \"([^\"]*)\" button$")
  public void i_should_see_the_button(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions

  }
}
