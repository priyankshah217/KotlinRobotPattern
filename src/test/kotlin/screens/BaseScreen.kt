package screens

import com.google.common.truth.Truth.assertThat
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import utils.DriverManager


abstract class BaseScreen {


    fun clickOn(by: By?) {
        getElement(by)?.click()
    }

    fun enterText(by: By?, value: String) {
        val webElement = getElement(by)
        webElement?.clear()
        webElement?.sendKeys(value)
    }

    fun waitForElementToBeClickable(by: By?): WebElement {
        val driver: WebDriver? = DriverManager.getDriver()
        val wait = WebDriverWait(driver, 30)
        return wait.until(ExpectedConditions.elementToBeClickable(by))
    }

    private fun getElement(by: By?): WebElement? {
        val mobileElement = waitForElementToBeClickable(by)
        return if (mobileElement.isDisplayed) mobileElement else null
    }

    fun elementIsPresent(by: By?): Boolean? {
        return getElement(by) != null
    }

    fun elementIsNotPresent(by: By?): Boolean? {
        return !elementIsPresent(by)!!
    }

    infix fun verifyThat(func: () -> Boolean?): BaseScreen = this.apply {
        assertThat(func()).isTrue()
    }

}
