package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

public class BaseTest {

    protected static final String BASE_URI = "https://jsonplaceholder.typicode.com";
    protected static RequestSpecification requestSpec;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        if (requestSpec == null) { 
            RestAssured.baseURI = BASE_URI;
            RestAssured.filters(
                    new RequestLoggingFilter(LogDetail.ALL),
                    new ResponseLoggingFilter(LogDetail.ALL)
            );

            requestSpec = given()
                    .baseUri(BASE_URI)
                    .header("Content-Type", "application/json");
        }
    }
}
