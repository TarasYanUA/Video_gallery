import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;

public class PreConditions_ConfigurationsTest extends TestRunner {
    @Test
    public void setConfigurations(){
        //Устанавливаем CS-Cart настройки
        $("#elm_menu_settings").hover();
        $("#elm_menu_settings_Appearance").click();
        SelenideElement displayProductDetailsInTabs = $("#field___product_details_in_tab_288");
        if(!displayProductDetailsInTabs.isSelected()){
            displayProductDetailsInTabs.click();
        }
        SelenideElement quickView = $("#field___enable_quick_view_290");
        if (!quickView.isSelected()){
            quickView.click();
        }
        SelenideElement displayImagesAsGallery = $("#field___thumbnails_gallery_147");
        if(!displayImagesAsGallery.isSelected()){
            displayImagesAsGallery.click();
        }
        $(".cm-submit").click();
    }
}
