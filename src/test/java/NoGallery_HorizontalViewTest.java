import adminPanel.CsCartSettings;
import adminPanel.SetCsCartSettings_NoGallery;
import adminPanel.VideoGallerySettings;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

/*
Устанавливаем CS-Cart настройки:
* Показывать мини-иконки в виде галереи --      нет
* Показывать информацию о товаре во вкладках -- да
* Включить быстрый просмотр --                  да

Устанавливаем настройки модуля
* Включить вертикальное отображение --  нет
*/

public class NoGallery_HorizontalViewTest extends TestRunner implements SetCsCartSettings_NoGallery {
    CsCartSettings csCartSettings = new CsCartSettings();

    @Test (priority = 10)
    public void setConfigurationsFor_NoGallery_HorizontalView() {
        setCsCartSettings_NoGallery();
        //Устанавливаем настройки модуля
        VideoGallerySettings videoGallerySettings = csCartSettings.navigateTo_VideoGallerySettings();
        if (videoGallerySettings.setting_EnableVerticalOutput.isSelected()) {
            videoGallerySettings.setting_EnableVerticalOutput.click();
            videoGallerySettings.button_SaveSettings.click();
        }
    }

    @Test(priority = 20, dependsOnMethods = "setConfigurationsFor_NoGallery_HorizontalView")
    public void checkNoGallery_HorizontalView() {
        //Работаем со страницей товара
        csCartSettings.navigateTo_ProductPage("adizero Rush Shoes");
        csCartSettings.productTemplate.selectOptionByValue("abt__ut2_bigpicture_flat_template");
        csCartSettings.navigateTo_StorefrontProductPage(1); //Переходим на витрину
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        Selenide.sleep(1000);
        screenshot("411 NoGallery, Horizontal - Big picture,flat");
        shiftLanguage("ar");
        Selenide.sleep(1000);
        screenshot("412 NoGallery, Horizontal - Big picture,flat (RTL)");

        switchTo().window(0);
        csCartSettings.productTemplate.selectOptionByValue("bigpicture_template");
        csCartSettings.navigateTo_StorefrontProductPage(2); //Переходим на витрину
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        Selenide.sleep(1000);
        screenshot("421 NoGallery, Horizontal - Big picture");
        shiftLanguage("ar");
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        Selenide.sleep(1000);
        screenshot("422 NoGallery, Horizontal - Big picture (RTL)");

        switchTo().window(0);
        csCartSettings.productTemplate.selectOptionByValue("default_template");
        csCartSettings.navigateTo_StorefrontProductPage(3); //Переходим на витрину
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        Selenide.sleep(1000);
        screenshot("431 NoGallery, Horizontal - Default");
        shiftLanguage("ar");
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        Selenide.sleep(1000);
        screenshot("432 NoGallery, Horizontal - Default (RTL)");

        switchTo().window(0);
        csCartSettings.productTemplate.selectOptionByValue("abt__ut2_three_columns_template");
        csCartSettings.navigateTo_StorefrontProductPage(4); //Переходим на витрину
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        Selenide.sleep(1000);
        screenshot("441 NoGallery, Horizontal - Three columns");
        shiftLanguage("ar");
        $(".ty-menu__items.cm-responsive-menu").scrollTo();
        Selenide.sleep(1000);
        screenshot("442 NoGallery, Horizontal - Three columns (RTL)");

        switchTo().window(0);
        csCartSettings.productTemplate.selectOptionByValue("abt__ut2_cascade_gallery_template");
        csCartSettings.navigateTo_StorefrontProductPage(5); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("451 Gallery, Horizontal - Cascade gallery");
        shiftLanguage("ar");
        Selenide.sleep(1000);
        screenshot("452 Gallery, Horizontal - Cascade gallery (RTL)");
        navigateToCategoryPageAndQuickView();
        screenshot("461 Gallery, Horizontal - QuickView (RTL)");

        System.out.println("NoGallery_HorizontalViewTest has passed successfully!");
    }
}