package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.ApiResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class myStepDef extends Utils {

    Response response;
    RequestSpecification req;
    ResponseSpecification resspec;
    TestDataBuild data = new TestDataBuild();

    @Given("Attend challenge payload")
    public void attend_challenge_payload() throws IOException {
        //this will make our request ready and build the request payload
        req = given().spec(requestSpecification()).body(data.joinChallengePayload());
    }

    @When("user calls {string} with {string} http request")
    public void userCallsWithHttpRequest(String resource, String method) {
        //here we test hitting the request
        //Constructor will be called with value of resource which we pass in feature file
        ApiResources resourceApi = ApiResources.valueOf(resource);

        resspec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
        if (method.equalsIgnoreCase("POST"))
            response = req.when().post(resourceApi.getResource());
        else if (method.equalsIgnoreCase("Get"))
            response = req.when().get(resourceApi.getResource());
    }

    @Then("the Api call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
       //here we assert on response status code
        assertEquals(response.getStatusCode(), 200);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyvalue, String Expectedvalue) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(getJsonPath(response, keyvalue), Expectedvalue);
    }

    @Given("Leave challenge payload")
    public void leaveChallengePayload() throws IOException {
        req = given().spec(requestSpecification()).body(data.leaveChallengePayload());
    }
}
