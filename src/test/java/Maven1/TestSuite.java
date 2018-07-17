package Maven1;

//import com.sun.jna.platform.FileUtils;
import Maven1.PageObjects.*;
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
    HomePage homepage=new HomePage();
    RegistrationDetails registrationDetails=new RegistrationDetails();
    RegisterResult registerResult=new RegisterResult();
    CompareProducts compareProducts=new CompareProducts();
    BooksPage booksPage=new BooksPage();
    ElectronicsPage electronicsPage=new ElectronicsPage();
    CameraAndPhotoPage cameraAndPhotoPage=new CameraAndPhotoPage();
    ShoppingCartAppleIcam shoppingCartAppleIcam=new ShoppingCartAppleIcam();
    JewelleryPage jewelleryPage=new JewelleryPage();
    JewelleryShoppingCart jewelleryShoppingCart=new JewelleryShoppingCart();
    CheckOutAsGuestPage checkOutAsGuestPage=new CheckOutAsGuestPage();
    CheckOutAsGuestDetails checkOutAsGuestDetails=new CheckOutAsGuestDetails();
    GuestCheckoutCompleted guestCheckoutCompleted=new GuestCheckoutCompleted();
    VirtualGiftCard virtualGiftCard=new VirtualGiftCard();
    VirtualGiftCardEmailAFriendDetails virtualGiftCardEmailAFriendDetails=new VirtualGiftCardEmailAFriendDetails();


    @Test(priority = 1)//this is a test method
    public void verifyUserIsAbleToRegisterSuccessfully()
    {
        homepage.clickOnRegister();
        registrationDetails.fillRegistrationDetails();
        registerResult.confirmRegistration();
    }
    @ Test(priority=3)//method
    public void verifyUserIsAbleToCompareProducts ()
    {
        homepage.addTwoProductsToTheCart();
        compareProducts.verifyProductsAddedToCompareList();
    }
    @Test(priority=4)//method
    public void verifyUserHasNoProductsToCompare()
    {
        homepage.addTwoProductsToTheCart();
        compareProducts.verifyProductsAddedToCompareList();
        compareProducts.verifyProductCompareListIsCleared();
    }
    @Test(priority=5)//method
    public void userSelectsBooksAndSortsThemInAscendingPriceOrder()
    {
        homepage.selectBooks();
        booksPage.sortInAscendingOrderOfPrice();
        booksPage.selectNumberOfBooksTRoBeDisplayed();
        booksPage.verifyThatBooksAreSortAndDisplayedAsSelected();
    }
    @Test(priority=6)//method
    public void productAddedToCart()
    {
        homepage.clickOnElectronicsInHeaderMenu();
        electronicsPage.clickOnCameraAndPhoto();
        cameraAndPhotoPage.addAppleIcamToCart();
        cameraAndPhotoPage.verifyProductHasBeenAddedToCart();
        cameraAndPhotoPage.clickOnShoppingCartInNotificationBar();
        shoppingCartAppleIcam.vefiryTheProductIsInTheShoppingcart();
        takeScreenShot("productaddedtocart");
    }

    @Test(priority=7)//method
    public void verifyUserIsAbleToPurchaseProductsCheckOutAsGuestAndReceiveOrderConfirmation()
    {
        homepage.clickOnJewellery();
        jewelleryPage.add1stProductToCart();
        jewelleryPage.add2ndProductToCart();
        jewelleryPage.clickOnShoppingCart();
        jewelleryShoppingCart.cleadDataFromQuantityFieldAndUpdateQuantityTo2();
        jewelleryShoppingCart.updateShoppingcart();
        jewelleryShoppingCart.clickOnCheckout();
        jewelleryShoppingCart.verifyThatWindowIsDispalyedToInformUserToCheckTheTermsAndServices();
        jewelleryShoppingCart.closetermsOfSericeCheckBox();
        jewelleryShoppingCart.acceptTermsOfService();
        jewelleryShoppingCart.clickOnCheckout();
        checkOutAsGuestPage.checkOutAsGuest();
        checkOutAsGuestDetails.verifyGuestBillingAddressDetailsAreFilledIn();
        checkOutAsGuestDetails.selectingShippingOption();
        checkOutAsGuestDetails.paymentMethodSelection();
        checkOutAsGuestDetails.cardPaymentInformationFilling();
        checkOutAsGuestDetails.orderConfirmed();
        guestCheckoutCompleted.verifyThatTheUserHasCheckedOutSuccessfullyAsAGuest();
    }
    @Test(priority=8)//method
    public void priceChangeFromDollarToEuro()
    {
        homepage.changeCurrencyFromDollarToEuro();
        homepage.verifyThatTheCurrencyHasChangedFromDollarToEuro();
    }
    @Test(priority=9)//method
    public void unregisteredUserCannotUseEmailAFriendFeature() {
        homepage.selectGiftCard();
        virtualGiftCard.selectOptionEmailAFriend();
        virtualGiftCardEmailAFriendDetails.fillInFriendsEmail();
        virtualGiftCardEmailAFriendDetails.fillInYourEmailField();
        virtualGiftCardEmailAFriendDetails.fillInPersonalMessage();
        virtualGiftCardEmailAFriendDetails.sendEmail();
        virtualGiftCardEmailAFriendDetails.verifyThatUnregiteredUsersCannotUseEmailAFriendFeature();
    }
    @Test(priority = 10)//method
    public void registeredUsersCanUseEmailAFriendfeature()
    {
        homepage.clickOnRegister();
        registrationDetails.fillRegistrationDetails();
        registerResult.confirmRegistration();
        registerResult.clickOnContinue();
        homepage.selectGiftCard();
        virtualGiftCard.fillInGiftCardDetailsMainPage();
        virtualGiftCard.selectOptionEmailAFriend();
        virtualGiftCardEmailAFriendDetails.fillInFriendsEmail();
        virtualGiftCardEmailAFriendDetails.fillInPersonalMessage();
        virtualGiftCardEmailAFriendDetails.sendEmail();
        virtualGiftCardEmailAFriendDetails.verifyRegisterdUsersCanSendMailToFriend();
    }

    @Test(priority=2)//this is a test method
    public void verifyScreenShotIsTakenIfUserIsUnableToRegisterSuccessfully()
    {
        homepage.clickOnRegister();
        registrationDetails.fillIncorrectDetails();
        registerResult.confirmRegistration();
    }
    @Test//method
    public void verifyScreenShotIsTakenPart2()
    {
        homepage.clickOnRegister();
        registrationDetails.fillRegistrationDetails();
        registerResult.wrongMessage();
    }
}
