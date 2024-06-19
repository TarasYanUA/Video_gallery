import adminPanel.CsCartSettings;
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
* Включить вертикальное отображение --  да
*/

public class Gallery_VerticalViewTest extends TestRunner {
    CsCartSettings csCartSettings = new CsCartSettings();

    @Test(priority = 10)
    public void setConfigurations(){
        //Устанавливаем CS-Cart настройки
        CsCartSettings csCartSettings = new CsCartSettings();
        csCartSettings.navigateTo_AppearanceSettings();
        if(!csCartSettings.setting_displayImagesAsGallery.isSelected()){
            csCartSettings.setting_displayImagesAsGallery.click();
        }
        if(!csCartSettings.setting_displayProductDetailsInTabs.isSelected()){
            csCartSettings.setting_displayProductDetailsInTabs.click();
        }
        if (!csCartSettings.setting_quickView.isSelected()){
            csCartSettings.setting_quickView.click();
        }
        csCartSettings.button_SaveSettings.click();

        //Устанавливаем настройки модуля
        VideoGallerySettings videoGallerySettings = csCartSettings.navigateTo_VideoGallerySettings();
        if(!videoGallerySettings.setting_EnableVerticalOutput.isSelected()) {
            videoGallerySettings.setting_EnableVerticalOutput.click();
            videoGallerySettings.button_SaveSettings.click();
        }
    }

    @Test(priority = 20)
    public void checkGallery_VerticalView_BigPictureFlat() {
        CsCartSettings csCartSettings = new CsCartSettings();
        //Работаем со страницей товара
        csCartSettings.navigateTo_ProductPage("adizero Rush Shoes");
        csCartSettings.productTemplate.selectOptionByValue("abt__ut2_bigpicture_flat_template");
        csCartSettings.navigateTo_StorefrontProductPage(1); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("211 Gallery, Vertical - Big picture,flat");
        shiftLanguage("ar");
        Selenide.sleep(1000);
        screenshot("212 Gallery, Vertical - Big picture,flat (RTL)");
    }

    @Test(priority = 30)
    public void checkGallery_VerticalView_BigPicture() {
        switchTo().window(0);
        csCartSettings.productTemplate.selectOptionByValue("bigpicture_template");
        csCartSettings.navigateTo_StorefrontProductPage(2); //Переходим на витрину
        $(".ut2-pb__title").shouldBe(Condition.enabled).scrollTo();
        Selenide.sleep(1000);
        screenshot("221 Gallery, Vertical - Big picture");
        shiftLanguage("ar");
        $(".ut2-pb__title").shouldBe(Condition.enabled).scrollTo();
        Selenide.sleep(1000);
        screenshot("222 Gallery, Vertical - Big picture (RTL)");
    }

    @Test(priority = 40)
    public void checkGallery_VerticalView_Default() {
        switchTo().window(0);
        csCartSettings.productTemplate.selectOptionByValue("default_template");
        csCartSettings.navigateTo_StorefrontProductPage(3); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("231 Gallery, Vertical - Default");
        shiftLanguage("ar");
        Selenide.sleep(1000);
        screenshot("232 Gallery, Vertical - Default (RTL)");
    }

    @Test(priority = 50)
    public void checkGallery_VerticalView_ThreeColumn() {
        switchTo().window(0);
        csCartSettings.productTemplate.selectOptionByValue("abt__ut2_three_columns_template");
        csCartSettings.navigateTo_StorefrontProductPage(4); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("241 Gallery, Vertical - Three columns");
        shiftLanguage("ar");
        Selenide.sleep(1000);
        screenshot("242 Gallery, Vertical - Three columns (RTL)");
    }

    @Test(priority = 60)
    public void checkGallery_VerticalView_CascadeGallery() {
        switchTo().window(0);
        csCartSettings.productTemplate.selectOptionByValue("abt__ut2_cascade_gallery_template");
        csCartSettings.navigateTo_StorefrontProductPage(5); //Переходим на витрину
        Selenide.sleep(1000);
        screenshot("251 Gallery, Vertical - Cascade gallery");
        shiftLanguage("ar");
        Selenide.sleep(1000);
        screenshot("252 Gallery, Vertical - Cascade gallery (RTL)");
        navigateToCategoryPageAndQuickView();
        screenshot("261 Gallery, Vertical - QuickView (RTL)");
    }
}