package HotelBooking;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumBooking {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		driver = new FirefoxDriver();
		driver.get("file:///D:/StudyMaterials/Module%203/hotelBooking/hotelbooking.html");
		String title = driver.getTitle();
		if(title.contentEquals("Hotel Booking")) {
			System.out.println("Title matched...");
		} else {
			System.out.println("Title not matched...");
		}
		try {
			
			//First Name
			Thread.sleep(1000);
			driver.findElement(By.name("txtFN")).sendKeys("");
			callAlert();
			Thread.sleep(1000);
			driver.findElement(By.name("txtFN")).sendKeys("Vamshi");
			callAlert();
			
			//Last Name
			Thread.sleep(1000);
			driver.findElement(By.name("txtLN")).sendKeys("");
			callAlert();
			Thread.sleep(1000);
			driver.findElement(By.name("txtLN")).sendKeys("Nani");
			callAlert();
			
			//Valid and invalid Email IDs
			Thread.sleep(1000);
			driver.findElement(By.name("Email")).sendKeys("vamshi.com");
			callAlert();
			driver.findElement(By.name("Email")).clear();
			Thread.sleep(1000);
			driver.findElement(By.name("Email")).sendKeys("vamshi@vamshi.com");
			callAlert();
			
			//Phone number
			Thread.sleep(1000);
			driver.findElement(By.name("Phone")).sendKeys("7306491045");
			callAlert();
			
			//Address
			Thread.sleep(1000);
			driver.findElement(By.xpath("html/body/div[1]/div/form/table/tbody/tr[6]/td[2]/textarea")).sendKeys("Hinjewadi, Phase 3");
			callAlert();
			
			// Blank city
			Thread.sleep(1000);
			Select dropCity = new Select(driver.findElement(By.name("city")));
			dropCity.selectByVisibleText("Select City");
			callAlert();

			// Valid city
			Thread.sleep(1000);
			dropCity.selectByIndex(1);

			// Blank State
			Thread.sleep(1000);
			Select dropState = new Select(driver.findElement(By.name("state")));
			dropState.selectByVisibleText("Select State");
			callAlert();
			
			//Valid State
			Thread.sleep(1000);
			dropState.selectByIndex(1);
			callAlert();
			
			//Card holder name
			Thread.sleep(1000);
			driver.findElement(By.id("txtCardholderName")).sendKeys("");
			callAlert();

			Thread.sleep(1000);
			driver.findElement(By.id("txtCardholderName")).sendKeys("Vamshidhar");
			callAlert();

			//Card number
			Thread.sleep(1000);
			driver.findElement(By.id("txtDebit")).sendKeys("");
			callAlert();
			
			Thread.sleep(1000);
			driver.findElement(By.id("txtDebit")).sendKeys("5233087721656789");
			callAlert();

			//Card CVV number
			Thread.sleep(1000);
			driver.findElement(By.id("txtCvv")).sendKeys("");
			callAlert();
			
			Thread.sleep(1000);
			driver.findElement(By.id("txtCvv")).sendKeys("111");
			callAlert();
			
			//Month
			Thread.sleep(1000);
			driver.findElement(By.id("txtMonth")).sendKeys("");
			callAlert();
			
			Thread.sleep(1000);
			driver.findElement(By.id("txtMonth")).sendKeys("03");
			callAlert();
			
			//Year
			Thread.sleep(1000);
			driver.findElement(By.id("txtYear")).sendKeys("");
			callAlert();
			
			Thread.sleep(1000);
			driver.findElement(By.id("txtYear")).sendKeys("2020");
			callAlert();
			driver.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void callAlert() {
		driver.findElement(By.className("btn")).click();
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		driver.switchTo().alert().accept();
	}
	
}
