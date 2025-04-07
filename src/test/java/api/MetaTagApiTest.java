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
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MetaTagApiTest {
    @DisplayName("The site must process this request correctly.")
    @Tags({@Tag("api"), @Tag("meta")})
    @Owner("Zhuravskyi M.")

    @Test
    void descriptionMetaTagShouldBeCorrect() {
        Response response = RestAssured.given()
                .filter(withCustomTemplates())
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
                .get("https://temerix.com/");
        assertEquals(200, response.getStatusCode());
        Document doc = Jsoup.parse(response.getBody().asString());
        String actualDescription = doc.select("meta[name=description]").attr("content");
        assertEquals("Temerix test task for One Smile Corporation", actualDescription);
    }
}

