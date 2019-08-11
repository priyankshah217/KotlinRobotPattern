package screens

import io.appium.java_client.MobileBy

fun onHomeScreen(func: HomeScreen.() -> Unit) = HomeScreen().apply(func)

class HomeScreen : BaseScreen() {
    private val nativeViewButtonsScreen = MobileBy.androidDataMatcher("{name:'hasEntry',args:['title','chainedView']}")
    fun selectNativeView():NativeViewScreen {
        clickOn(nativeViewButtonsScreen)
        return NativeViewScreen()
    }
}