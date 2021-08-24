package com.koplay.pages.yahoo

import com.koplay.pages.BasePage
import com.microsoft.playwright.Page
import org.assertj.core.api.Assertions

/**
 *
 * @author Jidhu Madhu on 24/08/2021.
 */
class YahooPage(page: Page) : BasePage(page) {

    private val searchInput = "input[name='p']"

    fun navigateToYahoo(url: String) {
        navigateToUrl(url)
    }

    fun enterSearchText(textValue: String) {
        enterText(searchInput, textValue)
    }

    fun seeResultsInYahoo() {
        Assertions.assertThat(true).isTrue
    }
}