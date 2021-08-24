package com.koplay.core

import com.microsoft.playwright.Page
import org.slf4j.LoggerFactory

/**
 *
 * @author Jidhu Madhu on 24/08/2021.
 */
abstract class AbstractFunctions(private val page: Page) {

    private val log = LoggerFactory.getLogger(AbstractFunctions::class.java)


    fun navigateToUrl(url: String, info: String = "Navigate to $url") {
        log.info(info)
        page.navigate(url)
    }

    fun clickOnElement(elementLocator: String, info: String = "Clicking element: $elementLocator") {
        log.info(info)
        page.waitForSelector(elementLocator)
        page.click(elementLocator)
    }

    fun enterText(
        elementLocator: String,
        textValue: String,
        info: String = "Entering the text: $textValue at locator: $elementLocator"
    ) {
        log.info(info)
        page.waitForSelector(elementLocator)
        page.fill(elementLocator, textValue)
    }

    fun getInnerText(elementLocator: String, info: String = "Getting Inner Text Value for $elementLocator"): String {
        page.waitForSelector(elementLocator)
        log.info(info)
        return page.innerText(elementLocator)
    }

    fun enterKeyPress(info: String = "Pressing Enter Key") {
        log.info(info)
        page.keyboard().down("Enter")
    }

}