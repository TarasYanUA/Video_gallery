package steps.storefront;

import com.codeborne.selenide.Condition;
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

    @And("Проверяем, что во вкладке товара ровно {int} видео")
    public void assertProductTab_4Videos(int videoQuantity) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(!$$("#ab__video_gallery").isEmpty(),
                "There is no tab 'Video gallery' on the product page!");
        $("#ab__video_gallery").click();
        $("#ab__video_gallery").scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");
        //Проверяем, что во вкладке ровно 4 видео
        softAssert.assertEquals($$(".ab__vg-video").size(), videoQuantity,
                "There is no 4 videos on the tab 'Video gallery' on the product page!");
        softAssert.assertAll();
        takeScreenshot("@10 Четыре видео во вкладке товара");
    }

    @And("Переключаем на RTL язык")
    public void shiftToLanguageRTL() {
        $("a[id*='sw_select'][id*='wrap_language']").scrollTo().click();
        $("a[data-ca-name='ar']").click();
    }

    @And("Переходим на страницу категории и открываем окно быстрого просмотра")
    public void navigateToCategoryPage_OpenQuickView() {
        $(".ty-text-links-wrapper").scrollTo();
        $("a:nth-child(3).ty-breadcrumbs__a bdi").click();
        $x("//a[@data-ca-view-id='78'][@data-ca-target-id='product_quick_view']").hover().click();
        $(".ui-dialog").shouldBe(Condition.visible).$(".ty-product-thumbnails").shouldBe(Condition.enabled);
        Selenide.sleep(1000);
    }
}