package screens


fun onViewScreen(func: ViewScreen.() -> Unit) = ViewScreen().apply { func() }
class ViewScreen : BaseScreen() {


}