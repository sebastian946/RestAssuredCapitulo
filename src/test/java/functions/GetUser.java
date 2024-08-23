package functions;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.notNullValue;

import org.testng.annotations.Test;
import utils.GlobalVariables;
import utils.JsonComplete;

import java.io.FileNotFoundException;

public class GetUser {

    @Test
    public void getUser(){
        given().
                baseUri(GlobalVariables.url).
                when()
                .get("user")
                .then()
                .log().all()
                .statusCode(200)
                .body("firstName", notNullValue());


    }
    @Test
    public void postUser() throws FileNotFoundException {
        given().baseUri(GlobalVariables.url)
                .and()
                .body(JsonComplete.userComplete())
                .when()
                .post("user")
                .then()
                .statusCode(201)
                .body("firstName",notNullValue());
    }
}
