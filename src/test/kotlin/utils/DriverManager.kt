package utils

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.AutomationName
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL

object DriverManager {
    @JvmStatic
    private var driver: AppiumDriver<MobileElement>? = null

    fun getDriver(): AppiumDriver<MobileElement>? {
        if (driver == null) {
            val capability = DesiredCapabilities().also {
                it.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") +
                        "/src/test/resources/VodQA.apk")
                it.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ESPRESSO)
                it.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator")
            }
            val server = "http://localhost:4723/wd/hub"
            driver = AndroidDriver(URL(server), capability)
            return driver
        }
        return driver
    }
}