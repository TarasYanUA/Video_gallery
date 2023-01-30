import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

public class NoGallery_HorizontalViewTest extends TestRunner{
    @Test
    public void checkNoGallery_Horizontal_BigPictureFlatTemplateOfProductPage() {
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
        selectBigPictureFlatTemplate();
        navigateToStorefront(1); //Переходим на витрину
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        screenshot("411 NoGallery, Horizontal, 'AB Big picture, flat'");
        shiftToRTLLanguage();
        screenshot("412 RTL, NoGallery, Horizontal, 'AB Big picture, flat'");
        switchTo().window(0);
    }
    @Test
    public void checkNoGallery_Horizontal_BigPictureTemplateOfProductPage() {
        selectBigPictureTemplate();
        navigateToStorefront(2); //Переходим на витрину
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        screenshot("421 NoGallery, Horizontal, 'Big picture'");
        shiftToRTLLanguage();
        screenshot("422 RTL, NoGallery, Horizontal, 'Big picture'");
        switchTo().window(0);
    }
    @Test
    public void checkNoGallery_Horizontal_DefaultTemplateOfProductPage() {
        selectDefaultTemplate();
        navigateToStorefront(3); //Переходим на витрину
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        screenshot("431 NoGallery, Horizontal, 'Default'");
        shiftToRTLLanguage();
        screenshot("432 RTL, NoGallery, Horizontal, 'Default'");
        switchTo().window(0);
    }
    @Test
    public void checkNoGallery_Horizontal_ThreeColumnTemplateOfProductPageTest() {
        selectThreeColumnTemplate();
        navigateToStorefront(4); //Переходим на витрину
        $(".ut2-pb__title").shouldBe(Condition.enabled).scrollTo();
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        screenshot("441 NoGallery, Horizontal, 'AB Three columns'");
        shiftToRTLLanguage();
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        screenshot("442 RTL, NoGallery, Horizontal, 'AB Three columns'");
        $(".ty-text-links-wrapper").scrollTo();
        $x("//bdi[text()='DVD & Blu-ray Players']").click();
        $x("//a[@data-ca-view-id=\"19\"][@data-ca-target-id=\"product_quick_view\"]").hover().click();
        $(".ui-dialog").shouldBe(Condition.visible).$(".ty-product-thumbnails").shouldBe(Condition.enabled);
        screenshot("451 RTL, NoGallery, Horizontal, QuickView");
    }
}
