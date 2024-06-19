package adminPanel;

/*
Устанавливаем CS-Cart настройки:
* Показывать мини-иконки в виде галереи --      нет
* Показывать информацию о товаре во вкладках -- да
* Включить быстрый просмотр --                  да
*/

public interface SetCsCartSettings_NoGallery {
    default void setCsCartSettings_NoGallery() {
        CsCartSettings csCartSettings = new CsCartSettings();
        csCartSettings.navigateTo_AppearanceSettings();
        if (csCartSettings.setting_displayImagesAsGallery.isSelected()) {
            csCartSettings.setting_displayImagesAsGallery.click();
        }
        if (!csCartSettings.setting_displayProductDetailsInTabs.isSelected()) {
            csCartSettings.setting_displayProductDetailsInTabs.click();
        }
        if (!csCartSettings.setting_quickView.isSelected()) {
            csCartSettings.setting_quickView.click();
        }
        csCartSettings.button_SaveSettings.click();
    }
}