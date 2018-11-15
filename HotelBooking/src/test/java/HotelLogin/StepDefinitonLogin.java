package HotelLogin;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.FindElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageBean.HotelLoginPageFactory;

public class StepDefinitonLogin {
	
	private WebDriver driver;
	private HotelLoginPageFactory hlpg;
	
	@Before
	@Given("^User is in login page$")
	public void user_is_in_login_page() throws Throwable {
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		hlpg = new HotelLoginPageFactory(driver);
		
		driver.get("file:///D:/StudyMaterials/Module%203/hotelBooking/login.html");
		
	}

	@Then("^Check the heading of the page$")
	public void check_the_heading_of_the_page() throws Throwable {
		
		String strHeading = driver.findElement(By.xpath(".//*[@id='mainCnt']/div[1]/div[1]/h1")).getText();
		if(strHeading.contentEquals("Hotel Booking Application"))
			System.out.println("Heading matched...");
		else
			System.out.println("Heading not matched...");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close();
		
	}

	@When("^User enters valid username and password and clicks on login button$")
	public void user_enters_valid_username_and_password_and_clicks_on_login_button() throws Throwable {
		
		hlpg.setPfuName("capgemini");
		hlpg.setPfuPwd("capg1234");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		hlpg.setPfLogin();
		driver.close();
		
	}

	@Then("^Hotel booking page should be displayed$")
	public void hotel_booking_page_should_be_displayed() throws Throwable {
		
		driver.navigate().to("file:///D:/StudyMaterials/Module%203/hotelBooking/hotelbooking.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close();
		
	}
	
	@When("^User enters either invalid username or password$")
	public void user_enters_either_invalid_username_or_password() throws Throwable {
		
		hlpg.setPfuName("");
		hlpg.setPfuPwd("capg1234");
		hlpg.setPfLogin();
		
	}

	@Then("^Error message should be displayed as invalid username or password$")
	public void error_message_should_be_displayed_as_invalid_username_or_password() throws Throwable {
		
		String alertMessage = driver.findElement(By.xpath(".//*[@id='userErrMsg']")).getText();
		assertEquals("* Please enter userName.", alertMessage);
		driver.close();
		
	}

	@When("^User does not enter neither username nor password$")
	public void user_does_not_enter_neither_username_nor_password() throws Throwable {
		
		hlpg.setPfuName("");
		hlpg.setPfuPwd("");
		hlpg.setPfLogin();
		
	}

	@Then("^Error message should be displayed as fields are empty$")
	public void error_message_should_be_displayed_as_fields_are_empty() throws Throwable {
		
		String alertMessage = driver.findElement(By.xpath(".//*[@id='userErrMsg']")).getText();
		assertEquals("* Please enter userName.", alertMessage);
		driver.close();
		
	}

	@When("^user clicks on the hyperlink$")
	public void user_clicks_on_the_hyperlink() throws Throwable {
		
		driver.findElement(By.linkText("Test")).click();
		
	}

	@Then("^user should be redirected to the success page$")
	public void user_should_be_redirected_to_the_success_page() throws Throwable {

		driver.close();
		
	}

	@When("^selects the a radio button$")
	public void selects_the_a_radio_button() throws Throwable {
		hlpg.setGender1();
//		hlpg.setGender2();
	}

	@Then("^does not show alert message$")
	public void does_not_show_alert_message() throws Throwable {
		hlpg.getGender1();
		driver.close();
	}
	
	@When("^user checks multiple checkboxes$")
	public void user_checks_multiple_checkboxes() throws Throwable {
		
		hlpg.setCook(); Thread.sleep(1000);
		hlpg.setEat(); Thread.sleep(1000);
	}

	@Then("^corresponding values should be displayed on the screen$")
	public void corresponding_values_should_be_displayed_on_the_screen() throws Throwable {
		
		hlpg.getCook();
		hlpg.getPhoto();
		hlpg.getEat();
		driver.close();
		
	}
	
	@After
	public void close() {
		driver.close();
	}
	
}
