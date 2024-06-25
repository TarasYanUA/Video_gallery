import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"hooks", "steps"},
        tags = "@30",
        plugin = {"pretty", "html:target/cucumber_target.html", "json:target/cucumber.json"}
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}