package screens

fun onNativeViewScreen(func: NativeViewScreen.() -> Unit) = NativeViewScreen().apply(func)
class NativeViewScreen : BaseScreen() {

}
