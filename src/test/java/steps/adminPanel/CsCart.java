package steps.adminPanel;

import hooks.DriverHooks;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class CsCart implements CheckMenuToBeActive {
    public CsCart() {super();}

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

    @When("Переходим на страницу редактирования товара")
    public void navigateTo_ProductPage() {
        checkMenuToBeActive("dispatch=products.manage", menu_Products);
        section_Products.click();
        searchFieldOfProduct.click();
        searchFieldOfProduct.sendKeys(productName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        anyProduct.click();
    }

    @When("Переходим во вкладку АВ: Видео галерея")
    public void navigateToProductTab_AbVideoGallery() {
        executeJavaScript("window.scrollTo(0, -document.body.scrollHeight);");
        tab_VideoGallery.click();
    }

    @And("Переходим на витрину страницы товара")
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

    @And("Устанавливаем товару шаблон {string}")
    public void setTemplateForProduct(String templateName) {
        productTemplate.selectOptionByValue(templateName);
        button_SaveProduct.click();
    }

    @And("Устанавливаем произвольный шаблон страницы товара")
    public void selectRandomProductTemplate() {
        // Получаем все доступные опции
        SelenideElement selectElement = $(By.id("elm_details_layout"));
        ElementsCollection templateValues = selectElement.$$("option");

        // Заполняем список, исключая опции с текстом, содержащим "Родительское"
        List<String> listOfValues = new ArrayList<>();
        for (SelenideElement option : templateValues) {
            String optionText = option.getText().toLowerCase();
            String optionValue = option.getValue();
            if (!optionText.contains("родительское") && !optionText.contains("─────────────")) {
                listOfValues.add(optionValue);
            }
        }

        // Выбор случайного элемента
        Random random = new Random();
        int randomIndex = random.nextInt(listOfValues.size());
        String randomValue = listOfValues.get(randomIndex);
        System.out.println("Случайно выбранный шаблон: " + randomValue);

        // Выбор опции по значению
        selectElement.selectOptionByValue(randomValue);
    }

    @And("Активируем настройку: Установить видео как изображение товара по умолчанию")
    public void enableSetting_SetVideoAsDefaultProductImage() {
        if(!setting_SetVideoAsDefaultProductImage.isSelected())
            setting_SetVideoAsDefaultProductImage.click();
    }

    @When("Активируем настройку {string} для видео с типом {string}")
    public void enableSettingInTab_AbVideoGallery(String settingName, String videoType) {
        if(!$x("//option[@selected='' and text()='" + videoType + "']/../../../..//input[contains(@id, '" + settingName + "')]").isSelected())
            $x("//option[@selected='' and text()='" + videoType + "']/../../../..//input[contains(@id, '" + settingName + "')]").click();
    }

    //option[@selected='' and text()='YouTube']/../../../..//input[contains(@id, 'ab__vg__autoplay__')]
    @When("Отключаем настройку {string} для видео с типом {string}")
    public void disableSettingInTab_AbVideoGallery(String settingName, String videoType) {
        if($x("//option[@selected='' and text()='" + videoType + "']/../../../..//input[contains(@id, '" + settingName + "')]").isSelected())
            $x("//option[@selected='' and text()='" + videoType + "']/../../../..//input[contains(@id, '" + settingName + "')]").click();
    }

    //option[@selected='' and text()='" + videoType + "']/../../../..//input[contains(@name, 'product_data[ab__vg_videos]')][@value='" + iconType + "']
    @When("У настройки `Тип иконки` выбираем значение {string} для видео с типом {string}")
    public void selectValueForSetting_IconType(String iconType, String videoType) {
        $x("//option[@selected='' and text()='" + videoType + "']/../../../..//input[contains(@name, 'product_data[ab__vg_videos]')][@value='" + iconType + "']").click();
    }

    @And("Добавляем изображение для видео")
    public void addImageForVideo() {
        $("div[id^='link_container_'] a[id^='url_']").click();
        Alert alert = webdriver().driver().switchTo().alert();
        sleep(1500);
        alert.sendKeys("https://i.artfile.ru/1920x1080_1704830_[www.ArtFile.ru].jpg");
        alert.accept();
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

    @And("Переходим в настройки модуля")
    public void navigateTo_VideoGallerySettings() {
        navigateTo_DownloadedAddonsPage();
        gearwheelOfVideoGallery.click();
        sectionOfVideoGallery_GeneralSettings.click();
        tab_Settings.click();
    }

    @And("Переходим на страницу настроек темы UniTheme")
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

    @And("CS-Cart настройки: Показывать мини-иконки в виде галереи, Показывать информацию о товаре во вкладках, Включить быстрый просмотр")
    public void setCsCartSettings_asGallery() {
        navigateTo_AppearanceSettings();
        if (!setting_displayImagesAsGallery.isSelected()) {
            setting_displayImagesAsGallery.click();
        }
        if (!setting_displayProductDetailsInTabs.isSelected()) {
            setting_displayProductDetailsInTabs.click();
        }
        if (!setting_quickView.isSelected()) {
            setting_quickView.click();
        }
        button_SaveSettings.click();
    }

    @And("CS-Cart настройки: Показывать мини-иконки БЕЗ галереи, Показывать информацию о товаре Без вкладок, Включить быстрый просмотр")
    public void setCsCartSettings_NoGallery() {
        navigateTo_AppearanceSettings();
        if (setting_displayImagesAsGallery.isSelected()) {
            setting_displayImagesAsGallery.click();
        }
        if (setting_displayProductDetailsInTabs.isSelected()) {
            setting_displayProductDetailsInTabs.click();
        }
        if (!setting_quickView.isSelected()) {
            setting_quickView.click();
        }
        button_SaveSettings.click();
    }
}