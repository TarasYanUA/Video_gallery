package adminPanel;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class VideoGallerySettings {
    public VideoGallerySettings(){super();}

    public SelenideElement setting_EnableVerticalOutput = $("input[id*='addon_option_ab__video_gallery_vertical_']");
    public SelenideElement button_SaveSettings = $(".cm-addons-save-settings");
}
