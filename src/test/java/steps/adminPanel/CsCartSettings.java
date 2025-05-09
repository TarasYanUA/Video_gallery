package steps.adminPanel;

import hooks.DriverHooks;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class CsCartSettings implements CheckMenuToBeActive {
    public CsCartSettings() {
        super();
    }

    String productName = DriverHooks.PRODUCT_NAME;

    SelenideElement button_SaveSettings = $(".nav__actions-bar .cm-submit");
    SelenideElement button_SaveProduct = $(".cm-product-save-buttons");

    //Меню "Товары -- Товары"
    SelenideElement menu_Products = $("a[href$='dispatch=products.manage'].main-menu-1__link");
    SelenideElement section_Products = $(By.id("products_products"));
    SelenideElement searchFieldOfProduct = $("input[form='search_filters_form']");
    SelenideElement anyProduct = $(".products-list__image");
    SelenideElement tab_VideoGallery = $(By.id("ab__video_gallery"));
    SelenideElement productTemplate = $(By.id("elm_details_layout"));
    SelenideElement gearWheelOnTop = $(".dropdown-icon--tools");
    SelenideElement button_Preview = $x("//a[contains(text(), 'Предпросмотр')]");
    SelenideElement setting_SetVideoAsDefaultProductImage = $(By.id("ab__vg__replace_image"));

    public void navigateTo_ProductPage() {
        checkMenuToBeActive("dispatch=products.manage", menu_Products);
        section_Products.click();
        searchFieldOfProduct.sendKeys(productName);
        sleep(3000);
        anyProduct.click();
    }

    public void navigateToProductTab_AbVideoGallery() {
        executeJavaScript("window.scrollTo(0, -document.body.scrollHeight);");
        tab_VideoGallery.click();
    }

    public void navigateTo_StorefrontProductPage() {
        button_SaveProduct.click();
        Selenide.sleep(1500);
        gearWheelOnTop.click();
        button_Preview.click();
        List<String> tabs = new ArrayList<>(Selenide.webdriver().object().getWindowHandles());
        Selenide.switchTo().window(tabs.get(1));
        if ($(".cm-btn-success").exists()) {
            $(".cm-btn-success").click();
        }
    }

    public void setTemplateForProduct(String templateName) {
        productTemplate.selectOptionByValue(templateName);
        button_SaveProduct.click();
    }

    public void selectRandomProductTemplate() {
        // Получаем все доступные опции
        SelenideElement selectElement = $(By.id("elm_details_layout"));
        ElementsCollection templateValues = selectElement.$$("option");

        // Заполняем список, исключая опции с текстом, содержащим "Родительское"
        List<String> listOfValues = new ArrayList<>();
        for (SelenideElement option : templateValues) {
            String optionText = option.getText().toLowerCase();
            String optionValue = option.getValue();
            if (!optionText.contains("родительское") && !optionText.contains("─────────────"))
                listOfValues.add(optionValue);
        }

        // Выбор случайного элемента
        Random random = new Random();
        int randomIndex = random.nextInt(listOfValues.size());
        String randomValue = listOfValues.get(randomIndex);
        System.out.println("Случайно выбранный шаблон: " + randomValue);

        // Выбор опции по значению
        selectElement.selectOptionByValue(randomValue);
    }

    public void enableSetting_SetVideoAsDefaultProductImage() {
        if (!setting_SetVideoAsDefaultProductImage.isSelected())
            setting_SetVideoAsDefaultProductImage.click();
    }

    public void toggleSettingInTab_AbVideoGallery(String action, String settingName, String videoType) {
        SelenideElement checkbox = $x("//option[@selected='' and text()='" + videoType + "']/../../../..//input[contains(@id, '" + settingName + "')]");

        boolean shouldEnable = action.equalsIgnoreCase("Активируем");
        boolean isCurrentlySelected = checkbox.isSelected();

        if (shouldEnable != isCurrentlySelected)
            checkbox.click();
    }

    public void selectValueForSetting_IconType(String iconType, String videoType) {
        $x("//option[@selected='' and text()='" + videoType + "']/../../../..//input[contains(@name, 'product_data[ab__vg_videos]')][@value='" + iconType + "']").click();
    }

    public void addImageForVideo(String image) {
        $("div[id^='link_container_'] a[id^='url_']").click();
        Alert alert = webdriver().driver().switchTo().alert();
        sleep(1500);
        alert.sendKeys(image);
        alert.accept();
    }

    public void saveProductPage() {
        button_SaveProduct.click();
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

        button_SaveSettings.click();
    }
}