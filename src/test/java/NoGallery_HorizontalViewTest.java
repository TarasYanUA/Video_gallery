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
        $("#elm_details_layout").click();
        $x("//option[@value='abt__ut2_bigpicture_flat_template']").click();
        navigateToStorefront(1); //Переходим на витрину
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        screenshot("411 NoGallery, Horizontal, 'AB Big picture, flat'");
        $("a[id*='sw_select_en_wrap_language']").click();   //Переключаемся на язык RTL
        $("a[data-ca-name='ar']").click();
        screenshot("412 RTL, NoGallery, Horizontal, 'AB Big picture, flat'");
        switchTo().window(0);
    }
    @Test
    public void checkNoGallery_Horizontal_BigPictureTemplateOfProductPage() {
        $("#elm_details_layout").click();
        $x("//option[@value='bigpicture_template']").click();
        navigateToStorefront(2); //Переходим на витрину
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        screenshot("421 NoGallery, Horizontal, 'Big picture'");
        $("a[id*='sw_select_en_wrap_language']").click();   //Переключаемся на язык RTL
        $("a[data-ca-name='ar']").click();
        screenshot("422 RTL, NoGallery, Horizontal, 'Big picture'");
        switchTo().window(0);
    }
    @Test
    public void checkNoGallery_Horizontal_DefaultTemplateOfProductPage() {
        $("#elm_details_layout").click();
        $x("//option[@value='default_template']").click();
        navigateToStorefront(3); //Переходим на витрину
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        screenshot("431 NoGallery, Horizontal, 'Default'");
        $("a[id*='sw_select_en_wrap_language']").click();   //Переключаемся на язык RTL
        $("a[data-ca-name='ar']").click();
        screenshot("432 RTL, NoGallery, Horizontal, 'Default'");
        switchTo().window(0);
    }
    @Test
    public void checkNoGallery_Horizontal_ThreeColumnTemplateOfProductPageTest() {
        $("#elm_details_layout").click();
        $x("//option[@value='abt__ut2_three_columns_template']").click();
        navigateToStorefront(4); //Переходим на витрину
        $(".ut2-pb__title").shouldBe(Condition.enabled).scrollTo();
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        screenshot("441 NoGallery, Horizontal, 'AB Three columns'");
        $("a[id*='sw_select_en_wrap_language']").click();   //Переключаемся на язык RTL
        $("a[data-ca-name='ar']").click();
        screenshot("442 RTL, NoGallery, Horizontal, 'AB Three columns'");
        $(".ty-text-links-wrapper").scrollTo();
        $x("//bdi[text()='DVD & Blu-ray Players']").click();
        $x("//a[@data-ca-view-id=\"19\"][@data-ca-target-id=\"product_quick_view\"]").hover().click();
        $(".ui-dialog").shouldBe(Condition.visible).$(".ty-product-thumbnails").shouldBe(Condition.enabled);
        screenshot("451 NoGallery, Horizontal, QuickView");
    }
}
