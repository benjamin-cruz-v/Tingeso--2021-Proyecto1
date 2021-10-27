package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class catalogo {

private WebDriver driver;
	
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/driverChrome/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}
		
	@Test
	public void catalogo() {
		WebElement women=driver.findElement(By.linkText("Women"));
		women.click();
		WebElement size=driver.findElement(By.name("layered_id_attribute_group_1"));
		size.click();
		size.click();
		WebElement color=driver.findElement(By.name("layered_id_attribute_group_11"));
		color.click();
		color.click();
		WebElement style=driver.findElement(By.name("layered_id_feature_11"));
		style.click();
		style.click();
		WebElement manufacturacion=driver.findElement(By.name("layered_manufacturer_1"));
		manufacturacion.click();
		manufacturacion.click();
	}
	@After
	public void setout() {
		driver.quit();
		}
}
