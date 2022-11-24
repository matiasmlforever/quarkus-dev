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
import static org.matias.Constants.*;
import static org.matias.JsonConstantsTest.*;

@QuarkusTest
@TestHTTPEndpoint(DataResource.class)
class ServiceMethodValidationDataResourceTest {


    @TestHTTPEndpoint(DataResource.class)
    @TestHTTPResource("service-method-validation")
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
                .body("message", Matchers.containsString(A_REQUIRED));
    }

    @Test
    void invalidData_a_t_Required_Test() {
        given().contentType(ContentType.JSON)
                .body(invalidJson_a_t_Required)
                .when().post(validationUrl)
                .then()
                .statusCode(200)
                .body("message", Matchers.containsString(A_T_REQUIRED));
    }

    @Test
    void invalidData_a_i_Required_Test() {
        given().contentType(ContentType.JSON)
                .body(invalidJson_a_i_Required)
                .when().post(validationUrl)
                .then()
                .statusCode(200)
                .body("message", Matchers.containsString(A_I_REQUIRED));
    }

    @Test
    void invalidData_bRequired_Test() {
        given().contentType(ContentType.JSON)
                .body(invalidJson_bRequired)
                .when().post(validationUrl)
                .then()
                .statusCode(200)
                .body("message", Matchers.containsString(B_REQUIRED));
    }

    @Test
    void invalidData_bEmpty_Test() {
        given().contentType(ContentType.JSON)
                .body(invalidJson_bEmpty)
                .when().post(validationUrl)
                .then()
                .statusCode(200)
                .body("message", Matchers.containsString(B_NOT_EMPTY));
    }

    @Test
    void invalidData_b_p_Required_Test() {
        given().contentType(ContentType.JSON)
                .body(invalidJson_b_p_required)
                .when().post(validationUrl)
                .then()
                .statusCode(200)
                .body("message", Matchers.containsString(B_P_REQUIRED));
    }

    @Test
    void invalidData_b_q_Required_Test() {
        given().contentType(ContentType.JSON)
                .body(invalidJson_b_q_required)
                .when().post(validationUrl)
                .then()
                .statusCode(200)
                .body("message", Matchers.containsString(B_Q_REQUIRED));
    }

    @Test
    void validData_cEmpty_Test() {
        given().contentType(ContentType.JSON)
                .body(validJson_cEmpty)
                .when().post(validationUrl)
                .then().statusCode(200).body("message", Matchers.equalTo(VALID_SERVICE_METHOD_MSG));
    }

    @Test
    void invalidData_c_r_Required_Test() {
        given().contentType(ContentType.JSON)
                .body(invalidJson_c_r)
                .when().post(validationUrl)
                .then()
                .statusCode(200)
                .body("message", Matchers.containsString(C_R_REQUIRED));
    }

    @Test
    void invalidData_c_s_Required_Test() {
        given().contentType(ContentType.JSON)
                .body(invalidJson_c_s)
                .when().post(validationUrl)
                .then()
                .statusCode(200)
                .body("message", Matchers.containsString(C_S_REQUIRED));
    }
}