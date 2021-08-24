package runners

import io.cucumber.testng.CucumberOptions

/**
 *
 * @author Jidhu Madhu on 24/08/2021.
 */
@CucumberOptions(
    features = ["src/test/java/features"],
    glue = ["classpath:com/koplay"],
    plugin = ["html:target/cucumber-report/cucumberReport.html", "pretty"]
)
class SearchRunner : BaseRunner() {
}