import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"hooks", "steps"},
        plugin = {"pretty", "html:target/cucumber_target.html", "json:target/cucumber.json"},
        tags = "@70_Autoplay_IconTypeNone_AllPages"
        //@10_AddVideo or @20_Gallery01_VerticalView or @30_Gallery02_HorizontalView
        // or @40_NoGallery01_HorizontalView or @50_NoGallery02_VerticalView
        // or @60_Autoplay_IconTypeNone_NoProductList or @70_Autoplay_IconTypeNone_AllPages
)

public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}