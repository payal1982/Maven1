package Maven1;

import org.openqa.selenium.By;
import org.testng.Assert;
//import org.testng.annotations;
import org.testng.annotations.Test;

public class TestSuite extends BaseTest
{
    @Test//this is a test method
    public void verifyUserIsAbleToRegisterSuccessfully()
    {
        ClickOnElement(By.xpath("//a[text()='Register']"));
        ClickOnElement(By.xpath("//input[@value='F']"));
        EnterText(By.xpath("//input[@id='FirstName']"),"Payal");
        EnterText(By.xpath("//input[@name='LastName']"),"Patel");
        SelectDayOfBirth(By.xpath("//select[@name='DateOfBirthDay']"),"15");
        SelectMonthOfBirth(By.xpath("//select[@name='DateOfBirthMonth']"),10);
        SelectYearOfBirth(By.xpath("//select[@name='DateOfBirthYear']"),"1983");
        Email(By.xpath("//input[@id='Email']"),"payal");
        EnterText(By.xpath("//input[@name='Company']"),"Patel's Corner");
        ClickOnElement(By.xpath("//input[@id='Newsletter']"));
        EnterText(By.xpath("//input[@id='Password']"),"test123");
        EnterText(By.xpath("//input[@id='ConfirmPassword']"),"test123");
        ClickOnElement(By.xpath("//input[@id='register-button']"));
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class='result']")),"Your registration completed");

    }
    @ Test//method
    public void VerifyUserIsAbleToCompareProducts()
    {
        ClickOnElement(By.xpath("//div[@data-productid='1']/child::div[2]/child::div[3]/child::div[2]/input[@value='Add to compare list']"));
        //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
       // WaitforElementToBeSelected(By.xpath("//div[@data-productid='43']/child::div[2]/child::div[3]/child::div[2]/input[@value='Add to compare list']"),20);
        ClickOnElement(By.xpath("//a[contains(text(),'product comparison')]"));
        ClickOnElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        ClickOnElement(By.xpath("//div[@data-productid='43']/child::div[2]/child::div[3]/child::div[2]/input[@value='Add to compare list']"));
        ClickOnElement(By.xpath("//a[contains(text(),'product comparison')]"));
        Assert.assertEquals(getTextFromElement(By.xpath("//h1[text()='Compare products']")),"Compare products");
    }
    @Test//method
    private void VerifyUserHasNoProductsToCompare()
    {
        VerifyUserIsAbleToCompareProducts();
        ClickOnElement(By.xpath("//a[text()='Clear list']"));
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class='no-data']")),"You have no items to compare.");
    }
    @Test//method
    private void UserSelectsBooksAndSortsThemInAscendingPriceOrder()
    {
        ClickOnElement(By.xpath("//div[@class='header-menu']//ul[@class='top-menu']/li[5]/a[contains(text(),'Books')]"));
        SelectByVisibleText(By.xpath("//select[@id='products-orderby']"),"Price: Low to High");
        Display(By.xpath("//select[@id='products-pagesize']"),"http://demo.nopcommerce.com/books?orderby=10&pagesize=3");
        String a=getTextFromElement(By.xpath("//div[@data-productid='39']/child::div[2]/child::div[3]/child::div/span[@class='price actual-price']"));
        String a1=a.replace("$"," ");//removes $ and replaces with space
        String a2=a1.trim();//removes the spaces
        Double a3=Double.parseDouble(a2);//converts string to double
       // System.out.println(a3);
        String b =getTextFromElement(By.xpath("//div[@data-productid='38']/child::div[2]/child::div[3]/child::div/span[@class='price actual-price']"));
        String b1=b.replace("$"," ");//removes $ and replaces with space
        String b2=b1.trim();
        Double b3=Double.parseDouble(b2);
       // System.out.println(b3);
        Assert.assertTrue(a3<b3);//compares the condition
    }
    @Test//method
    public void ProductAddedToCart()
    {
        ClickOnElement(By.xpath("//div[@class='header-menu']/child::ul[1]/li[2]"));
        ClickOnElement(By.xpath("//div[@class='item-grid']//child::div[1]//a[contains(text(),'Camera & photo')]"));
        ClickOnElement(By.xpath("//div[@class='item-grid']/child::div[2]/child::div/child::div[2]/child::div[3]/child::div[2]/input[@value='Add to cart']"));
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@id='bar-notification']/p")),"The product has been added to your shopping cart");
        ClickOnElement(By.xpath("//div[@id='bar-notification']/p/a"));
        Assert.assertEquals(getTextFromElement(By.xpath("//table[@class='cart']/tbody/tr/child::td[4]/a")),"Apple iCam");
    }

    //should have been included in seperate project, but to have a continuity, i have added this here.
    // Also i can check whether the reusable method is running properly or not.
    // So the before method runs here as a part of the test suite. Please ignore it.
    @Test//method
    public void PrintRandomNumber()
    {
        int i=1;
        do {
            GenerateRandomNumber(11,40);
            i++;
        }
        while (i<=3);

    }
}
