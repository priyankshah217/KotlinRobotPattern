import org.testng.annotations.Test
import screens.onHomeScreen
import screens.onLoginScreen

class VodQAAndroidTests : BaseTest() {

    @Test
    fun testNativeView() {
        onLoginScreen {
            login("admin", "admin")
        }
        onHomeScreen {
            selectNativeView()
        }
    }
}