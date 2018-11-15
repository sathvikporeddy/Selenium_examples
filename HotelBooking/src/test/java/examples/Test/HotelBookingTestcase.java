package examples.Test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HotelBookingTestcase {
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
//    baseUrl = "http://change-this-to-the-site-you-are-testing/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testHotelBookingTestcase() throws Exception {
    driver.get("file:///D:/StudyMaterials/Module%203/hotelBooking/login.html");
    driver.findElement(By.name("userName")).clear();
    driver.findElement(By.name("userName")).sendKeys("capgemini");
    driver.findElement(By.name("userPwd")).clear();
    driver.findElement(By.name("userPwd")).sendKeys("capg1234");
    driver.findElement(By.id("one")).click();
    driver.findElement(By.id("check")).click();
    driver.findElement(By.name("photography")).click();
    driver.findElement(By.name("eating")).click();
    driver.findElement(By.cssSelector("input.btn")).click();
    driver.findElement(By.id("txtFirstName")).clear();
    driver.findElement(By.id("txtFirstName")).sendKeys("Vamshi");
    driver.findElement(By.id("txtLastName")).clear();
    driver.findElement(By.id("txtLastName")).sendKeys("Nani");
    driver.findElement(By.id("txtEmail")).clear();
    driver.findElement(By.id("txtEmail")).sendKeys("vamshi@vamshi.com");
    driver.findElement(By.id("txtPhone")).clear();
    driver.findElement(By.id("txtPhone")).sendKeys("7306451044");
    driver.findElement(By.cssSelector("textarea")).clear();
    driver.findElement(By.cssSelector("textarea")).sendKeys("Hinjewadi, Phase-3");
    new Select(driver.findElement(By.name("city"))).selectByVisibleText("Pune");
    new Select(driver.findElement(By.name("state"))).selectByVisibleText("Maharashtra");
    new Select(driver.findElement(By.name("persons"))).selectByVisibleText("5");
    driver.findElement(By.id("txtCardholderName")).clear();
    driver.findElement(By.id("txtCardholderName")).sendKeys("Vamshidhar");
    driver.findElement(By.id("txtDebit")).clear();
    driver.findElement(By.id("txtDebit")).sendKeys("7896451236987456");
    driver.findElement(By.id("txtCvv")).clear();
    driver.findElement(By.id("txtCvv")).sendKeys("789");
    driver.findElement(By.id("txtMonth")).clear();
    driver.findElement(By.id("txtMonth")).sendKeys("03");
    driver.findElement(By.id("txtYear")).clear();
    driver.findElement(By.id("txtYear")).sendKeys("2019");
    driver.findElement(By.id("btnPayment")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
