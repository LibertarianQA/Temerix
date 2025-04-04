package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import mobile.androidStudio.AndroidActions;
import mobile.driver.LocalMobileDriver;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class AndroidTestBase {
    protected AndroidActions androidActions;

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = LocalMobileDriver.class.getName();
        Configuration.browserSize = null;
    }

    @BeforeEach
     void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        androidActions = new AndroidActions();
    }

    @AfterEach
     void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        closeWebDriver();
    }
}
