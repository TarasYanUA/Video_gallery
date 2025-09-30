package steps.adminPanel;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class CsCartSettingsSteps {

    public CsCartSettingsSteps() {super();}

    CsCartSettings csCartSettings = new CsCartSettings();


    @When("Переходим на страницу редактирования товара")
    public void navigateTo_ProductPage() {
        csCartSettings.navigateTo_ProductPage();
    }

    @And("Переходим в настройки модуля")
    public void navigateTo_VideoGallerySettings() {
        csCartSettings.navigateTo_VideoGallerySettings();
    }

    @And("Переходим на страницу настроек темы UniTheme")
    public UniThemeSettings navigateTo_UniThemeSettings() {
        return csCartSettings.navigateTo_UniThemeSettings();
    }

    @And("CS-Cart настройки: Показывать мини-иконки {string} галереи, Показывать информацию о товаре {string} вкладок, Включить быстрый просмотр")
    public void setCsCartSettings_WithOrWithoutOptions(String galleryOption, String tabsOption) {
        csCartSettings.setCsCartSettings_WithOrWithoutOptions(galleryOption, tabsOption);
    }
}