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
import static org.junit.jupiter.api.Assertions.*;

public class PageShouldContainExpectedContactHref {

    @DisplayName("The href value must contain '#contact'")
    @Tags({@Tag("api"), @Tag("href")})
    @Owner("Zhuravskyi M.")

    @Test
    void pageShouldContainExpectedContactHref() {

        Response response = step("Send GET request to temerix.com", () ->
                RestAssured.given()
                        .filter(withCustomTemplates())
                        .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
                        .get("https://temerix.com/")
        );

        step("Verify status code is 200", () -> {
            assertEquals(200, response.getStatusCode(), "expected status code 200");
        });

        Document doc = step("Parse HTML from response body", () ->
                Jsoup.parse(response.getBody().asString())
        );

        var contactLink = step("Find 'contact' link in the page", () ->
                doc.select("a[href*='contact']").first()
        );

        step("Verify contact link is present", () -> {
            assertNotNull(contactLink, "The contact link should be present");
        });

        String contactHref = step("Extract 'href' value from the contact link", () ->
                contactLink.attr("href")
        );

        step("Verify href value contains '#contact'", () -> {
            assertTrue(contactHref.contains("#contact"), "The href value must contain '#contact'");
        });
    }

}
