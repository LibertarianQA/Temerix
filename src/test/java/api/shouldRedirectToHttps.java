package api;


import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;

public class shouldRedirectToHttps {

    @DisplayName("Should return status code 301")
    @Tags({@Tag("api"), @Tag("statusCode")})
    @Owner("Zhuravskyi M.")

    @Test
    void shouldRedirectToHttps() {

        Response response = step("Send GET request to http://temerix.com", () ->
                RestAssured.given()
                        .filter(withCustomTemplates())
                        .redirects().follow(false)
                        .get("http://temerix.com")
        );

        step("Verify status code is 301", () -> {
            response.then().statusCode(301);
        });
    }
}
