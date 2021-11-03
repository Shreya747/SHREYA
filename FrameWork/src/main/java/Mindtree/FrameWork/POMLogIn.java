package Mindtree.FrameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POMLogIn {
	public WebDriver driver;

	By login = By.xpath("//span[text()='Login']");
	By email = By.id("user_email");
	By pass = By.id("user_password");
	By submit = By.name("commit");

	public POMLogIn(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogin() {
		return driver.findElement(login);
	}

	public WebElement getUsername() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(pass);
	}

	public WebElement getloggingin() {
		return driver.findElement(submit);
	}

}
