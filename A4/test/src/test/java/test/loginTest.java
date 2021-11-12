package test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginTest {
	private WebDriver driver;
	By cuenta= By.xpath(".//*[@class='account']");
	By email_fail= By.xpath(".//*[@class='alert alert-danger']");

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/driverChrome/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}
	
	@Test
	public void login() throws InterruptedException {
		WebElement sig_in=driver.findElement(By.linkText("Sign in"));
		sig_in.click();
		Thread.sleep(3000);
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("benjamin.yokese5026@gmail.com");
		Thread.sleep(2000);
		WebElement password=driver.findElement(By.id("passwd"));
		password.sendKeys("pass123");
		Thread.sleep(2000);
		WebElement login=driver.findElement(By.name("SubmitLogin"));
		login.click();
		Thread.sleep(4000);
		if(driver.findElement(cuenta).isDisplayed()) {
			System.out.println("El login funciona con las credenciales, Ok");

		}
	}
	
	@Test
	public void email_fail() throws InterruptedException {
		WebElement login=driver.findElement(By.linkText("Sign in"));
		login.click();
		Thread.sleep(3000);
		WebElement create_email=driver.findElement(By.name("email"));
		create_email.sendKeys("correo_fail");
		Thread.sleep(2000);
		WebElement boton_create=driver.findElement(By.id("SubmitLogin"));
		boton_create.click();
		Thread.sleep(2000);
		if(driver.findElement(email_fail).isDisplayed()) {
	    	System.out.println("La prueba muestra el mensaje de error al usuario, Ok");

		}
	}
	
	@Test
	public void login_fail() throws InterruptedException {
		WebElement sig_in=driver.findElement(By.linkText("Sign in"));
		sig_in.click();
		Thread.sleep(3000);
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("correo_falso@gmail.com");
		Thread.sleep(2000);
		WebElement password=driver.findElement(By.id("passwd"));
		password.sendKeys("pass000");
		Thread.sleep(2000);
		WebElement login=driver.findElement(By.name("SubmitLogin"));
		login.click();
		Thread.sleep(4000);
		if(driver.findElement(email_fail).isDisplayed()) {
	    	System.out.println("La prueba muestra el mensaje de error al usuario, Ok");

		}
	}
	
	public void logout() {
		WebElement sing_out=driver.findElement(By.linkText("Sign out"));
		sing_out.click();
		driver.quit();
		}
}
