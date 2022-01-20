import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class API_PostTesting_StepDefinition {

    private String path;
    private Response response;
    private String requestBody;
    @Given("^I set post posts API endpoint$")
    public void i_set_post_posts_API_endpoint() {
        RestAssured.baseURI = "https://automationintesting.online/";
        path = "auth/login";

    }

    @When("^I set HEADER param request content type as \"([^\"]*)\"$")
    public void i_set_HEADER_param_request_content_type_as(String contentType)  {

         given().contentType(contentType);


    }

    @When("^set request body$")
    public void set_request_body()  {
       requestBody= "{\"username\":\"admin\",\"password\":\"password\"}";

    }

    @When("^send POST HTTP request$")
    public void send_POST_HTTP_request() {
        response =  given().contentType(ContentType.JSON).body(requestBody)
                .when().post(path).then().extract().response();

    }
    @Then("^I receive valid HTTP response code (\\d+)$")
    public void i_receive_valid_HTTP_response_code(int statusCode)  {
        Assertions.assertEquals(statusCode, response.getStatusCode());
    }
}
