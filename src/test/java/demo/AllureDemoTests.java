package demo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Demo tests for Allure report visualization")
public class AllureDemoTests {

    @Tags({@Tag("demo")})
    @Test
    @DisplayName("Intentionally failed test")
    void failedTest() {
        assertTrue(2 > 3, "This test is designed to fail for demonstration purposes");
    }

    @Disabled("Not implemented yet")
    @Tags({@Tag("demo")})
    @Test
    @DisplayName("Skipped test 1")
    void skippedTest1() {
        // This test is skipped intentionally
    }

    @Disabled("Depends on external service")
    @Tags({@Tag("demo")})
    @Test
    @DisplayName("Skipped test 2")
    void skippedTest2() {
        // This test is skipped intentionally
    }
}
