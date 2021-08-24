package com.koplay.pagedef

import com.koplay.core.DriverManager
import com.koplay.pages.google.GoogleSearchPage
import com.koplay.pages.yahoo.YahooPage
import com.koplay.util.PropertyReader
import com.microsoft.playwright.Page
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then

/**
 *
 * @author Jidhu Madhu on 24/08/2021.
 */
class SearchDef {

    private val page: Page = DriverManager.getDriver().newPage()


    @Given("The User is navigate to {string} Home page")
    fun navigateToSearchPage(searchPage: String) {
        when (searchPage) {
            "google" -> GoogleSearchPage(page).navigateToGooglePage(PropertyReader.getProperty("google.url"))
            "yahoo" -> YahooPage(page).navigateToYahoo(PropertyReader.getProperty("yahoo.url"))
        }
    }

    @And("The User enter {string} on {string} Search page")
    fun enterSearchWord(textSearch: String, searchPage: String) {
        when (searchPage) {
            "google" -> GoogleSearchPage(page).enterSearchInput(textSearch)
            "yahoo" -> YahooPage(page).enterSearchText(textSearch)
        }
    }

    @And("The User press Enter Key on {string} Search page")
    fun pressEnterKey(searchPage: String) {
        when (searchPage) {
            "google" -> GoogleSearchPage(page)
            "yahoo" -> YahooPage(page)
            else -> throw Exception("Not found this Page $searchPage")
        }.enterKeyPress()
    }

    @Then("The User can see the results in {string} Home page")
    fun canSeeTheSearchResults(searchPage: String) {
        when (searchPage) {
            "google" -> GoogleSearchPage(page).sawGooglePage()
            "yahoo" -> YahooPage(page).seeResultsInYahoo()
        }
    }
}