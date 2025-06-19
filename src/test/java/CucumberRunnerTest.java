import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"hooks", "steps"},
        plugin = {"pretty", "html:target/cucumber_target.html", "json:target/cucumber.json"},
        tags = "@10_AddVideo or @20_Gallery01_VerticalView or @30_Gallery02_HorizontalView")
/*
@10_AddVideo or
@20_Gallery01_VerticalView or @30_Gallery02_HorizontalView or
@40_NoGallery01_HorizontalView or @50_NoGallery02_VerticalView or
@60_Autoplay01_IconTypeNone_NoProductList or @65_Autoplay02_IconTypeNone_ProductList or @70_Autoplay03_IconTypeManualIcon or @80_Autoplay04_AllProductTemplates or
@90_VideoAsDefaultProductImage
*/
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}