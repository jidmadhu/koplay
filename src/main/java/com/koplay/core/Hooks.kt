package com.koplay.core

import io.cucumber.java.After
import io.cucumber.java.Before
import io.cucumber.java.Scenario
import org.slf4j.LoggerFactory

/**
 *
 * @author Jidhu Madhu on 24/08/2021.
 */
class Hooks {

    companion object {
        private val log = LoggerFactory.getLogger(Hooks::class.java)
    }

    /**
     * userOption need to pass on the browser arguments
     * Default  - empty value
     */
    private val userOptions: List<String> = try {
        System.getProperty("pi.options")?.split(",") ?: emptyList()
    } catch (e: Exception) {
        throw RuntimeException("Options are not valid. Please check the format -Dpi.options=--headless,options")
    }

    private val mode: RunType = try {
        RunType.valueOf(System.getProperty("pi.mode", "LOCAL").uppercase())
    } catch (e: Exception) {
        throw RuntimeException("Mode not acceptable - Valid values are ${RunType.values()}")
    }

    /**
     * Name of the Browser
     * Give Values in the Command line (-Ddrona.browser)
     * Valid values are chrome, firefox, edge, ie, appium
     * Default value - chrome
     */
    private val browsers: Browsers = try {
        Browsers.valueOf(System.getProperty("pi.browser", "CHROMEDRIVER").uppercase())
    } catch (e: Exception) {
        throw Exception("Browser Not Found - Valid Browsers are ${Browsers.values()}")
    }


    @Before(order = 0)
    fun beforeScenario(scenario: Scenario) {
        log.info("Creating Web Driver for ${browsers.name} running: ${mode.name}")
        try {
            val drivers = browsers.createDriver(mode, userOptions)
            DriverManager.setDriver(drivers)
        } catch (e: Exception) {
            log.error(e.message)
        }


    }

    @After(order = 0)
    fun afterScenario(scenario: Scenario) {
        log.info("Closing the Driver: ${browsers.name} running: ${mode.name}")
        DriverManager.closeDriver()
    }

}