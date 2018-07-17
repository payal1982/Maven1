package Maven1;

//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.util.concurrent.TimeUnit;

//this method has the tests that run before the actual test cases
public class BaseTest extends Utils
{
   BrowserSetup browserSetup=new BrowserSetup();
    @BeforeMethod
    public void openBrowser()
    {
        browserSetup.browserSelector();
//         System.setProperty("webdriver.chrome.driver","src\\test\\resources\\BrowserDriver\\chromedriver.exe");
//        driver=new ChromeDriver();//sets the driver to Chrome driver
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//tells the driver to implicit wait for 20 sec for each element
        driver.manage().window().maximize();//to maximize the screen
        driver.get("http://demo.nopcommerce.com/");// opens the mentioned website
    }

    @AfterMethod
    public void onFailure(ITestResult result)//ITestResult is an interface
    {
        if(ITestResult.FAILURE==result.getStatus())//compares if the result is failed with the itest result
        {
            System.out.println("Test Failed.");
            takeScreenShot(result.getName());//uses the screenshot method from utils class
        }
        closeBrowser();
    }
    public void closeBrowser()
    {
        driver.quit();//closes all the windows opened by the current browser
    }



}
