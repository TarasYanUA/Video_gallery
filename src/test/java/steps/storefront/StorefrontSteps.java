package steps.storefront;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.$x;

public class StorefrontSteps {

    public StorefrontSteps() { super(); }

    Storefront storefront = new Storefront();

    @Then("Делаем скриншот {string}")
    public void takeScreenshot(String screenshotName) {
        storefront.takeScreenshot(screenshotName);
    }

    @And("Переключаем язык на {string}")
    public void shiftLanguage(String langRuAr) {
        storefront.shiftLanguage(langRuAr);
    }

    @And("Переходим на страницу категории и открываем окно быстрого просмотра товара")
    public void navigateToCategoryPage_OpenQuickView() {
        storefront.navigateToCategoryPageThroughBreadcrumbs();
        storefront.openQuickView();
    }

    @And("Закрываем окно быстрого просмотра")
    public void closeQuickView() {
        storefront.closeQuickView();
        storefront.scrollToElementAndHighLightIt();
    }

    @And("Проверяем, что присутствует вкладка 'Видео галерея'")
    public void assertVideoGalleryTab_Exists() {
        storefront.assertVideoGalleryTab_Exists();
    }

    @And("Проверяем, что во вкладке товара ровно {int} видео")
    public void assertProductTab_VideosQuantity(int videoQuantity) {
        storefront.clickVideoGalleryTab();
        storefront.assertProductTab_VideosQuantity(videoQuantity);
    }

    @And("Проверяем, что видео с автовоспроизведением присутствует среди мини-иконок")
    public void assertVideoWithAutoplayExistsAtMiniIconsGallery() {
        storefront.assertVideoWithAutoplayExistsAtMiniIconsGallery();
    }

    @And("Делаем скриншот видео с автовоспроизведением {string}")
    public void takeScreenshotOfVideoWithAutoplay(String screenshotName) {
        storefront.videoWithAutoplay.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");
        Selenide.sleep(3000);
        storefront.takeScreenshot(screenshotName);
    }

    @And("Делаем скриншот видео {int} с автовоспроизведением в окне быстрого просмотра {string}")
    public void takeScreenshotOfVideoWithAutoplay_QuickView(int num, String screenshotName) {
        $x("(//a[contains(@class, 'cm-thumbnails-mini ab__vg-image_gallery_item')])[" + num + "]").click();
        Selenide.sleep(3000);
        storefront.takeScreenshot(screenshotName);
    }

    @And("Проверяем, что во вкладке товара видео с автовоспроизведением отсутствует")
    public void assertVideoWithAutoplayIsEmptyAtTab() {
        storefront.assertVideoWithAutoplayIsEmptyAtTab();
    }

    @And("Проверяем, что видео НЕ автовоспроизводится на странице категории")
    public void assertVideoDoesNOTAutoplayInProductList() {
        storefront.assertVideoDoesNOTAutoplayInProductList();
    }

    @And("Проверяем, что видео автовоспроизводится на странице категории")
    public void assertVideoAutoplayInProductList() {
        storefront.assertVideoAutoplayInProductList();
    }

    @And("Проверяем, что видео автовоспроизводится при наведении мыши на странице категории")
    public void assertVideoAutoplayWhenHover_InProductList() {
        storefront.assertVideoAutoplayWhenHover_InProductList();
    }

    @And("Наводим курсор мыши на товар с видео на странице категории")
    public void hoverMousePointerOverProductWithVideo() {
        storefront.hoverMousePointerOverProductWithVideo();
    }

    @Then("Проверяем, что видео является главным изображением товара")
    public void assertThatVideoIsMainImageOfProduct() {
        storefront.assertThatVideoIsMainImageOfProduct();
    }
}