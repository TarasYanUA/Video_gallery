package hooks;

import com.codeborne.selenide.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.*;

public class DriverHooks {
    public static final String BASIC_URL = "https://trs.test.abt.team/4182ultru/admin.php?dispatch=products.manage";
    public static final String PRODUCT_NAME = "Nike Tenkay Slip";

    public DriverHooks() {super();}

    @Before()
    public void openBrowser() {
        Configuration.browser = "chrome";
        open(BASIC_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize(); //окно браузера на весь экран
        Configuration.holdBrowserOpen = false; //не закрываем браузер пока ведём разработку
        Configuration.screenshots = true; //делаем скриншоты при падении
        Configuration.timeout = 2000;   //настройка таймаута или Общая задержка

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