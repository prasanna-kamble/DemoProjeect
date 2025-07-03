package tests;

import base.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class SampleApiTest {
    Properties prop;
    String baseUrl;
    String endpoint;

    @BeforeClass
    public void setup() {
        String env = System.getProperty("env", "dev");
        System.out.println("Running tests in: " + env);

        prop = ConfigReader.initProperties(env);
        baseUrl = prop.getProperty("baseUrl");
        endpoint = prop.getProperty("endpoint");

        RestAssured.baseURI = baseUrl;
    }

    @Test
    public void getApiTest() {
        Response res = RestAssured
                .given()
                .when()
                .get(endpoint)
                .then()
                .extract().response();

        System.out.println("Status Code: " + res.getStatusCode());
        assertEquals(res.getStatusCode(), 200);

        String var1 = res.jsonPath().getString("data[0].id");

        String json = "{\n" +
                      "  \"orderId\": \"" + var1 + "\"\n" +
                      "}";

        System.out.println("Generated JSON: \n" + json);
    }
}
