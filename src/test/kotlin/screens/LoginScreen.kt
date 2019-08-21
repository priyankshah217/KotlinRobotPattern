package screens

import io.appium.java_client.MobileBy

fun onLoginScreen(func: LoginScreen.() -> Unit) = LoginScreen().apply(func)

class LoginScreen : BaseScreen() {
    private val userNameTextBox = MobileBy.AndroidViewTag("username")
    private val passwordTextBox = MobileBy.AndroidViewTag("password")
    private val loginConfirmButton = MobileBy.xpath("//com.facebook.react.views.text.ReactTextView[@text='LOG IN']")
//    private val loginConfirmButton =MobileBy.className("android.widget.Button")


    infix fun login(func: HomeScreen.() -> Unit): HomeScreen {
        clickOn(loginConfirmButton)
        return HomeScreen().apply(func)
    }

    fun username(userName: String) {
        enterText(userNameTextBox, userName)
    }

    fun password(password: String) {
        enterText(passwordTextBox, password)
    }
}