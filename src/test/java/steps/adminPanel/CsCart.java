package steps.adminPanel;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;

public class CsCart implements CheckMenuToBeActive {
    public CsCart() {super();}

    SelenideElement button_SaveSettings = $(".nav__actions-bar .cm-submit");
    SelenideElement button_SaveProduct = $(".cm-product-save-buttons");

    //Меню "Товары"
    SelenideElement menu_Products = $("a[href$='dispatch=products.manage'].main-menu-1__link");
    SelenideElement section_Products = $(By.id("products_products"));
    SelenideElement tab_VideoGallery = $(By.id("ab__video_gallery"));
    SelenideElement productTemplate = $(By.id("elm_details_layout"));
    SelenideElement gearWheelOnTop = $(".dropdown-icon--tools");
    SelenideElement button_Preview = $x("//a[contains(text(), 'Предпросмотр')]");

    @When("Переходим на страницу редактирования товара {string}")
    public void navigateTo_ProductPage(String productName) {
        checkMenuToBeActive("dispatch=products.manage", menu_Products);
        section_Products.click();
        $x("//td[@class='product-name-column wrap-word']//a[contains(text(), '" + productName + "')]").click();
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
    }


    //Меню "Модули -- Скачанные модули"
    SelenideElement menu_Addons = $("a[href$='dispatch=addons.manage'].main-menu-1__link");
    SelenideElement section_DownloadedAddons = $("#addons_downloaded_add_ons");
    SelenideElement gearwheelOfVideoGallery = $("tr#addon_ab__video_gallery button.btn.dropdown-toggle");
    SelenideElement sectionOfVideoGallery_GeneralSettings = $(".dropdown-menu a[href$='addon=ab__video_gallery&selected_section=settings']");
    SelenideElement tab_Settings = $("#settings");

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

    @And("Возвращаемся на страницу редактирования товара")
    public void switchToProductWindow() {
        switchTo().window(0);
    }
}