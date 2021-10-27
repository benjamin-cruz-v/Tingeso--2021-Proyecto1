package test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class comprar {
private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/driverChrome/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		WebElement sig_in=driver.findElement(By.linkText("Sign in"));
		sig_in.click();
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("benjamin.yokese5026@gmail.com");
		WebElement password=driver.findElement(By.id("passwd"));
		password.sendKeys("pass123");
		WebElement login=driver.findElement(By.name("SubmitLogin"));
		login.click();
	}
	
	@Test
	public void comparar()  throws InterruptedException {
		WebElement women=driver.findElement(By.linkText("Women"));
		women.click();
		List<WebElement> links = driver.findElements(By.xpath(".//*[@class='product_list grid row']/li"));
		WebElement ropa=links.get(0);
		WebElement ropa2=links.get(1);
		Thread.sleep(5000);
		Actions actionProvider = new Actions(driver);
	    actionProvider.moveToElement(ropa).build().perform();
	    WebElement add_comparar=ropa.findElement(By.linkText("Add to Compare"));
		add_comparar.click();
		Actions actionProvider2 = new Actions(driver);
		actionProvider2.moveToElement(ropa2).build().perform();
		WebElement add_comparar2=ropa2.findElement(By.linkText("Add to Compare"));
		add_comparar2.click();

		WebElement butom=driver.findElement(By.xpath(".//*[@class='btn btn-default button button-medium "
				+ "bt_compare bt_compare']"));
        butom.click();
	}
	
	@After
	public void setout() {
		WebElement sing_out=driver.findElement(By.linkText("Sign out"));
		sing_out.click();
		driver.quit();
		}
}
