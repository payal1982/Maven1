package Maven1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserSetup extends Utils
{
    LoadProp loadProp=new LoadProp();
    public void browserSelector()
    {
        String browser=loadProp.getProperty("browser");
     if(browser.equalsIgnoreCase("Chrome"))
        {
        System.setProperty("webdriver.chrome.driver","src\\test\\resources\\BrowserDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("IE"))
    {
        System.setProperty("webdriver.ie.driver","src\\test\\resources\\BrowserDriver\\IEDriverServer.exe");
        driver=new InternetExplorerDriver();
    }
    else if(browser.equalsIgnoreCase("FireFox"))
     {
         //System.setProperty("webdriver.firefox.marionette","src\\test\\resources\\BrowserDriver\\geckodriver.exe");
//ignore the above line, as webdriver executes itself. no need to set the system property for firefox
         driver= new FirefoxDriver();
     }
     else
     {
         System.out.println("Wrong browser name or empty2" + browser);
     }
}
}
