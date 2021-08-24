package runners

import io.cucumber.testng.AbstractTestNGCucumberTests
import org.testng.annotations.DataProvider

/**
 *
 * @author Jidhu Madhu on 24/08/2021.
 */
open class BaseRunner : AbstractTestNGCucumberTests() {

    @DataProvider(parallel = true)
    override fun scenarios(): Array<Array<Any>> {
        return super.scenarios()
    }
}