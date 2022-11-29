import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

public class NoGallery_HorizontalView extends TestRunner{
    @Test
    public void checkNoGalleryBigPictureFlatTemplateOfProductPage() {
        //Включаем вид без галереи
        $(".dropdown-toggle.settings").hover();
        $("#elm_menu_settings_Appearance").click();
        WebElement galleryCheckbox = $x("//input[contains(@id, 'field___thumbnails_gallery')]");
        if (galleryCheckbox.isSelected()){
            $x("//input[contains(@id, 'field___thumbnails_gallery')]").click();
            $(By.linkText("Сохранить")).click();
        }
        //Работаем со страницей товара
        navigateToProductPage();
        $("#elm_details_layout").click();
        $x("//option[@value='abt__ut2_bigpicture_flat_template']").click();
        navigateToStorefront(1); //Переходим на витрину
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        screenshot("401 NoGallery, Horizontal, 'AB Big picture, flat'");
        switchTo().window(0);
    }
    @Test
    public void checkNoGalleryBigPictureTemplateOfProductPage() {
        $("#elm_details_layout").click();
        $x("//option[@value='bigpicture_template']").click();
        navigateToStorefront(2); //Переходим на витрину
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        screenshot("402 NoGallery, Horizontal, 'Big picture'");
        switchTo().window(0);
    }
    @Test
    public void checkNoGalleryDefaultTemplateOfProductPage() {
        $("#elm_details_layout").click();
        $x("//option[@value='default_template']").click();
        navigateToStorefront(3); //Переходим на витрину
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        screenshot("403 NoGallery, Horizontal, 'Default'");
        switchTo().window(0);
    }
    @Test
    public void checkNoGalleryThreeColumnTemplateOfProductPageTest() {
        $("#elm_details_layout").click();
        $x("//option[@value='abt__ut2_three_columns_template']").click();
        navigateToStorefront(4); //Переходим на витрину
        $(".ut2-pb__title").shouldBe(Condition.enabled).scrollTo();
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        screenshot("404 Horizontal, 'AB Three columns'");
        $(".ty-text-links-wrapper").scrollTo();
        $x("//bdi[text()='DVD & Blu-ray Players']").click();
        $x("//a[contains(@href, 'toshiba-bdx2150-blu-ray-player/')]").hover();
        $x("//a[@data-ca-view-id=\"19\"][@data-ca-dialog-title=\"Quick product viewer\"]").shouldBe(Condition.visible).click();
        $(".ui-dialog").shouldBe(Condition.visible).$(".ty-product-thumbnails").shouldBe(Condition.enabled);
        screenshot("405 NoGallery, QuickView window");
    }
}
