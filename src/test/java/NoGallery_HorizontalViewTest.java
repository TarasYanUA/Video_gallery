import adminPanel.CsCartSettings;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

public class NoGallery_HorizontalViewTest extends TestRunner {
    CsCartSettings csCartSettings = new CsCartSettings();

    @Test(priority = 1)
    public void checkNoGallery_HorizontalView_BigPictureFlat() {
        //Включаем вид мини-иконок без галереи
        $(".dropdown-toggle.settings").hover();
        $("#elm_menu_settings_Appearance").click();
        WebElement galleryCheckbox = $x("//input[contains(@id, 'field___thumbnails_gallery')]");
        if (galleryCheckbox.isSelected()){
            $x("//input[contains(@id, 'field___thumbnails_gallery')]").click();
            $(By.linkText("Сохранить")).click();
        }
        //Работаем со страницей товара
        csCartSettings.navigateTo_ProductPage("adizero Rush Shoes");
        selectBigPictureFlatTemplate();
        csCartSettings.navigateTo_StorefrontProductPage(1); //Переходим на витрину
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        Selenide.sleep(1000);
        screenshot("411 NoGallery, Horizontal - Big picture,flat");
        shiftLanguage("ar");
        Selenide.sleep(1000);
        screenshot("412 NoGallery, Horizontal - Big picture,flat (RTL)");
    }

    @Test(priority = 2)
    public void checkNoGallery_HorizontalView_BigPicture() {
        switchTo().window(0);
        selectBigPictureTemplate();
        csCartSettings.navigateTo_StorefrontProductPage(2); //Переходим на витрину
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        Selenide.sleep(1000);
        screenshot("421 NoGallery, Horizontal - Big picture");
        shiftLanguage("ar");
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        Selenide.sleep(1000);
        screenshot("422 NoGallery, Horizontal - Big picture (RTL)");
    }

    @Test(priority = 3)
    public void checkNoGallery_HorizontalView_Default() {
        switchTo().window(0);
        selectDefaultTemplate();
        csCartSettings.navigateTo_StorefrontProductPage(3); //Переходим на витрину
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        Selenide.sleep(1000);
        screenshot("431 NoGallery, Horizontal - Default");
        shiftLanguage("ar");
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        Selenide.sleep(1000);
        screenshot("432 NoGallery, Horizontal - Default (RTL)");
    }

    @Test(priority = 4)
    public void checkNoGallery_HorizontalView_ThreeColumn() {
        switchTo().window(0);
        selectThreeColumnTemplate();
        csCartSettings.navigateTo_StorefrontProductPage(4); //Переходим на витрину
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        Selenide.sleep(1000);
        screenshot("441 NoGallery, Horizontal - Three columns");
        shiftLanguage("ar");
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        Selenide.sleep(1000);
        screenshot("442 NoGallery, Horizontal - Three columns (RTL)");
        $(".ty-text-links-wrapper").scrollTo();
        navigateToCategoryPageAndQuickView();
        screenshot("451 NoGallery, Horizontal - QuickView (RTL)");
    }
}