import adminPanel.CsCartSettings;
import adminPanel.SetCsCartSettings_NoGallery;
import adminPanel.VideoGallerySettings;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

/*
Устанавливаем CS-Cart настройки:
* Показывать мини-иконки в виде галереи --      нет
* Показывать информацию о товаре во вкладках -- да
* Включить быстрый просмотр --                  да

Устанавливаем настройки модуля
* Включить вертикальное отображение --  да
*/

public class NoGallery_VerticalViewTest extends TestRunner implements SetCsCartSettings_NoGallery {
    CsCartSettings csCartSettings = new CsCartSettings();

    @Test (priority = 10)
    public void setConfigurationsFor_NoGallery_VerticalView() {
        setCsCartSettings_NoGallery();
        //Устанавливаем настройки модуля
        VideoGallerySettings videoGallerySettings = csCartSettings.navigateTo_VideoGallerySettings();
        if (!videoGallerySettings.setting_EnableVerticalOutput.isSelected()) {
            videoGallerySettings.setting_EnableVerticalOutput.click();
            videoGallerySettings.button_SaveSettings.click();
        }
    }

    @Test(priority = 20, dependsOnMethods = "setConfigurationsFor_NoGallery_VerticalView")
    public void checkNoGallery_VerticalView() {
        //Работаем со страницей товара
        csCartSettings.navigateTo_ProductPage("adizero Rush Shoes");
        csCartSettings.productTemplate.selectOptionByValue("abt__ut2_bigpicture_flat_template");
        csCartSettings.navigateTo_StorefrontProductPage(1); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("511 NoGallery, Vertical - Big picture,flat");
        shiftLanguage("ar");
        Selenide.sleep(1000);
        screenshot("512 NoGallery, Vertical - Big picture,flat (RTL)");

        switchTo().window(0);
        csCartSettings.productTemplate.selectOptionByValue("bigpicture_template");
        csCartSettings.navigateTo_StorefrontProductPage(2); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("521 NoGallery, Vertical - Big picture");
        shiftLanguage("ar");
        Selenide.sleep(1000);
        screenshot("522 NoGallery, Vertical - Big picture (RTL)");

        switchTo().window(0);
        csCartSettings.productTemplate.selectOptionByValue("default_template");
        csCartSettings.navigateTo_StorefrontProductPage(3); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("531 NoGallery, Vertical - Default");
        shiftLanguage("ar");
        Selenide.sleep(1000);
        screenshot("532 NoGallery, Vertical - Default (RTL)");

        switchTo().window(0);
        csCartSettings.productTemplate.selectOptionByValue("abt__ut2_three_columns_template");
        csCartSettings.navigateTo_StorefrontProductPage(4); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("541 NoGallery, Vertical - Three columns");
        shiftLanguage("ar");
        Selenide.sleep(1000);
        screenshot("542 NoGallery, Vertical - Three columns (RTL)");

        switchTo().window(0);
        csCartSettings.productTemplate.selectOptionByValue("abt__ut2_cascade_gallery_template");
        csCartSettings.navigateTo_StorefrontProductPage(5); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("551 NoGallery, Vertical - Cascade gallery");
        shiftLanguage("ar");
        Selenide.sleep(1000);
        screenshot("552 NoGallery, Vertical - Cascade gallery (RTL)");
        navigateToCategoryPageAndQuickView();
        screenshot("561 NoGallery, Vertical - QuickView (RTL)");

        System.out.println("NoGallery_VerticalViewTest has passed successfully!");
    }
}