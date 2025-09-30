package steps.storefront;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.$x;

public class StorefrontSteps {

    public StorefrontSteps() {
        super();
    }

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

    @And("Делаем скриншот видео с автовоспроизведением {string}")
    public void takeScreenshotOfVideoWithAutoplay(String screenshotName) {
        storefront.videoWithAutoplay.scrollIntoCenter();
        Selenide.sleep(3000);
        storefront.takeScreenshot(screenshotName);
    }

    @And("Делаем скриншот видео {int} с автовоспроизведением в окне быстрого просмотра {string}")
    public void takeScreenshotOfVideoWithAutoplay_QuickView(int num, String screenshotName) {
        $x("(//a[contains(@class, 'cm-thumbnails-mini ab__vg-image_gallery_item')])[" + num + "]").click();
        Selenide.sleep(3000);
        storefront.takeScreenshot(screenshotName);
    }

    @And("Наводим курсор мыши на товар с видео на странице категории")
    public void hoverMousePointerOverProductWithVideo() {
        storefront.hoverMousePointerOverProductWithVideo();
    }
}