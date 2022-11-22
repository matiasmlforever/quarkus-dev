package org.matias;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(DataResource.class)
class RestEndpointValidationDataResourceTest {
    String validData;

    @TestHTTPEndpoint(DataResource.class)
    @TestHTTPResource("end-point-method-validation")
    URL validationUrl;

    @BeforeEach
    void setUp() {
        validData = "buena ctm";
    }

    @Test
    void missingContentTypeTest() throws IOException {
        when().post("/manual-validation")
                .then()
                .statusCode(415);
    }

    @Test
    void withContentTypeTest() throws IOException {
        given().contentType(ContentType.JSON)
                .when().post("/manual-validation")
                .then().statusCode(415);
    }

    @Test
    void tryMeManualValidation() throws IOException {
        when().post("/manual-validation")
                .then()
                .statusCode(200)
                .body(is("hello"));
    }

    @Test
    void tryMeEndPointMethodValidation() {
    }

    @Test
    void tryMeServiceMethodValidation(){ }
}