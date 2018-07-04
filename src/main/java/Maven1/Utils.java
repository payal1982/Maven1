package Maven1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;

public class Utils extends BasePage
{
    //reusable method to click on the elements on webpage
    public static void ClickOnElement(By by)
    {
         driver.findElement(by).click();
    }
    //reusable method to enter text
    public static void EnterText(By by,String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    public static void SelectDayOfBirth(By by,String str)
    {
        Select day=new Select(driver.findElement(by));
        day.selectByVisibleText(str);
    }
    public static void SelectMonthOfBirth(By by,int a)
    {
        Select month=new Select(driver.findElement(by));
        month.selectByIndex(a);
    }
    public static void SelectYearOfBirth(By by,String str)
    {
        Select month=new Select(driver.findElement(by));
        month.selectByValue(str);
    }
    public static void Email(By by,String str)
    {
        java.util.Date date=new java.util.Date();//get the current date and time from the system
       SimpleDateFormat sdf=new SimpleDateFormat("ddMMyyHHmmss");//give the format for the date
       String formatteddate=sdf.format(date);//converts the dte in the format we require
       // Timestamp time = new Timestamp(System.currentTimeMillis());
        driver.findElement(by).sendKeys(str + formatteddate+"@yahoo.com");
    }
//    public static void WaitForElementToBeClickable(By by, int time)
//    {
//        WebDriverWait wait=new WebDriverWait(driver,time);
//        wait.until(ExpectedConditions.elementToBeClickable(by));
//    }
    public static String getTextFromElement(By by)
    {
        return driver.findElement(by).getText() ;
    }
//    public static void WaitforElementToBeSelected(By by,int time)
//    {
//        WebDriverWait wait=new WebDriverWait(driver,time);
//       wait.until(ExpectedConditions.elementToBeSelected(by));
//
//    }
    public static void SelectByVisibleText(By by, String str)
    {
         Select sort=new Select(driver.findElement(by));
         sort.selectByVisibleText(str);
    }
    public static void Display(By by,String str)
    {
        Select display=new Select(driver.findElement(by));
        display.selectByValue(str);
    }
    public static void GenerateRandomNumber(int min, int max)
    {
        Random rand=new Random();
        int randomnum=rand.nextInt((max-min)+1)+min;//nextint is provided by random is exclusive of top value , so we added 1
        System.out.println(randomnum);
    }
}
