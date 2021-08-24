package com.koplay.core

import com.microsoft.playwright.Browser
import com.microsoft.playwright.BrowserType
import com.microsoft.playwright.Playwright

/**
 *
 * @author Jidhu Madhu on 24/08/2021.
 */
enum class Browsers {

    CHROMEDRIVER {
        override fun createDriver(mode: RunType, userOptions: List<String>): Browser {
            return when (mode) {
                RunType.LOCAL -> {
                    val playwright = Playwright.create()
                    playwright.chromium().launch(BrowserType.LaunchOptions().setHeadless(false))
                }
                RunType.REMOTE -> {
                    throw Exception("No Implementation on Remote Run")
                }
            }
        }

    };

    abstract fun createDriver(mode: RunType, userOptions: List<String>): Browser
}