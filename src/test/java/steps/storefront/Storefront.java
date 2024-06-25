package steps.storefront;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Selenide.*;

public class Storefront {

    @Then("Делаем скриншот {string}")
    public void takeScreenshot(String name) {
        Selenide.sleep(1500);
        screenshot(name);
    }

    @Then("Выполняем проверку добавленных видео")
    public void checkAsserts() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!$$("#ab__video_gallery").isEmpty(),
                "There is no tab 'Video gallery' on the product page!");
        //Проверяем, что во вкладке ровно 4 видео
        $("#ab__video_gallery").click();
        softAssert.assertTrue($$(".ab__vg-video").size() == 4,
                "There is no 4 videos on the tab 'Video gallery' on the product page!");
        softAssert.assertAll();
    }

    @And("Переключаем на RTL язык")
    public void shiftToLanguageRTL() {
        $("a[id*='sw_select'][id*='wrap_language']").scrollTo().click();
        $("a[data-ca-name='ar']").click();
    }
}