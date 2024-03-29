import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

public class NoGallery_HorizontalViewTest extends TestRunner{
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
        navigateToProductPage();
        selectBigPictureFlatTemplate();
        navigateToStorefront(1); //Переходим на витрину
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        Selenide.sleep(1000);
        screenshot("411 NoGallery, Horizontal - Big picture,flat");
        shiftToRTLLanguage();
        Selenide.sleep(1000);
        screenshot("412 NoGallery, Horizontal - Big picture,flat (RTL)");
    }
    @Test(priority = 2)
    public void checkNoGallery_HorizontalView_BigPicture() {
        switchTo().window(0);
        selectBigPictureTemplate();
        navigateToStorefront(2); //Переходим на витрину
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        Selenide.sleep(1000);
        screenshot("421 NoGallery, Horizontal - Big picture");
        shiftToRTLLanguage();
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        Selenide.sleep(1000);
        screenshot("422 NoGallery, Horizontal - Big picture (RTL)");
    }
    @Test(priority = 3)
    public void checkNoGallery_HorizontalView_Default() {
        switchTo().window(0);
        selectDefaultTemplate();
        navigateToStorefront(3); //Переходим на витрину
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        Selenide.sleep(1000);
        screenshot("431 NoGallery, Horizontal - Default");
        shiftToRTLLanguage();
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        Selenide.sleep(1000);
        screenshot("432 NoGallery, Horizontal - Default (RTL)");
    }
    @Test(priority = 4)
    public void checkNoGallery_HorizontalView_ThreeColumn() {
        switchTo().window(0);
        selectThreeColumnTemplate();
        navigateToStorefront(4); //Переходим на витрину
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        Selenide.sleep(1000);
        screenshot("441 NoGallery, Horizontal - Three columns");
        shiftToRTLLanguage();
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        Selenide.sleep(1000);
        screenshot("442 NoGallery, Horizontal - Three columns (RTL)");
        $(".ty-text-links-wrapper").scrollTo();
        navigateToCategoryPageAndQuickView();
        screenshot("451 NoGallery, Horizontal - QuickView (RTL)");
    }
}