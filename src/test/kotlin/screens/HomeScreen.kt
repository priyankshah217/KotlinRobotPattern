package screens

import io.appium.java_client.MobileBy

fun onHomeScreen(func: HomeScreen.() -> Unit) = HomeScreen().apply(func)
class HomeScreen : BaseScreen() {
    //    private val nativeViewButtonsScreen = MobileBy.AccessibilityId("chainedView")
    private val nativeViewButtonsScreen = MobileBy.AndroidViewTag("Chained View")

    infix fun selectNativeView(func: NativeViewScreen.() -> Unit): NativeViewScreen {
        clickOn(nativeViewButtonsScreen)
        return NativeViewScreen().apply(func)
    }

    fun isLoginSuccessful(): Boolean? {
        return elementIsPresent(nativeViewButtonsScreen)
    }

}