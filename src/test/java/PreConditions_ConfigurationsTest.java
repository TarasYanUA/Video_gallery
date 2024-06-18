import adminPanel.CsCartSettings;
import org.testng.annotations.Test;

public class PreConditions_ConfigurationsTest extends TestRunner {
    @Test
    public void setConfigurations(){
        //Устанавливаем CS-Cart настройки
        CsCartSettings csCartSettings = new CsCartSettings();
        csCartSettings.navigateTo_AppearanceSettings();
        if(!csCartSettings.setting_displayProductDetailsInTabs.isSelected()){
            csCartSettings.setting_displayProductDetailsInTabs.click();
        }
        if (!csCartSettings.setting_quickView.isSelected()){
            csCartSettings.setting_quickView.click();
        }
        if(!csCartSettings.setting_displayImagesAsGallery.isSelected()){
            csCartSettings.setting_displayImagesAsGallery.click();
        }
        csCartSettings.button_Save.click();
    }
}