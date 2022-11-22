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

@QuarkusTest
@TestHTTPEndpoint(DataResource.class)
class ManualValidationDataResourceTest {

    @TestHTTPEndpoint(DataResource.class)
    @TestHTTPResource("manual-validation")
    URL validationUrl;

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
    void withContentTypeNullBodyTest() {
        given().contentType(ContentType.JSON)
                .when().post(validationUrl)
                .then().statusCode(500);
    }
}