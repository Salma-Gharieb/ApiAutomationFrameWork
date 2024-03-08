package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.TestDataBuild;
import resources.Utils;

public class myStepDef extends Utils {

    TestDataBuild dataBuild = new TestDataBuild();
    @Given("Attend challenge payload")
    public void attend_challenge_payload() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user calls {string} with post http request")
    public void user_calls_with_post_http_request(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the Api call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
