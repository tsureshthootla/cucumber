import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import netscape.javascript.JSObject;
import org.junit.jupiter.api.Assertions;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class API_Testing_StepDefinition {

    private String path;
    private Response response;
    @Given("^the rooms endpoint exists$")
    public void the_rooms_endpoint_exists()  {
        RestAssured.baseURI = "https://automationintesting.online/";
        path = "room/";
    }

    @When("^I send a valid retrieve room details payload$")
    public void i_send_a_valid_retrieve_room_details_payload() {
        response = given()
                .contentType(ContentType.JSON)
                .get(path)
                .then().extract().response();

    }

    @Then("^Status_code equals (\\d+)$")
    public void status_code_equals(int arg1)  {
        System.out.println(response.getBody().asString() + " status code :: "+response.getStatusCode());
        Assertions.assertEquals(arg1, response.getStatusCode());

    }


}
