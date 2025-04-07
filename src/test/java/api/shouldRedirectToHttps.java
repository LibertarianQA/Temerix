package api;


import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static helpers.CustomAllureListener.withCustomTemplates;

public class shouldRedirectToHttps {

    @DisplayName("Should return status code 301")
    @Tags({@Tag("api"), @Tag("statusCode")})
    @Owner("Zhuravskyi M.")

    @Test
    void shouldRedirectToHttps() {
        RestAssured.given()
                .filter(withCustomTemplates())
                .redirects().follow(false)
                .get("http://temerix.com")
                .then()
                .statusCode(301);
    }

}
