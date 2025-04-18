package api;

import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;

public class RestrictedPageShouldReturn404 {


    @DisplayName("Should return status code 404")
    @Tags({@Tag("api"), @Tag("negative"), @Tag("statusCode")})
    @Owner("Zhuravskyi M.")

    @Test
    void restrictedPageShouldReturn404() {

        step("Send GET request to restricted admin page", () ->
                RestAssured.given()
                        .filter(withCustomTemplates())
                        .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
                        .get("https://temerix.com/admin")
        )
                .then()
                .statusCode(404);
    }
}
