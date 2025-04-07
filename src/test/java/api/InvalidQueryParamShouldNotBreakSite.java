package api;

import io.qameta.allure.Owner;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static helpers.CustomAllureListener.withCustomTemplates;

public class InvalidQueryParamShouldNotBreakSite {

    @DisplayName("The site must process this request correctly.")
    @Tags({@Tag("api"), @Tag("statusCode")})
    @Owner("Zhuravskyi M.")

    @Test
    void invalidQueryParamShouldNotBreakSite() {
        RestAssured.given()
                .filter(withCustomTemplates())
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
                .get("https://temerix.com/?param=<script>alert('XSS')</script>")
                .then()
                .statusCode(200);
    }

}
