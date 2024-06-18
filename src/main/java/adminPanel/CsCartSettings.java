package adminPanel;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import static com.codeborne.selenide.Selenide.*;

public class CsCartSettings implements CheckMenuToBeActive {
    public CsCartSettings() {
        super();
    }


    public SelenideElement button_Save = $(".btn.btn-primary.cm-submit");
    public SelenideElement popupWindow = $(".ui-dialog-title");
    public SelenideElement gearWheelOnTop = $(".nav__actions-bar .dropdown-icon--tools");
    public SelenideElement button_Preview = $x("//a[contains(text(), 'Предпросмотр')]");

    public void navigateTo_Storefront() {
        String currentUrl = WebDriverRunner.url();
        String[] url = currentUrl.split("admin.php");
        executeJavaScript("window.open('" + url[0] + "')");
    }

    //Меню "Товары"
    private final  SelenideElement menu_Products = $("a[href$='dispatch=products.manage'].main-menu-1__link");
    private final  SelenideElement section_Categories = $("#products_categories");

    private final  SelenideElement menu_Marketing = $("a[href$='dispatch=promotions.manage'].main-menu-1__link");
    private final  SelenideElement section_PromotionsAndDiscounts = $("#marketing_promotions");

    public void navigateTo_CategoryPage() {
        checkMenuToBeActive("dispatch=products.manage", menu_Products);
        section_Categories.click();
    }


    //Меню "Модули -- Скачанные модули"
    private final  SelenideElement menu_Addons = $("a[href$='dispatch=addons.manage'].main-menu-1__link");
    private final  SelenideElement section_DownloadedAddons = $("#addons_downloaded_add_ons");
    private final SelenideElement gearwheelOfVideoGallery = $("tr#addon_ab__video_gallery button.btn.dropdown-toggle");
    private final SelenideElement sectionOfVideoGallery_GeneralSettings = $("a[href$='addon=ab__video_gallery&selected_section=settings']");
    private final  SelenideElement tab_Settings = $("#settings");
    public SelenideElement field_SearchOnTop = $(".cm-autocomplete-off.search__input");
    public SelenideElement productTemplate = $("#elm_details_layout");

    private final  SelenideElement menu_Settings = $("#administration");
    private final  SelenideElement section_Appearance = $("a[href$='section_id=Appearance']");
    private final  SelenideElement section_GeneralSettings = $("a[href$='section_id=General']");
    public SelenideElement setting_QuickView = $x("//input[contains(@id, 'field___enable_quick_view_')]");
    public SelenideElement category_Notebooks = $(".table-wrapper a[href$='category_id=169']");

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
    public SelenideElement setting_displayProductDetailsInTabs = $("#field___product_details_in_tab_288");
    public SelenideElement setting_quickView = $("#field___enable_quick_view_290");
    public SelenideElement setting_displayImagesAsGallery = $("#field___thumbnails_gallery_147");

    public void navigateTo_AppearanceSettings() {
        menu_Settings.click();
        section_GeneralSettings.click();
        section_Appearance.click();
    }


}