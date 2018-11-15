package pageBean;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HotelBookingPageFactory {
	
	WebDriver driver;
	
	@FindBy(name = "txtFN")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(name = "txtLN")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(name = "Email")
	@CacheLookup
	WebElement email;
	
	@FindBy(name = "Phone")
	@CacheLookup
	WebElement phone;
	
	@FindBy(xpath = "html/body/div[1]/div/form/table/tbody/tr[6]/td[2]/textarea")
	@CacheLookup
	WebElement address;
	
	@FindBy(name = "city")
	@CacheLookup
	WebElement city;

	@FindBy(name = "state")
	@CacheLookup
	WebElement state;
	
	@FindBy(xpath = "html/body/div[1]/div/form/table/tbody/tr[10]/td[2]/select")
	@CacheLookup
	WebElement persons;
	
	@FindBy(id = "rooms")
	@CacheLookup
	WebElement rooms;
	
	@FindBy(id = "txtCardholderName")
	@CacheLookup
	WebElement CHName;

	@FindBy(id = "txtDebit")
	@CacheLookup
	WebElement CHNumber;
	
	@FindBy(id = "txtCvv")
	@CacheLookup
	WebElement CHcvv;
	
	@FindBy(id = "txtMonth")
	@CacheLookup
	WebElement CHmonth;
	
	@FindBy(id = "txtYear")
	@CacheLookup
	WebElement CHyear;

	@FindBy(id = "btnPayment")
	@CacheLookup
	WebElement btn;
	
	public HotelBookingPageFactory(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getPersons() {
		return persons;
	}

	public void setPersons(int string) {
//		persons.sendKeys(String.valueOf(string));
		new Select(persons).selectByVisibleText(String.valueOf(string));
	}

	public Integer getRooms() {
		return Integer.valueOf(rooms.getText());
	}

	public void setRooms(String string) {
		rooms.sendKeys(string);
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public void setFirstName(String string) {
		firstName.sendKeys(string);
	}

	public WebElement getLastName() {
		return lastName;
	}

	public void setLastName(String string) {
		lastName.sendKeys(string);
	}

	public WebElement getEmail() {
		return email;
	}

	public void setEmail(String string) {
		email.sendKeys(string);
	}

	public WebElement getPhone() {
		return phone;
	}

	public void setPhone(String string) {
		phone.sendKeys(string);
	}

	public WebElement getAddress() {
		return address;
	}

	public void setAddress(String string) {
		address.sendKeys(string);
	}

	public WebElement getCity() {
		return city;
	}

	public void setCity(String string) {
		city.sendKeys(string);
	}

	public WebElement getState() {
		return state;
	}

	public void setState(String string) {
		state.sendKeys(string);
	}

	public WebElement getCHName() {
		return CHName;
	}

	public void setCHName(String string) {
		CHName.sendKeys(string);
	}

	public WebElement getCHNumber() {
		return CHNumber;
	}

	public void setCHNumber(String string) {
		CHNumber.sendKeys(string);
	}

	public WebElement getCHcvv() {
		return CHcvv;
	}

	public void setCHcvv(String string){
		CHcvv.sendKeys(string);
	}

	public WebElement getCHmonth() {
		return CHmonth;
	}

	public void setCHmonth(String string){
		CHmonth.sendKeys(string);
	}

	public WebElement getCHyear() {
		return CHyear;
	}

	public void setCHyear(String string) {
		CHyear.sendKeys(string);
	}

	public WebElement getBtn() {
		return btn;
	}

	public void setBtn() {
		btn.click();
	}
	
}
