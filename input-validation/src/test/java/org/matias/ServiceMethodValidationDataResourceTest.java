package org.matias;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URL;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.matias.Constants.A_REQUIRED;
import static org.matias.Constants.VALID_SERVICE_METHOD_MSG;
import static org.matias.JsonConstantsTest.VALID;
import static org.matias.JsonConstantsTest.invalidJson_aRequired;

@QuarkusTest
@TestHTTPEndpoint(DataResource.class)
class ServiceMethodValidationDataResourceTest {


    @TestHTTPEndpoint(DataResource.class)
    @TestHTTPResource("service-method-validation")
    URL validationUrl;

    DataResource.Result result;

    @BeforeEach
    void setUp() {
    }

    @Test
    void missingContentTypeTest() {
        when().post(validationUrl)
                .then()
                .statusCode(415);
    }

    @Test
    void validatedDataTest() {
        given().contentType(ContentType.JSON)
                .body(VALID)
                .when().post(validationUrl)
                .then().statusCode(200).body("message", Matchers.equalTo(VALID_SERVICE_METHOD_MSG));
    }

    @Test
    void invalidData_ARequired_Test() {


        given().contentType(ContentType.JSON)
                .body(invalidJson_aRequired)
                .when().post(validationUrl)
                .then()
                .statusCode(200)
                .body("message", Matchers.equalTo(A_REQUIRED));
    }
}