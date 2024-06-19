import adminPanel.CsCartSettings;
import adminPanel.SetCsCartSettings_asGallery;
import adminPanel.VideoGallerySettings;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

/*
Устанавливаем CS-Cart настройки:
* Показывать мини-иконки в виде галереи --      да
* Показывать информацию о товаре во вкладках -- да
* Включить быстрый просмотр --                  да

Устанавливаем настройки модуля
* Включить вертикальное отображение --  нет
*/

public class Gallery_HorizontalViewTest extends TestRunner implements SetCsCartSettings_asGallery {
    CsCartSettings csCartSettings = new CsCartSettings();

    @Test (priority = 10)
    public void setConfigurationsFor_Gallery_HorizontalView() {
        setCsCartSettings_asGallery();
        //Устанавливаем настройки модуля
        VideoGallerySettings videoGallerySettings = csCartSettings.navigateTo_VideoGallerySettings();
        if (videoGallerySettings.setting_EnableVerticalOutput.isSelected()) {
            videoGallerySettings.setting_EnableVerticalOutput.click();
            videoGallerySettings.button_SaveSettings.click();
        }

        //Работаем со страницей товара
        csCartSettings.navigateTo_ProductPage("adizero Rush Shoes");
        csCartSettings.productTemplate.selectOptionByValue("abt__ut2_bigpicture_flat_template");
        csCartSettings.navigateTo_StorefrontProductPage(1); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("310 Gallery, Horizontal - Big picture,flat");
        shiftLanguage("ar");
        Selenide.sleep(1000);
        screenshot("312 Gallery, Horizontal - Big picture,flat (RTL)");

        switchTo().window(0);
        csCartSettings.productTemplate.selectOptionByValue("bigpicture_template");
        csCartSettings.navigateTo_StorefrontProductPage(2); //Переходим на витрину
        $(".ut2-pb__title").shouldBe(Condition.enabled).scrollTo();
        Selenide.sleep(1000);
        screenshot("321 Gallery, Horizontal - Big picture");
        shiftLanguage("ar");
        $(".ut2-pb__title").shouldBe(Condition.enabled).scrollTo();
        Selenide.sleep(1000);
        screenshot("322 Gallery, Horizontal - Big picture (RTL)");

        switchTo().window(0);
        csCartSettings.productTemplate.selectOptionByValue("default_template");
        csCartSettings.navigateTo_StorefrontProductPage(3); //Переходим на витрину
        $(".ut2-pb__title").shouldBe(Condition.enabled).scrollTo();
        Selenide.sleep(1000);
        screenshot("331 Gallery, Horizontal - Default");
        shiftLanguage("ar");
        Selenide.sleep(1000);
        screenshot("332 Gallery, Horizontal - Default (RTL)");

        switchTo().window(0);
        csCartSettings.productTemplate.selectOptionByValue("abt__ut2_three_columns_template");
        csCartSettings.navigateTo_StorefrontProductPage(4); //Переходим на витрину
        $(".ut2-pb__title").shouldBe(Condition.enabled).scrollTo();
        Selenide.sleep(1000);
        screenshot("341 Gallery, Horizontal - Three columns");
        shiftLanguage("ar");
        $(".ut2-pb__title").shouldBe(Condition.enabled).scrollTo();
        Selenide.sleep(1000);
        screenshot("342 Gallery, Horizontal - Three columns (RTL)");

        switchTo().window(0);
        csCartSettings.productTemplate.selectOptionByValue("abt__ut2_cascade_gallery_template");
        csCartSettings.navigateTo_StorefrontProductPage(5); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("351 Gallery, Horizontal - Cascade gallery");
        shiftLanguage("ar");
        Selenide.sleep(1000);
        screenshot("352 Gallery, Horizontal - Cascade gallery (RTL)");
        navigateToCategoryPageAndQuickView();
        screenshot("351 Gallery, Horizontal - QuickView (RTL)");

        System.out.println("Gallery_HorizontalViewTest has passed successfully!");
    }
}