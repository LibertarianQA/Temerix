package mobile.androidStudio;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class VerifyMobileAppsDevelopmentTextAppearsAfterScrolling extends AndroidTestBase {


    @DisplayName("Verify 'Mobile apps development' text appears after scrolling")
    @Tags({@Tag("mobile"), @Tag("android")})
    @Owner("Zhuravskyi M.")
    @Test
    void verifyMobileAppsDevelopmentTextAppearsAfterScrolling() {
        open("https://temerix.com/");
        androidActions.closeChromePopupIfPresent();
        androidActions.swipeDown();
        androidActions.swipeDown();
        $x("//android.widget.TextView[@text='Mobile apps development']")
                .shouldBe(Condition.visible);
    }

}
