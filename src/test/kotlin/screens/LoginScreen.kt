package screens

import io.appium.java_client.MobileBy

fun onLoginScreen(func: LoginScreen.() -> Unit) = LoginScreen().apply(func)

class LoginScreen : BaseScreen() {
    private val userNameTextBox = MobileBy.AndroidViewTag("username")
    private val passwordTextBox = MobileBy.AndroidViewTag("password")
    private val loginConfirmButton = MobileBy.className("android.widget.Button")


    fun login(userName: String, password: String) {
        enterText(userNameTextBox, userName)
        enterText(passwordTextBox, password)
        clickOn(loginConfirmButton)
    }
}