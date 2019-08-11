import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import utils.DriverManager

open class BaseTest {

    @BeforeMethod
    fun setUp() {
        DriverManager.getDriver()
    }

    @AfterMethod
    fun tearDown(){
        DriverManager.getDriver()?.quit()
    }
}
