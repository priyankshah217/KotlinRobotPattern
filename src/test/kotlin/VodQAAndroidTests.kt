import org.testng.annotations.Test
import screens.onHomeScreen
import screens.onLoginScreen
import screens.onNativeViewScreen

class VodQAAndroidTests : BaseTest() {

    @Test
    fun testNativeView() {
        onLoginScreen {
            username("admin")
            password("admin")
        } login {
            verifyThat { isLoginSuccessful() }
        }
        onHomeScreen {
            selectNativeView {}
        }
        onNativeViewScreen {
            
        }
    }
}