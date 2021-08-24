package com.koplay.pages

import com.koplay.core.AbstractFunctions
import com.microsoft.playwright.Page
import org.slf4j.LoggerFactory

/**
 *
 * @author Jidhu Madhu on 24/08/2021.
 */
open class BasePage(page: Page) : AbstractFunctions(page) {

    private val log = LoggerFactory.getLogger(BasePage::class.java)


}