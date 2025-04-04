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

import static org.junit.jupiter.api.Assertions.*;

public class PageShouldContainExpectedContactHref {

    @DisplayName("The href value must contain '#contact'")
    @Tags({@Tag("api"), @Tag("href")})
    @Owner("Zhuravskyi M.")

    @Test
    void pageShouldContainExpectedContactHref() {
        Response response = RestAssured.given()
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
                .get("https://temerix.com/");
        assertEquals(200, response.getStatusCode(), "expected status code 200 ");
        Document doc = Jsoup.parse(response.getBody().asString());
        var contactLink = doc.select("a[href*='contact']").first();
        assertNotNull(contactLink);
        String contactHref = contactLink.attr("href");
        assertTrue(contactHref.contains("#contact"), "The href value must contain '#contact'");
    }

}
