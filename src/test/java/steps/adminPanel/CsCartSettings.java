package steps.adminPanel;

import hooks.DriverHooks;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class CsCartSettings implements CheckMenuToBeActive {
    public CsCartSettings() {
        super();
    }

    String productName = DriverHooks.PRODUCT_NAME;

    SelenideElement button_SaveSettings = $(".nav__actions-bar .cm-submit");
    SelenideElement menu_Products = $("a[href$='dispatch=products.manage'].main-menu-1__link");
    SelenideElement section_Products = $(By.id("products_products"));
    SelenideElement searchFieldOfProduct = $("input[form='search_filters_form']");
    SelenideElement anyProduct = $(".products-list__image");


    public void saveSettings() {
        button_SaveSettings.click();
    }

    public void navigateTo_ProductPage() {
        checkMenuToBeActive("dispatch=products.manage", menu_Products);
        section_Products.click();
        searchFieldOfProduct.setValue(productName);
        sleep(3000);
        anyProduct.click();
    }


    //Меню "Модули -- Скачанные модули"
    SelenideElement menu_Addons = $("a[href$='dispatch=addons.manage'].main-menu-1__link");
    SelenideElement section_DownloadedAddons = $("#addons_downloaded_add_ons");
    SelenideElement gearwheelOfVideoGallery = $("tr#addon_ab__video_gallery button.btn.dropdown-toggle");
    SelenideElement sectionOfVideoGallery_GeneralSettings = $(".dropdown-menu a[href$='addon=ab__video_gallery&selected_section=settings']");
    SelenideElement tab_Settings = $("#settings");
    SelenideElement menuOfUniTheme = $("tr#addon_abt__unitheme2 button.btn.dropdown-toggle");
    SelenideElement sectionThemeSettings = $("div.nowrap a[href*='abt__ut2.settings']");


    private void navigateTo_DownloadedAddonsPage() {
        checkMenuToBeActive("dispatch=addons.manage", menu_Addons);
        section_DownloadedAddons.click();
    }

    public void navigateTo_VideoGallerySettings() {
        navigateTo_DownloadedAddonsPage();
        gearwheelOfVideoGallery.click();
        sectionOfVideoGallery_GeneralSettings.click();
        tab_Settings.click();
    }

    public UniThemeSettings navigateTo_UniThemeSettings() {
        navigateTo_DownloadedAddonsPage();
        menuOfUniTheme.click();
        sectionThemeSettings.click();
        return new UniThemeSettings();
    }


    //Меню "Настройки -- Общие настройки -- Внешний вид"
    SelenideElement menu_Settings = $("#administration");
    SelenideElement section_Appearance = $("a[href*='section_id=Appearance']");
    SelenideElement section_GeneralSettings = $("a[href$='section_id=General']");
    SelenideElement setting_displayProductDetailsInTabs = $("#field___product_details_in_tab_288");
    SelenideElement setting_quickView = $("#field___enable_quick_view_290");
    SelenideElement setting_displayImagesAsGallery = $("#field___thumbnails_gallery_147");

    public void navigateTo_AppearanceSettings() {
        menu_Settings.click();
        section_GeneralSettings.click();
        section_Appearance.click();
    }

    public void setCsCartSettings_WithOrWithoutOptions(String galleryOption, String tabsOption) {
        navigateTo_AppearanceSettings();

        boolean galleryWithout = galleryOption.equalsIgnoreCase("БЕЗ");
        boolean tabsWithout = tabsOption.equalsIgnoreCase("БЕЗ");

        if (setting_displayImagesAsGallery.isSelected() == galleryWithout)
            setting_displayImagesAsGallery.click();

        if (setting_displayProductDetailsInTabs.isSelected() == tabsWithout)
            setting_displayProductDetailsInTabs.click();

        if (!setting_quickView.isSelected())
            setting_quickView.click();

        saveSettings();
    }
}