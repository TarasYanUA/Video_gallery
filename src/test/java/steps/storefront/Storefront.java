package steps.storefront;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Selenide.*;

public class Storefront {

    @Then("Выполняем проверку добавленных видео делаем скриншот {string}")
    public void checkAsserts(String screenshot) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!$$("#ab__video_gallery").isEmpty(),
                "There is no tab 'Video gallery' on the product page!");
        //Проверяем, что во вкладке ровно 4 видео
        $("#ab__video_gallery").click();
        softAssert.assertTrue($$(".ab__vg-video").size() == 4,
                "There is no 4 videos on the tab 'Video gallery' on the product page!");
        Selenide.sleep(1500);
        screenshot(screenshot + " Videos are added on the product page");
        softAssert.assertAll();
    }
}
