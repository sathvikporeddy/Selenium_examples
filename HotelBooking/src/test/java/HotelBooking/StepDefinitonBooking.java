package HotelBooking;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.regex.Pattern;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageBean.HotelBookingPageFactory;

public class StepDefinitonBooking {
	
	private WebDriver driver;
	private HotelBookingPageFactory hbpf;
	
	@BeforeClass
	@Given("^User is logged in successfully and is on Booking page$")
	public void user_is_logged_in_successfully_and_is_on_Booking_page() throws Throwable {
		
		driver = new FirefoxDriver();
		Thread.sleep(100);
		hbpf = new HotelBookingPageFactory(driver);
		
		driver.get("file:///D:/StudyMaterials/Module%203/hotelBooking/hotelbooking.html");
		
	}

	@Then("^Check the head of the page$")
	public void check_the_head_of_the_page() throws Throwable {
		
		String str = driver.findElement(By.xpath("html/body/div[1]/h2")).getText();
		if(str.contentEquals("Hotel Booking Form"))
			System.out.println("Heading matched...");
		else
			System.out.println("Heading not matched...");
		Thread.sleep(100);
		driver.close();
		
	}

	@When("^User does not enter a valid or correct name$")
	public void user_does_not_enter_a_valid_or_correct_name() throws Throwable {
		
		hbpf.setFirstName(""); Thread.sleep(100);
		
	}

	@Then("^display alert message$")
	public void display_alert_message() throws Throwable {

		hbpf.setBtn();
		System.out.println("******"+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.close();
		
	}

	@When("^User enters valid FirstName$")
	public void user_enters_valid_FirstName() throws Throwable {
		
		hbpf.setFirstName("Vamshi"); Thread.sleep(100);
		
	}

	@When("^enters invalid LastName$")
	public void enters_invalid_LastName() throws Throwable {
		
		hbpf.setLastName(""); Thread.sleep(100);
		hbpf.setBtn(); Thread.sleep(100);
		System.out.println("******"+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.close();
		
	}

	@When("^User enters  valid FirstName and LastName$")
	public void user_enters_valid_FirstName_and_LastName() throws Throwable {
		
		hbpf.setFirstName("Vamshi"); Thread.sleep(100);
		hbpf.setLastName("Nani"); Thread.sleep(100);
		
	}
	
//	@When("^selects the a radio button$")
//	public void selects_the_a_radio_button() throws Throwable {
//		
//		hbpf.setGender2(); Thread.sleep(2000);
//		hbpf.setGender1(); Thread.sleep(2000);
//		
//	}
//
//	@Then("^doesn't show alert message$")
//	public void doesn_t_show_alert_message() throws Throwable {
//		
//		if(hbpf.getGender1().equals("male"))
//			System.out.println("*****1"+hbpf.getGender1());
//		else
//			System.out.println("*****2"+hbpf.getGender2());
//		
//	}

	@When("^enters invalid EmailID$")
	public void enters_invalid_EmailID() throws Throwable {
		
		hbpf.setEmail("Vamshi.com"); Thread.sleep(100);
		hbpf.setBtn(); Thread.sleep(100);
		System.out.println("******"+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.close();
		
	}

	@When("^User enters valid FirstName, LastName and EmailID$")
	public void user_enters_valid_FirstName_LastName_and_EmailID() throws Throwable {
		
		hbpf.setFirstName("Vamshi"); Thread.sleep(100);
		hbpf.setLastName("Nani"); Thread.sleep(100);
		hbpf.setEmail("vamshi@vamshi.com"); Thread.sleep(100); 
		
	}

	@When("^does not enter mobile number$")
	public void does_not_enter_mobile_number() throws Throwable {
		
		hbpf.setPhone(""); Thread.sleep(100);
		hbpf.setBtn(); Thread.sleep(100);
		System.out.println("******"+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.close();
		
	}

	@When("^enters invalid mobile number$")
	public void enters_invalid_mobile_number(DataTable arg1) throws Throwable {

		List<String> list = arg1.asList(String.class);
				
		for(int i = 0; i < list.size(); i++) {
			hbpf.getPhone().clear();
			hbpf.setPhone(list.get(i)); Thread.sleep(100);
			if(Pattern.matches("^[7-9]{1}[0-9]{9}$", list.get(i))) {
				System.out.println("****Matched "+ list.get(i)+"****");
				hbpf.setBtn(); Thread.sleep(100);
				System.out.println("******"+driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();
			}
			else {
				System.out.println("****Not Matched "+ list.get(i)+"****");
				hbpf.setBtn(); Thread.sleep(100);
				System.out.println("******"+driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();
			}
		}
		driver.close();		
		
	}
	
	@When("^User enters all valid details till Mobile number and enters address field$")
	public void user_enters_all_valid_details_till_Mobile_number_and_enters_address_field() throws Throwable {
		
		hbpf.setFirstName("Vamshi"); Thread.sleep(1000);
		hbpf.setLastName("Nani"); Thread.sleep(1000);
		hbpf.setEmail("vamshi@vamshi.com"); Thread.sleep(1000);
		hbpf.setPhone("7894561230"); Thread.sleep(1000);
		hbpf.setAddress("Hinjewadi Phase3"); Thread.sleep(1000);
		hbpf.setBtn(); Thread.sleep(1000);
		System.out.println("******"+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.close();
		
	}

	@When("^User does not select a city$")
	public void user_does_not_select_a_city() throws Throwable {
		
		hbpf.setFirstName("Vamshi"); Thread.sleep(100);
		hbpf.setLastName("Nani"); Thread.sleep(100);
		hbpf.setEmail("vamshi@vamshi.com"); Thread.sleep(100);
		hbpf.setPhone("7894561230"); Thread.sleep(100);
		hbpf.setAddress("Hinjewadi Phase 3"); Thread.sleep(100);
		hbpf.setCity("Select City"); Thread.sleep(100);
		hbpf.setBtn(); Thread.sleep(100);
		System.out.println("******"+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.close();
		
	}

	@When("^user enters (\\d+)$")
	public void user_enters(int arg1) throws Throwable {
		
		hbpf.setFirstName("Vamshi"); Thread.sleep(100);
		hbpf.setLastName("Nani"); Thread.sleep(100);
		hbpf.setEmail("vamshi@vamshi.com"); Thread.sleep(100);
		hbpf.setPhone("7894561230"); Thread.sleep(100);
		hbpf.setAddress("Hinjewadi Phase 3"); Thread.sleep(100);
		hbpf.setCity("Pune"); Thread.sleep(100);
		hbpf.setState("Maharastra"); Thread.sleep(100);
		hbpf.setPersons(arg1); Thread.sleep(100);
		
	}

	@Then("^for (\\d+) number of guests, allocate (\\d+) number of rooms$")
	public void for_number_of_guests_allocate_number_of_rooms(int arg1, int arg2) throws Throwable {
		
		if(arg1 <= 3) {
			hbpf.setPersons(arg1);
			int i = hbpf.getRooms();
			System.out.println(i);
			assertEquals(i, arg2);
		}
		/*
		 * These are not working as expected
		 * Uncomment below code and modify the logic
		 */
		else if(arg1 <= 6) {
			hbpf.setPersons(arg1);
			int j = hbpf.getRooms();
			assertEquals(j, arg2);
		}
		else if(arg1 <= 9) {
			hbpf.setPersons(arg1);
			int k = hbpf.getRooms();
			assertEquals(k, arg2);
		}
		
	}

	@When("^user leaves the card holder name blank and clicks the button$")
	public void user_leaves_the_card_holder_name_blank_and_clicks_the_button() throws Throwable {
		
		hbpf.setFirstName("Vamshi"); Thread.sleep(100);
		hbpf.setLastName("Nani"); Thread.sleep(100);
		hbpf.setEmail("vamshi@vamshi.com"); Thread.sleep(100);
		hbpf.setPhone("7894561230"); Thread.sleep(100);
		hbpf.setAddress("Hinjewadi Phase 3"); Thread.sleep(100);
		hbpf.setCity("Pune"); Thread.sleep(100);
		hbpf.setState("Maharastra"); Thread.sleep(100);
		hbpf.setCHName(""); Thread.sleep(100);
		hbpf.setBtn(); Thread.sleep(100);
		System.out.println("******"+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.close();
		
	}

	@When("^user leaves the Debit card number field blank and clicks the button$")
	public void user_leaves_the_Debit_card_number_field_blank_and_clicks_the_button() throws Throwable {
		
		hbpf.setFirstName("Vamshi"); Thread.sleep(100);
		hbpf.setLastName("Nani"); Thread.sleep(100);
		hbpf.setEmail("vamshi@vamshi.com"); Thread.sleep(100);
		hbpf.setPhone("7894561230"); Thread.sleep(100);
		hbpf.setAddress("Hinjewadi Phase 3"); Thread.sleep(100);
		hbpf.setCity("Pune"); Thread.sleep(100);
		hbpf.setState("Maharastra"); Thread.sleep(100);
		hbpf.setCHName("Vamshi"); Thread.sleep(100);
		hbpf.setCHNumber(""); Thread.sleep(100);
		hbpf.setBtn(); Thread.sleep(100);
		System.out.println("******"+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.close();
		
	}

	@When("^user leaves the cvv blank and clicks the button$")
	public void user_leaves_the_cvv_blank_and_clicks_the_button() throws Throwable {
		
		hbpf.setFirstName("Vamshi"); Thread.sleep(100);
		hbpf.setLastName("Nani"); Thread.sleep(100);
		hbpf.setEmail("vamshi@vamshi.com"); Thread.sleep(100);
		hbpf.setPhone("7894561230"); Thread.sleep(100);
		hbpf.setAddress("Hinjewadi Phase 3"); Thread.sleep(100);
		hbpf.setCity("Pune"); Thread.sleep(100);
		hbpf.setState("Maharastra"); Thread.sleep(100);
		hbpf.setCHName("Vamshi"); Thread.sleep(100);
		hbpf.setCHNumber("5211789478965213"); Thread.sleep(100);
		hbpf.setCHcvv(""); Thread.sleep(100);
		hbpf.setBtn(); Thread.sleep(100);
		System.out.println("******"+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.close();
		
	}

	@When("^user leaves the expiry month field blank and clicks the button$")
	public void user_leaves_the_expiry_month_field_blank_and_clicks_the_button() throws Throwable {
		
		hbpf.setFirstName("Vamshi"); Thread.sleep(100);
		hbpf.setLastName("Nani"); Thread.sleep(100);
		hbpf.setEmail("vamshi@vamshi.com"); Thread.sleep(100);
		hbpf.setPhone("7894561230"); Thread.sleep(100);
		hbpf.setAddress("Hinjewadi Phase 3"); Thread.sleep(100);
		hbpf.setCity("Pune"); Thread.sleep(100);
		hbpf.setState("Maharastra"); Thread.sleep(100);
		hbpf.setCHName("Vamshi"); Thread.sleep(100);
		hbpf.setCHNumber("5211789478965213"); Thread.sleep(100);
		hbpf.setCHcvv("102"); Thread.sleep(100);
		hbpf.setCHmonth(""); Thread.sleep(100);
		hbpf.setBtn();
		System.out.println("******"+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.close();
		
	}

	@When("^user leaves the expiry year field blank and clicks the button$")
	public void user_leaves_the_expiry_year_field_blank_and_clicks_the_button() throws Throwable {
		
		hbpf.setFirstName("Vamshi"); Thread.sleep(100);
		hbpf.setLastName("Nani"); Thread.sleep(100);
		hbpf.setEmail("vamshi@vamshi.com"); Thread.sleep(100);
		hbpf.setPhone("7894561230"); Thread.sleep(100);
		hbpf.setAddress("Hinjewadi Phase 3"); Thread.sleep(100);
		hbpf.setCity("Pune"); Thread.sleep(100);
		hbpf.setState("Maharastra"); Thread.sleep(100);
		hbpf.setCHName("Vamshi"); Thread.sleep(100);
		hbpf.setCHNumber("5211789478965213"); Thread.sleep(100);
		hbpf.setCHcvv("102"); Thread.sleep(100);
		hbpf.setCHmonth("03"); Thread.sleep(100);
		hbpf.setCHyear(""); Thread.sleep(100);
		hbpf.setBtn(); Thread.sleep(100);
		System.out.println("******"+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.close();
		
	}

	@When("^user does not leave any fields blank and enters valid input format$")
	public void user_does_not_leave_any_fields_blank_and_enters_valid_input_format() throws Throwable {
		
		hbpf.setFirstName("Vamshi"); Thread.sleep(100);
		hbpf.setLastName("Nani"); Thread.sleep(100);
		hbpf.setEmail("vamshi@vamshi.com"); Thread.sleep(100);
		hbpf.setPhone("7894561230"); Thread.sleep(100);
		hbpf.setAddress("Hinjewadi Phase 3"); Thread.sleep(100);
		hbpf.setCity("Pune"); Thread.sleep(100);
		hbpf.setState("Maharastra"); Thread.sleep(100);
		hbpf.setCHName("Vamshi"); Thread.sleep(100);
		hbpf.setCHNumber("5211789478965213"); Thread.sleep(100);
		hbpf.setCHcvv("102"); Thread.sleep(100);
		hbpf.setCHmonth("03"); Thread.sleep(100);
		hbpf.setCHyear("2021"); Thread.sleep(100);
		hbpf.setBtn(); Thread.sleep(100);
		driver.close();
		
	}

	@Then("^navigate to the Booking confirmed page$")
	public void navigate_to_the_Booking_confirmed_page() throws Throwable {
		
		driver.navigate().to("file:///D:/StudyMaterials/Module%203/hotelBooking/success.html");
		Thread.sleep(100);
		driver.close();
		
	}

}
