package mobile.androidStudio;

import com.codeborne.selenide.Condition;
import helpers.AndroidTestBase;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class VerifyOffshoreITTextIsVisibleOnHomePage extends AndroidTestBase {

    @DisplayName("Verify 'We specialize in opening long-term offshore IT offices in Ukraine.' text is visible on Temerix homepage")
    @Tags({@Tag("mobile"), @Tag("android")})
    @Owner("Zhuravskyi M.")
    @Test
    void verifyOffshoreITTextIsVisibleOnHomePage() {

        step("Open temerix.com in mobile browser", () -> {
            open("https://temerix.com/");
        });

        step("Close Chrome popup if present", () -> {
            androidActions.closeChromePopupIfPresent();
        });

        step("Verify 'We specialize in opening long-term offshore IT offices in Ukraine.' text is visible", () -> {
            $x("//android.widget.TextView[@text='We specialize in opening long-term offshore IT offices in Ukraine.']")
                    .shouldBe(Condition.visible);
        });
    }
}