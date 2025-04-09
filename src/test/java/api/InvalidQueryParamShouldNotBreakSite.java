package api;

import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;

public class InvalidQueryParamShouldNotBreakSite {

    @DisplayName("The site must process this request correctly.")
    @Tags({@Tag("api"), @Tag("statusCode")})
    @Owner("Zhuravskyi M.")

    @Test
    void restrictedPageShouldReturn404() {

        Response response = step("Send GET request to restricted admin page", () ->
                RestAssured.given()
                        .filter(withCustomTemplates())
                        .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
                        .get("https://temerix.com/admin")
        );

        step("Verify status code is 404", () -> {
            response.then().statusCode(404);
        });
    }
}
