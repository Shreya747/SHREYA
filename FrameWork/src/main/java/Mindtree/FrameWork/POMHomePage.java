package Mindtree.FrameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POMHomePage {
	
	public WebDriver driver;
	By title = By.xpath("//*[@id='content']/div/div/h2");
	
	
	public POMHomePage(WebDriver driver2) {
		this.driver= driver2;
	}


	public WebElement getTitleToCheckCorrectOrNot() {
		return driver.findElement(title);
		}
	
}

