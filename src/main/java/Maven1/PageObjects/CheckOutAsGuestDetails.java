package Maven1.PageObjects;

import Maven1.LoadProp;
import Maven1.Utils;
import org.openqa.selenium.By;

public class CheckOutAsGuestDetails extends Utils {

    LoadProp loadProp=new LoadProp();
    private By _firstNameField=By.name("BillingNewAddress.FirstName");
    private By _lastNameField=By.id("BillingNewAddress_LastName");
    private By _guestEmailField=By.id("BillingNewAddress_Email");
    private By _guestCompanyName=By.id("BillingNewAddress_Company");
    private By _countryDropDown=By.id("BillingNewAddress_CountryId");
    private By _billingAddressCityField=By.id("BillingNewAddress_City");
    private By _billingAddress1field=By.id("BillingNewAddress_Address1");
    private By _billingAddress2Field=By.id("BillingNewAddress_Address2");
    private By _billingAddressPostalCode=By.id("BillingNewAddress_ZipPostalCode");
    private By _phoneNumberField=By.id("BillingNewAddress_PhoneNumber");
    private By _faxNumberField=By.id("BillingNewAddress_FaxNumber");
    private By _billingContinueButton=By.xpath("//input[@onclick='Billing.save()']");
    private By _nextDayAirServiceRadiaButton=By.id("shippingoption_1");
    private By _continueFromShippingButton=By.xpath("//input[@onclick='ShippingMethod.save()']");
    private By _creditCardRadioButton=By.id("paymentmethod_1");
    private By _continueFromPaymentPageButton=By.xpath("//input[@onclick='PaymentMethod.save()']");
    private By _creditCardSelectionDropDownMenu =By.id("CreditCardType");
    private By _cardHoldersNameField=By.id("CardholderName");
    private By _cardNumberField=By.id("CardNumber");
    private By _expireMonthDropDown=By.id("ExpireMonth");
    private By _expireYearDropDown=By.id("ExpireYear");
    private By _cardCodeField=By.id("CardCode");
    private By _continueButtonAfterFillingPaymentDetails =By.xpath("//input[@onclick='PaymentInfo.save()']");
    private By _orderConfirmButton=By.xpath("//input[@onclick='ConfirmOrder.save()']");

    public void verifyGuestBillingAddressDetailsAreFilledIn()
    {
        waitForVisibilityOfElementLocated(_firstNameField,20);//waits for the page to load
        enterText(_firstNameField,loadProp.getProperty("guestFirstName"));//enters first name
        enterText(_lastNameField,loadProp.getProperty("guestLastName"));//enters last name
        email(_guestEmailField,loadProp.getProperty("guestEmail"));//enters auto generated email with time stamp
        enterText(_guestCompanyName,loadProp.getProperty("guestCompanyName"));//enters company name
        selectByVisibleText(_countryDropDown,loadProp.getProperty("guestCountry"));//selects country from drop down menu
        enterText(_billingAddressCityField,loadProp.getProperty("guestCity"));//enters city
        enterText(_billingAddress1field,loadProp.getProperty("guestAddress1"));//enters address line 1
        enterText(_billingAddress2Field,loadProp.getProperty("guestAddress2"));//enters address line 2
        enterText(_billingAddressPostalCode,loadProp.getProperty("guestPostalCode"));//enters post code
        enterText(_phoneNumberField,loadProp.getProperty("guestPhoneNumber"));//enters phone number
        enterText(_faxNumberField,loadProp.getProperty("guestFaxNumber"));//enters fax number
        clickOnElement(_billingContinueButton);//clicks on continue button
    }

    public void selectingShippingOption()
    {
        clickOnElement(_nextDayAirServiceRadiaButton);//selects shipping option
        clickOnElement(_continueFromShippingButton);//clicks on continue
    }
    public void paymentMethodSelection()
    {
        clickOnElement(_creditCardRadioButton);//selects payment option for credit card
        clickOnElement(_continueFromPaymentPageButton);//clicks on continue
    }
    public void cardPaymentInformationFilling()
    {
        selectByValue(_creditCardSelectionDropDownMenu,loadProp.getProperty("cardtype"));//selects Master card from drop down menu
        enterText(_cardHoldersNameField,loadProp.getProperty("CardHolderName"));//enters card holders name
        enterText(_cardNumberField,loadProp.getProperty("cardNumber"));//enters card number
        selectByIndex(_expireMonthDropDown,7);//selects expiry month from drop down
        selectByValue(_expireYearDropDown,loadProp.getProperty("expireYear"));//selects expiry year from drop down
        enterText(_cardCodeField,loadProp.getProperty("cardCode"));//enters card code
        clickOnElement(_continueButtonAfterFillingPaymentDetails);//selects continue
    }
    public void orderConfirmed()
    {
        waitForVisibilityOfElementLocated(_orderConfirmButton,20);
        clickOnElement(_orderConfirmButton);//clicks on confirm
    }

}
