package test;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
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
	public void login() {
	WebElement sig_in=driver.findElement(By.linkText("Sign in"));
	sig_in.click();
	WebElement email=driver.findElement(By.id("email"));
	email.sendKeys("benjamin.yokese5026@gmail.com");
	WebElement password=driver.findElement(By.id("passwd"));
	password.sendKeys("pass123");
	WebElement login=driver.findElement(By.name("SubmitLogin"));
	login.click();
	if(driver.findElement(cuenta).isDisplayed()) {
    	System.out.println("El login funciona con las credenciales, Ok");

	}
}
	
	@Test
	public void email_fail() {
		WebElement login=driver.findElement(By.linkText("Sign in"));
		login.click();
		WebElement create_email=driver.findElement(By.name("email_create"));
		create_email.sendKeys("correo_fail");
		WebElement boton_create=driver.findElement(By.id("SubmitCreate"));
		boton_create.click();
		if(driver.findElement(email_fail).isDisplayed()) {
	    	System.out.println("La prueba muestra el mensaje de error al usuario, Ok");

		}
	}
	
	@Test
	public void login_fail() {
		WebElement sig_in=driver.findElement(By.linkText("Sign in"));
		sig_in.click();
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("correo_falso@gmail.com");
		WebElement password=driver.findElement(By.id("passwd"));
		password.sendKeys("pass000");
		WebElement login=driver.findElement(By.name("SubmitLogin"));
		login.click();
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
