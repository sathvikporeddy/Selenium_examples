package HotelLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumLogin {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///D:/StudyMaterials/Module%203/hotelBooking/login.html/");
		String strHeading = driver.findElement(By.xpath(".//*[@id='mainCnt']/div[1]/div[1]/h1")).getText();
		if (strHeading.contentEquals("Hotel Booking Application")) {
			System.out.println("Heading matched...");
		} else {
			System.out.println("Heading not matched...");
		}
		
		System.out.println(driver.getCurrentUrl());
		
		try {
			Thread.sleep(300);
			driver.findElement(By.name("userName")).sendKeys("capgemini");
			Thread.sleep(300);
			driver.findElement(By.name("userPwd")).sendKeys("capg1234");
//			driver.findElement(By.name("userPwd")).sendKeys("capg123");
			Thread.sleep(300);
			driver.findElement(By.className("btn")).click();
//			String alertMessage = driver.switchTo().alert().getText(); //gets the prompt message from the alert box
//			System.out.println(alertMessage);
//			driver.switchTo().alert().accept(); //Accepts/clicks on the OK button of the alert window
//			driver.navigate().to("file:///D:/StudyMaterials/Module%203/hotelBooking/hotelbooking.html");
//			driver.close(); //will close only the current URL
			driver.quit(); //will close all the tabs/browser
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
