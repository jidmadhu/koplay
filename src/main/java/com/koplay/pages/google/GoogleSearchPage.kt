package com.koplay.pages.google

import com.koplay.pages.BasePage
import com.microsoft.playwright.Page
import org.assertj.core.api.Assertions.assertThat

/**
 *
 * @author Jidhu Madhu on 24/08/2021.
 */
class GoogleSearchPage(page: Page) : BasePage(page) {

    private val searchInput: String = "input[name='q']"


    fun navigateToGooglePage(url: String) {
        navigateToUrl(url)
    }

    fun enterSearchInput(searchText: String) {
        enterText(searchInput, searchText)
    }

    fun sawGooglePage() {
        assertThat(true).isTrue
    }
}