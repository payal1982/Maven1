package Maven1;

//import com.sun.jna.platform.FileUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class Utils extends BasePage
{
    //reusable method to click on the elements on webpage
    public static void clickOnElement(By by)
    {
         driver.findElement(by).click();//finds the elements and clicks on it
    }
    //reusable method to enter text
    public static void enterText(By by, String text)
    {
        driver.findElement(by).sendKeys(text);//finds elements and enters text in it
    }
    //method to select from drop down menu by text
    public static void selectByVisibleText(By by,String str)
    {
        Select day=new Select(driver.findElement(by));//finds and stores the element in a variable
        day.selectByVisibleText(str);//selects the data by visible text
    }
    //method to select from drop down menu by index
    public static void selectByIndex(By by, int a)
    {
        Select month=new Select(driver.findElement(by));//finds and stores the element in a variable
        month.selectByIndex(a);//selects the data by index
    }
    //method to select from drop down menu by index
    public static void selectByValue(By by, String str)
    {
        Select month=new Select(driver.findElement(by));//finds and stores the element in a variable
        month.selectByValue(str);//selects the data by value
    }
    //method to create timestamp for use in email
    public static void email(By by, String str)
    {
        java.util.Date date=new java.util.Date();//get the current date and time from the system
       SimpleDateFormat sdf=new SimpleDateFormat("ddMMyyHHmmss");//give the format for the date
       String formatteddate=sdf.format(date);//converts the dte in the format we require
        Timestamp time = new Timestamp(System.currentTimeMillis());
        driver.findElement(by).sendKeys(str + formatteddate+"@yahoo.com");//using concanitation for autogeneration of mail
    }
    // wait for element to be clickable
    public static void waitForElementToBeClickable(By by, int time)
    {
        WebDriverWait wait=new WebDriverWait(driver,time);//variable assigned
        wait.until(ExpectedConditions.elementToBeClickable(by));//expected condition for the wait
    }
    //gets string from the element
    public static String getTextFromElement(By by)

    {
        return driver.findElement(by).getText() ;//returns the string from the element
    }
    // waits for element to be selected
    public static void waitforElementToBeSelected(By by, int time)
    {
        WebDriverWait wait=new WebDriverWait(driver,time);//variable assigned
       wait.until(ExpectedConditions.elementToBeSelected(by));//expected condition for the wait

    }
    //method to sort the values by visible text
    public static void sortByVisibleText(By by, String str)
    {
         Select sort=new Select(driver.findElement(by));//variable assigned
         sort.selectByVisibleText(str);//sorts by string
    }
    //method to sort the values by visible text
    public static void display(By by, String str)
    {
        Select display=new Select(driver.findElement(by));//variable assigned
        display.selectByValue(str);//sorts by string
    }
    public static void generateRandomNumber(int min, int max)
    {
//        Random rand=new Random();
//        int randomnum=rand.nextInt((max-min)+1)+min;//nextint is provided by random is exclusive of top value , so we added 1
//        System.out.println(randomnum);
    }
    //waits for element to be invisible
    public static void waitForInvisibilityOfElementsLocated(By by,int time)
    {
        WebDriverWait wait=new WebDriverWait(driver,time);//variable assigned
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        //expected condition specified for the elements to be invisible
    }
    //waits for element to be visible
    public static void waitForVisibilityOfElementLocated(By by, int time)
    {
        WebDriverWait wait=new WebDriverWait(driver,time);//variable assigned
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        //expected condition specified for the elements to be visible
    }
    //clears data from the element
    public static void clearDataFromElement(By by)
    {
        driver.findElement(by).clear();//finds element and clears the data in it
    }
    //alert to be dismissed
    public static void dismissAlert()
    {
        driver.switchTo().alert().dismiss();//driver will switch to the alert and cancel it
    }
//    public static void elementIsDisplayed(By by)
//    {
//        driver.findElement(by).isDisplayed();
//    }
    //method to check the element is present,boolean because it returns the value true/false
    protected boolean isElementPresent(By by){
        try{
            driver.findElement(by);//if element is found, it returns true
            return true;
        }
        catch(NoSuchElementException e){//if element is not found, it will return false
            return false;
        }

    }
    //method to take screen shot
    public static void takeScreenShot(String name)
    {
        try {
            TakesScreenshot ts=((TakesScreenshot)driver);//type casting. TakesScreenshot is an interface, so cannot create its object
            File source=ts.getScreenshotAs(OutputType.FILE);//saves the screen shot in buffer memory
            FileUtils.copyFile(source,new File("src\\test\\resources\\ScreenShot\\" + name+".jpg"));//copies files from buffer to our destination file
            //also name is parameterized, so user can give name to the file as per choice
            System.out.println("Screenshot taken.");
        } catch (IOException e) {
            System.out.print("The error we got when taking screenshot:" );
            //in case if there is exception the below message is printed with the exception
            e.printStackTrace();
        }
    }
//    public static char extractParticularCharacterFromString(By by, int a)
//    {
//       String element= driver.findElement(by).getText();
//       char c=element.charAt(a);
//       return c;
//
//    }
    public void printRandomNumber()
    {
         int i=1;
        do {
              generateRandomNumber(11,40);//generates random number starting from 11 to 40
              i++;
         }
         while (i<=3);//generates 3 numbers

}
}
