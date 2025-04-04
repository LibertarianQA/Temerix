package ui;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class СlickFacebookIcon_ShouldNavigateToCorrectPage {

    @DisplayName("User should be redirected to the Facebook page after clicking the icon")
    @Tags({@Tag("ui"), @Tag("footer")})
    @Owner("Zhuravskyi M.")

    @Test
    void clickFacebookIconShouldNavigateToCorrectPage(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://temerix.com/#contact");
        $("[class='social fb']").click();
        webdriver().shouldHave(url("https://www.facebook.com/temerix/"));
    }
}
