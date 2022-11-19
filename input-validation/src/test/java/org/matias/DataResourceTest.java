package org.matias;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;
@QuarkusTest
@TestHTTPEndpoint(DataResource.class)
class DataResourceTest {
    String validData;

    @BeforeEach
    void setUp() {
        validData = "buena ctm";
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