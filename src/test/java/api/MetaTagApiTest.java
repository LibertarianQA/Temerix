package api;

import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MetaTagApiTest {
    @DisplayName("The site must process this request correctly.")
    @Tags({@Tag("api"), @Tag("meta")})
    @Owner("Zhuravskyi M.")

    @Test
    void descriptionMetaTagShouldBeCorrect() {

        Response response = step("Send GET request to temerix.com", () ->
                RestAssured.given()
                        .filter(withCustomTemplates())
                        .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
                        .get("https://temerix.com/")
        );

        step("Verify status code is 200", () -> {
            assertEquals(200, response.getStatusCode());
        });

        Document doc = step("Parse HTML from response body", () ->
                Jsoup.parse(response.getBody().asString())
        );

        step("Check that meta description is correct", () -> {
            String actualDescription = doc.select("meta[name=description]").attr("content");
            assertEquals("Temerix test task for One Smile Corporation", actualDescription);
        });
    }
}

