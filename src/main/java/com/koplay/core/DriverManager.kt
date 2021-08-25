package com.koplay.core

import com.microsoft.playwright.Browser

/**
 *
 * @author Jidhu Madhu on 24/08/2021.
 */
class DriverManager {

    companion object {

        private val driver: ThreadLocal<Browser> = ThreadLocal()

        fun getDriver(): Browser {
            return driver.get()
        }

        fun setDriver(driver: Browser) {
            DriverManager.driver.set(driver)
        }

        fun closeDriver() {
            if (driver.get() != null) {
                driver.get().close()
            }
        }
    }
}