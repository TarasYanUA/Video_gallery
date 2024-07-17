package steps.storefront;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import hooks.DriverHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.*;

public class Storefront {
    public Storefront() {super();}

    String productName = DriverHooks.PRODUCT_NAME;

    SelenideElement tab_VideoGallery = $(By.id("ab__video_gallery"));
    SelenideElement miniIconOfYoutubeVideo = $("a.ty-product-thumbnails__item img[alt='Музыка, успокаивает нервную систему и радует душу']");
    SelenideElement videoWithAutoplay = $(".ab__vg-image_gallery_video.ab__vg-image_gallery_video-autoplay");
    SelenideElement youtubeVideoInTheTab = $(".ab__video_gallery-block img[alt='Музыка, успокаивает нервную систему и радует душу']");

    @Then("Делаем скриншот {string}")
    public void takeScreenshot(String screenshotName) {
        Selenide.sleep(1500);
        screenshot(screenshotName);
    }

    @And("Проверяем, что во вкладке товара ровно {int} видео")
    public void assertProductTab_4Videos(int videoQuantity) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(tab_VideoGallery.exists(),
                "There is no tab 'Video gallery' on the product page!");
        tab_VideoGallery.click();
        tab_VideoGallery.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");
        //Проверяем, что во вкладке ровно 4 видео
        softAssert.assertEquals($$(".ab__vg-video").size(), videoQuantity,
                "There is no 4 videos on the tab 'Video gallery' on the product page!");
        softAssert.assertAll();
    }

    @And("Переключаем на RTL язык")
    public void shiftToLanguageRTL() {
        $("a[id*='sw_select'][id*='wrap_language']").scrollTo().click();
        $("a[data-ca-name='ar']").click();
    }

    @And("Переходим на страницу категории и открываем окно быстрого просмотра товара")
    public void navigateToCategoryPage_OpenQuickView() {
        $(".ty-text-links-wrapper").scrollTo();
        $("a:nth-child(3).ty-breadcrumbs__a bdi").click();
        $x("//a[@class='product-title'][contains(@title, '" + productName + "')]/../../..//a[contains(@class, 'ut2-quick-view-button')]").hover().click();
        $(".ui-dialog").shouldBe(Condition.visible).$(".ty-product-thumbnails").shouldBe(Condition.enabled);
        Selenide.sleep(1000);
    }

    @And("Проверяем, что видео с автовоспроизведением присутствует среди мини-иконок")
    public void assertVideoWithAutoplayExistsAtMiniIconsGallery() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(miniIconOfYoutubeVideo.exists(),
                "There is no video with autoplay at mini-icons gallery!");
    }

    @And("Делаем скриншот видео с автовоспроизведением {string}")
    public void takeScreenshotOfVideoWithAutoplay(String screenshotName) {
        miniIconOfYoutubeVideo.click();
        Selenide.sleep(2000);
        videoWithAutoplay.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");
        takeScreenshot(screenshotName);
    }

    @And("Проверяем, что во вкладке товара видео с автовоспроизведением отсутствует")
    public void assertVideoWithAutoplayIsEmptyAtTab() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(youtubeVideoInTheTab.exists(),
                "There is a video with autoplay in the product tab but shouldn't!");
    }

    @And("Закрываем окно быстрого просмотра для товара")
    public void closeQuickView() {
        $(".ui-icon-closethick").scrollTo().click();
        $(".ui-icon-closethick").shouldBe(Condition.disappear);
        SelenideElement productOnCategoryPage = $x("//a[@class='product-title'][contains(@title, '" + productName + "')]/../../..");
        // Прокручиваем к элементу и выделяем его
        executeJavaScript(
                "arguments[0].scrollIntoView({behavior: 'instant', block: 'center', inline: 'center'});" +
                        "arguments[0].style.border='3px solid #ccffcc';",
                productOnCategoryPage);
    }

    @And("Проверяем, что видео НЕ автовоспроизводится на странице категории")
    public void assertVideoDoesNOTAutoplayInProductList() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse($(".ab__vg-image_gallery_video-wrapper").exists(),
                "Video is shown with autoplay in the product list but shouldn't!");
    }
}