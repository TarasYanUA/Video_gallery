package adminPanel;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class CsCartSettings implements CheckMenuToBeActive {
    public CsCartSettings() {
        super();
    }

    public SelenideElement button_SaveSettings = $(".nav__actions-bar .cm-submit");
    public SelenideElement button_SaveProduct = $(".cm-product-save-buttons");


    //Меню "Товары"
    private final SelenideElement menu_Products = $("a[href$='dispatch=products.manage'].main-menu-1__link");
    private final SelenideElement section_Products = $(By.id("products_products"));
    public SelenideElement tab_VideoGallery = $(By.id("ab__video_gallery"));
    public SelenideElement productTemplate = $(By.id("elm_details_layout"));
    private final SelenideElement gearWheelOnTop = $(".dropdown-icon--tools");
    public SelenideElement button_Preview = $x("//a[contains(text(), 'Предпросмотр')]");

    public void navigateTo_ProductPage(String productName) {
        checkMenuToBeActive("dispatch=products.manage", menu_Products);
        section_Products.click();
        $x("//td[@class='product-name-column wrap-word']//a[contains(text(), '" + productName + "')]").click();
    }

    public void navigateTo_StorefrontProductPage(int tabNum) {
        button_SaveProduct.click();
        Selenide.sleep(1500);
        gearWheelOnTop.click();
        button_Preview.click();
        List<String> tabs = new ArrayList<>(Selenide.webdriver().object().getWindowHandles());
        Selenide.switchTo().window(tabs.get(tabNum));
        if ($(".cm-btn-success").exists()) {
            $(".cm-btn-success").click();
        }
    }


    //Меню "Модули -- Скачанные модули"
    private final SelenideElement menu_Addons = $("a[href$='dispatch=addons.manage'].main-menu-1__link");
    private final SelenideElement section_DownloadedAddons = $("#addons_downloaded_add_ons");
    private final SelenideElement gearwheelOfVideoGallery = $("tr#addon_ab__video_gallery button.btn.dropdown-toggle");
    private final SelenideElement sectionOfVideoGallery_GeneralSettings = $(".dropdown-menu a[href$='addon=ab__video_gallery&selected_section=settings']");
    private final SelenideElement tab_Settings = $("#settings");

    private void navigateTo_DownloadedAddonsPage() {
        checkMenuToBeActive("dispatch=addons.manage", menu_Addons);
        section_DownloadedAddons.click();
    }

    public VideoGallerySettings navigateTo_VideoGallerySettings() {
        navigateTo_DownloadedAddonsPage();
        gearwheelOfVideoGallery.click();
        sectionOfVideoGallery_GeneralSettings.click();
        tab_Settings.click();
        return new VideoGallerySettings();
    }


    //Меню "Настройки -- Общие настройки -- Внешний вид"
    private final SelenideElement menu_Settings = $("#administration");
    private final SelenideElement section_Appearance = $("a[href$='section_id=Appearance']");
    private final SelenideElement section_GeneralSettings = $("a[href$='section_id=General']");
    public SelenideElement setting_displayProductDetailsInTabs = $("#field___product_details_in_tab_288");
    public SelenideElement setting_quickView = $("#field___enable_quick_view_290");
    public SelenideElement setting_displayImagesAsGallery = $("#field___thumbnails_gallery_147");

    public void navigateTo_AppearanceSettings() {
        menu_Settings.click();
        section_GeneralSettings.click();
        section_Appearance.click();
    }
}