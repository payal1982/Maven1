package Maven1;

//import com.sun.jna.platform.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
//import org.testng.annotations;
import org.testng.annotations.Test;

import java.io.File;

public class TestSuite extends BaseTest
{
    @Test(priority = 1)//this is a test method
    public void verifyUserIsAbleToRegisterSuccessfully()
    {
        clickOnElement(By.xpath("//a[text()='Register']"));//clicks on register button
        clickOnElement(By.xpath("//input[@value='F']"));//selects female radio button
        enterText(By.xpath("//input[@id='FirstName']"),"Payal");//enters first name
        enterText(By.xpath("//input[@name='LastName']"),"Patel");//enters last name
        selectByVisibleText(By.xpath("//select[@name='DateOfBirthDay']"),"15");//selects day of birth from drop down menu
        selectByIndex(By.xpath("//select[@name='DateOfBirthMonth']"),10);//selects month of birth from drop down menu
        selectByValue(By.xpath("//select[@name='DateOfBirthYear']"),"1983");//selects year of birth from drop down menu
        email(By.id("Email"),"Payal");//enters email id
        enterText(By.xpath("//input[@name='Company']"),"Patel's Corner");//enters company name
        clickOnElement(By.xpath("//input[@id='Newsletter']"));//deselects newsletter check box
        enterText(By.xpath("//input[@id='Password']"),"test123");//enters password
        enterText(By.xpath("//input[@id='ConfirmPassword']"),"test123");//confirms password
        clickOnElement(By.xpath("//input[@id='register-button']"));//clicks on register button
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class='result']")),"Your registration completed");
        //asserts that user receives confirmation message once the registration is complete
    }
    @ Test(priority=3)//method
    public void verifyUserIsAbleToCompareProducts ()
    {
        clickOnElement(By.xpath("//div[@data-productid='1']/child::div[2]/child::div[3]/child::div[2]/input[@value='Add to compare list']"));
        //1st product added to compare list
         waitForVisibilityOfElementLocated(By.xpath("//div[@id='bar-notification']"),20);
         //waiting for the visibility of the green bar on the top
        waitForInvisibilityOfElementsLocated(By.xpath("//div[@id='bar-notification']"),20);
        //waiting for the invisibility of the green bar on the top
        clickOnElement(By.xpath("//div[@data-productid='43']/child::div[2]/child::div[3]/child::div[2]/input[@value='Add to compare list']"));
        //2nd product added to compare list
        waitForVisibilityOfElementLocated(By.xpath("//div[@id='bar-notification']"),20);
        //waiting for the visibility of the green bar on the top
        clickOnElement(By.xpath("//a[contains(text(),'product comparison')]"));//clicks on the product comparision list
        Assert.assertEquals(getTextFromElement(By.xpath("//h1[text()='Compare products']")),"Compare products");
        //verify that both the products are visible in the comparision list
    }
    @Test(priority=4)//method
    public void verifyUserHasNoProductsToCompare()
    {
        verifyUserIsAbleToCompareProducts();//method reused, as this method is extension of the mentioned method
        clickOnElement(By.xpath("//a[text()='Clear list']"));//clicks on clear list
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class='no-data']")),"You have no items to compare.");
        //verify that the compare list is empty
    }
    @Test(priority=5)//method
    public void userSelectsBooksAndSortsThemInAscendingPriceOrder()
    {
        clickOnElement(By.xpath("//div[@class='header-menu']//ul[@class='top-menu']/li[5]/a[contains(text(),'Books')]"));
        //clicks on books in the top bar
        sortByVisibleText(By.xpath("//select[@id='products-orderby']"),"Price: Low to High");
        //sorts the books in the ascending order of price from drop down menu
        display(By.xpath("//select[@id='products-pagesize']"),"http://demo.nopcommerce.com/books?orderby=10&pagesize=3");
        //selects the option to display 3 books
        String a=getTextFromElement(By.xpath("//div[@data-productid='39']/child::div[2]/child::div[3]/child::div/span[@class='price actual-price']"));
        //stores actual price of the product in a string
        String a1=a.replace("$"," ");//removes $ and replaces with space
        String a2=a1.trim();//removes the spaces
        Double a3=Double.parseDouble(a2);//converts string to double
        String b =getTextFromElement(By.xpath("//div[@data-productid='38']/child::div[2]/child::div[3]/child::div/span[@class='price actual-price']"));
        String b1=b.replace("$"," ");//removes $ and replaces with space
        String b2=b1.trim();//removes the blank spaces from the string
        Double b3=Double.parseDouble(b2);//converts string to double
        Assert.assertTrue(a3<b3);//compares the condition
    }
    @Test(priority=6)//method
    public void productAddedToCart()
    {
        clickOnElement(By.xpath("//div[@class='header-menu']/child::ul[1]/li[2]"));//clicks on electronics from the header menu
        clickOnElement(By.xpath("//div[@class='item-grid']//child::div[1]//a[contains(text(),'Camera & photo')]"));
        //clicks on camera and photo in the list
        clickOnElement(By.xpath("//div[@class='item-grid']/child::div[2]/child::div/child::div[2]/child::div[3]/child::div[2]/input[@value='Add to cart']"));
        //clicks on add to cart for Apple Icam
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@id='bar-notification']/p")),
                "The product has been added to your shopping cart");
        //verifies the green bar on the top as a confirmation that the product has been added to the cart
        clickOnElement(By.xpath("//div[@id='bar-notification']/p/a"));//clicks on the shopping cart iin the green bar
        Assert.assertEquals(getTextFromElement(By.xpath("//table[@class='cart']/tbody/tr/child::td[4]/a")),"Apple iCam");
        //verify that the selected product is added in the shopping cart
        takeScreenShot("productaddedtocart");
    }

    //should have been included in seperate project, but to have a continuity, i have added this here.
    // Also i can check whether the reusable method is running properly or not.
    // So the before method runs here as a part of the test suite. Please ignore it.
    @Test//method
    public void printRandomNumber()
    {
        int i=1;
        do {
            generateRandomNumber(11,40);//generates random number starting from 11 to 40
            i++;
        }
        while (i<=3);//generates 3 numbers

    }
    @Test(priority=7)//method
    public void verifyUserIsAbleToPurchaseProductsCheckOutAsGuestAndReceiveOrderConfirmation()
    {
        clickOnElement(By.xpath("//div[@class='header-menu']/ul[1]/child::li[6]/a[contains(text(),'Jewelry')]"));//selects Jewelery from top menu
        clickOnElement(By.xpath("//div[@data-productid='41']/div[2]/div[3]/div[2]/input[@value='Add to cart']"));
        //selects Flower girls bracelet to add to the cart
        waitForVisibilityOfElementLocated(By.xpath("//div[@id='bar-notification']"),20);//wait for the green bar on the top to be visible
        waitForInvisibilityOfElementsLocated(By.xpath("//div[@id='bar-notification']"),20);//waits for green bar on the top to be invisible
        clickOnElement(By.xpath("//div[@data-productid='42']/div[2]/div[3]/div[2]/input[@value='Add to cart']"));
        //selects Vintage style engagement ring to add to the cart
        waitForVisibilityOfElementLocated(By.xpath("//div[@id='bar-notification']"),20);//wait for the green bar on the top to be visible
        clickOnElement(By.xpath("//a[text()='shopping cart']"));//clicks on shopping cart
        //  box.sendKeys(Keys.chord(Keys.CONTROL,"a"));
       // box.sendKeys(Keys.BACK_SPACE);
        clearDataFromElement(By.xpath("//tbody/tr/td[6]/input"));//clears the quantity field
        enterText(By.xpath("//tbody/tr/child::td[6]/input"),"2");//enter quantity 2
        clickOnElement(By.xpath("//div[@class='common-buttons']/input[@name='updatecart']"));//clicks on update cart button
        clickOnElement(By.id("checkout"));//clicks on the check out button
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@id='terms-of-service-warning-box']/p")),"Please accept the terms of service before the next step.");
        //verifying that the alert pops up if we do not accept the terms of service before checking out
        //dismissAlert();
        clickOnElement(By.xpath("//button[@title='close']"));//closes the terms of service box
        clickOnElement(By.id("termsofservice"));//selects the terms of service checkbox
        clickOnElement(By.name("checkout"));//clicks on checkout
        waitForVisibilityOfElementLocated(By.xpath("//input[@value='Checkout as Guest']"),20);//waits for another page to be loaded
        clickOnElement(By.xpath("//input[@value='Checkout as Guest']"));//selects the option check out as guest
        waitForVisibilityOfElementLocated(By.name("BillingNewAddress.FirstName"),20);//waits for the page to load
        enterText(By.name("BillingNewAddress.FirstName"),"Payal");//enters first name
        enterText(By.id("BillingNewAddress_LastName"),"Patel");//enters last name
        email(By.id("BillingNewAddress_Email"),"payal");//enters auto generated email with time stamp
        enterText(By.id("BillingNewAddress_Company"),"Patel's corner");//enters company name
        selectByVisibleText(By.id("BillingNewAddress_CountryId"),"United Kingdom");//selects country from drop down menu
        enterText(By.id("BillingNewAddress_City"),"London");//enters city
        enterText(By.id("BillingNewAddress_Address1"),"233, Quadrant Court");//enters address line 1
        enterText(By.id("BillingNewAddress_Address2"),"Empire House");//enters address line 2
        enterText(By.id("BillingNewAddress_ZipPostalCode"),"AA1 2BB");//enters post code
        enterText(By.id("BillingNewAddress_PhoneNumber"),"09999888888");//enters phone number
        enterText(By.id("BillingNewAddress_FaxNumber"),"111222233334");//enters fax number
        clickOnElement(By.xpath("//input[@onclick='Billing.save()']"));//clicks on continue button
        clickOnElement(By.id("shippingoption_1"));//selects shipping option
        clickOnElement(By.xpath("//input[@onclick='ShippingMethod.save()']"));//clicks on continue
        clickOnElement(By.id("paymentmethod_1"));//selects payment option for credit card
        clickOnElement(By.xpath("//input[@onclick='PaymentMethod.save()']"));//clicks on continue
        selectByValue(By.id("CreditCardType"),"MasterCard");//selects Master card from drop down menu
        enterText(By.id("CardholderName"),"Payal Patel");//enters card holders name
        enterText(By.id("CardNumber"),"5558144407578088");//enters card number
        selectByIndex(By.id("ExpireMonth"),7);//selects expiry month from drop down
        selectByValue(By.id("ExpireYear"),"2023");//selects expiry year from drop down
        enterText(By.id("CardCode"),"123");//enters card code
        clickOnElement(By.xpath("//input[@onclick='PaymentInfo.save()']"));//selects continue
        waitForVisibilityOfElementLocated(By.xpath("//input[@onclick='ConfirmOrder.save()']"),20);
        clickOnElement(By.xpath("//input[@onclick='ConfirmOrder.save()']"));//clicks on confirm
        Assert.assertEquals(getTextFromElement(By.xpath(
                "//div[@class='master-wrapper-page']/child::div[3]/child::div/child::div/child::div/child::div[2]/child::div/child::div/strong")),
                "Your order has been successfully processed!");
        //verifies that the message order placed successfully is displayed
        Assert.assertEquals(true,isElementPresent(By.xpath("//div[@class='buttons']/input")));
        //verifies that continue button is displayed after successful placement of order
        Assert.assertEquals(driver.getCurrentUrl(),"http://demo.nopcommerce.com/checkout/completed/");
        //verifies the current url
    }
    @Test(priority=8)//method
    public void priceChangeFromDollarToEuro()
    {
        selectByVisibleText(By.id("customerCurrency"),"Euro");//selects Euro as currency
        Assert.assertTrue(getTextFromElement(By.xpath("//div[@data-productid='1']/div[2]/div[3]/div/span")).contains("€"),"€");
        //verifies that the price is changed to euro
    }
    @Test(priority=9)//method
    public void unregisteredUserCannotUseEmailAFriendFeature()
    {
        clickOnElement(By.xpath("//div[@data-productid='43']/div/a"));//selects virtual gift card
        clickOnElement(By.className("email-a-friend"));//clicks on button email a friend
        email(By.id("FriendEmail"),"Deep");//enters friends email
        email(By.id("YourEmailAddress"),"Payal");//enters email address of the user
        enterText(By.id("PersonalMessage"),"Enjoy the Gift Card!!");//enters personal message
        clickOnElement(By.xpath("//input[@name='send-email']"));//clicks on send email button
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class='center-1']/div/div[2]/form/div/ul")),
                "Only registered customers can use email a friend feature");
        //verifies that error message is displayed if unregistered users tries to use email a friend feature
    }
    @Test(priority=2)//this is a test method
    public void verifyScreenShotIsTakenIfUserIsUnableToRegisterSuccessfully()
    {
        clickOnElement(By.xpath("//a[text()='Register']"));//clicks on register button
        clickOnElement(By.xpath("//input[@value='F']"));//selects female radio button
        enterText(By.xpath("//input[@id='FirstName']"),"");//intentionally left blank
        enterText(By.xpath("//input[@name='LastName']"),"Patel");//enters last name
        selectByVisibleText(By.xpath("//select[@name='DateOfBirthDay']"),"15");//selects day of birth from drop down menu
        selectByIndex(By.xpath("//select[@name='DateOfBirthMonth']"),10);//selects month of birth from drop down menu
        selectByValue(By.xpath("//select[@name='DateOfBirthYear']"),"1983");//selects year of birth from drop down menu
        email(By.id("Emai"),"Payal");//wrong path given, intentionally
        enterText(By.xpath("//input[@name='Company']"),"Patel's Corner");//enters company name
        clickOnElement(By.xpath("//input[@id='Newsletter']"));//deselects newsletter check box
        enterText(By.xpath("//input[@id='Password']"),"test123");//enters password
        enterText(By.xpath("//input[@id='ConfirmPassword']"),"test123");//confirms password
        clickOnElement(By.xpath("//input[@id='register-button']"));//clicks on register button
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class='result']")),"Your registration completed");
        //asserts that user receives confirmation message once the registration is complete

    }
    @Test//method
    public void verifyScreenShotIsTakenPart2()
    {
        clickOnElement(By.xpath("//a[text()='Register']"));//clicks on register button
        clickOnElement(By.xpath("//input[@value='F']"));//selects female radio button
        enterText(By.xpath("//input[@id='FirstName']"),"");//intentionally left blank
        enterText(By.xpath("//input[@name='LastName']"),"");//enters last name blank
        selectByVisibleText(By.xpath("//select[@name='DateOfBirthDay']"),"15");//selects day of birth from drop down menu
        selectByIndex(By.xpath("//select[@name='DateOfBirthMonth']"),10);//selects month of birth from drop down menu
        selectByValue(By.xpath("//select[@name='DateOfBirthYear']"),"1983");//selects year of birth from drop down menu
        email(By.id("Email"),"");//wrong data entered, intentionally
        enterText(By.xpath("//input[@name='Company']"),"Patel's Corner");//enters company name
        clickOnElement(By.xpath("//input[@id='Newsletter']"));//deselects newsletter check box
        enterText(By.xpath("//input[@id='Password']"),"");//enters password
        enterText(By.xpath("//input[@id='ConfirmPassword']"),"");//confirms password
        clickOnElement(By.xpath("//input[@id='register-button']"));//clicks on register button
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class='result']")),"Your registration completed");
        //asserts that user receives confirmation message once the registration is complete

    }
}
