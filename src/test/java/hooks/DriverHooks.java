package hooks;

import com.codeborne.selenide.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.*;

public class DriverHooks {
    public static final String BASIC_URL = "https://trs.test.abt.team/4201ultru/admin.php?dispatch=addons.manage";
    public static final String PRODUCT_NAME = "adizero Rush Shoes";

    public DriverHooks() {super();}

    @Before()
    public void openBrowser() {
        Configuration.browser = "chrome";
        open(BASIC_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize(); //окно браузера на весь экран
        Configuration.screenshots = true; //делаем скриншоты при падении
        Configuration.savePageSource = false; //не создавать html файлы при создании скриншотов

        SoftAssert softAsserts = new SoftAssert();
        CollectAssertMessages.setSoftAsserts(softAsserts);

        $(".btn.btn-primary").click();
        $("#bp_off_bottom_panel").click();
    }

    @After
    public void closerBrowser() {
        SoftAssert softAsserts = CollectAssertMessages.getSoftAsserts();
        try {
            softAsserts.assertAll();
        } catch (AssertionError e) {
            System.out.println("\nОшибки в asserts:");
            System.out.println(e.getMessage());
        }

        closeWebDriver();
    }
}