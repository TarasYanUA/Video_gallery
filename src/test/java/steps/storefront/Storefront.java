package steps.storefront;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import hooks.DriverHooks;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import hooks.CollectAssertMessages;

import static com.codeborne.selenide.Selenide.*;

public class Storefront {
    public Storefront() { super(); }

    SoftAssert softAssert = CollectAssertMessages.getSoftAsserts();

    String productName = DriverHooks.PRODUCT_NAME;

    SelenideElement tab_VideoGallery = $(By.id("ab__video_gallery"));
    SelenideElement videoWithAutoplay = $(".ab__vg-image_gallery_video-autoplay");
    SelenideElement videoWithAutoplay_CategoryPage = $(".ab__vg-product_list-video .ab__vg-image_gallery_video-autoplay");
    SelenideElement videoWithAutoplay_withHover = $(".ab__vg-product_list-video.hover_image");
    SelenideElement youtubeVideoInTheTab = $(".ab__video_gallery-block img[alt='Музыка, успокаивает нервную систему и радует душу']");


    public void takeScreenshot(String screenshotName) {
        Selenide.sleep(1500);
        screenshot(screenshotName);
    }

    public void clickVideoGalleryTab() {
        tab_VideoGallery.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");
        tab_VideoGallery.click();
    }

    public void shiftLanguage(String langRuAr) {
        $("a[id*='sw_select'][id*='wrap_language']").scrollTo().click();
        $("a[data-ca-name='" + langRuAr + "']").click();
    }

    public void navigateToCategoryPageThroughBreadcrumbs() {
        $(".ty-text-links-wrapper").scrollTo();
        $("a:nth-child(3).ty-breadcrumbs__a bdi").click();
    }

    public void openQuickView() {
        String productTitleXPath = "//a[@class='product-title'][contains(@title, '" + productName + "')]/../../..//a[contains(@class, 'ut2-quick-view-button')]";
        SelenideElement productQuickView = $x(productTitleXPath);
        executeJavaScript("arguments[0].scrollIntoView(true);", productQuickView);
        executeJavaScript("arguments[0].click();", productQuickView);
        $(".ui-dialog").shouldBe(Condition.visible).$(".ty-product-thumbnails").shouldBe(Condition.enabled);
        Selenide.sleep(1000);
    }

    public void closeQuickView() {
        $(".ui-icon-closethick").scrollTo().click();
        $(".ui-icon-closethick").shouldBe(Condition.disappear);
    }

    public void scrollToElementAndHighLightIt() {
        SelenideElement productOnCategoryPage = $x("//a[@class='product-title'][contains(@title, '" + productName + "')]/../../..");
        executeJavaScript(
                "arguments[0].scrollIntoView({behavior: 'instant', block: 'center', inline: 'center'});" +
                        "arguments[0].style.border='3px solid #ccffcc';",
                productOnCategoryPage);
    }

    public void hoverMousePointerOverProductWithVideo() {
        videoWithAutoplay_withHover.scrollIntoCenter().hover();
        Selenide.sleep(1500);
    }

    public void assertVideoGalleryTab_Exists() {
        softAssert.assertTrue(tab_VideoGallery.exists(),
                "There is no tab 'Video gallery' on the product page!");
    }

    public void assertProductTab_VideosQuantity(int videoQuantity) {
        softAssert.assertEquals($$(".ab__vg-video").size(), videoQuantity,
                "There is no 4 videos on the tab 'Video gallery' on the product page!");
    }

    public void assertVideoWithAutoplayExistsAtMiniIconsGallery() {
        softAssert.assertTrue(videoWithAutoplay.exists(),
                "There is no video with autoplay at mini-icons gallery!");
    }

    public void assertVideoWithAutoplayIsEmptyAtTab() {
        softAssert.assertFalse(youtubeVideoInTheTab.exists(),
                "There is a video with autoplay in the product tab but shouldn't!");
    }

    public void assertVideoDoesNOTAutoplayInProductList() {
        softAssert.assertFalse(videoWithAutoplay_CategoryPage.exists(),
                "Video is shown with autoplay in the product list but shouldn't!");
    }

    public void assertVideoAutoplayInProductList() {
        softAssert.assertTrue(videoWithAutoplay_CategoryPage.exists(),
                "Video is not shown with autoplay in the product list!");
    }

    public void assertVideoAutoplayWhenHover_InProductList() {
        softAssert.assertTrue(videoWithAutoplay_withHover.exists(),
                "Video is not shown with autoplay in the product list!");
    }

    public void assertThatVideoIsMainImageOfProduct() {
        softAssert.assertTrue($(".ab_vg-replace_image").exists(),
                "Video is not the main image of the product on the product page!");
    }
}