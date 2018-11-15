package pageBean;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HotelLoginPageFactory {

	WebDriver driver;

	@FindBy(name = "userName")
	@CacheLookup // The identified element will be stored temporarily till the operation is
					// performed on the particular element
	WebElement pfuName;

	// How is used to identify or make specific which type of identifier should be
	// used
	@FindBy(how = How.NAME, using = "userPwd")
	@CacheLookup
	WebElement pfuPwd;

	@FindBy(className = "btn")
	@CacheLookup // The identified element will be stored temporarily till the operation is
					// performed on the particular element
	WebElement pfLogin;

	@FindBy(id = "one")
	@CacheLookup
	WebElement gender1;

	@FindBy(id = "two")
	@CacheLookup
	WebElement gender2;

	@FindBy(name = "cooking")
	@CacheLookup
	WebElement cook;

	@FindBy(name = "eating")
	@CacheLookup
	WebElement eat;

	@FindBy(name = "photography")
	@CacheLookup
	WebElement photo;

	public void getGender1() {
		boolean b = gender1.isSelected();
		if(b) {
			System.out.println("Male");
		}
	}

	public void setGender1() {
		gender1.click();
	}

	public void getGender2() {
		boolean b = gender2.isSelected();
		if(b) {
			System.out.println("Female");
		}
	}

	public void setGender2() {
		gender2.click();
	}

	public void getCook() {
		if (cook.isSelected())
			System.out.println("Cooking option is selected");
		else
			System.out.println("Cooking option is not selected");
	}

	public void setCook() {
		cook.click();
	}

	public void getEat() {
		if (eat.isSelected())
			System.out.println("Eating option is selected");
		else
			System.out.println("Eating option is not selected");
	}

	public void setEat() {
		eat.click();
	}

	public void getPhoto() {
		if (photo.isSelected()) {
			String select = photo.getCssValue("name");
			System.out.println(select);
			System.out.println("Photography option is selected");
		}
		else
			System.out.println("Photography option is not selected");
	}

	public void setPhoto() {
		photo.click();
	}

	public HotelLoginPageFactory(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getPfuName() {
		return pfuName;
	}

	public void setPfuName(String sName) {
		pfuName.sendKeys(sName);
	}

	public WebElement getPfuPwd() {
		return pfuPwd;
	}

	public void setPfuPwd(String sPwd) {
		pfuPwd.sendKeys(sPwd);
	}

	public WebElement getPfLogin() {
		return pfLogin;
	}

	public void setPfLogin() {
		pfLogin.click();
	}

}
