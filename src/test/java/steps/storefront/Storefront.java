package steps.storefront;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import hooks.DriverHooks;
import static com.codeborne.selenide.Selenide.*;

public class Storefront {
    public Storefront() { super(); }

    String productName = DriverHooks.PRODUCT_NAME;

    SelenideElement videoWithAutoplay = $(".ab__vg-image_gallery_video-autoplay");
    SelenideElement videoWithAutoplay_withHover = $(".ab__vg-product_list-video.hover_image");


    public void takeScreenshot(String screenshotName) {
        Selenide.sleep(1500);
        screenshot(screenshotName);
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
        Selenide.sleep(2000);
    }
}